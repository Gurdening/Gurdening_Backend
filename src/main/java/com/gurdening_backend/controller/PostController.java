package com.gurdening_backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("post/{id}")
    public ResponseEntity<PostDTO.Response> getPost(@PathVariable Long id) {
        PostDTO.Response post = postService.getPost(id);
        return ResponseEntity.ok(post);
    }
    @GetMapping("post/category/{category}")
    public ResponseEntity<Slice<PostDTO.Response>> getPostsByCategory(Pageable pageable, @PathVariable Category category) {
        Slice<PostDTO.Response> posts = postService.getPostsByCategory(pageable, category);
        return ResponseEntity.ok(posts);
    }
    @GetMapping("post/list")
    public ResponseEntity<Page<PostDTO.Response>> getListOfPosts(Pageable pageable) {
        Page<PostDTO.Response> posts = postService.getListOfPosts(pageable);
        return ResponseEntity.ok(posts);
    }

}
