package com.connect.CONNECT.service;

import com.connect.CONNECT.entry.User;
import com.connect.CONNECT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public String createNewAccount(User user) throws Exception {
        User db_user = userRepository.findByUsername(user.getUsername());
        if (db_user!=null){
            throw new Exception("User already exist");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        user.setLocalDate(LocalDate.now());
        userRepository.save(user);
        return "Account created";
    }

    public User getUserDetails(String name)
    {
        return userRepository.findByUsername(name);
    }

    public String deleteByUserName(String name) {
        userRepository.deleteById(userRepository.findByUsername(name).getId());
        return "Account deleted.";
    }

    public User updateUserDetails(User user, String name) {

        User db_user = userRepository.findByUsername(name);
        db_user.setUsername(user.getUsername());
        db_user.setPassword(passwordEncoder.encode(user.getPassword()));
        db_user.setEmail_address(user.getEmail_address());
        userRepository.save(db_user);
        return db_user;
    }


    public void saveUser(User user){
        userRepository.save(user);
    }

}