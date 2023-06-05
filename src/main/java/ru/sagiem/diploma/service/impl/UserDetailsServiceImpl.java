package ru.sagiem.diploma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sagiem.diploma.model.User;
import ru.sagiem.diploma.model.UserRole;
import ru.sagiem.diploma.repository.RoleRepository;
import ru.sagiem.diploma.repository.UserRepository;
import ru.sagiem.diploma.repository.UserRoleRepository;
import ru.sagiem.diploma.security.UserDetailsImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User>userOptional = loadUserOptionalByUsername(username);
        if (userOptional.isEmpty()){
            throw  new UsernameNotFoundException("Пользователь не найден");
        }
        User user = userOptional.get();
        setAuthorities(user);
        return new UserDetailsImpl(user);
    }

    public Optional<User> loadUserOptionalByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private void setAuthorities(User user) {
        Long userId = user.getId();
        List<UserRole> userRoles = (List<UserRole>) userRoleRepository.findAllByUserId(userId);
        List<Long> roleIds = userRoles.stream().map(userRole -> userRole.getRoleId()).collect(Collectors.toList());
        List<String> authorities = roleIds.stream().map(roleId -> roleRepository.findById(roleId).get().getTitle())
                .collect(Collectors.toList());
        user.setAuthorities(authorities);
    }
}
