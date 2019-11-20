

package com.example.demoexcel.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;


import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
public class ExecutiveInfoExcel  {

    @ExcelProperty("零售客户名")
    @NotBlank
    private String executiveName;
    @ExcelProperty("企业名称")
    @NotBlank
    private String enterpriseName;
    @ExcelProperty("统一社会信用代码")
    @NotNull(message = "不能为空" )
    private String enterpriseCreditCode;
    @ExcelProperty("详细地址")
    @NotBlank
    private String enterpriseAddress;
    @ExcelProperty("零售客户号")
    @NotNull
    private Long executiveId;
    @ExcelProperty("零售客户身份")
    @NotBlank
    private String executivePosition;
    @ExcelProperty("注册资金")
    @NotBlank
    private String registerCapital;
    @ExcelProperty("法定代表人")
    @NotBlank
    private String legalRepresentative;
    @ExcelProperty("电话")
    @NotBlank
    private String telephone;
    @ExcelProperty("邮箱")
    @NotBlank
    private String email;
    @ExcelProperty("公司类型")
    @NotBlank
    private String companyType;
    @ExcelProperty("所属行业")
    @NotBlank
    private String industry;
    @ExcelProperty("卡号")
    @NotNull
    private Integer cardNumber;
    @ExcelProperty("身份证号码")
    @NotBlank
    private String idCard;
    @ExcelProperty("客户号开立日期")
    @DateTimeFormat("yyyy-MM-dd")
    private Date customerOpeningDay;
    @ExcelProperty("联系电话")
    @NotNull
    private Integer telephoneNumber;
    @ExcelProperty("成立时间")
    @DateTimeFormat("yyyy-MM-dd")
    private Date establishmentTime;
    @ExcelProperty("最高持卡级别")
    @NotBlank
    private String highestCardholderLevel;
    @ExcelProperty("是否办理过小微贷款业务")
    @NotBlank
    private String flagMicroLoanBusiness;

}