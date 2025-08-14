package com.self.datasource.third.mapper.w;

import org.apache.ibatis.annotations.Insert;

public interface LoanMapper {

    @Insert("insert into ccs_loan values(4, 'test-03', 6, 1800.00)")
    void insertOne();

}
