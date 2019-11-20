package com.example.demoexcel.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.demoexcel.dao.ExecutiveInfoDao;
import com.example.demoexcel.excel.ExecutiveInfoExcel;
import com.example.demoexcel.listener.UploadDataListener;
import com.example.demoexcel.service.ExecutiveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("easyexcel")
public class EasyExcelTest  {
    @Autowired
    private ExecutiveInfoService executiveInfoService;


    @GetMapping("hello")
    public String hello() {
       return "hello";
    }

    @PostMapping("import_excel")
   public Object importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        UploadDataListener uploadDataListener = new UploadDataListener(executiveInfoService);
        EasyExcel.read(file.getInputStream(), ExecutiveInfoExcel.class,  uploadDataListener).sheet().doRead();
        // 这里根据自己的返回类型去修改
        if (uploadDataListener.getInsertFlag()){
            return "success";
        }
        return uploadDataListener.getFailList();
    }

    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("zms", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), ExecutiveInfoExcel.class).sheet("模板").doWrite(null);
    }

}
