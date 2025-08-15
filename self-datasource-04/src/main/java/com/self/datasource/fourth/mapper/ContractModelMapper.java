package com.self.datasource.fourth.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.self.datasource.fourth.domain.ContractModelDO;

@DS(value = "db2")
public interface ContractModelMapper extends BaseMapper<ContractModelDO> {

    default ContractModelDO getByModelCode(String modelCode) {
        return selectList(Wrappers.<ContractModelDO>lambdaQuery()
                .eq(ContractModelDO::getModelCode, modelCode))
                .stream()
                .findFirst()
                .orElse(null);
    }

}
