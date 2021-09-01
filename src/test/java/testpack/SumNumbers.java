package testpack;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.Repeatable;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import  org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

class SumNumbers {
	
	private final Sum obj = new Sum();

	@Test
	@DisplayName("Equals method")
	void test() {
		assertEquals(5,obj.sum(2,3));
	}
	
	@Test
	@Disabled
	void testNegative() {
		assertNotEquals(6,obj.sum(4, 9));
	}
	
	@RepeatedTest(5)
	
	void testt() {
		System.out.println("first case");
	}
	
	
	
	

}
