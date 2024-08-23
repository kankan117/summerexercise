package com.example.KeelungSightsCrawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SightController {

    @Autowired
    private SightService sightService;

    @CrossOrigin(origins = "*")
    @GetMapping("/SightAPI")
    public List<Sight> getSights(@RequestParam("zone") String zone) {
        return sightService.getSightsByZone(zone);
    }
}
