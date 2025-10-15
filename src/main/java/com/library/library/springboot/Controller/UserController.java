package com.library.library.springboot.Controller;

import com.library.library.springboot.model.User;
import com.library.library.springboot.service.UserDaoService;
import com.library.library.springboot.exception.UserNotFoundException;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService){
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> users(){
        return userDaoService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable int id){
        User user = userDaoService.getUser(id);
        if (user == null){
            throw new UserNotFoundException("id: "+id);
        }
        return userDaoService.getUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User saveUser = userDaoService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userDaoService.deleteUser(id);
    }
}
