package com.exercise.maven.project_final_assignment_OOP.MainClass;

import java.awt.EventQueue;

import com.exercise.maven.project_final_assignment_OOP.CalculatorClasses.AdvancedCalculator;
import com.exercise.maven.project_final_assignment_OOP.CalculatorClasses.SimpleCalculator;

/***
 * Main class
 * 
 * @author Brita Jonsson
 * @version 1.0
 * 
 */
public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorWindow window = new CalculatorWindow();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
