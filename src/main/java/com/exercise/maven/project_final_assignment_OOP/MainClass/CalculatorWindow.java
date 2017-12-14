package com.exercise.maven.project_final_assignment_OOP.MainClass;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

import com.exercise.maven.project_final_assignment_OOP.CalculatorClasses.AdvancedCalculator;

/***
 * CalculatorWindow
 * 
 * @author Brita Jonsson
 * @version 1.0
 * 
 * This class was intended to be separated into one GUI class
 * and one class for methods and functions to the calculator.
 * This will be fixed in a later version, promise!
 */
public class CalculatorWindow {

	public AdvancedCalculator ac = new AdvancedCalculator();
	public JFrame frame = new JFrame();
	public JButton btnPinpad0 = new JButton("0");
	public JButton btnPinpad1 = new JButton("1");
	public JButton btnPinpad2 = new JButton("2");
	public JButton btnPinpad3 = new JButton("3");
	public JButton btnPinpad4 = new JButton("4");
	public JButton btnPinpad5 = new JButton("5");
	public JButton btnPinpad6 = new JButton("6");
	public JButton btnPinpad7 = new JButton("7");
	public JButton btnPinpad8 = new JButton("8");
	public JButton btnPinpad9 = new JButton("9");
	public JButton btnComma = new JButton(",");
	public JButton btnEquals = new JButton("=");
	public JButton btnDivision = new JButton("/");
	public JButton btnMultiplication = new JButton("*");
	public JButton btnSubtraction = new JButton("-");
	public JButton btnAddition = new JButton("+");
	public JButton btnPowerOf = new JButton("x^y");
	public JButton btnSquareOf = new JButton("x^2");
	public JButton btnCubeOf = new JButton("x^3");
	public JButton btnRemainder = new JButton("mod");
	public JButton btnPowerOfTen = new JButton("10^x");
	public JButton btnRandom = new JButton("Rand");
	public JButton btnClear = new JButton("C");
	public JButton btnSwitchOn = new JButton();
	public JButton btnSwitchOff = new JButton();
	public JLabel lblAdvancedMode = new JLabel("Advanced mode");
	public JTextField display = new JTextField("0");
	public JDialog dialog = new JDialog();

	private DecimalFormat df = new DecimalFormat("0.#################");

	// Used to decide if Advanced buttons should be visible or not.
	public boolean isBasic = true;

	// Used to decide if a number should be printed when pressing the pinpad.
	// If true = OK to write in display, if false = add to existing number or use in
	// calculation
	// !! Must be set to true after every finished calculation
	// !! Must be set to false when pressing a button that writes in display
	public boolean isFirstAction = true;

	// Stores the pressed operator button's text
	public char chosenOperator = ' ';

	// To save value in the display to use for calculations
	public double firstNumber = 0;
	public double secondNumber = 0;
	public double result = 0;
	// Used in continueAddition(), continueSubtraction() etc. To know if result is
	// cleared or not.
	// If cleared, it should not be possible to press "=" repetitive and keep on
	// adding/subtracting etc.
	public boolean resultCleared = true;

	/**
	 * Create the application.
	 */
	public CalculatorWindow() {
		frame.setVisible(true);
		initialize();
		addComponents();
		addActionListeners();

		// Deactivate advanced buttons at start
		deActivateAdvanceButtons();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 280, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

	}

