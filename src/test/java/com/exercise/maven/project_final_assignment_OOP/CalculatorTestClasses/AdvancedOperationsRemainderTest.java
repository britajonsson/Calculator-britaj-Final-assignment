package com.exercise.maven.project_final_assignment_OOP.CalculatorTestClasses;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Random;
import java.util.logging.Logger;

import com.exercise.maven.project_final_assignment_OOP.CalculatorClasses.AdvancedCalculator;

public class AdvancedOperationsRemainderTest {
	Random random = new Random();
	AdvancedCalculator ac = new AdvancedCalculator();
	public static final Logger LOG = Logger.getLogger(AdvancedCalculator.class.getName());
	
	@Test
	public void testPositiveRemainder() {
		int dividend = 0;
		int divisor = 0;
		int expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			dividend = random.nextInt(10)+1;
			divisor = random.nextInt(10)+1;
			expectedResult = dividend%divisor;
			LOG.info("Testing remainder method with positives: " + dividend + " % " + divisor + " = " + expectedResult);
			assertEquals(ac.remainder(dividend, divisor), expectedResult, 0);
		}
	}
	
	@Test
	public void testNegativeRemainder() {
		int dividend = 0;
		int divisor = 0;
		int expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			dividend = random.nextInt(10)-10;
			divisor = random.nextInt(10)-10;
			expectedResult = dividend%divisor;
			LOG.info("Testing remainder method with negatives: " + dividend + " % " + divisor + " = " + expectedResult);
			assertEquals(ac.remainder(dividend, divisor), expectedResult, 0);
		}
	}
	
	
	@Test
	public void testRemainderWithDividend0() {
		int dividend = 0;
		int divisor = 0;
		int expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			divisor = random.nextInt(10)+1;
			expectedResult = dividend%divisor;
			LOG.info("Testing remainder method with dividend = 0: " + dividend + " % " + divisor + " = " + expectedResult);
			assertEquals(ac.remainder(dividend, divisor), expectedResult, 0);
		}	
		
		
	}
	
	@Test
	public void testRemainderWithDivisor0() {
		// Create try-catch for ArithmeticException "/ by zero"
		
		int dividend = 0;
		int divisor = 0;
		int expectedResult = 999999999;	// Dummy value set in method (TO BE CHANGED!)
		
		
		LOG.info("Testing remainder method with divisor = 0: " + dividend + " % " + divisor + " = " + expectedResult);
		assertEquals(ac.remainder(dividend, divisor), expectedResult, 0);
		
		
		
	}
}
