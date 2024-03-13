package com.starwars.steps;

import com.starwars.apiutils.Requests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;

public class MyStepdefs {

    Response response = null;

    @When("I send a GET request to {string}")
    public void iSendAGETRequestTo(String uri) {
        response = Requests.get(uri);
    }

    @Then("^the response status should be \"(\\d{3})\"$")
    public void assertStatusCode(int statusCode) {
        Object jsonResponseStatusCode = response.getStatusCode();
        assertEquals(jsonResponseStatusCode, statusCode, "Oops! Something went wrong. Assertion failed. ");
    }

    @And("^the JSON response \"(.*?)\" equals \"(.*?)\"$")
    public void theJSONResponseIsEquals(String str, String expected) {
        String jsonValue = Requests.getJSONPathValue(response, str);
        assertEquals(jsonValue, expected, "Oops! Something went wrong. Assertion failed. ");
    }

    @And("the JSON response {string} is not equals {string}")
    public void theJSONResponseIsNotEquals(String str, String expected) {
        String jsonValue = Requests.getJSONPathValue(response, str);
        assertNotEquals(jsonValue, expected, "Oops! Something went wrong. Assertion failed. ");
    }
}
