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
	 * @param base
	 * @return base ^ 3
	 */
	public double cubeOf(double base);
	/**
	 * Calculates the power of ten for the given number.
	 * @param exponent
	 * @return 10 ^ exponent
	 */
	public double powerOfTen(double exponent);
	/**
	 * Returns the remainder of the division between the given integer values.
	 * @param dividend
	 * @param divisor
	 * @return dividend % divisor
	 */
	public int remainder(int dividend, int divisor);
	/**
	 * Calculates the square of (^2) the given number.
	 * @param base
	 * @return base ^ 2
	 */
	public double squareOf(double base);
	/**
	 * Returns a random value between 0 and 1.
	 * @return Number between 0 and 1
	 */
	public double random0to1();
	
}
