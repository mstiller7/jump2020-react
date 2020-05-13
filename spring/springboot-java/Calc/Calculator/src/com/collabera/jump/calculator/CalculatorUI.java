package com.collabera.jump.calculator;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorUI {
	
	public static JFrame buildUI() {

	JFrame calculatorFrame = new JFrame();
	calculatorFrame.setTitle("Calculator");
	calculatorFrame.setSize(200, 200);
	calculatorFrame.setResizable(false);
	calculatorFrame.setVisible(true);

	calculatorFrame.setLayout(new BoxLayout(calculatorFrame.getContentPane(), BoxLayout.Y_AXIS));

	JTextField textField = new JTextField(10);
	textField.setEditable(false);
	textField.setText("");
	textField.setHorizontalAlignment(JTextField.RIGHT);
	calculatorFrame.add(textField);
	//CalculatorActionListener actionListener = new CalculatorActionListener(textField);
	CalculatorActionListenerAdvanced actionListener = new CalculatorActionListenerAdvanced(textField);

	
	JPanel panel = buildPanel(actionListener);

	calculatorFrame.add(panel);

	calculatorFrame.validate();
	// calculatorFrame.setMaximumSize(new Dimension(200, 300));
	calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	return calculatorFrame;
	
	}

	private static JPanel buildPanel(ActionListener actionListener) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 4));
		panel.setBackground(new Color(255, 0, 0));

			

		// textField.addActionListener(actionListener);

		for (int i = 0; i < 10; i++) {

			JButton button = new JButton("" + i);
			button.setActionCommand("" + i);
			button.addActionListener(actionListener);
			//button.addMouseListener(new CalculatorMouseListener());
			panel.add(button);
		}

		JButton clearButton = new JButton("C");
		clearButton.setActionCommand("C");
		clearButton.addActionListener(actionListener);
		panel.add(clearButton);

		JButton addButton = new JButton("+");
		addButton.setActionCommand("+");
		addButton.addActionListener(actionListener);
		panel.add(addButton);

		JButton subtractButton = new JButton("-");
		subtractButton.setActionCommand("-");
		subtractButton.addActionListener(actionListener);
		panel.add(subtractButton);

		JButton mulitplyButton = new JButton("x");
		mulitplyButton.setActionCommand("x");
		mulitplyButton.addActionListener(actionListener);
		panel.add(mulitplyButton);

		JButton divideButton = new JButton("/");
		divideButton.setActionCommand("/");
		divideButton.addActionListener(actionListener);
		panel.add(divideButton);

		JButton modButton = new JButton("%");
		modButton.setActionCommand("%");
		modButton.addActionListener(actionListener);
		panel.add(modButton);

		JButton unaryButton = new JButton("+/-");
		unaryButton.setActionCommand("U");
		unaryButton.addActionListener(actionListener);
		panel.add(unaryButton);

		JButton equalsButton = new JButton("=");
		equalsButton.setActionCommand("=");
		equalsButton.addActionListener(actionListener);
		panel.add(equalsButton);
		return panel;
	}
}
