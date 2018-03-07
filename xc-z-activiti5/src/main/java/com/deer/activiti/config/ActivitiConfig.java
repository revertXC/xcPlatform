package com.deer.activiti.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.deer.common.config.dataSources.mysql.DataSourceConfig;
import org.activiti.engine.*;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@AutoConfigureAfter(DataSourceConfig.class)
public class ActivitiConfig extends AbstractProcessEngineAutoConfiguration{

    @Bean(name="activitiDataSource",initMethod = "init", destroyMethod = "close")
    //相同对象 默认选中 Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
    @ConfigurationProperties(prefix = "spring.datasource.activiti")
    public DataSource activitiDataSource() {
        return new DruidDataSource();
    }
    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(activitiDataSource());
    }


    //流程配置，与spring整合采用SpringProcessEngineConfiguration这个实现
    @Bean
    @Primary
    public ProcessEngineConfiguration processEngineConfiguration(){
        SpringProcessEngineConfiguration processEngineConfiguration = new SpringProcessEngineConfiguration();
        processEngineConfiguration.setDataSource(activitiDataSource());
        processEngineConfiguration.setDatabaseSchemaUpdate("true");
        processEngineConfiguration.setDatabaseType("mysql");
        processEngineConfiguration.setTransactionManager(txManager());
        return processEngineConfiguration;
    }

//    @Bean
//    public SpringProcessEngineConfiguration getProcessEngineConfiguration(){
//        SpringProcessEngineConfiguration config =
//                new SpringProcessEngineConfiguration();
//        config.setDataSource(druidDataSource);
//        config.setTransactionManager(transactionManager);
//        config.setDatabaseType("mysql");
//        config.setDatabaseSchemaUpdate("true");
//        return config;
//    }

}
