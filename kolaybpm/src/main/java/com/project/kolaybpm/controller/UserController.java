package com.project.kolaybpm.controller;

import com.project.kolaybpm.service.UserManagementService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserManagementService userManagementService;

    @RequestMapping(value = "/api/user/save", method = RequestMethod.POST)
    public void saveUser(@RequestBody User user, @RequestBody Group group) {
        userManagementService.saveUser(user, group);
    }

    @RequestMapping(value = "/api/user/detail", method = RequestMethod.GET)
    public ResponseEntity<User> findByUserId(@PathVariable String userId) {
        return new ResponseEntity<User>(userManagementService.findById(userId), HttpStatus.OK);
    }

}
