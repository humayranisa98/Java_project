import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TemparatureConversion extends JFrame implements ActionListener {
	JLabel label1, label2, label3, label4, label5;
	JTextField textField1, textField2, textField3, textField4;
	JButton btn1, btn2, btn3, btn4;
	Font font, font2, font3;
	Container container;

	public TemparatureConversion() {

		container = this.getContentPane();

		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		font = new Font("Arial", Font.ITALIC, 20);
		font2 = new Font("Arial", Font.BOLD, 17);
		font3 = new Font("Arial", Font.BOLD, 14);

		label1 = new JLabel("Temperature Conversion ");
		label1.setBounds(25, 10, 250, 35);
		label1.setForeground(Color.WHITE);
		label1.setFont(font);

		container.add(label1);

		// add Input of Celsius
		label2 = new JLabel("Input  C : ");
		label2.setBounds(30, 60, 100, 30);
		label2.setForeground(Color.white);
		label2.setFont(font2);

		textField1 = new JTextField();
		textField1.setBounds(120, 60, 130, 30);
		textField1.setBackground(Color.PINK);
		textField1.setFont(font3);

		container.add(label2);
		container.add(textField1);

		// add Input of Fahrenheit
		label3 = new JLabel("Input  F : ");
		label3.setBounds(30, 100, 100, 30);
		label3.setForeground(Color.white);
		label3.setFont(font2);

		textField2 = new JTextField();
		textField2.setBounds(120, 100, 130, 30);
		textField2.setBackground(Color.PINK);
		textField2.setFont(font3);

		container.add(label3);
		container.add(textField2);

		// add Input of Kelvin
		label4 = new JLabel("Input  K : ");
		label4.setBounds(30, 140, 100, 30);
		label4.setForeground(Color.white);
		label4.setFont(font2);

		textField3 = new JTextField();
		textField3.setBounds(120, 140, 130, 30);
		textField3.setBackground(Color.PINK);
		textField3.setFont(font3);

		container.add(label4);
		container.add(textField3);

		// add Input of output
		label5 = new JLabel("Output : ");
		label5.setBounds(30, 180, 100, 30);
		label5.setForeground(Color.white);
		label5.setFont(font2);

		textField4 = new JTextField();
		textField4.setBounds(120, 180, 130, 30);
		textField4.setBackground(Color.PINK);
		textField4.setFont(font3);

		container.add(label5);
		container.add(textField4);

		// Button for Celsius
		btn1 = new JButton("C");
		btn1.setBackground(Color.MAGENTA);
		btn1.setBounds(30, 230, 50, 40);
		container.add(btn1);

		// Button for Fahrenheit
		btn2 = new JButton("F");
		btn2.setBackground(Color.MAGENTA);
		btn2.setBounds(110, 230, 50, 40);
		container.add(btn2);

		// Button for Kelvin
		btn3 = new JButton("K");
		btn3.setBackground(Color.MAGENTA);
		btn3.setBounds(190, 230, 50, 40);
		container.add(btn3);

		btn4 = new JButton("Back");
		btn4.setBounds(30, 300, 90, 30);
		container.add(btn4);

		// Add Action Listener
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		textField1.addActionListener(this);
		textField2.addActionListener(this);
		textField3.addActionListener(this);
		textField4.addActionListener(this);

		container.setBackground(Color.DARK_GRAY);
		setLayout(null);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn4) {
			dispose();
			new FontPage();
		}

		String str1, str2, str3;
		str1 = textField1.getText();
		str2 = textField2.getText();
		str3 = textField3.getText();

		// C Button
		if (e.getSource() == btn1) {

			// F to C [ (°F − 32 ) × 5/9]

			if ((!Objects.equals(str2, "")) && (Objects.equals(str3, "")) && (Objects.equals(str1, ""))) {
				double data = Double.parseDouble(str2);
				double data2 = (data - 32) * 5 / 9;
				String send = String.format("%.2f", data2);
				// String send = String.valueOf(data2);
				textField4.setText(send);
			}
			// K to C [ K − 273 ]
			else if ((!Objects.equals(str3, "")) && (Objects.equals(str2, "")) && (Objects.equals(str1, ""))) {
				double data = Double.parseDouble(str3);
				double data2 = data - 273;
				String send = String.format("%.2f", data2);
				// String send = String.valueOf(data2);
				textField4.setText(send);
			}
			// C to C
			else if ((Objects.equals(str3, "")) && (Objects.equals(str2, "")) && (!Objects.equals(str1, ""))) {
				textField4.setText(str1);
			}
			// Nothing insert
			else if ((Objects.equals(str3, "")) && (Objects.equals(str2, "")) && (Objects.equals(str1, ""))) {
				textField4.setText("Nothing Inserted");

			} else {
				textField4.setText("Multiple INPUT");

			}
		}

		// F Button
		else if (e.getSource() == btn2) {
			// textField4.setText(" Button 2 ..!!!");

			// C to F [(°C × 9/5) + 32 ]

			if ((!Objects.equals(str1, "")) && (Objects.equals(str2, "")) && (Objects.equals(str3, ""))) {
				double data = Double.parseDouble(str1);
				double data2 = (1.8 * data) + 32;

				String send = String.format("%.2f", data2);
				// String send = String.valueOf(data2);
				textField4.setText(send);
			}
			// F to K [°F − 32) × 5/9 + 273.15 ]

			else if ((Objects.equals(str1, "")) && (Objects.equals(str2, "")) && (!Objects.equals(str3, ""))) {
				double data = Double.parseDouble(str3);
				double data2 = ((data - 273) * 1.8) + 32;
				String send = String.format("%.2f", data2);
				// String send = String.valueOf(data2);
				textField4.setText(send);
			}
			// F to F [input == output ]

			else if ((Objects.equals(str1, "")) && (!Objects.equals(str2, "")) && (Objects.equals(str3, ""))) {

				textField4.setText(str2);
			}
			// Nothing insert
			else if ((Objects.equals(str3, "")) && (Objects.equals(str2, "")) && (Objects.equals(str1, ""))) {
				textField4.setText("Nothing Inserted");

			}

			// Multiple
			else {
				textField4.setText("Multiple INPUT");

			}
		}

		else if (e.getSource() == btn3) {

			// K to C [ °C + 273 ]

			if ((!Objects.equals(str1, "")) && (Objects.equals(str2, "")) && (Objects.equals(str3, ""))) {
				double data = Double.parseDouble(str1);
				double data2 = data + 273;
				;

				String send = String.format("%.2f", data2);
				// String send = String.valueOf(data2);
				textField4.setText(send);
			}
			// K to F [(°K − 273 ) × 9/5 + 32 ]
			else if ((Objects.equals(str1, "")) && (!Objects.equals(str2, "")) && (Objects.equals(str3, ""))) {
				double data = Double.parseDouble(str2);
				double data2 = ((data - 32) * .555) + 273;
				String send = String.format("%.2f", data2);
				// String send = String.valueOf(data2);
				textField4.setText(send);
			}

			else if ((Objects.equals(str1, "")) && (Objects.equals(str2, "")) && (!Objects.equals(str3, ""))) {

				textField4.setText(str3);
			}

			else if ((Objects.equals(str3, "")) && (Objects.equals(str2, "")) && (Objects.equals(str1, ""))) {
				textField4.setText("Nothing Inserted");

			} else {
				textField4.setText("Multiple INPUT");

			}
		}
	}

	public static void main(String[] args) {
		new TemparatureConversion();
	}

}
