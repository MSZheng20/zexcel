package com.example.demoexcel.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("executive_info")
public class ExecutiveInfoEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 零售客户名
     */
    private String executiveName;
    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 统一社会信用代码
     */
    private String enterpriseCreditCode;
    /**
     * 企业开户状态
     */
    private Integer openStatus;
    /**
     * 详细地址
     */
    private String enterpriseAddress;
    /**
     * 零售客户身份
     */
    private String executivePosition;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 零售客户号
     */
    private Long executiveId;
    /**
     * 零售客户经理
     */
    private Long retailCustomerManagerId;
    /**
     *
     */
    private Date updateDate;
    /**
     * 注册资金
     */
    private String registerCapital;
    /**
     * 法定代表人
     */
    private String legalRepresentative;
    /**
     * 电话
     */
    private String telephone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 公司类型
     */
    private String companyType;
    /**
     * 所属行业
     */
    private String industry;
    /**
     * 卡号
     */
    private Integer cardNumber;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 客户号开立日
     */
    private Date customerOpeningDay;
    /**
     * 联系电话
     */
    private Integer telephoneNumber;
    /**
     * 成立时间
     */
    private Date establishmentTime;
    /**
     * 最高持卡级别
     */
    private String highestCardholderLevel;
    /**
     * 是否办理过小微贷款业务
     */
    private String flagMicroLoanBusiness;
    /**
     * 服务人
     */
    private String servantRcm;
}
