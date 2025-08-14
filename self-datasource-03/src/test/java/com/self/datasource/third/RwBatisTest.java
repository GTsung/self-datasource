package com.self.datasource.third;

import com.self.datasource.third.domain.r.ContractModelDO;
import com.self.datasource.third.mapper.r.ContractModelMapper;
import com.self.datasource.third.mapper.w.LoanMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class RwBatisTest {

    @Resource
    private LoanMapper loanMapper;
    @Resource
    private ContractModelMapper contractModelMapper;

    @Test
    public void testRead() {
        List<ContractModelDO> list = contractModelMapper.list();
        System.out.println(list);
    }

    @Test
    public void testWrite() {
        loanMapper.insertOne();
    }
}
