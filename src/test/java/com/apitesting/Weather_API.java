package com.apitesting;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.Scanner;

import static io.restassured.RestAssured.given;

public class Weather_API {

    @Test
    public void getRandomCityWeather_API_Test(){
        RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/weather";
        given()
                .queryParam("q","khartoum")
                .queryParam("appid","160eab60196dead891feb6d21dadafde")
                .queryParam("lang","ar")
                .get()
                .prettyPeek();
    }

    public static void main(String[] args) {
    for (int i=0;i<3;i++){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter city for temp");
        System.out.println("write x to exit");

        String city = scanner.nextLine();
        RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/weather";
        given()
                .queryParam("q",city)
                .queryParam("appid","160eab60196dead891feb6d21dadafde")
                .queryParam("lang","ar")
                .get()
                .prettyPeek();


    }




    }
}
