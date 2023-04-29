package com.example.weather.weatherApi.Controller;

import com.example.weather.weatherApi.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/forecast/{city}")
    public ResponseEntity<String> GetCurrentWeatherDataByCityName(@PathVariable("city") String city,
                                                                  @RequestHeader("clientId") String clientId,
                                                            @RequestHeader("clientSecret") String clientSecret) {
        // validate clientId and clientSecret
        if (!validateCredentials(clientId, clientSecret)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // call WeatherService method to get forecast summary
        String forecastSummary = null;
        try {
            forecastSummary = weatherService.GetCurrentWeatherDataByCityName(city);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        // return ResponseEntity with JSON response
        return ResponseEntity.ok(forecastSummary);
    }

    @GetMapping("/forecast/weekly/{latitude}/{longitude}")
    public ResponseEntity<String> getHourlyWeatherForecast(@PathVariable("latitude") String latitude,
                                                           @PathVariable("longitude") String longitude,
                                                           @RequestHeader("clientId") String clientId,
                                                           @RequestHeader("clientSecret") String clientSecret) {
        // validate clientId and clientSecret
        if (!validateCredentials(clientId, clientSecret)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // call WeatherService method to get hourly forecast details
        String hourlyForecast = null;
        try {
            hourlyForecast = weatherService.getFiveDaysWeatherForecast(latitude, longitude);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        // return ResponseEntity with JSON response
        return ResponseEntity.ok(hourlyForecast);
    }

    private boolean validateCredentials(String clientId, String clientSecret) {
        // perform validation logic here

        // for demo purposes, we'll just check that the values are not empty

        if (clientId == null || clientSecret == null) {
            return false;
        }

        if (clientId.isEmpty() || clientSecret.isEmpty()) {
            return false;
        }

        // Add more validation logic here as needed

        return true;
    }
}

