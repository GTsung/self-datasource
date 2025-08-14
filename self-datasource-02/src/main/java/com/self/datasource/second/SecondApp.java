package com.self.datasource.second;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@MapperScan(basePackages = {"com.self.datasource.second.mapper"})
@SpringBootApplication
public class SecondApp {

    public static void main(String[] args) {
        SpringApplication.run(SecondApp.class, args);
    }
}
