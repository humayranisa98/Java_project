import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Rules extends JFrame implements ActionListener{
	JButton btn1,btn2;
	String username;
	Rules(String username){
		this.username = username;
		setBounds(600,200,800,650);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel label1 = new JLabel("Welcome " + username + " to Quiz");
		label1.setFont(new Font("Times new Roman",Font.BOLD,28));
		label1.setBounds(50,20,700,30);
		add(label1);
		
		JLabel label2 = new JLabel("");
		label2.setFont(new Font("Times new Roman",Font.BOLD,16));
		label2.setBounds(20,90,600,350);
		label2.setText("<html>"+
				          "1. Quizmaster's decision is final and blinding." + "<br><br>" +
				          "2. You Google in quiz, you are out of these quiz." + "<br><br>" +
				          "3. No cell phones or any type of out sources are allowed." + "<br><br>" +
				          "4. Be quiet." + "<br><br>" +
				          "5. We'll total scores and see who's the Winner!!" + "<br><br>" +
				       "<html>");
		add(label2);
		
		btn1= new JButton("Back");
		btn1.setBounds(250,500,100,30);
		btn1.setBackground(Color.CYAN);
		btn1.addActionListener(this);
		add(btn1);
		
		btn2= new JButton("Start");
		btn2.setBounds(400,500,100,30);
		btn2.setBackground(Color.CYAN);
		btn2.addActionListener(this);
		add(btn2);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			this.setVisible(false);
			new DevelopQuiz().setVisible(true);
		}
		else if(e.getSource() == btn2) {
			this.setVisible(false);
			new Quiz(username).setVisible(true);
			
		}
		
	}
}
