package com.example.WeatherPro.scraper;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class WeatherScraper {

    //Använder scraping
    public String [] getKlartData(String county, String city) {
        county = county + "-län";
        city = "väder-" + city;
        String url = "https://www.klart.se/se/" + county + "/" + city +"/";
        Document doc = getJsoupDocument(url);

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

    //Använder API.
    public String [] getSmhiData(String city) {
        String geoID = getGeoNamesId(city);

        JSONObject jsonResponse = callAPI("https://www.smhi.se/wpt-a/backend_startpage_nextgen/forecast/fetcher/"+ geoID+ "/10dFormat");

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

    //Använder API.
    public String[] getDmiData(String city){
        String geoID = getGeoNamesId(city);

        JSONObject jsonResponse = callAPI("https://www.dmi.dk/NinJo2DmiDk/ninjo2dmidk?cmd=llj&ids="+geoID);
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

    //Anropa ett API och få json objekt i retur.
    public JSONObject callAPI(String uri){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return new JSONObject(result);
    }

    //Anropa en hemsida och få jsoup document i retur.
    public Document getJsoupDocument(String url){

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

    //Returnerar geoNamesID för en stad. Vissa väderappar använder ID:t som en unik identiferare för en stad.
    public String getGeoNamesId(String cityName){
        String url = "https://public.opendatasoft.com/api/records/1.0/search/?dataset=geonames-all-cities-with-a-population-1000&q=" + cityName + "&sort=name&facet=feature_code&facet=cou_name_en&facet=timezone";
        JSONObject jsonResponse = callAPI(url);
        JSONArray records = jsonResponse.getJSONArray("records");
        JSONObject obj = records.getJSONObject(0);
        JSONObject fields = obj.getJSONObject("fields");
        String geonameID = fields.getString("geoname_id");
        String name = fields.getString("name");
        System.out.println("Geo id: " + geonameID + " name: " + name);
        return geonameID;
    }

    //Hämta vilket län en viss stad ligger i.
    //ToDo: Implement
    public String getCountyForCity(String cityName){
        return null;
    }
}
