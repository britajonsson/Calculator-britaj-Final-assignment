package com.exercise.maven.project_final_assignment_OOP.MainClass;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;

import com.exercise.maven.project_final_assignment_OOP.CalculatorClasses.AdvancedCalculator;

import javax.swing.JToggleButton;

public class CalculatorWindow {
	
	private AdvancedCalculator ac = new AdvancedCalculator();
	private JFrame frame = new JFrame();
	private JButton btnPinpad0 = new JButton("0");
	private JButton btnPinpad1 = new JButton("1");
	private JButton btnPinpad2 = new JButton("2");
	private JButton btnPinpad3 = new JButton("3");
	private JButton btnPinpad4 = new JButton("4");
	private JButton btnPinpad5 = new JButton("5");
	private JButton btnPinpad6 = new JButton("6");
	private JButton btnPinpad7 = new JButton("7");
	private JButton btnPinpad8 = new JButton("8");
	private JButton btnPinpad9 = new JButton("9");
	private JButton btnComma = new JButton(",");
	private JButton btnEquals = new JButton("=");
	private JButton btnDivison = new JButton("/");
	private JButton btnMultiplication = new JButton("*");
	private JButton btnSubtraction = new JButton("-");
	private JButton btnAddition = new JButton("+");
	private JButton btnPowerOf = new JButton("x^y");
	private JButton btnSquareOf = new JButton("x^2");
	private JButton btnCubeof = new JButton("x^3");
	private JButton btnRemainder = new JButton("mod");
	private JButton btnPowerOfTen = new JButton("10^x");
	private JButton btnRandom = new JButton("Rand");
	private JButton btnClear = new JButton("C");
	private JButton btnSwitchOn = new JButton();
	private JButton btnSwitchOff = new JButton();
	private JLabel lblAdvancedMode = new JLabel("Advanced mode");
	private JTextField display = new JTextField("0");
	private DecimalFormat df = new DecimalFormat("0.#################");
	
	// Used to decide if Advanced buttons should be visible or not.
	private boolean isBasic = true;
	
	// Used to decide if a number should be printed when pressing the pinpad.
	// If true = OK to write in display, if false = add to existing number or use in calculation
	// !! Must be set to true after every finished calculation
	// !! Must be set to false when pressing a button that writes in display
	private boolean isFirstAction = true;
	
	// MIGHT NOT BE NEEDED?!
	// Used to know if there's an calculation process going on when pressing the pinpad. If false = OK to write number in display, if trie = use number in ongoing calculation
	private boolean ongoingCalculation = false;
	
	// Stores the pressed operator button's text, used together with ongoingCalculation = true
	private char chosenOperator = ' ';
	
	// To save value in the display to use for calculations
	private double firstNumber = 0;
	private double secondNumber = 0;
	
	
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
	private void initialize() {
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 280, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		System.out.println(isFirstAction);

	}

	private void addComponents() {
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
		btnDivison.setBounds(145, 120, 29, 29);
		btnMultiplication.setBounds(145, 161, 29, 29);
		btnSubtraction.setBounds(145, 202, 29, 29);
		btnAddition.setBounds(145, 243, 29, 29);
		btnPowerOf.setBounds(186, 202, 29, 29);
		btnSquareOf.setBounds(186, 161, 29, 29);
		btnCubeof.setBounds(186, 120, 29, 29);
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
		btnCubeof.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
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
		frame.getContentPane().add(btnDivison);
		frame.getContentPane().add(btnMultiplication);
		frame.getContentPane().add(btnSubtraction);
		frame.getContentPane().add(btnAddition);
		frame.getContentPane().add(btnPowerOf);
		frame.getContentPane().add(btnSquareOf);
		frame.getContentPane().add(btnCubeof);
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
		
		// Switch start at Off
		btnSwitchOn.setBackground(Color.RED);
		btnSwitchOn.setOpaque(true);
		btnSwitchOn.setBorderPainted(false);
		btnSwitchOn.setFocusPainted(false);
		btnSwitchOff.setOpaque(true);
		btnSwitchOff.setBorderPainted(true);
		btnSwitchOff.setFocusPainted(false);
	}

