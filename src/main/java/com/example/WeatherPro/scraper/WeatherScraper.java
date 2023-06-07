package com.example.WeatherPro.scraper;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;

import java.io.IOException;
import java.sql.SQLOutput;

@Component
public class WeatherScraper {


    public String [] getKlartData(String county, String city) {
        county = county + "-län";
        city = "väder-" + city;
        String url = "https://www.klart.se/se/" + county + "/" + city +"/";
        Document doc = connect(url);

        Element div = doc.getElementById("day-1");
        String temperature = div.getElementsByClass("col -temp").first().text();
        String wind = div.getElementsByClass("item-child wind-value").first().text();
        System.out.println("Test");

        String[] parts = temperature.split(" ");
        String tempMax = parts[0];
        String tempMin = parts[1];
        System.out.println("------------------");
        System.out.println("Klart:");
        System.out.println("Temp High: " + tempMax);
        System.out.println("Temp low: " + tempMin);
        System.out.println("Wind: " + wind);
        System.out.println("-------------------");

        return parts;
    }


    //Gick inte att scrapea så använder deras API.
    public String [] getSmhiData(String city, String geoNamesId) {

        JSONObject jsonResponse = callAPI("https://www.smhi.se/wpt-a/backend_startpage_nextgen/forecast/fetcher/2706767/10dFormat");

        JSONArray daySerie = jsonResponse.getJSONArray("daySerie"); //Från js array måste vi hämta data.
        JSONObject today = daySerie.getJSONObject(0); //Från array väljer vi första dagen i listan.

        //Hämta temperaturer.
        String tempMax = today.get("max").toString();
        String tempMin = today.get("min").toString();

        //Hämta vind
        JSONArray data = today.getJSONArray("data");
        JSONObject thisHour = data.getJSONObject(0);
        String windSpeed = thisHour.getString("ws");
        String gusts = thisHour.getString("gust");

        System.out.println("-------------------");
        System.out.println("SMHI");
        System.out.println("Temp max: " + tempMax + " Temp min: " + tempMin);
        System.out.println("Wind speed: " + windSpeed + " Gusts: " + gusts);
        System.out.println("-------------------");



        return null;
    }


    public String[] getDmiData(String city, String geoNamesId){
        JSONObject jsonResponse = callAPI("https://www.dmi.dk/NinJo2DmiDk/ninjo2dmidk?cmd=llj&ids=2706767");
        JSONArray aggData = jsonResponse.getJSONArray("aggData");

        //Temperaturer för hela dagen.
        JSONObject today = aggData.getJSONObject(0);

        Double tempMax = today.getDouble("maxTemp");
        Double tempMin = today.getDouble("minTemp");


        //Vind visas i 6h intervaller och inte för dagen.
        JSONArray sixHourSymbols = jsonResponse.getJSONArray("sixHourSymbols");
        JSONObject currentInterval = sixHourSymbols.getJSONObject(0);
        Double windSpeed = currentInterval.getDouble("windSpeed6");

        //Konvertera talet till en decimal.
        windSpeed = windSpeed * Math.pow(10, 1);
        windSpeed = Math.floor(windSpeed);
        windSpeed = windSpeed / Math.pow(10, 1);


        System.out.println("-------------------");
        System.out.println("DMI");
        System.out.println("Temp max: " + tempMax + " Temp min: " + tempMin);
        System.out.println("Wind speed: " + windSpeed);

        return null;

    }

    public JSONObject callAPI(String uri){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return new JSONObject(result);
    }

    public Document connect(String url){

        Document doc;

        try{
            doc = Jsoup
                    .connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return doc;
    }
}
