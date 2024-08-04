package com.guideline2germany.controller;

import com.guideline2germany.entity.User;
import com.guideline2germany.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public String getUserList(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userList";
    }


/*   @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public void createNewUser(@RequestBody User user){
        userService.createUser(user);
    }

    @RequestMapping("/{id}" )
    public ResponseEntity<User> findUserById(@PathVariable long id) throws ResourceNotFoundException {
        User user = userService.findUser(id);
        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable long id) throws ResourceNotFoundException {
       User user = userService.updateUserData(newUser, id);
       return ResponseEntity.ok().body(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = ("/{id}"))
    public Map<String, Boolean> deleteCurrentUser(@PathVariable long id) throws ResourceNotFoundException{
        userService.deleteUser(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }*/


}
