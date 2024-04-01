package com.gurdening_backend.repository;

import java.util.List;
import java.util.Optional;

import com.gurdening_backend.domain.Bookmark;
import com.gurdening_backend.domain.Member;
import com.gurdening_backend.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Optional<Bookmark> findByPostAndMember(Post post, Member member);
    Optional<Bookmark> findByMemberIdAndPostId(Long memberId, Long postId);
    List<Bookmark> findAllByMember(Member member);
}
