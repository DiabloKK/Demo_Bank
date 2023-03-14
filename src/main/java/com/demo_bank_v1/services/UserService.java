package com.demo_bank_v1.services;

import com.demo_bank_v1.models.User;
import com.demo_bank_v1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void registerUser(@Param("first_name")String first_name,
                      @Param("last_name")String last_name,
                      @Param("email")String email,
                      @Param("password")String password,
                      @Param("token")String token,
                      @Param("code")String code) {
        User user = new User(first_name, last_name, email, password, token, code);
        userRepository.save(user);
    }

    public void verifyAccount(@Param("token")String token, @Param("code")String code) {
        User user = userRepository.findByTokenAndCode(token, code);
        user.setToken(null);
        user.setCode(null);
        user.setVerified(1);
        user.setVerified_at(LocalDate.now());
        user.setUpdate_at(LocalDateTime.now());

        userRepository.save(user);

    }

    public boolean checkToken(@Param("token")String token) {
        return userRepository.existsByToken(token);
    }

    public User getUserDetails(@Param("email")String email) {
        return userRepository.getUserByEmail(email);
    }

    public String getUserEmail(@Param("email")String email) {
        if(userRepository.existsByEmail(email)) {
            return userRepository.getUserByEmail(email).getEmail();
        }
        return null;
    }

    public String getUserPassword(@Param("password")String email) {
        if(userRepository.existsByEmail(email)) {
            return userRepository.getUserByEmail(email).getPassword();
        }
        return null;
    }

    public int isVerified(@Param("email")String email) {
        if(userRepository.existsByEmail(email)) {
            return userRepository.getUserByEmail(email).getVerified();
        }
        return 0;
    }

}
