package com.exercise.maven.project_final_assignment_OOP.CalculatorTestClasses;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Random;
import java.util.logging.Logger;

import com.exercise.maven.project_final_assignment_OOP.CalculatorClasses.SimpleCalculator;

public class BasicOperationsAdditionTest {
	Random random = new Random();
	SimpleCalculator sc = new SimpleCalculator();
	public static final Logger LOG = Logger.getLogger(SimpleCalculator.class.getName());
	
	@Test
	public void testPositiveAddition() {
		int firstSummand = 0;
		int secondSummand = 0;
		int expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			firstSummand = random.nextInt(10)+1;
			secondSummand = random.nextInt(10)+1;
			expectedResult = firstSummand + secondSummand;
			LOG.info("Testing addition method with positives: " + firstSummand + " + " + secondSummand + " = " + expectedResult);
			assertEquals(sc.addition(firstSummand, secondSummand), expectedResult, 0);
		}
	}
	
	@Test
	public void testNegativeAddition() {
		int firstSummand = 0;
		int secondSummand = 0;
		int expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			firstSummand = random.nextInt(10)-10;
			secondSummand = random.nextInt(10)-10;
			expectedResult = firstSummand + secondSummand;
			LOG.info("Testing addition method with negatives: " + firstSummand + " + " + secondSummand + " = " + expectedResult);
			assertEquals(sc.addition(firstSummand, secondSummand), expectedResult, 0);
		}
	}
	
	@Test
	public void testAdditionWithFirstSummand0() {
		int firstSummand = 0;
		int secondSummand = 0;
		int expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			secondSummand = random.nextInt(10)+1;
			expectedResult = firstSummand + secondSummand;
			LOG.info("Testing addition method with firstSummand = 0: " + firstSummand + " + " + secondSummand + " = " + expectedResult);
			assertEquals(sc.addition(firstSummand, secondSummand), expectedResult, 0);
		}
		
		
	}
	
	@Test
	public void testAdditionWithSecondSummand0() {
		int firstSummand = 0;
		int secondSummand = 0;
		int expectedResult = 0;
		
		for (int i = 0; i < 50; i++) {
			firstSummand = random.nextInt(10)+1;
			expectedResult = firstSummand + secondSummand;
			LOG.info("Testing addition method with secondSummand = 0: " + firstSummand + " + " + secondSummand + " = " + expectedResult);
			assertEquals(sc.addition(firstSummand, secondSummand), expectedResult, 0);
		}
	}

}
