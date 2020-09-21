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
import utils.RestUtils;

public class ConsultaCEPTest {
	String uri = "https://viacep.com.br/ws/";

	@Test
	public void validateStatusCode() {
		String cep = "04055041";
		String endpoint = cep.concat("/json/");
		RestUtils.setEndpoint(endpoint);
		
		RestUtils.setUri(uri);
	
		RestUtils.get();
		assertEquals(200, RestUtils.getStatusCode());
		
	}
	
	@Test
	public void validationDateCep() {
		String cep = "04055041";
		String endpoint = cep.concat("/json/");
		RestUtils.setEndpoint(endpoint);
		
		LinkedHashMap<String, String> header = new LinkedHashMap<>();
		header.put("client-id", "curso");
		header.put("Authorization", "Basic YWRhbTp0ZXN0ZQ==");
		
		RestUtils.setUri(uri);
		RestUtils.get(header);
		
		assertEquals(200, RestUtils.getStatusCode());
		assertEquals("Rua Mauro", RestUtils.getJsonValue("logradouro"));
		assertEquals("São Paulo", RestUtils.getJsonValue("localidade"));
		
	}
	
	@Test
	public void validationDateCepParam() {
		String cep = "04055041";
		String endpoint = cep.concat("/json/");
		RestUtils.setEndpoint(endpoint);
		
		LinkedHashMap<String, String> param = new LinkedHashMap<>();
		param.put("client-id", "curso");
		param.put("nome", "Teste");
		
		RestUtils.setUri(uri);
		RestUtils.getParams(param);

		assertEquals(200, RestUtils.getStatusCode());
		assertEquals("Rua Mauro", RestUtils.getJsonValue("logradouro"));
		assertEquals("São Paulo", RestUtils.getJsonValue("localidade"));
		
	}
}
