package com.self.datasource.second.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class BusinessServiceTest {

    @Resource
    private BusinessService businessService;

    @Test
    public void testRead() {
        businessService.listModels();
    }

    @Test
    public void testWrite() {
        businessService.saveLoan();
    }

}
