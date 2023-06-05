package com.example.WeatherPro.scraper;

import org.springframework.stereotype.Component;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

@Component
public class WeatherScraper {


    public String getKlartData(String city) {

        Document doc;

        try{
            doc = Jsoup
                    .connect("https://www.klart.se/se/skåne-län/väder-helsingborg/timmar/")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements divs = doc.getElementsByClass("row");

        for (Element divElement: divs){
            Element tempDiv = divElement.select(".col -temp").first();
            Element feelsLikeDiv = divElement.select(".value").first();
            if(tempDiv != null){
                String temperature = tempDiv.text();
                String feelsLikeTemp = feelsLikeDiv.text();
                System.out.println("-----------------------");
                System.out.println("Temperature: " + temperature);
                System.out.println("Feels Like: " + feelsLikeTemp);
                System.out.println("-----------------------");
            }





        }

        return null;
    }
}
