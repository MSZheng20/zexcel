package com.example.demoexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.example.demoexcel.dao.ExecutiveInfoDao;
import com.example.demoexcel.entity.ExecutiveInfoEntity;
import com.example.demoexcel.excel.ExecutiveInfoExcel;
import com.example.demoexcel.service.ExecutiveInfoService;
import com.example.demoexcel.utils.ConvertUtils;
import com.example.demoexcel.utils.HibernateValidator;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.*;


public class  UploadDataListener extends AnalysisEventListener<ExecutiveInfoExcel> {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(UploadDataListener.class);

    private ExecutiveInfoService executiveInfoService;
    private Boolean insertFlag = true;
    private List<Integer> failList = new ArrayList<>();

    List<ExecutiveInfoExcel> list = new ArrayList<ExecutiveInfoExcel>();

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param
     */
    public UploadDataListener(ExecutiveInfoService executiveInfoService) {
        this.executiveInfoService = executiveInfoService;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     *            one row value. Is is same as {@link #()}
     * @param context
     */
    @Override
    public void invoke(ExecutiveInfoExcel data, AnalysisContext context) {
        //LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        Validator validator = HibernateValidator.getValidator();
        Set<ConstraintViolation<ExecutiveInfoExcel>> validateSet = validator.validate(data,Default.class);
        if (validateSet != null && !validateSet.isEmpty()) {
            //System.out.println("校验出错：" + data);
            LOGGER.info("校验出错: {}",data);
            failList.add(context.readRowHolder().getRowIndex());
            insertFlag = false;
        }else {
            list.add(data);
        }

    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
       if (insertFlag){
           saveData();
       }else {
           LOGGER.info("有校验错误不入库");
       }
    }

    @Override
    public void onException(Exception exception, AnalysisContext context){
        LOGGER.error("exception: {}",exception.toString());
        context.currentReadHolder();
    }

    @Override
    public void invokeHead(Map<Integer, CellData> var1, AnalysisContext var2){

    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
       LOGGER.info("{}条数据，开始存储数据库！", list.size());
        List<ExecutiveInfoEntity> entityList = ConvertUtils.sourceToTarget(list, ExecutiveInfoEntity.class);
        executiveInfoService.insert(entityList);
       // LOGGER.info("存储数据库成功！");
    }

    public List<Integer> getFailList() {
        return failList;
    }

    public Boolean getInsertFlag() {
        return insertFlag;
    }
}