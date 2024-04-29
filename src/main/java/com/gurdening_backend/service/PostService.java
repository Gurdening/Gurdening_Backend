package com.gurdening_backend.service;

import com.gurdening_backend.domain.Post;
import com.gurdening_backend.domain.dto.PostDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostDTO.Response getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 Post가 없습니다. id=" + id));

        return PostDTO.Response.builder()
                .id(post.getId())
                .title(post.getTitle())
                .category(post.getCategory())
                .viewCount(post.getViewCount())
                .content(post.getContent())
                .images(post.getImages())
                .likeCount(post.getLikeCount())
                .build();
    }

    @Transactional(readOnly = true)
    public Slice<PostDTO.Response> getPostsByCategory(Pageable pageable, Category category) {
        Slice<Post> posts = postRepository.findByCategory(pageable, category);

        return posts.map(post -> PostDTO.Response.builder()
                .id(post.getId())
                .title(post.getTitle())
                .category(post.getCategory())
                .viewCount(post.getViewCount())
                .content(post.getContent())
                .images(post.getImages())
                .likeCount(post.getLikeCount())
                .build());
    }

    @Transactional(readOnly = true)
    public Page<PostDTO.Response> getListOfPosts(Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);

        return posts.map(post -> PostDTO.Response.builder()
                .id(post.getId())
                .title(post.getTitle())
                .category(post.getCategory())
                .viewCount(post.getViewCount())
                .content(post.getContent())
                .images(post.getImages())
                .likeCount(post.getLikeCount())
                .build());
    }

}
