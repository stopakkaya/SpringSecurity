package com.platonakademisi.SpringSecurity.service;

import com.platonakademisi.SpringSecurity.model.AppRole;
import com.platonakademisi.SpringSecurity.model.AppUser;
import com.platonakademisi.SpringSecurity.repository.RoleRepository;
import com.platonakademisi.SpringSecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("User saving {}", user.getUsername());
        return userRepo.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        log.info("Role saving {}", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        log.info("User role adding {}, role : {} role", username, role);
        AppUser user = userRepo.findAppUserByUsername(username);
        AppRole appRole = roleRepo.findAppRoleByName(role);
        user.getRoles().add(appRole);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("User is loaded {}", username);
        return userRepo.findAppUserByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Loading all users");
        return userRepo.findAll();
    }
}
