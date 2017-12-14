package com.exercise.maven.project_final_assignment_OOP.CalculatorClasses;

import java.util.Random;

import com.exercise.maven.project_final_assignment_OOP.Interfaces.CalculatorAdvancedOperationsInterface;

/**
 * AdvancedCalculator
 * 
 * @author Brita Jonsson
 * @version 1.0
 *
 **/
public class AdvancedCalculator extends SimpleCalculator implements CalculatorAdvancedOperationsInterface {
	
	/**
	 * Calculates the power of the given base and exponent, in that order.
	 * 
	 * If exponent is 0 the result will automatically be 1.
	 * If base is 0 the result will automatically be 0.
	 * 
	 * @param base
	 * @param exponent
	 * @return base ^ exponent
	 */
	public double powerOf(double base, double exponent) {
		if (exponent == 0) {
			return 1;
		} else if (base == 0) {
			return 0;
		}
		double result = base;
		
		// Loop as many times as the exponent.
		// If exponent is negative, the result is divided with the base for each loop
		if (exponent < 0) {
			for (int i = 1; i > exponent;) {
				i--;
				result = result / base;
			}
			return result;
		}
		
		for (int i = 1; i < exponent; i++) {			// i starts at 1 because base^1 is done in declaration of result
			result = result * base;					// first looping gives base^2 because explanation above
		}
		return result;
	}
	
	/**
	 * Calculates the cube of (^3) the given number.
	 * @param base
	 * @return base ^ 3
	 */
	public double cubeOf(double base) {
		double result = base;
		// Loop three times to return base^3
		for (int i = 1; i < 3; i++) {				// i starts at 1 because base^1 is done in declaration of result
			result = result * base;					// first loop gives base^2 because explanation above
		}
		return result;
	}

	/**
	 * Calculates the power of ten for the given number.
	 * 
	 * If exponent is 0 the result will automatically be 1.
	 * @param exponent
	 * @return 10 ^ exponent
	 */
	public double powerOfTen(double exponent) {
		if (exponent == 0) {
			return 1;
		} 
		double result = 10;							// The base is always 10
		// Loop as many times as the exponent
		// If exponent is negative, the result is divided instead of multiplied
		if (exponent < 0) {
			for (int i = 1; i > exponent;) {
				i--;
				result = result / 10;
			}
			return result;
		}
		
		for (int i = 1; i < exponent; i++) {		// i starts at 1 because 10^1 is done in declaration of result
			result = result * 10;				// first looping gives 10^2 because explanation above
		}
		return result;
	}
	
	/**
	 * Returns the remainder of the division between the given integer values.
	 * Basic logic is:
	 * 
	 * 	dividend / divisor = quotient
	 *  intQuotient = formatted quotient (x.)
	 *  remainder = dividend - (divisor * intQuotient)
	 * 
	 * If the divisor is 0, a message is printed and the result is 999999999.
	 * 
	 * @param dividend
	 * @param divisor
	 * @return dividend % divisor
	 */
	public int remainder(int dividend, int divisor) {
		// Create try-catch for ArithmeticException "/ by zero" ??
		if (divisor == 0) {
			System.out.println("Not possible to calculate remainder with divisor = 0");
			return 999999999;
		}
		int remainder = 0;								// The result of the calculation
		double quotient = dividend / divisor;			// The result of division of dividend and divisor
		// intQuotient should become an integer of quotient without it's decimals (rounded down)
		int intQuotient = (int)Math.floor(quotient);		// The quotient formatted to integer (see previous comment)
		remainder = dividend - (divisor * intQuotient);
		
		return remainder;
	}

	/**
	 * Calculates the square of (^2) the given number.
	 * @param base
	 * @return base ^ 2
	 */
	public double squareOf(double base) {
		return base * base;
	}

	/**
	 * Returns a random value between 0 and 1.
	 * @return Number between 0 and 1
	 */
	public double random0to1() {
		Random random = new Random();
		return random.nextDouble();
	}

}
