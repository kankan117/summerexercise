package com.example.KeelungSightsCrawler;
import com.example.KeelungSightsCrawler.Sight;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeelungSightsCrawler {

    public Sight[] getItems(String zone) {
        List<Sight> sights = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("https://www.travelking.com.tw/tourguide/taiwan/keelungcity/").get();
            Element guidePointDiv = doc.getElementById("guide-point");

            if (guidePointDiv != null) {
                String targetZone = zone + "區";
                Elements headers = guidePointDiv.select("h4");

                for (Element header : headers) {
                    if (header.text().equals(targetZone)) {
                        // 抓<ul>列表
                        Element nextUl = header.nextElementSibling();
                        if (nextUl != null && nextUl.tagName().equals("ul")) {
                            Elements listItems = nextUl.select("li a");
                            for (Element link : listItems) {
                                String nextSiteUrl = link.absUrl("href");
                                Document sightDoc = Jsoup.connect(nextSiteUrl).get();
                                Element pointArea = sightDoc.getElementById("point_area");

                                if (pointArea != null) {
                                    String name = pointArea.select("meta[itemprop=name]").attr("content");
                                    String photoURL = pointArea.select("meta[itemprop=image]").attr("content");
                                    String description = pointArea.select("meta[itemprop=description]").attr("content");
                                    String address = pointArea.select("meta[itemprop=address]").attr("content");
                                    String category = pointArea.select("cite > span.point_type > span[property='rdfs:label'] strong").text();

                                    Sight sight = new Sight(name, targetZone, category, photoURL, description, address);
                                    sights.add(sight);
                                }
                            }
                        }
                        break;
                    }
                }
            } else {
                System.out.println("No element with id 'guide-point' found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sights.toArray(new Sight[0]);
    }
}