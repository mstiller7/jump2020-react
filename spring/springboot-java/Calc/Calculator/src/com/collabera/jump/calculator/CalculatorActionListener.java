package com.collabera.jump.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class CalculatorActionListener implements ActionListener {

	Integer value1, value2;

	String operator;

	private JTextField textField;
	
	public CalculatorActionListener(JTextField textField) {
		
		this.textField = textField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9": {
			String text = textField.getText();
			textField.setText(text + e.getActionCommand());
		}
			break;

		case "+": {

			String text = textField.getText();
			textField.setText("");
			value1 = Integer.parseInt(text);
			operator = e.getActionCommand();

		}
			break;
		case "-": {

			String text = textField.getText();
			textField.setText("");
			value1 = Integer.parseInt(text);
			operator = e.getActionCommand();

//			String text = textField.getText();
//			textField.setText("");
//			if (operator == null ) {
//				value1 = Integer.parseInt(text);
//				System.out.println("Value1" + value1);
//				
//			} else {
//				value2 = Integer.parseInt(text);
//				System.out.println("Value2" + value2);
//				value1 = compute(value1, value2, operator);
//				textField.setText(value1 + "");
//			}
//
//			operator = e.getActionCommand();

		}
			break;
		case "x": {

			String text = textField.getText();
			textField.setText("");
			value1 = Integer.parseInt(text);
			operator = e.getActionCommand();

		}
			break;
		case "/": {

			String text = textField.getText();
			textField.setText("");
			value1 = Integer.parseInt(text);
			operator = e.getActionCommand();

		}
			break;
		case "%": {

			String text = textField.getText();
			textField.setText("");
			value1 = Integer.parseInt(text);
			operator = e.getActionCommand();

		}
			break;
		case "U": {
			String text = textField.getText();
			value1 = Integer.parseInt(text);
			textField.setText(value1 * -1 + "");
		}
			break;
		case "C": {
			textField.setText("");
			value1 = 0;
			value2 = 0;
			operator = null;
		}

		case "=": {
			String text = textField.getText();
			value2 = Integer.parseInt(text);
			Integer result = compute(value1, value2, operator);
			textField.setText(result + "");
			operator = null;

		}
			break;
		default: {
			System.out.println("God save you!" + e.getActionCommand());
		}
			break;
		}

		// System.out.println(e.getActionCommand());
	}

	private Integer compute(Integer value1, Integer value2, String operator) {

		System.out.println(value1);
		System.out.println(value2);
		System.out.println(operator);
		Integer result = null;
		switch (operator) {
		case "+":
			result = value1 + value2;
			break;

		case "x":
			result = value1 * value2;
			break;
		case "-":
			result = value1 - value2;
			break;
		case "/":
			result = value1 / value2;
			break;
		
		case "%":
			result = value1 / value2;
			break;
		}

		return result;
	}

}
