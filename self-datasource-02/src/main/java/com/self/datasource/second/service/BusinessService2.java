package com.self.datasource.second.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.self.datasource.second.annotation.DbSwitch;
import com.self.datasource.second.domain.ContractModelDO;
import com.self.datasource.second.enums.DbTypeEnum;
import com.self.datasource.second.mapper.ContractModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@DbSwitch(value = DbTypeEnum.R)
public class BusinessService2 {

    @Resource
    private ContractModelMapper contractModelMapper;

    public void read() {
        List<ContractModelDO> contractModelDOS = contractModelMapper
                .selectList(Wrappers.<ContractModelDO>lambdaQuery());
        System.out.println(contractModelDOS);
    }

}
