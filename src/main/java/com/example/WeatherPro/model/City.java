package com.example.WeatherPro.model;

import java.util.ArrayList;

public class City {

    private String cityName;
    private String countyName;
    private String countryName;
    private String population;
    private Double metersAboveSeaLevel;
    private String wikiFunFact;
    private ArrayList<Weather> weatherList;

    public City(){

    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public Double getMetersAboveSeaLevel() {
        return metersAboveSeaLevel;
    }

    public void setMetersAboveSeaLevel(Double metersAboveSeaLevel) {
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }

    public String getWikiFunFact() {
        return wikiFunFact;
    }

    public void setWikiFunFact(String wikiFunFact) {
        this.wikiFunFact = wikiFunFact;
    }

    public ArrayList<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(ArrayList<Weather> weatherList) {
        this.weatherList = weatherList;
    }


    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", countyName='" + countyName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", population='" + population + '\'' +
                ", metersAboveSeaLevel=" + metersAboveSeaLevel +
                ", wikiFunFact='" + wikiFunFact + '\'' +
                ", weatherList=" + weatherList +
                '}';
    }
}
