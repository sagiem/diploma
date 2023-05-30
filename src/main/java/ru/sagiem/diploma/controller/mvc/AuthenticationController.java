package ru.sagiem.diploma.controller.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sagiem.diploma.model.User;
import ru.sagiem.diploma.service.interf.UserService;
import ru.sagiem.diploma.validator.UserValidator;

import javax.naming.Binding;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "auth/registration";
    }

    @PostMapping("/process-registration")
    public String processRegistration(@ModelAttribute("user") @Valid User user,
                                      BindingResult bindingResult) {

        //check if user already exists
        userValidator.validate(user, bindingResult);

        if(bindingResult.hasErrors()){
            return "auth/registration";
        }

        userService.create(user);
        return "redirect:/auth/login";
    }
}
