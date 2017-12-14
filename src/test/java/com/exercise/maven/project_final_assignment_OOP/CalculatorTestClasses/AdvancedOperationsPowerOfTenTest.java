package com.exercise.maven.project_final_assignment_OOP.CalculatorTestClasses;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Random;
import java.util.logging.Logger;

import com.exercise.maven.project_final_assignment_OOP.CalculatorClasses.AdvancedCalculator;

public class AdvancedOperationsPowerOfTenTest {
	Random random = new Random();
	AdvancedCalculator ac = new AdvancedCalculator();
	public static final Logger LOG = Logger.getLogger(AdvancedCalculator.class.getName());
	
	@Test
	public void testPositivePowerOfTen() {
		double exponent = 0;
		double expectedResult = 10;
		
		for (int i = 0; i < 50; i++) {
			exponent = random.nextInt(10)+1;
			expectedResult = Math.pow(10, exponent);
			LOG.info("Testing power of ten method with positives: 10^" + exponent + " = " + expectedResult);
			assertEquals(ac.powerOfTen(exponent), expectedResult, 0);
		}
	}
	
	@Test
	public void testNegativePowerOfTen() {
		double exponent = 0;
		double expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			exponent = random.nextInt(3)-3;
			expectedResult = Math.pow(10, exponent);
			LOG.info("Testing power of ten method with negatives: 10^" + exponent + " = " + expectedResult);
			assertEquals(ac.powerOfTen(exponent), expectedResult, 0);
		}
	}
	
	@Test
	public void testPowerOfTenWithExponent0() {
		int exponent = 0;
		int expectedResult = 1;		// 10^0 = 1
		LOG.info("Testing power of ten method with exponent = 0: 10^" + exponent + " = " + expectedResult);
		assertEquals(ac.powerOfTen(exponent), expectedResult, 0);
		
		
		
	}
}