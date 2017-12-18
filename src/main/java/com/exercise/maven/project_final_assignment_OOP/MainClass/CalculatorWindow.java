package com.exercise.maven.project_final_assignment_OOP.MainClass;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Insets;

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
	Random random = new Random();
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
	public JButton btnSuperModeOn = new JButton();
	public JButton btnSuperModeOff = new JButton();
	public JLabel lblSuperMode = new JLabel("Super advanced mode");
	public JButton btnChaos = new JButton("Chaos");
	public JButton btnShuffle = new JButton("Shuffle");

	private DecimalFormat df = new DecimalFormat("0.#################");
	
	// ArrayLists for pinpadPositions, all buttons and hidden buttons.
	public ArrayList<String> pinpadPositions = new ArrayList<String>();
	public ArrayList<Integer> shuffledButtonNumbers = new ArrayList<Integer>();
	public ArrayList<JButton> listOfButtons = new ArrayList<JButton>();
	public ArrayList<Integer> hiddenButtons = new ArrayList<Integer>();
	ArrayList<Integer> positionsAsInt = new ArrayList<Integer>();
	
	// Used in shufflePinpad()
	int positionX = 0;
	int positionY = 0;
	int positionWidth = 0;
	int positionHeight = 0;

	// Used to decide if Advanced buttons should be visible or not.
	public boolean isBasic = true;
	// Used to decide if Super mode buttons should be visible or not.
	public boolean isSuper = false;

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
		deActivateSuperButtons();
		hideSuperSwitch();
		
		createArrayListOfButtons();
		createArrayListOfPinpadPositions();
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
		btnSuperModeOn.setBounds(227, 319, 13, 20);
		btnSuperModeOff.setBounds(239, 319, 13, 20);
		lblSuperMode.setBounds(114, 316, 116, 29);
		btnChaos.setBounds(193, 345, 65, 29);
		btnShuffle.setBounds(123, 345, 75, 29);
	
		// Removes the margin of the buttons (so the text will fit and not be replaced by "..."
		btnPinpad0.setMargin(new Insets(1, 1, 1, 1));
		btnPinpad1.setMargin(new Insets(1, 1, 1, 1));
		btnPinpad2.setMargin(new Insets(1, 1, 1, 1));
		btnPinpad3.setMargin(new Insets(1, 1, 1, 1));
		btnPinpad4.setMargin(new Insets(1, 1, 1, 1));
		btnPinpad5.setMargin(new Insets(1, 1, 1, 1));
		btnPinpad6.setMargin(new Insets(1, 1, 1, 1));
		btnPinpad7.setMargin(new Insets(1, 1, 1, 1));
		btnPinpad8.setMargin(new Insets(1, 1, 1, 1));
		btnPinpad9.setMargin(new Insets(1, 1, 1, 1));
		btnComma.setMargin(new Insets(1, 1, 1, 1));
		btnEquals.setMargin(new Insets(1, 1, 1, 1));
		btnDivision.setMargin(new Insets(1, 1, 1, 1));
		btnMultiplication.setMargin(new Insets(1, 1, 1, 1));
		btnSubtraction.setMargin(new Insets(1, 1, 1, 1));
		btnAddition.setMargin(new Insets(1, 1, 1, 1));
		btnPowerOf.setMargin(new Insets(1, 1, 1, 1));
		btnSquareOf.setMargin(new Insets(1, 1, 1, 1));
		btnCubeOf.setMargin(new Insets(1, 1, 1, 1));
		btnPowerOfTen.setMargin(new Insets(1, 1, 1, 1));
		btnRemainder.setMargin(new Insets(1, 1, 1, 1));
		btnRandom.setMargin(new Insets(1, 1, 1, 1));
		btnClear.setMargin(new Insets(1, 1, 1, 1));
		btnSwitchOn.setMargin(new Insets(1, 1, 1, 1));
		btnSwitchOff.setMargin(new Insets(1, 1, 1, 1));
		btnSuperModeOn.setMargin(new Insets(1, 1, 1, 1));
		btnSuperModeOff.setMargin(new Insets(1, 1, 1, 1));
		btnChaos.setMargin(new Insets(1, 1, 1, 1));
		btnShuffle.setMargin(new Insets(1, 1, 1, 1));
		

		// Set font (for those with bigger text)
		btnPowerOf.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnSquareOf.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnCubeOf.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnPowerOfTen.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		btnRemainder.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		btnRandom.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblAdvancedMode.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblSuperMode.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

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
		frame.getContentPane().add(btnSuperModeOn);
		frame.getContentPane().add(btnSuperModeOff);
		frame.getContentPane().add(lblSuperMode);
		frame.getContentPane().add(btnChaos);
		frame.getContentPane().add(btnShuffle);

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
		
		// Super Advanced mode deactivated at start
		btnSuperModeOn.setBackground(Color.RED);
		btnSuperModeOn.setOpaque(true);
		btnSuperModeOn.setBorderPainted(false);
		btnSuperModeOn.setFocusPainted(false);
		btnSuperModeOff.setOpaque(true);
		btnSuperModeOff.setBorderPainted(true);
		btnSuperModeOff.setFocusPainted(false);
	}
	
	/**
	 * Sets the values of the ArrayList containing all buttons.
	 */
	public void createArrayListOfButtons() {
		listOfButtons.add(btnPinpad0);
		listOfButtons.add(btnPinpad1);
		listOfButtons.add(btnPinpad2);
		listOfButtons.add(btnPinpad3);
		listOfButtons.add(btnPinpad4);
		listOfButtons.add(btnPinpad5);
		listOfButtons.add(btnPinpad6);
		listOfButtons.add(btnPinpad7);
		listOfButtons.add(btnPinpad8);
		listOfButtons.add(btnPinpad9);
		listOfButtons.add(btnComma);
		listOfButtons.add(btnEquals);
		listOfButtons.add(btnDivision);
		listOfButtons.add(btnMultiplication);
		listOfButtons.add(btnSubtraction);
		listOfButtons.add(btnAddition);
		listOfButtons.add(btnPowerOf);
		listOfButtons.add(btnSquareOf);
		listOfButtons.add(btnCubeOf);
		listOfButtons.add(btnPowerOfTen);
		listOfButtons.add(btnRemainder);
		listOfButtons.add(btnRandom);
		listOfButtons.add(btnClear);
		listOfButtons.add(btnShuffle);
	}
	
	/**
	 * Sets the values in the ArrayList containing the positions (bounds) of all pinpad number buttons
	 */
	public void createArrayListOfPinpadPositions() {
		pinpadPositions.add("63, 243, 29, 29");
		pinpadPositions.add("22, 202, 29, 29");
		pinpadPositions.add("63, 202, 29, 29");
		pinpadPositions.add("104, 202, 29, 29");
		pinpadPositions.add("22, 161, 29, 29");
		pinpadPositions.add("63, 161, 29, 29");
		pinpadPositions.add("104, 161, 29, 29");
		pinpadPositions.add("22, 120, 29, 29");
		pinpadPositions.add("63, 120, 29, 29");
		pinpadPositions.add("104, 120, 29, 29");
	}

	/**
	 * Activates the Advanced buttons
	 */
	public void activateAdvanceButtons() {
		btnPowerOf.setEnabled(true);
		btnSquareOf.setEnabled(true);
		btnCubeOf.setEnabled(true);
		btnPowerOfTen.setEnabled(true);
		btnRemainder.setEnabled(true);
		btnRandom.setEnabled(true);
		frame.setBounds(100, 100, 280, 408);
		showSuperSwitch();
	}

	/**
	 * Deactivates the Advanced buttons
	 */
	public void deActivateAdvanceButtons() {
		btnPowerOf.setEnabled(false);
		btnSquareOf.setEnabled(false);
		btnCubeOf.setEnabled(false);
		btnPowerOfTen.setEnabled(false);
		btnRemainder.setEnabled(false);
		btnRandom.setEnabled(false);
		frame.setBounds(100, 100, 280, 358);
		hideSuperSwitch();
	}
	
	/**
	 * Show the Super switch
	 */
	public void showSuperSwitch() {
		btnSuperModeOn.setVisible(true);
		btnSuperModeOff.setVisible(true);
		lblSuperMode.setVisible(true);
		btnChaos.setVisible(true);
		btnShuffle.setVisible(true);
	}
	
	/**
	 * Hide the Super switch
	 */
	public void hideSuperSwitch() {
		btnSuperModeOn.setVisible(false);
		btnSuperModeOff.setVisible(false);
		lblSuperMode.setVisible(false);
		btnChaos.setVisible(false);
		btnShuffle.setVisible(false);
	}
	
	/**
	 * Activates the Super advanced buttons
	 */
	public void activateSuperButtons() {
		btnChaos.setEnabled(true);
		btnShuffle.setEnabled(true);
	}

	/**
	 * Deactivates the Super Advanced buttons
	 */
	public void deActivateSuperButtons() {
		btnChaos.setEnabled(false);
		btnShuffle.setEnabled(false);
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
	 * The switch for activating Super Advanced mode.
	 */
	public void switchSuperMode() {
		if (!(isSuper)) {
			// Activate Super mode
			activateSuperButtons();
			btnSuperModeOn.setBackground(new Color(238, 238, 238));
			btnSuperModeOn.setBorderPainted(true);
			btnSuperModeOff.setBackground(Color.GREEN);
			btnSuperModeOff.setBorderPainted(false);
			isSuper = true;
		} else {
			// Deactivate advanced buttons
			deActivateSuperButtons();
			btnSuperModeOn.setBackground(Color.RED);
			btnSuperModeOn.setBorderPainted(false);
			btnSuperModeOff.setBackground(new Color(238, 238, 238));
			btnSuperModeOff.setBorderPainted(true);
			isSuper = false;
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
	 * Hides a randomly picked button from the calculator.
	 */
	public void releaseChaosMonkey() {
		// If all buttons are hidden, change text on button. Else, release the chaos monkey!
		if (hiddenButtons.size() == listOfButtons.size()) {
			btnChaos.setText("Sorry!");
		} else {
			int buttonToHide = 100;
			
			// If not all buttons are added to the  list of hidden buttons
			if (hiddenButtons.size() < listOfButtons.size()) {
				// If the button already is hidden, get a new random number
				do {
					buttonToHide = random.nextInt(listOfButtons.size());
				} while (hiddenButtons.contains(buttonToHide));
				// When found a button to hide that's yet visible,
				// add it to list of hidden buttons and hide it
				hiddenButtons.add(buttonToHide);
				listOfButtons.get(buttonToHide).setVisible(false);
			}
		}
	}

	/**
	 * Shuffles the position of the number buttons on the pinpad.
	 */
	public void shufflePinpad() {
		int buttonToShuffle = 100;

		// Loop through the pinpad buttons in listOfButtons from 0 to 9
		for (int i = 0; i < 10; i++) {
			do {
				buttonToShuffle = random.nextInt(10);
			} while (shuffledButtonNumbers.contains(buttonToShuffle));
			// When found a free position to use for this button,
			// add it to list of shuffled buttons
			shuffledButtonNumbers.add(buttonToShuffle);
			
			// convert the bounds-string to integers and set them as unique variables
			convertBoundsToIntArray(buttonToShuffle);
			
			positionX = positionsAsInt.get(0);
			positionY = positionsAsInt.get(1);
			positionWidth = positionsAsInt.get(2);
			positionHeight = positionsAsInt.get(3);
			
			// Clear the array of bound-values before next round in the loop
			positionsAsInt.clear();
			
			listOfButtons.get(i).setBounds(positionX, positionY, positionWidth, positionHeight);
		}
		// When all buttons are moved, clear list of shuffled buttons if the method will be run again
		shuffledButtonNumbers.clear();
	}
	
	public void convertBoundsToIntArray(int buttonToShuffle) {
		String positionAsString = pinpadPositions.get(buttonToShuffle);
		
		StringTokenizer st = new StringTokenizer(positionAsString);
		while (st.hasMoreTokens()) {
			positionsAsInt.add(Integer.parseInt(st.nextToken(", ")));
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
		
		btnSuperModeOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchSuperMode();
			}
		});
		
		btnSuperModeOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchSuperMode();
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
		
		btnChaos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				releaseChaosMonkey();
			}
		});
		
		btnShuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shufflePinpad();
			}
		});
	}
}
