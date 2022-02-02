import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Score extends JFrame implements ActionListener {

	Connection con;
	PreparedStatement pst;
	PreparedStatement pst1;
	PreparedStatement pst2;

	Score(String username, int score) {
		setBounds(600, 150, 750, 550);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setLocationRelativeTo(null);

		ImageIcon image1 = new ImageIcon(new ImageIcon("F:\\Quiz\\src\\Icons/score.jpg").getImage()
				.getScaledInstance(300, 250, Image.SCALE_DEFAULT));
		JLabel l1 = new JLabel(image1);
		l1.setBounds(0, 200, 300, 250);
		add(l1);

		JLabel l2 = new JLabel("Thank you " + username + " for Playing Quiz");
		l2.setBounds(45, 30, 700, 30);
		l2.setFont(new Font("Arial", Font.PLAIN, 26));
		add(l2);

		JLabel l3 = new JLabel("Your Score is " + score);
		l3.setBounds(350, 200, 300, 30);
		l3.setFont(new Font("Times new Roman", Font.PLAIN, 26));
		l3.setForeground(new Color(199, 21, 133));
		add(l3);

		JButton b1 = new JButton("Play Again");
		b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);

		b1.setBounds(400, 270, 120, 30);
		add(b1);

		String userName = username;

		int sc = score;

		if (userName == "" || sc == 0 || userName == " ") {
			JOptionPane.showMessageDialog(null, "Either score is 0 or name format is incorrect ");
		} else {
			connect();
			updateDb(userName, sc);
		}

		setVisible(true);

	}

	public void connect() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateDb(String username, int score) {

		try {

			DateTimeFormatter dfSet = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDateTime nowTime = LocalDateTime.now();

			String date = dfSet.format(nowTime);

			String query1 = "insert into history(name,date,score)values(?,?,?)";

			pst1 = con.prepareStatement(query1);
			pst1.setString(1, username);
			pst1.setString(2, date);
			pst1.setInt(3, score);

			pst1.executeUpdate();
			JOptionPane.showMessageDialog(null, "Your data update in data base  ");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent ae) {
		this.setVisible(false);
		new DevelopQuiz().setVisible(true);
	}

	public static void main(String[] args) {
		new Score("", 0).setVisible(true);
	}
}
