package com.example.WeatherPro.repository;

import com.example.WeatherPro.repository.Icons;

import org.springframework.stereotype.Repository;

@Repository
public class WeatherRepository {

    String url = Icons.Sunrise.getUrl();
}