	/**
	 * Adding the components to the frame and setting their properties.
	 */
	public void addComponents() {
		// Setting component placing
		btnPinpad0.setBounds(63, 243, 29, 29);
		btnPinpad1.setBounds(22, 202, 29, 29);
		btnPinpad2.setBounds(63, 202, 29, 29);
		btnPinpad3.setBounds(104, 202, 29, 29);
		btnPinpad4.setBounds(22, 161, 29, 29);
		btnPinpad5.setBounds(63, 161, 29, 29);
		btnPinpad6.setBounds(104, 161, 29, 29);
		btnPinpad7.setBounds(22, 120, 29, 29);
		btnPinpad8.setBounds(63, 120, 29, 29);
		btnPinpad9.setBounds(104, 120, 29, 29);
		btnComma.setBounds(22, 243, 29, 29);
		btnEquals.setBounds(104, 243, 29, 29);
		btnDivision.setBounds(145, 120, 29, 29);
		btnMultiplication.setBounds(145, 161, 29, 29);
		btnSubtraction.setBounds(145, 202, 29, 29);
		btnAddition.setBounds(145, 243, 29, 29);
		btnPowerOf.setBounds(186, 202, 29, 29);
		btnSquareOf.setBounds(186, 161, 29, 29);
		btnCubeOf.setBounds(186, 120, 29, 29);
		btnPowerOfTen.setBounds(227, 202, 29, 29);
		btnRemainder.setBounds(227, 161, 29, 29);
		btnRandom.setBounds(227, 120, 29, 29);
		btnClear.setBounds(22, 79, 29, 29);
		btnSwitchOn.setBounds(227, 286, 13, 20);
		btnSwitchOff.setBounds(239, 286, 13, 20);
		lblAdvancedMode.setBounds(143, 282, 87, 29);

		// Set font (for those with bigger text)
		btnPowerOf.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnSquareOf.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnCubeOf.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnPowerOfTen.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnRemainder.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnRandom.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblAdvancedMode.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		// Adding the components to frame
		frame.getContentPane().add(btnPinpad0);
		frame.getContentPane().add(btnPinpad1);
		frame.getContentPane().add(btnPinpad2);
		frame.getContentPane().add(btnPinpad3);
		frame.getContentPane().add(btnPinpad4);
		frame.getContentPane().add(btnPinpad5);
		frame.getContentPane().add(btnPinpad6);
		frame.getContentPane().add(btnPinpad7);
		frame.getContentPane().add(btnPinpad8);
		frame.getContentPane().add(btnPinpad9);
		frame.getContentPane().add(btnComma);
		frame.getContentPane().add(btnEquals);
		frame.getContentPane().add(btnDivision);
		frame.getContentPane().add(btnMultiplication);
		frame.getContentPane().add(btnSubtraction);
		frame.getContentPane().add(btnAddition);
		frame.getContentPane().add(btnPowerOf);
		frame.getContentPane().add(btnSquareOf);
		frame.getContentPane().add(btnCubeOf);
		frame.getContentPane().add(btnPowerOfTen);
		frame.getContentPane().add(btnRemainder);
		frame.getContentPane().add(btnRandom);
		frame.getContentPane().add(btnClear);
		frame.getContentPane().add(btnSwitchOn);
		frame.getContentPane().add(btnSwitchOff);
		frame.getContentPane().add(lblAdvancedMode);
		frame.getContentPane().add(display);

		// Settings for display field
		display.setColumns(10);
		display.setBounds(60, 76, 200, 35);
		display.setBackground(new Color(245, 255, 250));
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setEditable(false);

		// Basic mode at start, advanced buttons deactivated
		btnSwitchOn.setBackground(Color.RED);
		btnSwitchOn.setOpaque(true);
		btnSwitchOn.setBorderPainted(false);
		btnSwitchOn.setFocusPainted(false);
		btnSwitchOff.setOpaque(true);
		btnSwitchOff.setBorderPainted(true);
		btnSwitchOff.setFocusPainted(false);
	}

	/**
	 * Activates the Advances buttons
	 */
	public void activateAdvanceButtons() {
		btnPowerOf.setEnabled(true);
		btnSquareOf.setEnabled(true);
		btnCubeOf.setEnabled(true);
		btnPowerOfTen.setEnabled(true);
		btnRemainder.setEnabled(true);
		btnRandom.setEnabled(true);
	}

	/**
	 * Deactivates the Advances buttons
	 */
	public void deActivateAdvanceButtons() {
		btnPowerOf.setEnabled(false);
		btnSquareOf.setEnabled(false);
		btnCubeOf.setEnabled(false);
		btnPowerOfTen.setEnabled(false);
		btnRemainder.setEnabled(false);
		btnRandom.setEnabled(false);
	}

	/**
	 * The switch between Basic and Advanced mode.
	 */
	public void switchMode() {
		if (isBasic) {
			// Activate advanced buttons
			activateAdvanceButtons();
			btnSwitchOn.setBackground(new Color(238, 238, 238));
			btnSwitchOn.setBorderPainted(true);
			btnSwitchOff.setBackground(Color.GREEN);
			btnSwitchOff.setBorderPainted(false);
			isBasic = false;
		} else {
			// Deactivate advanced buttons
			deActivateAdvanceButtons();
			btnSwitchOn.setBackground(Color.RED);
			btnSwitchOn.setBorderPainted(false);
			btnSwitchOff.setBackground(new Color(238, 238, 238));
			btnSwitchOff.setBorderPainted(true);
			isBasic = true;
		}
	}

