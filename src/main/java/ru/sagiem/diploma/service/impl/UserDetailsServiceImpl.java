package ru.sagiem.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sagiem.diploma.model.User;
import ru.sagiem.diploma.repository.UserRepository;
import ru.sagiem.diploma.security.UserDetailsImpl;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User>user = userRepository.findByUsername(username);
        if (user.isEmpty()){
            throw  new UsernameNotFoundException("Пользователь не найден");
        }

        return new UserDetailsImpl(user.get());
    }
}
