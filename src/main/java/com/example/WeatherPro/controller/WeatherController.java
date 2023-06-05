package com.example.WeatherPro.controller;

import com.example.WeatherPro.model.City;
import com.example.WeatherPro.scraper.WeatherScraper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    //  http://localhost:8080/weather/
    @GetMapping("/")
    public String test(){
        WeatherScraper scraper = new WeatherScraper();
        scraper.getKlartData("Helsingborg");
        return "hello";
    }
}
