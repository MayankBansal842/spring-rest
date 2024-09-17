//package com.example.rest.webservices.restful_web_services.user;
//
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//import java.util.List;
//
//@RestController
//public class UserResourceController {
//    private UserDaoService userDaoService;
//    public UserResourceController(UserDaoService userDaoService) {
//        this.userDaoService = userDaoService;
//    }
//
//    @GetMapping("/users")
//    public List<User> getAllUsers() {
//        return userDaoService.getAllUsers();
//    }
//
////    WebMvcLinkBuilder is used to add links
////    To use hateoas we will wrap the  user with entity model
//    @GetMapping("/users/{id}")
//    public EntityModel<User> getUser(@PathVariable int id) {
//        User user = userDaoService.getUserById(id);
//        if (user == null) {
//            throw new UserNotFoundException("id=" + id);
//        } else {
//            EntityModel<User> entityModel = EntityModel.of(user);
//            WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserResourceController.class).getAllUsers());
//
//            entityModel.add(linkBuilder.withRel("allUsers"));
//            return entityModel;
//        }
//    }
//
//    @PostMapping("/users")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User addedUser  = userDaoService.addUser(user);
//        URI location = ServletUriComponentsBuilder
//                            .fromCurrentRequest()
//                            .path("/{id}")
//                            .buildAndExpand(addedUser.getId())
//                            .toUri();
//        return ResponseEntity.created(location).build();
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable int id) {
//        userDaoService.deleteUserById(id);
//    }
//}
