package ru.sagiem.diploma.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sagiem.diploma.model.User;
import ru.sagiem.diploma.service.interf.CRUDService;
import ru.sagiem.diploma.service.interf.UserService;

@RestController
@RequestMapping(UserRestController.USER_REST_URL)
public class UserRestController extends CRUDRestController<User, Long> {
    public static final String USER_REST_URL = "user";

    @Autowired
    private UserService userService;

    @Override
    CRUDService<User, Long> getService() {
        return userService;
    }
}
