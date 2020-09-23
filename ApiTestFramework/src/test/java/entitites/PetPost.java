package entitites;

import java.util.LinkedHashMap;
import java.util.List;

public class PetPost {

private LinkedHashMap<String, Object> petpost = new LinkedHashMap<>();
	
	public PetPost(Category category, Object name, List<Object> photoUrls, List<LinkedHashMap<String, Object>> tags, Object status) {
		petpost.put("category", category.get());
		petpost.put("name", name);
		petpost.put("photoUrls", photoUrls);
		petpost.put("tags", tags);
		petpost.put("status", status);
	}

	public void setPetPost(String key, Object value) {
		petpost.put(key, value);
		
	}
	
	public void setPetPost(LinkedHashMap<String, Object> map) {
		petpost.putAll(map);
	}
	
	public LinkedHashMap<String, Object> get(){
		return petpost;
	}
	
	
	
	
	
}
