import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DevelopQuiz extends JFrame implements ActionListener {
	JButton btn2, btn1, btn3;
	JTextField txt1;

	DevelopQuiz() {
		setBounds(400, 200, 1200, 500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setLocationRelativeTo(null);

		ImageIcon image1 = new ImageIcon(new ImageIcon("F:\\Quiz\\src\\Icons/login.jpg").getImage()
				.getScaledInstance(600, 500, Image.SCALE_DEFAULT));
		JLabel label1 = new JLabel(image1);
		label1.setBounds(0, 0, 600, 500);
		add(label1);

		JLabel label2 = new JLabel("Quiz");
		label2.setFont(new Font("Arial", Font.BOLD, 40));
		label2.setForeground(Color.BLUE);
		label2.setBounds(750, 40, 300, 45);
		add(label2);

		JLabel label3 = new JLabel("Enter Your Name");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label3.setForeground(Color.BLUE);
		label3.setBounds(810, 150, 300, 20);
		add(label3);

		txt1 = new JTextField();
		txt1.setBounds(735, 200, 300, 25);
		txt1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(txt1);

		btn1 = new JButton("Rules");
		btn1.setBounds(735, 270, 120, 25);
		btn1.setBackground(Color.CYAN);
		btn1.addActionListener(this);
		add(btn1);

		btn2 = new JButton("Exit");
		btn2.setBounds(915, 270, 120, 25);
		btn2.setBackground(Color.CYAN);
		btn2.addActionListener(this);
		add(btn2);

//		btn3 = new JButton("Back");
//		btn3.setBounds(915, 350, 120, 25);
//		btn3.setBackground(Color.CYAN);
//		btn3.addActionListener(this);
//		add(btn3);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			String name = txt1.getText();
			this.setVisible(false);
			new Rules(name);

		} else {
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new DevelopQuiz();
	}
}
