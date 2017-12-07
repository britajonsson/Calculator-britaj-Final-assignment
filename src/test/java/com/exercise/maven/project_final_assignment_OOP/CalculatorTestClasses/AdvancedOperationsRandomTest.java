package com.exercise.maven.project_final_assignment_OOP.CalculatorTestClasses;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import com.exercise.maven.project_final_assignment_OOP.CalculatorClasses.AdvancedCalculator;

public class AdvancedOperationsRandomTest {
	AdvancedCalculator ac = new AdvancedCalculator();
	public static final Logger LOG = Logger.getLogger(AdvancedCalculator.class.getName());
			
	@Test
	public void testRandom0to1() {
		double result = 0;
		for (int i = 0; i < 50; i++) {
			result = ac.random0to1();
			LOG.info("Testing random 0 to 1 method with random value: " + result);
			assertTrue((result >= 0) && (result <= 1));
		}
	}

}
