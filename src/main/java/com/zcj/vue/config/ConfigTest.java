package com.zcj.vue.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
public class ConfigTest {

    @Bean
    public String kk() {
        System.out.println("哇哈哈");
        return "fsdf";
    }
}
