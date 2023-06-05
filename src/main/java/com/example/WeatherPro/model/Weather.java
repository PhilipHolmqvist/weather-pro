package com.example.WeatherPro.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Weather {
    private int day;
    private ArrayList<Integer> temperatures;
    private int wind;
    private int chanceOfRain;
    private String weatherIconUrl;
    private LocalDateTime date;

    public Weather(){

    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public ArrayList<Integer> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(ArrayList<Integer> temperatures) {
        this.temperatures = temperatures;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public int getChanceOfRain() {
        return chanceOfRain;
    }

    public void setChanceOfRain(int chanceOfRain) {
        this.chanceOfRain = chanceOfRain;
    }

    public String getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(String weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "day=" + day +
                ", temperatures=" + temperatures +
                ", wind=" + wind +
                ", chanceOfRain=" + chanceOfRain +
                ", weatherIconUrl='" + weatherIconUrl + '\'' +
                ", date=" + date +
                '}';
    }
}
