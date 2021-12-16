package com.apitesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class Crud {


    @Test
    public void test_get() {
        RestAssured.baseURI = "https://619d0c18131c600017088d09.mockapi.io";

        int response = given()
                .request(Method.GET, "/fullName/5")
                .prettyPeek()
                .then()
                .extract()
                .response()
                .getStatusCode();


        Assert.assertEquals(response,200);

    }

    @Test
    public void test_update() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstname","khan");
        jsonObject.put("lastname","mohammed");
        jsonObject.put("address","5241 lee hywy");
        jsonObject.put("id","5");
        RestAssured.baseURI = "https://619d0c18131c600017088d09.mockapi.io";
        int response = given()
                .header("Content-Type", "application/json")
                .and()
                .body(jsonObject)
                .when()
                .put("/fullName/7").getStatusCode();
        System.out.println(response);

        Assert.assertEquals(response, 200);

    }

    @Test
    public void test_delete() {
        RestAssured.baseURI = "https://619d0c18131c600017088d09.mockapi.io/fullName/4";

        RequestSpecification httpRequest = given();
        int response = httpRequest.request(Method.DELETE).getStatusCode();
        Assert.assertEquals(response, 2000);

    }

    @Test
    public void test_post() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstname","emad");
        jsonObject.put("lastname","mohammed");
        jsonObject.put("address","5241 lee hywy");
        jsonObject.put("id","8");
        RestAssured.baseURI = "https://619d0c18131c600017088d09.mockapi.io";

        int response = given()
                .header("Content-type", "application/json")
                .and()
                .body(jsonObject)
                .when()
                .post("/fullName")
                .then()
                .extract().response().getStatusCode();
        Assert.assertEquals(response, 201);
    }

}



