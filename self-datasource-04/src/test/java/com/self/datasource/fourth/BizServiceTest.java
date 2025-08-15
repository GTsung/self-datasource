package com.self.datasource.fourth;

import com.self.datasource.fourth.service.BizService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class BizServiceTest {

    @Resource
    private BizService bizService;

    @Test
    public void test() {
        bizService.update("test-01", "00001");
    }

}
