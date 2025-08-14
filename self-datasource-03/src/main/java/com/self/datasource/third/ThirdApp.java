package com.self.datasource.third;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Hello world!
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class ThirdApp {

    public static void main(String[] args) {
        SpringApplication.run(ThirdApp.class, args);
    }

}
