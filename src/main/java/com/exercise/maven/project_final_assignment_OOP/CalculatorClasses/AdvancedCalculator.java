package com.exercise.maven.project_final_assignment_OOP.CalculatorClasses;

import java.text.Format;
import java.util.Random;

import com.exercise.maven.project_final_assignment_OOP.Interfaces.CalculatorAdvancedOperationsInterface;

public class AdvancedCalculator implements CalculatorAdvancedOperationsInterface {
	
	public double powerOf(double base, double exponent) {
		if (exponent == 0) {
			return 1;
		} else if (base == 0) {
			return 0;
		}
		double result = base;
		// Loop as many times as the exponent
		for (int i = 1; i < exponent; i++) {			// i starts at 1 because base^1 is done in declaration of result
			result = result * base;					// first looping gives base^2 because explanation above
		}
		return result;
	}

	public double cubeOf(double base) {
		double result = base;
		// Loop three times to return base^3
		for (int i = 1; i < 3; i++) {				// i starts at 1 because base^1 is done in declaration of result
			result = result * base;					// first loop gives base^2 because explanation above
		}
		return result;
	}

	public double powerOfTen(double exponent) {
		if (exponent == 0) {
			return 1;
		} 
		double result = 10;							// The base is always 10
		// Loop as many times as the exponent
		for (int i = 1; i < exponent; i++) {			// i starts at 1 because 10^1 is done in declaration of result
			result = result * 10;					// first looping gives 10^2 because explanation above
		}
		return result;
	}
	
	public int remainder(int dividend, int divisor) {
		/*
		 * dividend / divisor = quotient
		 * intQuotient = formatted quotient (x.)
		 * remainder = dividend - (divisor * intQuotient)
		 * 
		 */
	
		// Handling of division by zero is handled before calling this method,
		// so it's not needed to be handled here.
		
		int remainder = 0;								// The result of the calculation
		double quotient = dividend / divisor;			// The result of division of dividend and divisor
		
		// intQuotient should become an integer of quotient without it's decimals (rounded down)
		int intQuotient = (int)Math.floor(quotient);		// The quotient formatted to integer (see previous comment)
		remainder = dividend - (divisor * intQuotient);
		
		return remainder;
	}

	public double squareOf(double base) {
		return base * base;
	}

	public double random0to1() {
		Random random = new Random();
		return random.nextDouble();
	}

}
