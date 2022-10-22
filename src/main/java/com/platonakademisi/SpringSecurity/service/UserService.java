package com.platonakademisi.SpringSecurity.service;

import com.platonakademisi.SpringSecurity.model.AppRole;
import com.platonakademisi.SpringSecurity.model.AppUser;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    AppRole saveRole(AppRole role);
    void addRoleToUser(String username, String role);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
