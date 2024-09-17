package com.example.rest.webservices.restful_web_services.post;

import com.example.rest.webservices.restful_web_services.user.UserJpaController;
import com.example.rest.webservices.restful_web_services.user.UserNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
public class PostJpaController {

    private PostRepository postRepository;

    public PostJpaController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getAllPosts(@PathVariable int id) {
        return postRepository.findAllByUserId(id);
    }

//    @GetMapping("/users/{id}/posts/{p_id}")
//    public EntityModel<Post> getPost(@PathVariable int id, @PathVariable int p_id) {
//        Post post = postRepository.findByIdAndUserId(id, p_id);
//        if (post == null) {
//            throw new PostNotFoundException("User Id : " + id + " Post Id : " + p_id);
//        } else {
//            EntityModel<Post> entityModel = EntityModel.of(post);
//            WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PostJpaController.class).getAllPosts(id));
//            entityModel.add(linkBuilder.withRel("all-posts"));
//
//            return entityModel;
//        }
//    }

    @GetMapping("/users/{id}/posts/{p_id}")
    public Post getPost(@PathVariable int id, @PathVariable int p_id) {
        return postRepository.findByIdAndUserId(id, p_id);
    }
}
