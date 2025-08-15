package com.self.datasource.fourth.service;

import com.baomidou.dynamic.datasource.annotation.DSTransactional;
import com.self.datasource.fourth.domain.ContractModelDO;
import com.self.datasource.fourth.domain.LoanDO;
import com.self.datasource.fourth.mapper.ContractModelMapper;
import com.self.datasource.fourth.mapper.LoanMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BizService {

    @Resource
    private LoanMapper loanMapper;
    @Resource
    private ContractModelMapper contractModelMapper;

    /**
     * 开启了事务,各个mapper类上都加上了@DS注解
     * 看看这个能不能同时提交事务或回滚 -> 是可以的因为底层重写了
     * 如果是spring自己的事务注解就不行了
     */
    @DSTransactional
    public void update(String loanNbr, String modelCode) {
        LoanDO loanDO = loanMapper.getByLoanNbr(loanNbr);
        loanDO.setInitTerm(36);
        loanMapper.updateById(loanDO);
        ContractModelDO modelDO = contractModelMapper.getByModelCode(modelCode);
        modelDO.setUpdateUser("test-model");
        contractModelMapper.updateById(modelDO);
        // int i = 1 / 0;
    }

}
