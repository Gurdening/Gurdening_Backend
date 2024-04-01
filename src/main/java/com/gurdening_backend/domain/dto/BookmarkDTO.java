package com.gurdening_backend.domain.dto;

import com.gurdening_backend.domain.Member;
import com.gurdening_backend.domain.Post;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

public class BookmarkDTO {

    @Data
    @Builder
    @Getter
    public static class Response {
        private Long id;
        private Member member;
        private Post post;
    }
}