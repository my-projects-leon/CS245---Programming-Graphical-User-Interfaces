//
//	Name:	Leon, Pablo
//	Project:#2
//	Due:	October 30, 2014
//	Course: CS-245-01-f14
//
//	Description:
//				A simple calculator that accepts integer values and performs
//				4 basic math functions:add, subtract, divided, and multiply.
//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calc implements ActionListener {
	JLabel display;
	int num = 0;
	int lhs = 0;
	char operator;
	boolean error;
	
	Calc()
	{
		ImageIcon icon = new ImageIcon("Calculator.png");
		error = false;
		JFrame frame = new JFrame("Calculator");
		frame.setIconImage(icon.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension panelDim = new Dimension(325, 435);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(panelDim);
		panel.setMaximumSize(panelDim);
		panel.setMinimumSize(panelDim);
		
		Box box = new Box(BoxLayout.Y_AXIS);
		
		box.add(Box.createVerticalGlue());
		box.add(panel);
		box.add(Box.createVerticalGlue());
		
		panel.setLayout(new GridLayout(2,0));
		frame.add(box);
		frame.pack();
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4,4));
		
		panel.add(panel1);
		panel.add(panel2);
		
		display = new JLabel("0", SwingConstants.RIGHT);
		display.setPreferredSize(new Dimension(300,200));
		panel1.add(display);
		
		String butNames[] = {"7", "8", "9", "/", "4", "5", "6", "*",
				"1", "2", "3", "-", "0", "C", "=", "+"};
		JButton but;
		
		for (int i =0; i < butNames.length; i++)
		{
			but = new JButton(butNames[i]);
			if(butNames[i] == "C") {
				but.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						error = false;
						num = 0;
						lhs = 0;
						display.setText("0");
					}
				});
			} 
			else {
				but.addActionListener(this);
			}
			panel2.add(but);
		}
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		char key = Character.toLowerCase(ae.getActionCommand().charAt(0));
		long result = 0;
		switch(key)
		{
			case '0':
				if(num == 0){
					display.setText(ae.getActionCommand());
					num++;
				}
				else{
					if (num <10){
						display.setText(display.getText() + ae.getActionCommand());
						num++;
					}
				}
				break;
			case '1':
				if(num == 0){
					display.setText(ae.getActionCommand());
					num++;
				}
				else{
					if (num <10){
						display.setText(display.getText() + ae.getActionCommand());
						num++;
					}
				}
				break;
			case '2':
				if(num == 0){
					display.setText(ae.getActionCommand());
					num++;
				}
				else{
					if (num <10){
						display.setText(display.getText() + ae.getActionCommand());
						num++;
					}
				}
				break;
			case '3':
				if(num == 0){
					display.setText(ae.getActionCommand());
					num++;
				}
				else{
					if (num <10){
						display.setText(display.getText() + ae.getActionCommand());
						num++;
					}
				}
				break;
			case '4':
				if(num == 0){
					display.setText(ae.getActionCommand());
					num++;
				}
				else{
					if (num <10){
						display.setText(display.getText() + ae.getActionCommand());
						num++;
					}
				}
				break;
			case '5':
				if(num == 0){
					display.setText(ae.getActionCommand());
					num++;
				}
				else{
					if (num <10){
						display.setText(display.getText() + ae.getActionCommand());
						num++;
					}
				}
				break;
			case '6':
				if(num == 0){
					display.setText(ae.getActionCommand());
					num++;
				}
				else{
					if (num <10){
						display.setText(display.getText() + ae.getActionCommand());
						num++;
					}
				}
				break;
			case '7':
				if(num == 0){
					display.setText(ae.getActionCommand());
					num++;
				}
				else{
					if (num <10){
						display.setText(display.getText() + ae.getActionCommand());
						num++;
					}
				}
				break;
			case '8':
				if(num == 0){
					display.setText(ae.getActionCommand());
					num++;
				}
				else{
					if (num <10){
						display.setText(display.getText() + ae.getActionCommand());
						num++;
					}
				}
				break;
			case '9':
				if(num == 0){
					display.setText(ae.getActionCommand());
					num++;
				}
				else{
					if (num <10){
						display.setText(display.getText() + ae.getActionCommand());
						num++;
					}
				}
				break;
			case '+':
				operator = key;
				num = 0;
				result = Long.parseLong(display.getText());
				if (result > Integer.MAX_VALUE)
				{
					display.setText("Overflow occured. Reset with C");
					break;
				}
				lhs = Integer.parseInt(display.getText());
				break;
			case '-':
				operator = key;
				num = 0;
				result = Long.parseLong(display.getText());
				if (result > Integer.MAX_VALUE)
				{
					display.setText("Overflow occured. Reset with C");
					break;
				}
				lhs = Integer.parseInt(display.getText());
				break;
			case '/':
				operator = key;
				num = 0;
				result = Long.parseLong(display.getText());
				if (result > Integer.MAX_VALUE)
				{
					display.setText("Overflow occured. Reset with C");
					break;
				}
				lhs = Integer.parseInt(display.getText());
				break;
			case '*':
				operator = key;
				num = 0;
				result = Long.parseLong(display.getText());
				if (result > Integer.MAX_VALUE)
				{
					display.setText("Overflow occured. Reset with C");
					break;
				}
				lhs = Integer.parseInt(display.getText());
				break;
			case '=':
				int rhs = Integer.parseInt(display.getText());
				switch (operator) {
				case '+':
					result = ((long)lhs) + rhs;
					System.out.println(result);
					if (result > Integer.MAX_VALUE)
					{
						display.setText("Overflow occur");
						error = true;
						break;
					}
					lhs = lhs + rhs;
					break;
				case '-':
					result = ((long)lhs) - rhs;
					if (result < Integer.MIN_VALUE)
					{
						display.setText("Underflow occur");
						error = true;
						break;
					}
					lhs = lhs - rhs;
					break;
				case '/':
					if (rhs == 0)
					{
						error = true;
						display.setText("Can not divide by 0. Press C to clear");
						break;
					}
					else{
						lhs = lhs / rhs;
						break;
					}
				case '*':
					lhs = lhs * rhs;
					break;
				}
				if(error == false)
				{
					num = 0;
					display.setText("" + lhs);
				}
				break;
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				new Calc();
			}
		});

	}

}