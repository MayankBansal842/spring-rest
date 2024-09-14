package com.example.rest.webservices.restful_web_services.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResourceController {
    private UserDaoService userDaoService;
    public UserResourceController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDaoService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = userDaoService.getUserById(id);
        if (user == null) {
            throw new UserNotFoundException("id=" + id);
        } else {
            return user;
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User addedUser  = userDaoService.addUser(user);
        URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(addedUser.getId())
                            .toUri();
        return ResponseEntity.created(location).build();
    }
}
