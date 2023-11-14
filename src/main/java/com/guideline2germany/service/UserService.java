package com.guideline2germany.service;


import com.guideline2germany.entity.User;
import com.guideline2germany.exceptions.ResourceNotFoundException;

import com.guideline2germany.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void createUser(User user){
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setMobileNumber(user.getMobileNumber());
        newUser.setEmailAddress(user.getEmailAddress());
        newUser.setUserPassword(user.getUserPassword());

        userRepository.save(newUser);
    }

    public User findUser(Long id) throws ResourceNotFoundException{
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not found for this id :: " + id));
        return user;
    }

    public User updateUserData(User newUser, long id) throws ResourceNotFoundException {
        User currentUser = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not found for this id :: " + id));

        currentUser.setFirstName(newUser.getFirstName());
        currentUser.setLastName(newUser.getLastName());
        currentUser.setMobileNumber(newUser.getMobileNumber());
        currentUser.setEmailAddress(newUser.getEmailAddress());

        User updatedUser = userRepository.save(currentUser);
        return updatedUser;
    }

    public void deleteUser(long id) throws ResourceNotFoundException{
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User not found for this id :: " + id));
        userRepository.delete(user);
    }
}
