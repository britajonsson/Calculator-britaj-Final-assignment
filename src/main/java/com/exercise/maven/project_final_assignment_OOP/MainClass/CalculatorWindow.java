package com.exercise.maven.project_final_assignment_OOP.MainClass;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class CalculatorWindow {

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
	private JButton btnSwitchMode = new JButton("Off");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorWindow window = new CalculatorWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorWindow() {
		initialize();
		addComponents();
		addActionListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 447, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				

		
	}
	
	private void addComponents() {
		// Adding the buttons and setting their properties
		
		btnPinpad0.setBounds(82, 271, 29, 29);
		frame.getContentPane().add(btnPinpad0);
		
		
		btnPinpad1.setBounds(41, 230, 29, 29);
		frame.getContentPane().add(btnPinpad1);
		
		
		btnPinpad2.setBounds(82, 230, 29, 29);
		frame.getContentPane().add(btnPinpad2);
		
		
		btnPinpad3.setBounds(123, 230, 29, 29);
		frame.getContentPane().add(btnPinpad3);
		
		
		btnPinpad4.setBounds(41, 189, 29, 29);
		frame.getContentPane().add(btnPinpad4);
		
		
		btnPinpad5.setBounds(82, 189, 29, 29);
		frame.getContentPane().add(btnPinpad5);
		
		
		btnPinpad6.setBounds(123, 189, 29, 29);
		frame.getContentPane().add(btnPinpad6);
		
		
		btnPinpad7.setBounds(41, 148, 29, 29);
		frame.getContentPane().add(btnPinpad7);
		
		
		btnPinpad8.setBounds(82, 148, 29, 29);
		frame.getContentPane().add(btnPinpad8);
		
		
		btnPinpad9.setBounds(123, 148, 29, 29);
		frame.getContentPane().add(btnPinpad9);
		
		
		btnComma.setBounds(41, 271, 29, 29);
		frame.getContentPane().add(btnComma);
		
		
		btnEquals.setBounds(123, 271, 29, 29);
		frame.getContentPane().add(btnEquals);
		
		
		btnDivison.setBounds(164, 230, 29, 29);
		frame.getContentPane().add(btnDivison);
		
		
		btnMultiplication.setBounds(164, 189, 29, 29);
		frame.getContentPane().add(btnMultiplication);
		
		
		btnSubtraction.setBounds(164, 148, 29, 29);
		frame.getContentPane().add(btnSubtraction);
		
		
		btnAddition.setBounds(164, 271, 29, 29);
		frame.getContentPane().add(btnAddition);
		
		btnSwitchMode.setBounds(164, 33, 29, 29);
		frame.getContentPane().add(btnSwitchMode);
		
		JLabel lblAdvancedMode = new JLabel("Advanced mode:");
		lblAdvancedMode.setBounds(41, 38, 114, 16);
		frame.getContentPane().add(lblAdvancedMode);
	}
	
	
	private void addActionListeners() {
		
		btnSwitchMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isBasic = true;
				  
				if (isBasic) {
					// Activate advanced buttons
					Implement!
					Set btnSwitchMode to "On"
					isBasic = false;
				} else {
					// Deactivate advanced buttons
					Implement!
					Set btnSwitchMode to "Off"
					isBasic = true;
				}
	
			}
		});
	}
}
