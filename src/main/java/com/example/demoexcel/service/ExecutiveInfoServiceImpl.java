package com.example.demoexcel.service;

import com.example.demoexcel.dao.ExecutiveInfoDao;
import com.example.demoexcel.entity.ExecutiveInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExecutiveInfoServiceImpl implements ExecutiveInfoService {
    @Autowired
    private ExecutiveInfoDao executiveInfoDao;

    @Override
    @Transactional
    public void insert(List<ExecutiveInfoEntity> entityList) {
        //一次插入3000条数据到数据库
        int num = 3000;
        int toIndex=num;
        int listSize = entityList.size();
        for (int i=0; i< entityList.size(); i+=num){
            if (i+num > listSize){
                toIndex = listSize-i;
            }
            List<ExecutiveInfoEntity> infoEntities = entityList.subList(i, i+toIndex);
            executiveInfoDao.insertOrUpdate(infoEntities);
        }
    }
}
