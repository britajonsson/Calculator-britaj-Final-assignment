package com.exercise.maven.project_final_assignment_OOP.CalculatorClasses;

import com.exercise.maven.project_final_assignment_OOP.Interfaces.CalculatorBasicOperationsInterface;
/**
 * SimpleCalculator
 * 
 * @author Brita Jonsson
 * @version 1.0
 */
public class SimpleCalculator implements CalculatorBasicOperationsInterface {
	
	/**
	 * Calculates the addition of the given summands.
	 * @param firstSummand 
	 * @param secondSummand
	 * @return firstSummand + secondSummand
	 */
	public double addition(double firstSummand, double secondSummand) {
		return firstSummand + secondSummand;
	}

	/**
	 * Calculates the subtraction the given minuend and subtrahend.
	 * @param minuend
	 * @param subtrahend
	 * @return minuend - subtrahend
	 */
	public double subtraction(double minuend, double subtrahend) {
		return minuend - subtrahend;
	}

	/**
	 * Calculates the multiplication the given factors.
	 * @param firstFactor
	 * @param secondFactor
	 * @return firstFactor * secondFactor
	 */
	public double multiplication(double firstFactor, double secondFactor) {
		return firstFactor * secondFactor;
	}

	/**
	 * Calculates the division of the given dividend and divisor.
	 * If the divisor is 0, a message is printed and the result is 999999999.
	 * 
	 * @param dividend
	 * @param divisor
	 * @return dividend / divisor
	 */
	public double division(double dividend, double divisor) {
		if (divisor == 0) {
			System.out.println("You can't divide by zero.");
			return 999999999;
		}
		return dividend / divisor;
	}

}
