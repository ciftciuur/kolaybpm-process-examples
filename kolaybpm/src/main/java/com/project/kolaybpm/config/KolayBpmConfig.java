package com.project.kolaybpm.config;

import org.activiti.engine.*;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class KolayBpmConfig {
    /*
    TODO: spring boot environment adında bir interface aracılığıyla application.properties üzerinde bulunan her değişkeni okuyabiliyoruz , örnegin  env.getProperty("app.name") gibi
     */


    @Bean
    public SpringProcessEngineConfiguration processEngineConfiguration() {
        SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();
        config.setDataSource(databaseConnection());
        config.setTransactionManager(transactionManager());
        //TODO : ilk kurulumda " create " olucak tabloların olusması için sonra none kalıcak
        config.setDatabaseSchemaUpdate("none");
        config.setHistory("audit");
        config.setAsyncExecutorActivate(true);
        return config;
    }


    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(databaseConnection());
    }

    @Bean
    public ProcessEngineFactoryBean processEngine() {
        ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
        factoryBean.setProcessEngineConfiguration(processEngineConfiguration());
        return factoryBean;
    }

    //TODO :  database information added application properties , non-static
    //TODO : database bilgilerini buradan değilde application.properties dosyasından okumalı
    @Bean
    public DataSource databaseConnection() {
        return DataSourceBuilder.create().url("jdbc:postgresql://localhost:5432/kolaybpm").username("postgres")
                .password("postgres").driverClassName("org.postgresql.Driver").build();
    }

    @Bean
    public RepositoryService repositoryService(ProcessEngine processEngine) {
        return processEngine.getRepositoryService();
    }

    @Bean
    public RuntimeService runtimeService(ProcessEngine processEngine) {
        return processEngine.getRuntimeService();
    }

    @Bean
    public TaskService taskService(ProcessEngine processEngine) {
        return processEngine.getTaskService();
    }

    @Bean
    public IdentityService identityService(ProcessEngine processEngine) {
        return processEngine.getIdentityService();
    }
}
