package com.stepdefinition;

import org.junit.Assert;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Tc2_SwaggerAPI {

	private String baseUrl;
	private String endpoint;
	private String username;
	private String password;
	private Response response;

	@Given("I set the base URL as {string}")
	public void setBaseUrl(String url) {
		this.baseUrl = url;
	}

	@And("I set the request endpoint as {string}")
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	@And("I set the request body with {string} and {string}")
	public void setRequestBody(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@When("I send a POST request")
	public void sendPostRequest() {
		response = RestAssured.given().baseUri(baseUrl).contentType("application/json")
				.body("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}").post(endpoint);
	}

	@Then("I expect the response status to be {string}")
	public void validateResponseStatus(String statusCode) {
		response.then().statusCode(Integer.parseInt(statusCode));
	}

	@And("I validate the response message contains {string}")
	public void validateResponseMessage(String message) {
		String responseBody = response.getBody().asString();
		Assert.assertTrue( "Response message does not contain 'Unauthorized'",responseBody.contains("Unauthorized"));

	}
}
