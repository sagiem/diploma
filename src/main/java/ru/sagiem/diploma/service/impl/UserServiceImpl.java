package ru.sagiem.diploma.service.impl;

import org.springframework.stereotype.Service;
import ru.sagiem.diploma.model.User;
import ru.sagiem.diploma.service.interf.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void create(User entity) {

    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(User entity) {

    }
}
