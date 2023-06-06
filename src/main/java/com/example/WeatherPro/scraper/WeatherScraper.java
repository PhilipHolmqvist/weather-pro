package com.example.WeatherPro.scraper;

import org.springframework.stereotype.Component;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
        System.out.println("Test");

        String[] parts = temperature.split(" ");
        String tempHigh = parts[0];
        String tempLow = parts[1];
        System.out.println("------------------");
        System.out.println("Klart:");
        System.out.println("Temp High: " + tempHigh);
        System.out.println("Temp low: " + tempLow);
        System.out.println("-------------------");

        return parts;
    }


    //Skyddad
    public String [] getSmhiData(String city, String geoNamesId) {
        String cityLetterUppercase = city.substring(0, 1).toUpperCase() + city.substring(1);
        System.out.println("https://www.smhi.se/vader/prognoser/ortsprognoser/q/" + cityLetterUppercase + "/" + geoNamesId);
        Document doc = connect("https://www.smhi.se/vader/prognoser/ortsprognoser/q/" + cityLetterUppercase + "/" + geoNamesId);

        String tempHigh = "";
        String tempLow = "";

        try{
            Element root = doc.getElementById("article");
            System.out.println("root: " + root);
            tempHigh = doc.getElementsByClass("jVmkZ").first().text();
            tempLow = doc.getElementsByClass("wDJQv").first().text();

            System.out.println("----");
            System.out.println("SMHI:");
            System.out.println("Temp High: " + tempHigh);
            System.out.println("Temp low: " + tempLow);

        }catch (NullPointerException e){
            e.printStackTrace();
        }

        String[] parts = {tempHigh, tempLow};


        return parts;
    }

    //Skyddad
    public String[] getDmiData(String city, String geoNamesId){

        String cityLetterUppercase = city.substring(0, 1).toUpperCase() + city.substring(1);
        String url = "https://www.dmi.dk/lokation/show/SE/"+ geoNamesId + "/" + cityLetterUppercase + "/";
        System.out.println(url);
        Document doc = connect(url);

        try{
            Element root = doc.getElementById("container1");
            System.out.println("root: " + root);




        }catch (NullPointerException e){
            e.printStackTrace();
        }


        return null;
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
