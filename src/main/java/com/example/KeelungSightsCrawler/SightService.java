package com.example.KeelungSightsCrawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SightService {

    @Autowired
    private SightRepository sightRepository;

    public List<Sight> getSightsByZone(String zone) {
        return sightRepository.findByZone(zone);
    }
}
