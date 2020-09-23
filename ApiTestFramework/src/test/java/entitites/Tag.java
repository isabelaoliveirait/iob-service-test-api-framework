package entitites;

import java.util.LinkedHashMap;

public class Tag {

private LinkedHashMap<String, Object> tag = new LinkedHashMap<>();
	
	public Tag(Object id, Object name) {
		tag.put("id", id);
		tag.put("name", name);
		
	}

	public void setTag(String key, Object value) {
		tag.put(key, value);
		
	}
	
	public void setTag(LinkedHashMap<String, Object> map) {
		tag.putAll(map);
	}
	
	public LinkedHashMap<String, Object> get(){
		return tag;
	}
	
	
}
