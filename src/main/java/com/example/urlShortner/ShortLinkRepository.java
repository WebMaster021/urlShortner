package com.example.urlShortner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortLinkRepository extends JpaRepository<ShortLink, Long> {
    ShortLink findByShortCode(String shortCode);
}
