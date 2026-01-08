package com.example.urlShortner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShortLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalUrl;
    private String shortCode;

    public ShortLink() {}

    public ShortLink(String originalUrl, String shortCode) {
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
    }

    public Long getId() { return id; }
    public String getOriginalUrl() { return originalUrl; }
    public String getShortCode() { return shortCode; }

    public void setOriginalUrl(String originalUrl) { this.originalUrl = originalUrl; }
    public void setShortCode(String shortCode) { this.shortCode = shortCode; }
}
