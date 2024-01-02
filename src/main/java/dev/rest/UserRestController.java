package dev.rest;

import dev.domain.User;
import dev.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

//add user
    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        userService.create(user);
        return "Successful";
    }
//update specific user
    @PutMapping("/{users}")
    public String updateUser(@PathVariable("users") int users, @RequestBody User user) {

        userService.edit(user);
        return "Successful";
    }
    //gett all user
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/count")
    public Long getTotalUserCount() {
        return userService.countUsers();
    }

    //get specific user data
    @GetMapping("/users/{id}")
    public User addUser(@PathVariable("id") int id) {
        return userService.get(id);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "Successful";
    }


}
