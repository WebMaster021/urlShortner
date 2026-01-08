package com.example.urlShortner;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkController {
    private final LinkService service;

    public LinkController(LinkService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public ShortLink createShortLink(@RequestBody ShortLink request) {
        return service.createShortLink(request.getOriginalUrl());
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirectToOriginal(@PathVariable String shortCode) {
        ShortLink link = service.getOriginalLink(shortCode);

        if(link != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(link.getOriginalUrl()));

            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
