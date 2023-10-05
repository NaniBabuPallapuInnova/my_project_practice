package com.food.app.controler;

import com.food.app.domain.User;
import com.food.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> displayAllUsers() {
        return userService.displayUsers();
    }

    @PostMapping("/save-users")
    public HttpStatus saveAllUsers(@RequestBody List<User> users) {
        userService.saveAllUsers(users);
        return HttpStatus.CREATED;
    }

    @PostMapping("/create-user")
    public HttpStatus createUser(@RequestBody User user) {
        userService.createUser(user);
        return HttpStatus.CREATED;
    }

    @GetMapping("/get-user/{id}")
    public User displayUserById(@PathVariable Integer id) {
        return userService.findById(id);

    }

    @PutMapping("/update-user/{id}")
    public HttpStatus updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.updateUserById(id, user);
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete-user/{id}")
    public HttpStatus deleteUserById(@PathVariable Integer id) {
        userService.deleteByUserId(id);
        return HttpStatus.OK;
    }


}
