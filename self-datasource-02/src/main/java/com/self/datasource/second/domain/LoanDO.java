package com.self.datasource.second.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "ccs_loan")
public class LoanDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String loanNbr;

    private Integer initTerm;

    private BigDecimal initPrincipal;

}
