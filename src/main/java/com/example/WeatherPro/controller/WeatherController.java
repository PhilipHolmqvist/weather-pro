package com.example.WeatherPro.controller;

import com.example.WeatherPro.model.City;
import com.example.WeatherPro.scraper.WeatherScraper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherScraper weatherScraper;



    //  http://localhost:8080/weather/?q=helsingborg
    @GetMapping("/")
    public String getCityWeather(@RequestParam("q") String cityName){
        //String[] parts = weatherScraper.getKlartData("stockholms", "stockholm");
        System.out.println("Entered cityname: " + cityName);
        String[] parts1 = weatherScraper.getSmhiData(cityName);
        String[] parts2 = weatherScraper.getDmiData(cityName);
        return "hello";
    }

}
