package ru.sagiem.diploma.validator;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.sagiem.diploma.model.User;
import ru.sagiem.diploma.service.impl.UserDetailsServiceImpl;

import java.util.Objects;
import java.util.Optional;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        User userToValidate = (User) obj;
        Optional<User> userFromDB = userDetailsService.loadUserOptionalByUsername(userToValidate.getUsername());
        if(userFromDB.isPresent()){
            errors.rejectValue("username", "400",
                    "Пользователь с таким именет уже существует");
        }

    }
}
