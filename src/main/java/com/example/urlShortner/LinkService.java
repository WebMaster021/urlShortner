package com.example.urlShortner;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LinkService {
    private final ShortLinkRepository repository;

    public LinkService(ShortLinkRepository repository) {
        this.repository = repository;
    }

    public ShortLink createShortLink(String originalUrl) {
        String randomCode = UUID.randomUUID().toString().substring(0, 6);
        ShortLink newLink = new ShortLink(originalUrl, randomCode);
        return repository.save(newLink);
    }

    public ShortLink getOriginalLink(String shortCode) {
        return repository.findByShortCode(shortCode);
    }

}
