package com.self.datasource.third.domain.w;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoanDO {

    private Long id;

    private String loanNbr;

    private Integer initTerm;

    private BigDecimal initPrincipal;

}
