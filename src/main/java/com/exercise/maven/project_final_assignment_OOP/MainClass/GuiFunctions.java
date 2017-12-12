package com.exercise.maven.project_final_assignment_OOP.MainClass;

import java.text.DecimalFormat;

public class GuiFunctions extends CalculatorWindow {

	public DecimalFormat df = new DecimalFormat("0.#################");
	
	
	public double getDisplayValue() {
		double displayValue = Double.parseDouble(display.getText());
		return displayValue;
	}
	
	public void setDisplayValue(double toBeDisplayed) {
		display.setText(df.format(toBeDisplayed));
	}

}
