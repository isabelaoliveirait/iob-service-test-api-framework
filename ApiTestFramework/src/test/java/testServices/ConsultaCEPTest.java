package testServices;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

public class ConsultaCEPTest {
	String uri = "https://viacep.com.br/ws/";

	@Test
	public void validateStatusCode() {
		String cep = "04055041";
		String endpoint = cep.concat("/json/");
		
		//given is use to create the prerequisites to execute the test like base uri, type of request and etc.
		// to create request follow the same parameter like gherkin (given, when and then)
		RestAssured.baseURI = uri;
	
		Response response = get(endpoint);
		assertEquals(200, response.statusCode());
		
	}
	
	@Test
	public void validationDateCep() {
		String cep = "04055041";
		String endpoint = cep.concat("/json/");
		LinkedHashMap<String, String> header = new LinkedHashMap<>();
		header.put("client-id", "curso");
		header.put("Authorization", "Basic YWRhbTp0ZXN0ZQ==");
		
		RestAssured.baseURI = uri;
		
		RequestSpecification request = initRequest(ContentType.JSON, header);
		Response response = request
		.when()
		.given().get(endpoint)
		.then().statusCode(200)
		.extract()
		.response();
		
		JsonPath json = response.getBody().jsonPath();
		
		assertEquals("Rua Mauro", json.get("logradouro"));
		assertEquals("São Paulo", json.get("localidade"));
		
	}
	
	@Test
	public void validationDateCepParam() {
		String cep = "04055041";
		String endpoint = cep.concat("/json/");
		LinkedHashMap<String, String> param = new LinkedHashMap<>();
		param.put("client-id", "curso");
		param.put("nome", "Teste");
		
		RestAssured.baseURI = uri;
		
		
		Response  response = RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
		.param("client-id", "curso")
		.param("nome", "Teste")
		.when()
		.given().get(endpoint)
		.then().statusCode(200)
		.extract()
		.response();
		
		JsonPath json = response.getBody().jsonPath();
		
		assertEquals("Rua Mauro", json.get("logradouro"));
		assertEquals("São Paulo", json.get("localidade"));
		
	}
	
	private RequestSpecification extract() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public RequestSpecification initRequest(ContentType contentType) {
		return RestAssured.given()
		.relaxedHTTPSValidation()
		.contentType(contentType);
		
	}
	
	public RequestSpecification initRequest(ContentType contentType, LinkedHashMap<String, String> header) {
		return RestAssured.given()
		.relaxedHTTPSValidation()
		.contentType(contentType)
		.headers(header);
		
	}
	
	
	public Response get(String endpoint) {
		
		return initRequest(ContentType.JSON)
		.when()
		.get(endpoint)
		.then()
		.extract()
		.response();
		
	}

}
