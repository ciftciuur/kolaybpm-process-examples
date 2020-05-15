package com.project.kolaybpm.controller;

import com.project.kolaybpm.service.UserManagementService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Book;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({"classpath:application.properties"})
public class UserManagementControllerTest {

    @LocalServerPort
    private int tomcatLocalPortNo;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private IdentityService identityService;


    @Test
    @Order(1)
    public void saveUser() {
        String url = localHostUrl() + "/user/save";
        User user = identityService.newUser("test");
        user.setEmail("test@gmail.com");
        user.setFirstName("test first name");
        user.setLastName("test last name");
        user.setPassword("test user password");
        Group group = identityService.newGroup("testgroup");
        group.setName("test group name");
        testRestTemplate.postForEntity(url, user, User.class, group, Group.class);


        String getUserUrl = localHostUrl() + "/user/detail?userId=" + user.getId();

        ResponseEntity<User> response = testRestTemplate.getForEntity(getUserUrl, User.class);

        User getSaveUser = response.getBody();


        Assert.assertNotNull(getSaveUser);

    }


    private String localHostUrl() {
        return "http://localhost:" + tomcatLocalPortNo + "/api";
    }

}
