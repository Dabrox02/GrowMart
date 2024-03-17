package com.campus.growmart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campus.growmart.domain.security.JWTAuthtenticationConfig;

@RestController
public class LoginController {

    @Autowired
    JWTAuthtenticationConfig jwtAuthtenticationConfig;

    // @Autowired
    // private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        // Optional<UserEntity> user = userRepository.findByUsername(username);
        // if (!user.isPresent()) {
        // throw new UsernameNotFoundException("No existe el usuario");
        // }

        String token = jwtAuthtenticationConfig.getJWTToken(username);
        return token;
        // return new UserDTO(username, passwordEncoder.encode(password), token);

    }

}