package com.self.datasource.fourth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 */
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableTransactionManagement
@MapperScan(basePackages = {"com.self.datasource.fourth.mapper"})
@SpringBootApplication
public class FourthApp {

    public static void main(String[] args) {
        SpringApplication.run(FourthApp.class, args);
    }

}
