package com.gurdening_backend.repository;

import java.util.Optional;

import com.gurdening_backend.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String userEmail);
}