package testServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;

import utils.RestUtils;

public class CadastroPetTest {
	String uri = "https://petstore.swagger.io/v2/";
	String endpoint = "pet";
	
	@Test
	public void validaStatusCode() {
		RestUtils.setUri(uri);
		RestUtils.setEndpoint(endpoint);
		
		
		String json = "{ \"id\": 0,\"category\": {\"id\": 0,\"name\": \"string\"},\"name\": \"doggie\",\"photoUrls\": [\"string\"],\"tags\": [{\"id\": 0,\"name\": \"string\"}],\"status\": \"available\"}";
		RestUtils.post(json);

		assertEquals(200, RestUtils.getStatusCode());
		
	}
	
	@Test
	public void validaStatusCodeMap() {
		RestUtils.setUri(uri);
		RestUtils.setEndpoint(endpoint);
		
		LinkedHashMap<String, Object> json = new LinkedHashMap<>();
		LinkedHashMap<String, Object> category = new LinkedHashMap<>();
		List<String> listPhoto = new ArrayList<String>();
		LinkedHashMap<String, Object> tag = new LinkedHashMap<>();
		List<LinkedHashMap<String, Object>> listTags = new ArrayList<LinkedHashMap<String, Object>>();
		
		
		category.put("id", 0);
		category.put("name", "teste api");
		
		json.put("category", category);
		json.put("name", "doggie");
		listPhoto.add("string");
		json.put("photoUrls", listPhoto);
		tag.put("id", 0);
		tag.put("name", "tag");
		listTags.add(tag);
		json.put("tags", listTags);
		json.put("status", "avaliable");
		
		RestUtils.post(json);
		assertEquals(200, RestUtils.getStatusCode());
		
		assertEquals("teste api", RestUtils.getJsonValue("category.name"));
		assertEquals("doggie", RestUtils.getJsonValue("name"));
		assertEquals("tag", RestUtils.getJsonValue("tags[0].name"));
		assertNotEquals("", RestUtils.getJsonValue("id"));
		assertNotEquals(null, RestUtils.getJsonValue("id"));
	}

}
