package com.self.datasource.third.domain.r;

import lombok.*;

import java.util.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContractModelDO {

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

    private Date createTime;

    private Date updateTime;

}
