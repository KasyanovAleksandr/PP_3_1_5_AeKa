package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;


@Component
public class TestClass {

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public TestClass(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init(){
        if (
                (roleService.findAll().size() != 2) &&
                        (userService.findByName("admin") == null)
        ) {

            User admin = new User("Admin", "Admin", "20", "100");
            Role adminRole = new Role("ROLE_ADMIN");
            roleService.addRole(adminRole);
            admin.addRole(adminRole);
            userService.saveUser(admin);
        }
    }
}
