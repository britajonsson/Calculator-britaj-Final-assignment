package com.exercise.maven.project_final_assignment_OOP.Interfaces;

/**
 * CalculatorBasicOperationsInterface
 * 
 * @author Brita Jonsson
 * @version 1.0
 *
 */
public interface CalculatorBasicOperationsInterface {
	/**
	 * Calculates the addition of the given summands.
	 * @param firstSummand 
	 * @param secondSummand
	 * @return firstSummand + secondSummand
	 */
	public double addition(double firstSummand, double secondSummand);
	/**
	 * Calculates the subtraction the given minuend and subtrahend.
	 * @param minuend
	 * @param subtrahend
	 * @return minuend - subtrahend
	 */
	public double subtraction(double minuend, double subtrahend);
	/**
	 * Calculates the multiplication the given factors.
	 * @param firstFactor
	 * @param secondFactor
	 * @return firstFactor * secondFactor
	 */
	public double multiplication(double firstFactor, double secondFactor);
	/**
	 * Calculates the division of the given dividend and divisor.
	 * @param dividend
	 * @param divisor
	 * @return dividend / divisor
	 */
	public double division(double dividend, double divisor);
}
