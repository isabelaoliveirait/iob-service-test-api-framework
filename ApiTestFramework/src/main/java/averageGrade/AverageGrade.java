package averageGrade;

import java.util.LinkedHashMap;

public class AverageGrade {

	int grade1;
	int grade2;

	public AverageGrade(int grade1, int grade2) {
		this.grade1 = grade1;
		this.grade2 = grade2;
	}

	public String getResult() {
		int sum = grade1 + grade2;
		if (sum < 12) {
			return "Failed";
		}
		return "Passed";
	}
	
//	public void Test() {
//		String time = "sunny";
//		String result = "";
//		
//		switch (time) {
//		case "sunny":
//			result = "leave at home with mask";
//			break;
//		case "raining":
//			result = "leave at home with umbrella";
//			break;
//		
//		case "snowing":
//			result = "Stay at home";
//			break;
//		default:
//			break;
//		}
//	}
	
	public void TestMap() {
		String time = "sunny";
		String result = "";
		
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("sunny", "leave at home with mask");
		map.put("raining", "leave at home with umbrella");
		map.put("snowing", "Stay at home");
		
		result = map.get(time);
	}

}
