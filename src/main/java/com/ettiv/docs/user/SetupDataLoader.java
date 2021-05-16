package com.ettiv.docs.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserJpaRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        String email = "hanss@list.ru";
        if (userRepository.findByEmail(email)==null){
            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            Role userRole = roleRepository.findByName("ROLE_USER");
            ArrayList<Role> roles = new ArrayList<Role>();
            // добавим в список ряд элементов
            roles.add(adminRole);
            roles.add(userRole);

            User user = new User();
            user.setFirstName("Пав");
            user.setLastName("Гру");
            user.setPassword(passwordEncoder.encode("privet"));
            user.setEmail(email);
            user.setRoles(roles);
            user.setEnabled(true);
            userRepository.save(user);
        }

        email = "victor@gmail.com";
        if (userRepository.findByEmail(email)==null){
            Role userRole = roleRepository.findByName("ROLE_ADMIN");
            User user = new User();
            user.setFirstName("Вик");
            user.setLastName("Гру");
            user.setPassword(passwordEncoder.encode("123"));
            user.setEmail(email);
            user.setRoles(Arrays.asList(userRole));
            user.setEnabled(true);
            userRepository.save(user);
        }

        email = "user@gmail.com";
        if (userRepository.findByEmail(email)==null){
            Role userRole = roleRepository.findByName("ROLE_USER");
            User user = new User();
            user.setFirstName("User");
            user.setLastName("User");
            user.setPassword(passwordEncoder.encode("123"));
            user.setEmail(email);
            user.setRoles(Arrays.asList(userRole));
            user.setEnabled(true);
            userRepository.save(user);
        }

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

}
