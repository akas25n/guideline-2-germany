package com.guideline2germany.service;

import com.guideline2germany.entity.User;
import com.guideline2germany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void createUser(User user){
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setMobileNumber(user.getMobileNumber());
        newUser.setEmailAddress(user.getEmailAddress());

        userRepository.save(newUser);
    }
}
