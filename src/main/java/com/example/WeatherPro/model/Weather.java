package com.example.WeatherPro.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Weather {
    private String day;
    private int tempMax;
    private int tempLow;
    private int wind;
    private int chanceOfRain;
    private String weatherIconUrl;
    private LocalDateTime date;

    public Weather(){

    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempLow() {
        return tempLow;
    }

    public void setTempLow(int tempLow) {
        this.tempLow = tempLow;
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
                "day='" + day + '\'' +
                ", tempMax=" + tempMax +
                ", tempLow=" + tempLow +
                ", wind=" + wind +
                ", chanceOfRain=" + chanceOfRain +
                ", weatherIconUrl='" + weatherIconUrl + '\'' +
                ", date=" + date +
                '}';
    }
}
