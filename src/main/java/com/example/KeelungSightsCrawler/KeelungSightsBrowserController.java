package com.example.KeelungSightsCrawler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KeelungSightsBrowserController {
    @GetMapping("/")
    public String index() {
        return "KeelungSightsBrowser";
    }
}

