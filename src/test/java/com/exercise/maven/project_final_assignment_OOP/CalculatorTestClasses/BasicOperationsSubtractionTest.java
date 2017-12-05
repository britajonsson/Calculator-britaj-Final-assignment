package com.exercise.maven.project_final_assignment_OOP.CalculatorTestClasses;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Random;
import java.util.logging.Logger;

import com.exercise.maven.project_final_assignment_OOP.CalculatorClasses.SimpleCalculator;

public class BasicOperationsSubtractionTest {
	Random random = new Random();
	SimpleCalculator sc = new SimpleCalculator();
	public static final Logger LOG = Logger.getLogger(SimpleCalculator.class.getName());
	
	@Test
	public void testPositiveSubtraction() {
		int minuend = 0;
		int subtrahend = 0;
		int expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			minuend = random.nextInt(10)+1;
			subtrahend = random.nextInt(10)+1;
			expectedResult = minuend - subtrahend;
			LOG.info("Testing subtraction method with positives: " + minuend + " - " + subtrahend + " = " + expectedResult);
			assertEquals(sc.subtraction(minuend, subtrahend), expectedResult, 0);
		}
	}
	
	@Test
	public void testNegativeSubtraction() {
		int minuend = 0;
		int subtrahend = 0;
		int expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			minuend = random.nextInt(10)-10;
			subtrahend = random.nextInt(10)-10;
			expectedResult = minuend - subtrahend;
			LOG.info("Testing subtraction method with negatives: " + minuend + " - " + subtrahend + " = " + expectedResult);
			assertEquals(sc.subtraction(minuend, subtrahend), expectedResult, 0);
		}
	}
	
	@Test
	public void testSubtractionWithMinuend0() {
		int minuend = 0;
		int subtrahend = 0;
		int expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			subtrahend = random.nextInt(10)+1;
			expectedResult = minuend - subtrahend;
			LOG.info("Testing subtraction method with minuend = 0: " + minuend + " - " + subtrahend + " = " + expectedResult);
			assertEquals(sc.subtraction(minuend, subtrahend), expectedResult, 0);
		}
		
		
	}
	
	@Test
	public void testSubtractionWithSubtrahend0() {
		int minuend = 0;
		int subtrahend = 0;
		int expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			minuend = random.nextInt(10)+1;
			expectedResult = minuend - subtrahend;
			LOG.info("Testing subtraction method with subtrahend = 0: " + minuend + " - " + subtrahend + " = " + expectedResult);
			assertEquals(sc.subtraction(minuend, subtrahend), expectedResult, 0);
		}
	}

}
