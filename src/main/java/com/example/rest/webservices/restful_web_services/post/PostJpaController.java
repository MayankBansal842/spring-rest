package com.example.rest.webservices.restful_web_services.post;

import com.example.rest.webservices.restful_web_services.user.User;
import com.example.rest.webservices.restful_web_services.user.UserJpaController;
import com.example.rest.webservices.restful_web_services.user.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
public class PostJpaController {

    private static final Logger log = LoggerFactory.getLogger(PostJpaController.class);
    private final PostRepository postRepository;

    public PostJpaController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getAllPosts(@PathVariable int id) {
        return postRepository.findAllByUserId(id);
    }

   @GetMapping("/users/{id}/posts/{p_id}")
    public EntityModel<Post> getPost(@PathVariable int id, @PathVariable int p_id) {
        Post post = postRepository.findByIdAndUserId(p_id, id);
        if (post == null) {
            throw new PostNotFoundException("User Id : " + id + " Post Id : " + p_id);
        } else {
            EntityModel<Post> entityModel = EntityModel.of(post);
            WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PostJpaController.class).getAllPosts(id));
            entityModel.add(linkBuilder.withRel("all-posts"));

            return entityModel;
        }
    }

    // Acc. to me in a real word project rather that accepting post as body you should accept some other class object that only contains title and description
    @PostMapping("/users/{id}/posts")
    public void createPost(@PathVariable int id, @RequestBody Post post) {
        User user = postRepository.findAllByUserId(id).getFirst().getUser();
        post.setUser(user);
        log.info("Creating post : " + postRepository.save(post));
    }
}
