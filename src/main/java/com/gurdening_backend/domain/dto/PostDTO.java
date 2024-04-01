package com.gurdening_backend.domain.dto;

import java.util.List;

import com.gurdening_backend.domain.Category;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;


public class PostDTO {

    @Data
    @Builder
    @Getter
    public static class Response {

        private Long id;
        private String title;
        private Category category;
        private int viewCount;
        private List<String> content;
        private List<String> images;
        private int likeCount;

    }
}