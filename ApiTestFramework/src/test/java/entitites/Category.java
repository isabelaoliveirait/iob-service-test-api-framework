package entitites;

import java.util.LinkedHashMap;

public class Category {
	
	
	private LinkedHashMap<String, Object> category = new LinkedHashMap<>();
	
	public Category(Object id, Object name) {
		category.put("id", id);
		category.put("name", name);
		
	}

	public void setCategory(String key, Object value) {
		category.put(key, value);
		
	}
	
	public void setCategory(LinkedHashMap<String, Object> map) {
		category.putAll(map);
	}
	
	public LinkedHashMap<String, Object> get(){
		return category;
	}
	
	
	
}
