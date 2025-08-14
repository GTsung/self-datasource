package com.self.datasource.second.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.self.datasource.second.annotation.DbSwitch;
import com.self.datasource.second.domain.ContractModelDO;
import com.self.datasource.second.domain.LoanDO;
import com.self.datasource.second.enums.DbTypeEnum;
import com.self.datasource.second.mapper.ContractModelMapper;
import com.self.datasource.second.mapper.LoanMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Component
public class BusinessService {

    @Resource
    private LoanMapper loanMapper;
    @Resource
    private ContractModelMapper contractModelMapper;

    @DbSwitch(value = DbTypeEnum.W)
    public void saveLoan() {
        LoanDO loanDO = LoanDO.builder()
                .loanNbr("test-02")
                .initTerm(6)
                .initPrincipal(new BigDecimal("2100.00"))
                .build();
        loanMapper.insert(loanDO);
    }

    @DbSwitch(value = DbTypeEnum.R)
    public void listModels() {
        List<ContractModelDO> contractModelDOS = contractModelMapper.selectList(
                Wrappers.<ContractModelDO>lambdaQuery()
                        .eq(ContractModelDO::getSignNode, 5));
        System.out.println(contractModelDOS);
    }

}
