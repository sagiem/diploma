package ru.sagiem.diploma.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sagiem.diploma.model.User;
import ru.sagiem.diploma.security.UserDetailsImpl;


@RestController
@RequestMapping("user-details")
public class UserDetailsRestController {

    @GetMapping
    public ResponseEntity<User> findCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        if (userDetails == null) {
            return ResponseEntity.notFound().build();
        }

        User user = userDetails.getUser();

        return ResponseEntity.ok(user);
    }
}
