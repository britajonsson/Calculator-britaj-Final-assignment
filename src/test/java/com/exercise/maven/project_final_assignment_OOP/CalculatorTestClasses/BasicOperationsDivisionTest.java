package com.exercise.maven.project_final_assignment_OOP.CalculatorTestClasses;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Random;
import java.util.logging.Logger;

import com.exercise.maven.project_final_assignment_OOP.CalculatorClasses.SimpleCalculator;

public class BasicOperationsDivisionTest {
	Random random = new Random();
	SimpleCalculator sc = new SimpleCalculator();
	public static final Logger LOG = Logger.getLogger(SimpleCalculator.class.getName());
	
	@Test
	public void testPositiveDivision() {
		double dividend = 0;
		double divisor = 0;
		double expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			dividend = random.nextInt(10)+1;
			divisor = random.nextInt(10)+1;
			expectedResult = dividend / divisor;
			LOG.info("Testing division method with positives: " + dividend + " / " + divisor + " = " + expectedResult);
			assertEquals(sc.division(dividend, divisor), expectedResult, 0);
		}
	}
	
	@Test
	public void testNegativeDivision() {
		double dividend = 0;
		double divisor = 0;
		double expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			dividend = random.nextInt(10)-10;
			divisor = random.nextInt(10)-10;
			expectedResult = dividend / divisor;
			LOG.info("Testing division method with negatives: " + dividend + " / " + divisor + " = " + expectedResult);
			assertEquals(sc.division(dividend, divisor), expectedResult, 0);
		}
	}
	
	@Test
	public void testDivisionWithDividend0() {
		double dividend = 0;
		double divisor = 0;
		double expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			divisor = random.nextInt(10)+1;
			expectedResult = dividend / divisor;
			LOG.info("Testing division method with dividend = 0: " + dividend + " / " + divisor + " = " + expectedResult);
			assertEquals(sc.division(dividend, divisor), expectedResult, 0);
		}
		
		
	}
	
	@Test
	public void testDivisionWithDivisor0() {
		double dividend = 0;
		double divisor = 0;
		double expectedResult = 999999999;
		
	
		LOG.info("Testing division method with divisor = 0: " + dividend + " * " + divisor + " = " + expectedResult);
		assertEquals(sc.division(dividend, divisor), expectedResult, 0);
		
	}

}
