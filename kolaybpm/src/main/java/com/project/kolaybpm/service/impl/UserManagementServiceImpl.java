package com.project.kolaybpm.service.impl;

import com.project.kolaybpm.service.UserManagementService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    private IdentityService identityService;


    @Override
    public void saveUser(User user, Group group) {
        if (group != null) {
            identityService.saveGroup(group);
        }
        if (user != null) {
            identityService.saveUser(user);
        }
        if (group != null && user != null) {
            //eğer kullanıcı ve grup tanımlıysa tabloda ilişkilendirme yapıldı
            createMemberShip(user.getId(), group.getId());
        }
    }

    @Override
    public void deleteUser(String userId) {
        identityService.deleteUser(userId);
    }


    private void createMemberShip(String userId, String groupId) {
        identityService.createMembership(userId, groupId);
    }
}