	/**
	 * First action of the addition calculation, invoked by pressing btnAddition.
	 * Saves the number in the display as firstNumber and set the corresponding
	 * operator sign as chosenOperator.
	 */
	public void startAddition() {
		firstNumber = getDisplayValue();
		isFirstAction = true;
		chosenOperator = btnAddition.getText().charAt(0);
	}

	/**
	 * Last action of the addition calculation, invoked when running
	 * doCalculation(). Saves the number in the display as secondNumber and perform
	 * the calculation. The result is written in the display.
	 * 
	 * If btnEquals is pressed repetitively, secondNumber will be added to the
	 * result from the first calculation one more time.
	 */
	public void continueAddition() {
		if (chosenOperator == '+' && !(resultCleared)) {
			result = ac.addition(result, secondNumber);
		} else {
			secondNumber = getDisplayValue();
			result = ac.addition(firstNumber, secondNumber);
		}
		setDisplayValue(result);
		resultCleared = false;
		isFirstAction = true;

	}

	/**
	 * First action of the subtraction calculation, invoked by pressing
	 * btnSubtraction. Saves the number in the display as firstNumber and set the
	 * corresponding operator sign as chosenOperator.
	 */
	public void startSubtraction() {
		firstNumber = getDisplayValue();
		isFirstAction = true;
		chosenOperator = btnSubtraction.getText().charAt(0);
	}

	/**
	 * Last action of the subtraction calculation, invoked when running
	 * doCalculation(). Saves the number in the display as secondNumber and perform
	 * the calculation. The result is written in the display.
	 * 
	 * If btnEquals is pressed repetitively, secondNumber will be deducted from the
	 * result from the first calculation one more time.
	 */
	public void continueSubtraction() {
		if (chosenOperator == '-' && !(resultCleared)) {
			result = ac.subtraction(result, secondNumber);
		} else {
			secondNumber = getDisplayValue();
			result = ac.subtraction(firstNumber, secondNumber);
		}
		setDisplayValue(result);
		resultCleared = false;
		isFirstAction = true;
	}

	/**
	 * First action of the multiplication calculation, invoked by pressing
	 * btnMultiplication. Saves the number in the display as firstNumber and set the
	 * corresponding operator sign as chosenOperator.
	 */
	public void startMultiplication() {
		firstNumber = getDisplayValue();
		isFirstAction = true;
		chosenOperator = btnMultiplication.getText().charAt(0);
	}

	/**
	 * Last action of the multiplication calculation, invoked when running
	 * doCalculation(). Saves the number in the display as secondNumber and perform
	 * the calculation. The result is written in the display.
	 * 
	 * If btnEquals is pressed repetitively, secondNumber will be multiplied with
	 * the result from the first calculation one more time.
	 */
	public void continueMultiplication() {
		if (chosenOperator == '*' && !(resultCleared)) {
			result = ac.multiplication(result, secondNumber);
		} else {
			secondNumber = getDisplayValue();
			result = ac.multiplication(firstNumber, secondNumber);
		}
		setDisplayValue(result);
		resultCleared = false;
		isFirstAction = true;
	}

	/**
	 * First action of the division calculation, invoked by pressing btnDivision.
	 * Saves the number in the display as firstNumber and set the corresponding
	 * operator sign as chosenOperator.
	 */
	public void startDivision() {
		firstNumber = getDisplayValue();
		isFirstAction = true;
		chosenOperator = btnDivision.getText().charAt(0);
	}

