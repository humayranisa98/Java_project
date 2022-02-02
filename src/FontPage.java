import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FontPage extends JFrame implements ActionListener {

	JButton bmiBtn, tempBtn, quizBtn, registrationbtn;

	FontPage() {

		setBounds(250, 50, 1000, 900);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setLocationRelativeTo(null);

		bmiBtn = new JButton("B M I ");
		bmiBtn.setBounds(100, 200, 200, 80);
		add(bmiBtn);

		tempBtn = new JButton(" TEMPARATURE ");
		tempBtn.setBounds(100, 340, 200, 80);
		add(tempBtn);

		quizBtn = new JButton("Q U I Z ");
		quizBtn.setBounds(100, 480, 200, 80);
		add(quizBtn);

		registrationbtn = new JButton("REGISTRATION ");
		registrationbtn.setBounds(100, 620, 200, 80);
		add(registrationbtn);

		bmiBtn.addActionListener(this);
		tempBtn.addActionListener(this);
		quizBtn.addActionListener(this);
		registrationbtn.addActionListener(this);

		setVisible(true);

	}

	public static void main(String[] args) {
		new FontPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bmiBtn) {

			dispose();
			new BMIcalculator();
			// new FontPage();
		} else if (e.getSource() == tempBtn) {
			dispose();
			new TemparatureConversion();

		} else if (e.getSource() == quizBtn) {

			dispose();
			// new Quiz(" ");
			new DevelopQuiz();
		} else if (e.getSource() == registrationbtn) {
			dispose();
			new RegisterForm();

		}
	}
}