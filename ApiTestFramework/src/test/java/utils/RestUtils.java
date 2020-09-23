package utils;

import java.util.LinkedHashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {

	public static String uri;
	public static Response response;
	public static String endpoint;

	public static String getEndpoint() {
		return endpoint;
	}

	public static void setEndpoint(String endpoint) {
		RestUtils.endpoint = endpoint;
	}

	public static String getUri() {
		return uri;
	}

	public static void setUri(String uri) {
		RestAssured.baseURI = uri;
		RestUtils.uri = uri;
	}

	public static Response getResponse() {
		return response;
	}

	public static void setResponse(Response response) {
		RestUtils.response = response;
	}
	
	//given is use to create the prerequisites to execute the test like base uri, type of request and etc.
	// to create request follow the same parameter like gherkin (given, when and then)
	public static RequestSpecification initRequest(ContentType contentType) {
		return RestAssured.given()
		.relaxedHTTPSValidation()
		.contentType(contentType);
		
	}
	

	public static RequestSpecification initRequest(ContentType contentType, LinkedHashMap<String, String> header) {
		return RestAssured.given().relaxedHTTPSValidation().contentType(contentType).headers(header);

	}

	public static void get() {

		Response response = initRequest(ContentType.JSON).when().get(endpoint).then().extract().response();
		setResponse(response);
	}
	
	//request with form-url-encoded
	public static void postUrlEncode(LinkedHashMap<String, String> json) {
		response = initRequest(ContentType.URLENC)
				.formParams(json)
				.when().post(endpoint)
				.then()
				.extract().response();
	}
	
	//request with form-url-encoded with header
	public static void postUrlEncode(LinkedHashMap<String, String> json, LinkedHashMap<String, String> header) {
		response = initRequest(ContentType.URLENC)
				.formParams(json)
				.headers(header)
				.when().post(endpoint)
				.then()
				.extract().response();
	}
	
	public static void post(Object json) {
		response = initRequest(ContentType.JSON)
				.body(json)
				.when().post(endpoint)
				.then()
				.extract().response();
	}
	
	public static void post(Object json, LinkedHashMap<String, String> header) {
		response = initRequest(ContentType.JSON)
				.headers(header)
				.body(json)
				.when().post(endpoint)
				.then()
				.extract().response();
	}
	
	public static int getStatusCode() {
		return getResponse().statusCode();
	}
	
	public static void get(LinkedHashMap<String, String> header) {
		Response response = RestUtils.initRequest(ContentType.JSON)
				
				.headers(header)
				.when()
				.given().get(endpoint)
				.then()
				.extract()
				.response();
		setResponse(response);
	}
	
	public static void getParams(LinkedHashMap<String, String> param) {
		Response  response = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.params(param)
				.when()
				.given().get(endpoint)
				.then()
				.extract()
				.response();
		
		setResponse(response);
	}
	
	public static void getParams(LinkedHashMap<String, String> param,
		LinkedHashMap<String, String> header) {
		Response  response = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				.params(param)
				.headers(header)
				.when()
				.given().get(endpoint)
				.then()
				.extract()
				.response();
		
		setResponse(response);
	}
	
	public static Object getJsonValue(String key) {
		JsonPath json = getResponse().getBody().jsonPath();
		return json.get(key);
		
	}

}
