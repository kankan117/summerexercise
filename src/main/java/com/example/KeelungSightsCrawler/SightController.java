package com.example.KeelungSightsCrawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SightController {

    @Autowired
    private SightService sightService;

    @CrossOrigin(origins = "*")
    @GetMapping("/SightAPI")
    public ResponseEntity<?> getSights(@RequestParam("zone") String zone) {
        List<Sight> sights = sightService.getSightsByZone(zone);
        if (sights == null || sights.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("該區域的資料未找到");
        }
        return ResponseEntity.ok(sights);
    }
}
