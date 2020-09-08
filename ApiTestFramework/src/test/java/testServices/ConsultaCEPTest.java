package testServices;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ConsultaCEPTest {
	String uri = "https://viacep.com.br/ws/";

	@Test
	public void realizaConsulta() {
		String cep = "04055041";
		String endpoint = cep.concat("/json/");
		
		//given is use to create the prerequisites to execute the test like base uri, type of request and etc.
		// to create request follow the same parameter like gherkin (given, when and then)
		RestAssured.baseURI = uri;
		RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON).given().get(endpoint)
		.then().statusCode(200);
		
	}

}
