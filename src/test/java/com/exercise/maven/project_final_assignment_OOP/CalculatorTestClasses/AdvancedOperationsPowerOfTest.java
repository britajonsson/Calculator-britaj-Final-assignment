package com.exercise.maven.project_final_assignment_OOP.CalculatorTestClasses;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.logging.Logger;

import org.junit.Test;

import com.exercise.maven.project_final_assignment_OOP.CalculatorClasses.AdvancedCalculator;

public class AdvancedOperationsPowerOfTest {
	Random random = new Random();
	AdvancedCalculator ac = new AdvancedCalculator();
	public static final Logger LOG = Logger.getLogger(AdvancedCalculator.class.getName());
	
	@Test
	public void testPositivePowerOf() {
		double base = 0.0;
		double exponent = 0.0;
		double expectedResult = 0.0;
		
		for (int i = 0; i < 50; i++) {
			base = random.nextInt(9)+1;
			exponent = random.nextInt(9)+1;
			expectedResult = Math.pow(base, exponent);
			
			LOG.info("Testing powerOf method with positives: " + base + " ^ " + exponent + " = " + expectedResult);
			assertEquals(ac.powerOf(base, exponent), expectedResult, 0);
		}
		
	}
	
	@Test
	public void testNegativePowerOf() {
		/*
		 * How does negative power of really work?
		 * Exception handling is needed here.
		 */
		
		double base = 0.0;
		double exponent = 0.0;
		double expectedResult = 0.0;
		
		for (int i = 0; i < 50; i++) {
			base = random.nextInt(5)-5;
			exponent = random.nextInt(4)-4;
			expectedResult = Math.pow(base, exponent);
			
			LOG.info("Testing powerOf method with negatives: " + base + " ^ " + exponent + " = " + expectedResult);
			assertEquals(ac.powerOf(base, exponent), expectedResult, 0);
		}
		
	}
	
	@Test
	public void testPowerOfWithBase0() {
		double base = 0.0;
		double exponent = 0.0;
		double expectedResult = 0.0; 	// My return for this calculation is always 0
		
		for (int i = 0; i < 50; i++) {
			exponent = random.nextInt(9)-10;
			
			LOG.info("Testing powerOf method with base = 0: " + base + " ^ " + exponent + " = " + expectedResult);
			assertEquals(ac.powerOf(base, exponent), expectedResult, 0);
		}
		
	}
	
	@Test
	public void testPowerOfWithExponent0() {
		double base = 0.0;
		double exponent = 0.0;
		double expectedResult = 0.0;
		
		for (int i = 0; i < 50; i++) {
			base = random.nextInt(9)-10;
			expectedResult = Math.pow(base, exponent);
			
			LOG.info("Testing powerOf method with exponent = 0: " + base + " ^ " + exponent + " = " + expectedResult);
			assertEquals(ac.powerOf(base, exponent), expectedResult, 0);
		}
		
	}

}
