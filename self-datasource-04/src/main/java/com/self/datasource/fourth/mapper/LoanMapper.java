package com.self.datasource.fourth.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.self.datasource.fourth.domain.LoanDO;


@DS(value = "db1")
public interface LoanMapper extends BaseMapper<LoanDO> {

    default LoanDO getByLoanNbr(String loanNbr) {
        return selectOne(Wrappers.<LoanDO>lambdaQuery().eq(LoanDO::getLoanNbr, loanNbr));
    }

}
