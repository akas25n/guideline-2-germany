package com.guideline2germany.controller;

import com.guideline2germany.entity.User;
import com.guideline2germany.exceptions.ResourceNotFoundException;
import com.guideline2germany.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = ("/users"))
    public void createNewUser(@RequestBody User user){
        userService.createUser(user);
    }

    @RequestMapping("/users/{id}" )
    public ResponseEntity<User> findUserById(@PathVariable long id) throws ResourceNotFoundException {
        User user = userService.findUser(id);
        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable long id) throws ResourceNotFoundException {
       User user = userService.updateUserData(newUser, id);
       return ResponseEntity.ok().body(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = ("/users/{id}"))
    public Map<String, Boolean> deleteCurrentUser(@PathVariable long id) throws ResourceNotFoundException{
        userService.deleteUser(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
