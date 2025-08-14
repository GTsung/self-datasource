package com.self.datasource.first;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.self.datasource.first.config.DynamicDataSource;
import com.self.datasource.first.domain.ContractModelDO;
import com.self.datasource.first.domain.LoanDO;
import com.self.datasource.first.enums.DbTypeEnum;
import com.self.datasource.first.mapper.ContractModelMapper;
import com.self.datasource.first.mapper.LoanMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class DynamicDataSourceTest {

    @Resource
    private LoanMapper loanMapper;

    @Resource
    private ContractModelMapper contractModelMapper;

    @Test
    public void testRead() {
        DynamicDataSource.setCurrentDataSource(DbTypeEnum.R);
        try {
            List<ContractModelDO> contractModelDOS = contractModelMapper.selectList(Wrappers.<ContractModelDO>lambdaQuery());
            System.out.println(contractModelDOS);
        } finally {
            DynamicDataSource.clearCurrentDataSource();
        }
    }

    @Test
    public void testWrite() {
        DynamicDataSource.setCurrentDataSource(DbTypeEnum.W);
        try {
            loanMapper.insert(LoanDO.builder()
                    .loanNbr("test-01")
                    .initTerm(12)
                    .initPrincipal(new BigDecimal("1200.00"))
                    .build());
        } finally {
            DynamicDataSource.clearCurrentDataSource();
        }
    }

}
