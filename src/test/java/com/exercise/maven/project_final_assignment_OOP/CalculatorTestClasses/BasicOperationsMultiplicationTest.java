package com.exercise.maven.project_final_assignment_OOP.CalculatorTestClasses;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Random;
import java.util.logging.Logger;

import com.exercise.maven.project_final_assignment_OOP.CalculatorClasses.SimpleCalculator;

public class BasicOperationsMultiplicationTest {
	Random random = new Random();
	SimpleCalculator sc = new SimpleCalculator();
	public static final Logger LOG = Logger.getLogger(SimpleCalculator.class.getName());
	
	@Test
	public void testPositiveMultiplication() {
		double firstFactor = 0;
		double secondFactor = 0;
		double expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			firstFactor = random.nextInt(10)+1;
			secondFactor = random.nextInt(10)+1;
			expectedResult = firstFactor * secondFactor;
			LOG.info("Testing multiplication method with positives: " + firstFactor + " * " + secondFactor + " = " + expectedResult);
			assertEquals(sc.multiplication(firstFactor, secondFactor), expectedResult, 0);
		}
	}
	
	@Test
	public void testNegativeMultiplication() {
		double firstFactor = 0;
		double secondFactor = 0;
		double expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			firstFactor = random.nextInt(10)-10;
			secondFactor = random.nextInt(10)-10;
			expectedResult = firstFactor * secondFactor;
			LOG.info("Testing multiplication method with negatives: " + firstFactor + " * " + secondFactor + " = " + expectedResult);
			assertEquals(sc.multiplication(firstFactor, secondFactor), expectedResult, 0);
		}
	}
	
	@Test
	public void testMultiplicationWithFirstFactor0() {
		double firstFactor = 0;
		double secondFactor = 0;
		double expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			secondFactor = random.nextInt(10)+1;
			expectedResult = firstFactor * secondFactor;
			LOG.info("Testing multiplication method with firstFactor = 0: " + firstFactor + " * " + secondFactor + " = " + expectedResult);
			assertEquals(sc.multiplication(firstFactor, secondFactor), expectedResult, 0);
		}
		
		
	}
	
	@Test
	public void testMultiplicationWithSecondFactor0() {
		double firstFactor = 0;
		double secondFactor = 0;
		double expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			firstFactor = random.nextInt(10)+1;
			expectedResult = firstFactor * secondFactor;
			LOG.info("Testing multiplication method with secondFactor = 0: " + firstFactor + " * " + secondFactor + " = " + expectedResult);
			assertEquals(sc.multiplication(firstFactor, secondFactor), expectedResult, 0);
		}
	}

}
