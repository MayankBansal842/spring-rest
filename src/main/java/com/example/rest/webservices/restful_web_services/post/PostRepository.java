package com.example.rest.webservices.restful_web_services.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    public List<Post> findAllByUserId(int id);
    public Post findByIdAndUserId(int id, int userId);
}
