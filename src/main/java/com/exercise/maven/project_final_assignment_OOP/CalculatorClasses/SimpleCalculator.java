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
		if (divisor == 0) {
			System.out.println("You can't divide by zero.");
			return 999999999;
		}
		return dividend / divisor;
	}

}
