package com.starwars.apiutils;

import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
public class Requests {

    public static Response get(String apiPath) {
        Response response = given().
                when().log().all().get(apiPath.trim());
        response.getBody().prettyPrint();
        return response;
    }

    public static String getJSONPathValue(Response response, String jsonPath) {
        JsonPath jPath = response.jsonPath();
        return jPath.get(jsonPath).toString();
    }
}
