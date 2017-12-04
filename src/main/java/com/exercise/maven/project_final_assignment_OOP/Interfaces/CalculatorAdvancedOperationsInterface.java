package com.exercise.maven.project_final_assignment_OOP.Interfaces;

public interface CalculatorAdvancedOperationsInterface {
	/**
	 * Calculates the power of the given base and exponent, in that order.
	 * @param base
	 * @param exponent
	 * @return base ^ exponent
	 */
	public double powerOf(double base, double exponent);
	/**
	 * Calculates the cube of (^3) the given number.
	 * @param number
	 * @return number ^ 3
	 */
	public double cubeOf(double number);
	/**
	 * Returns the remainder of the divison between the given values.
	 * @param divident
	 * @param divisor
	 * @return divident % divisor
	 */
	public double remainder(double divident, double divisor);
	/**
	 * Calculates the square of (^2) the given number.
	 * @param number
	 * @return number ^ 2
	 */
	public double squareOf(double number);
	/**
	 * Calculates the power of ten for the given number.
	 * @param number
	 * @return 10 ^ number
	 */
	public double powerOfTen(double number);
	/**
	 * Returns a random value between 0 and 1.
	 * @return Number between 0 and 1
	 */
	public double random0to1();
	
}
