package ru.sagiem.diploma.controller.mvc;

import ru.sagiem.diploma.model.User;
import ru.sagiem.diploma.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.security.auth.login.AccountNotFoundException;


@Controller
@RequestMapping("ui/user-details")
public class UserDetailsController {

    public static final String USER_DETAILS_NAME = "user-details";

    private String getEntityName() {
        return USER_DETAILS_NAME;
    }

    @GetMapping
    public String showRead(Model model) throws AccountNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        if(userDetails == null){
            throw  new AccountNotFoundException("Account error");
        }

        User user = userDetails.getUser();
        model.addAttribute("id", user.getId());
        return getEntityName() + "/read";
    }
}
