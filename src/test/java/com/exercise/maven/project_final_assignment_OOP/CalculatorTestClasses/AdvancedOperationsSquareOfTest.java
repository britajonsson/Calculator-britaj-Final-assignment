package com.exercise.maven.project_final_assignment_OOP.CalculatorTestClasses;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Random;
import java.util.logging.Logger;

import com.exercise.maven.project_final_assignment_OOP.CalculatorClasses.AdvancedCalculator;

public class AdvancedOperationsSquareOfTest {
	Random random = new Random();
	AdvancedCalculator ac = new AdvancedCalculator();
	public static final Logger LOG = Logger.getLogger(AdvancedCalculator.class.getName());
	
	@Test
	public void testPositiveSquareOf() {
		double base = 0;
		double expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			base = random.nextInt(10)+1;
			expectedResult = base * base;
			LOG.info("Testing square of method with positives: " + base + "^2" + " = " + expectedResult);
			assertEquals(ac.squareOf(base), expectedResult, 0);
		}
	}
	
	@Test
	public void testNegativeSquareOf() {
		double base = 0;
		double expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			base = random.nextInt(10)-10;
			expectedResult = base * base;
			LOG.info("Testing square of method with negatives: " + base + "^2" + " = " + expectedResult);
			assertEquals(ac.squareOf(base), expectedResult, 0);
		}
	}
	
	@Test
	public void testSquareOfWithBase0() {
		int base = 0;
		int expectedResult = 0;		// Should always be 0
		
		LOG.info("Testing square of method with base = 0: " + base + "^2 " + " = " + expectedResult);
		assertEquals(ac.squareOf(base), expectedResult, 0);
		
		
		
	}
}