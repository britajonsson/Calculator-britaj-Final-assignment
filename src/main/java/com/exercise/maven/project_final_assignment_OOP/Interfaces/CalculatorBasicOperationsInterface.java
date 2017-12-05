package com.exercise.maven.project_final_assignment_OOP.Interfaces;

public interface CalculatorBasicOperationsInterface {
	/**
	 * 
	 * @param firstSummand 
	 * @param secondSummand
	 * @return
	 */
	public double addition(double firstSummand, double secondSummand);
	/**
	 * 
	 * @param minuend
	 * @param subtrahend
	 * @return
	 */
	public double subtraction(double minuend, double subtrahend);
	/**
	 * 
	 * @param firstFactor
	 * @param secondFactor
	 * @return
	 */
	public double multiplication(double firstFactor, double secondFactor);
	/**
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public double division(double dividend, double divisor);
}
