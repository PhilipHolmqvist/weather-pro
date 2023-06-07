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
        String[] parts = scraper.getKlartData("skåne", "helsingborg");
        String[] parts1 = scraper.getSmhiData("helsingborg", "2706767");
        String[] parts2 = scraper.getDmiData("helsingborg", "2706767");
        return "hello";
    }
}
