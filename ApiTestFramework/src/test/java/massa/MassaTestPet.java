package massa;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import entitites.Category;
import entitites.PetPost;
import entitites.Tag;

public class MassaTestPet {

	public static Category category = new Category(0, "teste api");
	
	public static List<Object> listPhoto = new ArrayList<Object>();
	
	public static Tag tag = new Tag(0, "tag");
	
	public static List<LinkedHashMap<String, Object>> tags = new ArrayList<LinkedHashMap<String, Object>>();
	
	public static PetPost petPost = new PetPost(category, "doggie", listPhoto, tags, "available");
	
	
	public static PetPost geradorMassa() {
		listPhoto.add("string");
		tags.add(tag.get());
		return petPost;
		
	}
}
