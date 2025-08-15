package com.self.datasource.fourth.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "cm_contract_model")
public class ContractModelDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String modelCode;

    private String modelName;

    private String type;

    private Integer signNode;

    private Integer signType;

    private Integer signSubject;

    private Integer customerType;

    private String cooperatorCode;

    private String cooperatorName;

    private String guarantorCode;

    private String ossFileName;

    private String url;

    private Integer status;

    private Integer delFlag;

    private Date createTime;

    private String createUser;

    private String updateUser;

    private Date updateTime;

    private String remark;

    private String prodCode;

}
