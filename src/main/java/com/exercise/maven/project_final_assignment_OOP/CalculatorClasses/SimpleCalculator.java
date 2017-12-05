package com.exercise.maven.project_final_assignment_OOP.CalculatorClasses;


import com.exercise.maven.project_final_assignment_OOP.Interfaces.CalculatorBasicOperationsInterface;

public class SimpleCalculator implements CalculatorBasicOperationsInterface {

	public double addition(double firstSummand, double secondSummand) {
		return firstSummand + secondSummand;
	}

	public double subtraction(double minuend, double subtrahend) {
		return minuend - subtrahend;
	}

	public double multiplication(double firstFactor, double secondFactor) {
		return firstFactor * secondFactor;
	}

	public double division(double dividend, double divisor) {
		// Handling of division by zero is handled before calling this method,
		// so it's not needed to be handled here.
		return dividend / divisor * OK?;
	}

}