	/**
	 * Last action of the division calculation, invoked when running
	 * doCalculation(). Saves the number in the display as secondNumber and perform
	 * the calculation. The result is written in the display.
	 * 
	 * If btnEquals is pressed repetitively, the result from the first calculation
	 * will be divided with secondNumber one more time.
	 */
	public void continueDivision() {
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

	/**
	 * First action of the power of calculation, invoked by pressing btnPowerOf.
	 * Saves the number in the display as firstNumber and set the corresponding
	 * operator sign as chosenOperator.
	 */
	public void startPowerOf() {
		firstNumber = getDisplayValue();
		isFirstAction = true;
		// Button text = "x^y", hence charAt(1);
		chosenOperator = btnPowerOf.getText().charAt(1);
	}

	/**
	 * Last action of the power of calculation, invoked when running
	 * doCalculation(). Saves the number in the display as secondNumber and perform
	 * the calculation. The result is written in the display.
	 * 
	 * If btnEquals is pressed repetitively, the result from the first calculation
	 * will be raised to secondNumber.
	 */
	public void continuePowerOf() {
		if (chosenOperator == '^' && !(resultCleared)) {
			result = ac.powerOf(result, secondNumber);
		} else {
			secondNumber = getDisplayValue();
			result = ac.powerOf(firstNumber, secondNumber);
		}
		setDisplayValue(result);
		resultCleared = false;
		isFirstAction = true;
	}

	/**
	 * Performs the power of ten calculation, invoked when pressing btnPowerOfTen.
	 * Uses the number in the display as exponent and performs the calculation. The
	 * result is written in the display.
	 */
	public void performPowerOfTen() {
		firstNumber = getDisplayValue();
		double result = ac.powerOfTen(firstNumber);
		setDisplayValue(result);
		isFirstAction = true;
	}

	/**
	 * Performs the square of calculation, invoked when pressing btnSquareOf. Uses
	 * the number in the display as base and performs the calculation. The result is
	 * written in the display.
	 */
	public void performSquareOf() {
		firstNumber = getDisplayValue();
		double result = ac.squareOf(firstNumber);
		setDisplayValue(result);
		isFirstAction = true;
	}

	/**
	 * Performs the cube of calculation, invoked when pressing btnCubeOf. Uses the
	 * number in the display as base and performs the calculation. The result is
	 * written in the display.
	 */
	public void performCubeOf() {
		firstNumber = getDisplayValue();
		double result = ac.cubeOf(firstNumber);
		setDisplayValue(result);
		isFirstAction = true;
	}

	/**
	 * First action of the remainder calculation, invoked by pressing btnRemainder.
	 * Saves the number in the display as firstNumber and set the corresponding
	 * operator sign as chosenOperator.
	 */
	public void startRemainder() {
		firstNumber = getDisplayValue();
		isFirstAction = true;
		chosenOperator = '%';
	}

	/**
	 * Last action of the remainder calculation, invoked when running
	 * doCalculation(). Saves the number in the display as secondNumber and perform
	 * the calculation. The result is written in the display.
	 * 
	 * The remainder function of AdvancedCalculator class uses integers, this
	 * function will first find out if the two numbers have decimals or not. If they
	 * do, a message is shown on the display. If they don't, the numbers are
	 * converted to Integer and the calculation is done. The result is written in
	 * the display.
	 */
	public void continueRemainder() {
		System.out.println(firstNumber + " " + secondNumber);
		if (((firstNumber % 1) > 0) || ((secondNumber % 1) > 0)) {
			display.setText("Modulus only take integers!");
		} else {
			Integer firstNumberAsInt = (int) firstNumber;
			Integer secondNumberAsInt = (int) secondNumber;
			System.out.println(firstNumberAsInt + " " + secondNumberAsInt);
			double result = ac.remainder(firstNumberAsInt, secondNumberAsInt);
			setDisplayValue(result);
			resultCleared = false;
			isFirstAction = true;
			chosenOperator = ' ';
		}
	}

	/**
	 * Setting a random value between 0 and 1 on to the display.
	 */
	public void createRandomValue() {
		double randomValue = ac.random0to1();
		setDisplayValue(randomValue);
		// Set to make sure no number is added to this number
		isFirstAction = true;
	}

	/**
	 * Resets the calculator so no data from old calculations is saved.
	 */
	public void getCleanState() {
		firstNumber = 0;
		secondNumber = 0;
		result = 0;
		resultCleared = true;
		isFirstAction = true;
		chosenOperator = ' ';
	}

	/**
	 * The value in the display is saved as String. This method converts the string
	 * to a double with "," as decimal separator.
	 * 
	 * If the value is not a number, the calculator is reset by getCleanState().
	 *
	 * @return The value in the display, as double
	 */
	public double getDisplayValue() {
		try {
			String displayValueAsString = display.getText();
			System.out.println(displayValueAsString);
			displayValueAsString = displayValueAsString.replaceAll(",", ".");
			double displayValue = Double.parseDouble(displayValueAsString);
			return displayValue;
		} catch (NumberFormatException e) {
			getCleanState();
			return 0;
		}
	}

	/**
	 * The value in the display is saved as String. This method converts a double to
	 * String in order to show it in the display.
	 * 
	 * @param toBeDisplayed
	 *            The number to be displayed
	 */
	public void setDisplayValue(double toBeDisplayed) {
		try {
			display.setText(df.format(toBeDisplayed));
		} catch (NumberFormatException e) {
			System.err.println("Not able to show value in display");
		}
	}

	/**
	 * Checks if this is the first action, i.e. if a pressed button should result in
	 * starting a new number in screen or adding it to the existing number.
	 * 
	 * @return True if it should start writing a new number, false if it should add
	 *         to existing.
	 */
	public boolean checkIfFirstAction() {
		if (getDisplayValue() == 0) {
			isFirstAction = true;
			return isFirstAction;
		} else {
			isFirstAction = false;
			return isFirstAction;
		}
	}

	/**
	 * Prints the pressed number to the display, invoked when a number is pressed on
	 * the pinpad. If the display already contains 20 numbers, no number will be
	 * added.
	 * 
	 * @param pressedNumber
	 *            The number of the pressed button
	 */
	public void pinpadNumberPressed(String pressedNumber) {
		if (isFirstAction) {
			setDisplayValue(Double.parseDouble(pressedNumber));
			isFirstAction = false;
		} else if (display.getText().length() >= 20) {
			// Do nothing, does not fit screen
		} else {
			display.setText(display.getText() + pressedNumber);
		}
	}

	/**
	 * Adds a comma to the number in the display, invoked by pressing btnComma. If
	 * the display already contains 19 numbers or already contains a comma, nothing
	 * will be added.
	 */
	public void addComma() {
		if (isFirstAction) {
			display.setText(0 + btnComma.getText());
			isFirstAction = false;
		} else if (display.getText().length() >= 19) {
			// length >= 19 (instead of 20) because there will be a number added after ","
			// Do nothing, does not fit screen
		} else if (!(display.getText().contains(","))) {
			display.setText(display.getText() + btnComma.getText());
		}
	}

	/**
	 * Invoked by pressing btnEquals. Checks which operator was chosen and run
	 * corresponding continue-method. Non-mentioned operators are handled directly
	 * in their ActionListener
	 */
	public void doCalculation() {
		switch (chosenOperator) {
		case '+':
			continueAddition();
			break;
		case '-':
			continueSubtraction();
			break;
		case '*':
			continueMultiplication();
			break;
		case '/':
			if (getDisplayValue() == 0) {
				display.setText("No division by zero!");
				isFirstAction = false;
			} else {
				continueDivision();
			}
			break;
		case '%':
			secondNumber = getDisplayValue();
			if (((firstNumber % 1) > 0) || ((getDisplayValue() % 1) > 0)) {
				display.setText("Modulus only take integers!");
				isFirstAction = false;
			} else {
				continueRemainder();
			}
			break;
		case '^':
			continuePowerOf();
			break;
		default:
			// Do nothing
			break;
		}
	}

	/**
	 * ActionListeners for all buttons.
	 */
	public void addActionListeners() {

		btnSwitchOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchMode();
			}
		});

		btnSwitchOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchMode();
			}
		});

		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createRandomValue();
			}
		});

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDisplayValue(0);
				getCleanState();
			}
		});

		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doCalculation();
			}
		});

		btnAddition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(checkIfFirstAction())) {
					startAddition();
				}
			}
		});

		btnSubtraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(checkIfFirstAction())) {
					startSubtraction();
				}
			}
		});

		btnMultiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(checkIfFirstAction())) {
					startMultiplication();
				}
			}
		});

		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(checkIfFirstAction())) {
					startDivision();
				}
			}
		});

		btnPinpad0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinpadNumberPressed(btnPinpad0.getText());
			}
		});

		btnPinpad1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinpadNumberPressed(btnPinpad1.getText());
			}
		});

		btnPinpad2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinpadNumberPressed(btnPinpad2.getText());
			}
		});

		btnPinpad3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinpadNumberPressed(btnPinpad3.getText());
			}
		});

		btnPinpad4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinpadNumberPressed(btnPinpad4.getText());
			}
		});

		btnPinpad5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinpadNumberPressed(btnPinpad5.getText());
			}
		});

		btnPinpad6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinpadNumberPressed(btnPinpad6.getText());
			}
		});

		btnPinpad7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinpadNumberPressed(btnPinpad7.getText());
			}
		});

		btnPinpad8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinpadNumberPressed(btnPinpad8.getText());
			}
		});

		btnPinpad9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pinpadNumberPressed(btnPinpad9.getText());
			}
		});

		btnComma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addComma();
			}
		});

		btnPowerOfTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performPowerOfTen();
			}
		});

		btnPowerOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(checkIfFirstAction())) {
					startPowerOf();
				}
			}
		});

		btnSquareOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performSquareOf();
			}
		});

		btnCubeOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performCubeOf();
			}
		});

		btnRemainder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(checkIfFirstAction())) {
					startRemainder();
				}
			}
		});
	}
}
