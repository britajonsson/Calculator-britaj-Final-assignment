package com.exercise.maven.project_final_assignment_OOP.CalculatorTestClasses;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Random;
import java.util.logging.Logger;

import com.exercise.maven.project_final_assignment_OOP.CalculatorClasses.AdvancedCalculator;

public class AdvancedOperationsCubeOfTest {
	Random random = new Random();
	AdvancedCalculator ac = new AdvancedCalculator();
	public static final Logger LOG = Logger.getLogger(AdvancedCalculator.class.getName());
	
	@Test
	public void testPositiveCubeOf() {
		double base = 0;
		double expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			base = random.nextInt(10)+1;
			expectedResult = base * base * base;
			LOG.info("Testing cube of method with positives: " + base + "^3" + " = " + expectedResult);
			assertEquals(ac.cubeOf(base), expectedResult, 0);
		}
	}
	
	@Test
	public void testNegativeCubeOf() {
		double base = 0;
		double expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			base = random.nextInt(10)-10;
			expectedResult = base * base * base;
			LOG.info("Testing cube of method with negatives: " + base + "^3" + " = " + expectedResult);
			assertEquals(ac.cubeOf(base), expectedResult, 0);
		}
	}
	
	@Test
	public void testCubeOfWithBase0() {
		int base = 0;
		int expectedResult = 0;		// Should always be 0
		
		LOG.info("Testing cube of method with base = 0: " + base + "^3 " + " = " + expectedResult);
		assertEquals(ac.cubeOf(base), expectedResult, 0);
		
		
		
	}
}