package com.self.datasource.second.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class BusinessService2Test {

    @Resource
    private BusinessService2 businessService2;

    @Test
    public void read() {
        businessService2.read();
    }

}
