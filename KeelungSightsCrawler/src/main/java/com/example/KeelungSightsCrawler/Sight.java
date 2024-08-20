package com.example.KeelungSightsCrawler;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sights")
public class Sight {
    @Id
    private String sightName;
    private String zone;
    private String category;
    private String photoURL;
    private String address;
    private String description;

    public Sight(String sightName, String zone, String category, String photoURL, String description, String address) {
        this.sightName = sightName;
        this.zone = zone;
        this.category = category;
        this.photoURL = photoURL;
        this.description = description;
        this.address = address;
    }

    public String getSightName() {
        return sightName;
    }

    public void setSightName(String sightName) {
        this.sightName = sightName;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
