package com.library.library.springboot.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.library.library.springboot.model.User;
import com.library.library.springboot.service.UserDaoService;
import com.library.library.springboot.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public EntityModel<User> user(@PathVariable int id){
        User user = userDaoService.getUser(id);
        if (user == null){
            throw new UserNotFoundException("id: "+id);
        }
        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).users());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User saveUser = userDaoService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userDaoService.deleteUserById(id);
    }
}