	private void activateAdvanceButtons() {
		btnPowerOf.setEnabled(true);
		btnSquareOf.setEnabled(true);
		btnCubeof.setEnabled(true);
		btnPowerOfTen.setEnabled(true);
		btnRemainder.setEnabled(true);
		btnRandom.setEnabled(true);
	}
	
	private void deActivateAdvanceButtons() {
		btnPowerOf.setEnabled(false);
		btnSquareOf.setEnabled(false);
		btnCubeof.setEnabled(false);
		btnPowerOfTen.setEnabled(false);
		btnRemainder.setEnabled(false);
		btnRandom.setEnabled(false);
	}
	
	private void switchMode() {
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
	
	private void startSubtraction() {
		firstNumber = Double.parseDouble(display.getText());
		ongoingCalculation = true;
		isFirstAction = true;
		chosenOperator = btnSubtraction.getText().charAt(0);
		// Marking that Subtraction key is active. 
		// Might implement later on, must be reverted if C is pressed
		// btnSubtraction.setFont(new Font("Lucida Grande", Font.BOLD, 13));
	}
	
	private void continueSubtraction() {
		String result = df.format(ac.subtraction(firstNumber, secondNumber));
		// Marking that Subtraction key is no longer active. 
		// Might implement later on, must be reverted if C is pressed
		// btnSubtraction.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		display.setText(result);
		isFirstAction = true;
	}
	
	private void startAddition() {
		System.out.println("startAddition: " + isFirstAction);
		firstNumber = Double.parseDouble(display.getText());
		ongoingCalculation = true;
		isFirstAction = true;
		chosenOperator = btnAddition.getText().charAt(0);
		// Marking that Addition key is active. 
		// Might implement later on, must be reverted if C is pressed
		// btnAddition.setFont(new Font("Lucida Grande", Font.BOLD, 13));
	}
	
	private void continueAddition() {
		System.out.println("continueAddition: " + isFirstAction);
		String result = df.format(ac.addition(firstNumber, secondNumber));
		// Marking that Addition key is no longer active. 
		// Might implement later on, must be reverted if C is pressed
		// btnAddition.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		display.setText(result);
		isFirstAction = true;
	}
	
	private boolean checkIfFirstAction() {
		
		if (display.getText().equals("0")) {
			isFirstAction = true;
			System.out.println("checkIfFirstAction = true: " + isFirstAction);
			return isFirstAction;
		} else {
			isFirstAction = false;
			System.out.println("checkIfFirstAction = false: " + isFirstAction);
			return isFirstAction;
		}
		
	}
	
	private void addActionListeners() {
		
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
				double randomValue = ac.random0to1();
				//display.setText(df.format(randomValue));
				display.setText(Double.toString(randomValue));
				// Make sure no number is added to this number
				isFirstAction = true;
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText("0");
				isFirstAction = true;
				ongoingCalculation = false;
			}
		});
		
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ongoingCalculation) {
					secondNumber = Double.parseDouble(display.getText());
					// Check which operator was chosen and run corresponding method
					// Would have liked to use String as switch value, but not OK below v1.7
					switch (chosenOperator) {
					case '+':
						continueAddition();
						break;
					case '-':
						continueSubtraction();
						break;
					/*
					case "*":
						continueMultiplication();
						break;
					case "/":
						continueDivision();
						break;
			
					ADD ALL ADVANCED OPERATORS
			
					*/
					default:
						// WHAT TO DO HERE?
						break;
					}
				}
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
		
		btnPinpad1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isFirstAction) {
					display.setText(btnPinpad1.getText());
					isFirstAction = false;
				} else if (display.getText().length() >= 20) {
					// Do nothing, does not fit screen
				} else {		
					display.setText(display.getText()+btnPinpad1.getText());
				}
			}
		});
		
		btnPinpad2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isFirstAction) {
					display.setText(btnPinpad2.getText());
					isFirstAction = false;
				} else if (display.getText().length() >= 20) {
					// Do nothing, does not fit screen
				} else {		
					display.setText(display.getText()+btnPinpad2.getText());
				}
			}
		});
	}
}
