package com.project.kolaybpm.db;

import com.project.kolaybpm.config.KolayBpmConfig;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import javax.swing.*;

@RunWith(SpringRunner.class)
//@TestPropertySource({"classpath:application.properties"})
public class KolayBpmAppDatabaseTests {

    @Autowired
    private KolayBpmConfig kolayBpmConfig;

    @Test
    @Order(1)
    public void kolayBpmDatabaseConnectionTest() {

        DataSource dataSource = kolayBpmConfig.databaseConnection();

        Assert.assertNotNull(dataSource);
    }


    @Test
    @Order(2)
    public void kolayBpmDatabaseConfigTest() {

        SpringProcessEngineConfiguration configuration = kolayBpmConfig.processEngineConfiguration();

        Assert.assertNotNull(configuration);
    }

}
