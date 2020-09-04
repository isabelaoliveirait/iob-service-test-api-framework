package tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import averageGrade.AverageGrade;

public class AverageGradeTest {

	//Unit tests
	// two notes and receive the result if it was approved
	// average smaller than 6 failed and bigger than 6 passed
	
	@Test
	public void testFailed() {
		int grade1 = 5;
		int grade2 = 5;
		String result = "";
		AverageGrade averageGrade = new AverageGrade(grade1, grade2);
		result = averageGrade.getResult();
		assertEquals("Failed", result);
		
	}
	
	@Test
	public void testPassed() {
		String result = "";
		AverageGrade averageGrade = new AverageGrade(6, 6);
		result = averageGrade.getResult();
		assertEquals("Passed", result);
	
	}
	
}
