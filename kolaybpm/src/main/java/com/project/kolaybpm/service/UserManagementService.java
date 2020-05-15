package com.project.kolaybpm.service;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserManagementService {

    public void saveUser(User user, Group group);

    public void deleteUser(String userId);

    public User findById(String userId);
}
