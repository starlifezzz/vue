package com.zcj.vue.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class durid {

    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername("postgres");
        druidDataSource.setPassword("778280151");
        druidDataSource.setUrl("jdbc:postgresql://localhost:5432/welove");
        Driver driver = new Driver();
        druidDataSource.setDriver(driver);
        return druidDataSource;
    }
}
