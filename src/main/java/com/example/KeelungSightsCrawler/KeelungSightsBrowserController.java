package com.example.KeelungSightsCrawler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KeelungSightsBrowserController {

    @GetMapping("/")
    public String index() {
        return "KeelungSightsBrowser";  // 這裡的返回值必須是模板名稱（不含 .html 副檔名）
    }
}

