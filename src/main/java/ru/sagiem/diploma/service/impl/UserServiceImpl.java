package ru.sagiem.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sagiem.diploma.model.Roles;
import ru.sagiem.diploma.model.User;
import ru.sagiem.diploma.model.UserRole;
import ru.sagiem.diploma.repository.RoleRepository;
import ru.sagiem.diploma.repository.UserRepository;
import ru.sagiem.diploma.repository.UserRoleRepository;
import ru.sagiem.diploma.service.interf.UserService;

import java.util.List;

@Service
public class UserServiceImpl extends AbstractCRUDService<User, Long> implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    CrudRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public void create(User user) {

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        getRepository().save(user);

        //сохранение роли пользователя
        UserRole userRole =new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(roleRepository.findByTitle(Roles.ROLE_USER.name()).get().getId());
        userRoleRepository.save(userRole);


    }
}

