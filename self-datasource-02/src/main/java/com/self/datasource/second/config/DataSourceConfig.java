package com.self.datasource.second.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.datasource1")
    public DataSource firstDataSource() {
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.datasource2")
    public DataSource secondDataSource() {
        return new DruidDataSource();
    }


}
