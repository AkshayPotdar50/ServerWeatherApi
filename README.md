# ServerWeatherApi
 server by using SpringBoot Java and integrate Weather API from Rapid API.
 
 Project Title
SpringBoot Weather API Server

Description
This project is a server implementation in Java using SpringBoot framework. It integrates with the Weather API provided by Rapid API and exposes RESTful APIs for retrieving weather forecast data in JSON format. The server supports header-based authentication with a random client id and secret.

APIs
Authentication
Request
Header:

X-CLIENT-ID: a random client id
X-CLIENT-SECRET: a random client secret

Get Weather Forecast Summary by Location Name
Request
[GET /weather/{locationName}/summary](http://localhost:8080/forecast/cityname)

Parameters:

cityName: the name of the city for which to retrieve weather forecast data
Headers:

X-CLIENT-ID: a random client id
X-CLIENT-SECRET: a random client secret
Response
Status Code: 200 OK

Body:-
{
    "city": {
        "name": "City Name",
        "country": "Country Code"
    },
    "description": "Weather summary description",
    "temperature": {
        "current": 15.5,
        "min": 12.3,
        "max": 18.7
    },
    "wind": {
        "speed": 4.5,
        "direction": "NE"
    },
    "humidity": 50,
    "pressure": 1005,
    "visibility": 10
}



**Get Weekly Weather Forecast by Latitude & longitude**

Request:-

http://localhost:8080/forecast/weekly/30.438/-89.1028

Parameters:

Latitude and Longitude OF LOCATION

Headers:
X-CLIENT-ID: a random client id
X-CLIENT-SECRET: a random client secret
Response
Status Code: 200 OK

References
SpringBoot documentation: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
Rapid API documentation: https://docs.rapidapi.com/docs/keys





