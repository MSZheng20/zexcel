package com.example.demoexcel.controller;


import com.example.demoexcel.excel.ExecutiveInfoExcel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("zms")
public class ExcelTest {

//    /**
//     * 导入excel
//     */
//    @PostMapping("import_excel")
//    public Object importExcel(@RequestParam("file") MultipartFile file) {
//        ImportParams params = new ImportParams();
//        params.setTitleRows(0);
//        params.setHeadRows(1);
//        params.setNeedVerfiy(true);
//        importExcel(file, params);
//        //ExcelResult excelResult = executiveInfoService.importInfo(file, params);
//        System.out.println("完成" + new Date());
////        if (excelResult.getCode() != 0) {
////            return new Object();
////        }
//        return new Object();
//    }
//
//    @GetMapping("hello")
//    public String hello() {
//       return "hello";
//    }
//
//    public  void importExcel(MultipartFile file, ImportParams params){
//        ExcelImportResult<ExecutiveInfoExcel> list = null;
//        System.out.println("开始" + new Date());
//        try {
//            list =  ExcelImportUtil.importExcelMore(
//                    file.getInputStream(),
//                    ExecutiveInfoExcel.class, params);
//        } catch (Exception e) {
//            e.toString();
//        }
//    }
}
