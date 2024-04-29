package com.gurdening_backend.repository;

import java.util.Optional;

import com.gurdening_backend.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByImageUrl(String imageUrl);
}