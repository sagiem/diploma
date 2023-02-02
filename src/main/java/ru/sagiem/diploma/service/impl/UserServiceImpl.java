package ru.sagiem.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.sagiem.diploma.model.User;
import ru.sagiem.diploma.repository.UserRepository;
import ru.sagiem.diploma.service.interf.UserService;

import java.util.List;

@Service
public class UserServiceImpl extends AbstractCRUDService<User, Long> implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    CrudRepository<User, Long> getRepository() {
        return userRepository;
    }
}
