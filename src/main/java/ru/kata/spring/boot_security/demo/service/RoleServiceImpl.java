package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepositories;

import java.util.List;
@Service
//@Transactional
public class RoleServiceImpl implements RoleService{
    RoleRepositories roleRepositories;

    //@Autowired
    public RoleServiceImpl(RoleRepositories roleRepositories) {
        this.roleRepositories = roleRepositories;
    }
    @Override
    public List<Role> findAll() {
        return roleRepositories.findAll();
    }

    //@Transactional
    @Override
    public void addRole(Role role) {
        roleRepositories.save(role);
    }

}
