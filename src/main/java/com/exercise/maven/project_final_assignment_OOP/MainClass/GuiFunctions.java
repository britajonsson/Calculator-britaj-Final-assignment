/*package com.exercise.maven.project_final_assignment_OOP.MainClass;


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

	
	public void pinpadNumberPressed(String pressedNumber) {
		if (isFirstAction) {
			setDisplayValue(Double.parseDouble(pressedNumber));
			isFirstAction = false;
		} else if (display.getText().length() >= 20) {
			// Do nothing, does not fit screen
		} else {	
			String displayValueAsString = df.format(getDisplayValue());
			displayValueAsString = displayValueAsString + pressedNumber;
			setDisplayValue(Double.parseDouble(displayValueAsString));
		}
	}
	
			if (chosenOperator == '/' && !(resultCleared)) {
			result = ac.division(result, secondNumber);
		} else {
			secondNumber = getDisplayValue();
			result = ac.division(firstNumber, secondNumber);
		}
		setDisplayValue(result);
		resultCleared = false;
		isFirstAction = true;

	
}
*/





