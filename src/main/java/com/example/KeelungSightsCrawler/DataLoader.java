package com.example.KeelungSightsCrawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Autowired
    private SightRepository sightRepository;

    @Bean
    ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) {
                // 執行爬蟲 儲存資料到 MongoDB
                KeelungSightsCrawler crawler = new KeelungSightsCrawler();
                String[] zones = {"中山", "信義", "仁愛", "中正", "安樂", "七堵", "暖暖"};
                for (String zone : zones) {
                    Sight[] sights = crawler.getItems(zone);
                    for (Sight sight : sights) {
                        sightRepository.save(sight);
                    }
                }
            }
        };
    }
}
