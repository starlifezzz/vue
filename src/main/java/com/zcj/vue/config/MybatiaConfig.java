package com.zcj.vue.config;


import com.sun.xml.internal.ws.api.ResourceLoader;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

@Configuration
@MapperScan("com.zcj.vue.dao")
public class MybatiaConfig {

    private final durid durid;

    public MybatiaConfig(com.zcj.vue.config.durid durid) {
        this.durid = durid;
    }

    @Autowired


    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(durid.druidDataSource());
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("static/mybatisconfig.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);
        try {
            Resource[] resources = resolver.getResources("classpath:static/mapper/*.xml");
            sqlSessionFactoryBean.setMapperLocations(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sqlSessionFactoryBean.setTypeAliasesPackage("com.zcj.vue.entity");
        return sqlSessionFactoryBean;
    }
}
