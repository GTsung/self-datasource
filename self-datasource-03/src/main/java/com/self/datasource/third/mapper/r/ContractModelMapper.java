package com.self.datasource.third.mapper.r;

import com.self.datasource.third.domain.r.ContractModelDO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ContractModelMapper {

    @Select("select * from cm_contract_model")
    List<ContractModelDO> list();

}
