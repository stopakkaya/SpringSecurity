package com.platonakademisi.SpringSecurity.repository;

import com.platonakademisi.SpringSecurity.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findAppRoleByName(String name);
}
