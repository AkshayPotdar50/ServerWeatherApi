package com.example.weather.weatherApi.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {
    // This method makes a GET request to retrieve weather forecast summary for a given location.
    public String GetCurrentWeatherDataByCityName(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://open-weather13.p.rapidapi.com/city/landon")
                .get()
                .addHeader("content-type", "application/octet-stream")
                .addHeader("X-RapidAPI-Key", "e3a0e636e8msh9440651a93caecdp15aec7jsn7a301cc669d8")
                .addHeader("X-RapidAPI-Host", "open-weather13.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();


        return response.body().string();
    }

    public String getFiveDaysWeatherForecast(String latitude, String longitude) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://open-weather13.p.rapidapi.com/city/fivedaysforcast/30.438/-89.1028")
                .get()
                .addHeader("content-type", "application/octet-stream")
                .addHeader("X-RapidAPI-Key", "e3a0e636e8msh9440651a93caecdp15aec7jsn7a301cc669d8")
                .addHeader("X-RapidAPI-Host", "open-weather13.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();


        return response.body().string();
    }

}




