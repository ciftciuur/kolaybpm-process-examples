package com.project.kolaybpm.controller;

import com.project.kolaybpm.service.UserManagementService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserManagementService userManagementService;

    @RequestMapping(value = "/api/activiti/user/save", method = RequestMethod.POST)
    public void saveUser(@RequestBody User user, @RequestBody Group group) {
        userManagementService.saveUser(user, group);
    }

}
