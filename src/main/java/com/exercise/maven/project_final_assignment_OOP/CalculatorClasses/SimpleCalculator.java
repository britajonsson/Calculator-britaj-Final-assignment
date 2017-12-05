package com.exercise.maven.project_final_assignment_OOP.CalculatorClasses;


import com.exercise.maven.project_final_assignment_OOP.Interfaces.CalculatorBasicOperationsInterface;

public class SimpleCalculator implements CalculatorBasicOperationsInterface {

	public double addition(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}

	public double subtraction(double firstNumber, double secondNumber) {
		return firstNumber - secondNumber;
	}

	public double multiplication(double firstNumber, double secondNumber) {
		return firstNumber * secondNumber;
	}

	public double division(double firstNumber, double secondNumber) {
		// Handling of division by zero is handled before calling this method,
		// so it's not needed to be handled here.
		return firstNumber / secondNumber * OK?;
	}

}
