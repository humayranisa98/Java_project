import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Quiz extends JFrame implements ActionListener {

	JButton next, submit;
	public static int count = 0;
	public static int timer = 15;
	public static int ans_given = 0;
	public static int score = 0;

	static JLabel qno;
	static JLabel question;
	static String q[][] = new String[10][5];
	static String ans[][] = new String[10][1];
	static String correct_ans[][] = new String[10][2];
	static JRadioButton op1, op2, op3, op4;
	static ButtonGroup options;
	String username;

	Quiz(String username) {
		this.username = username;
		setBounds(250, 50, 1440, 950);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setLocationRelativeTo(null);

		ImageIcon image1 = new ImageIcon(new ImageIcon("F:\\Quiz\\src\\Icons/quiz.jpg").getImage()
				.getScaledInstance(1440, 392, Image.SCALE_DEFAULT));
		JLabel label1 = new JLabel(image1);
		label1.setBounds(0, 0, 1440, 392);
		add(label1);

		qno = new JLabel("");
		qno.setFont(new Font("Times new Roman", Font.PLAIN, 24));
		qno.setBounds(100, 450, 40, 30);
		add(qno);

		question = new JLabel("");
		question.setFont(new Font("Times new Roman", Font.PLAIN, 24));
		question.setBounds(150, 450, 900, 30);
		add(question);

		q[0][0] = "Which is your course teacher name?";
		q[0][1] = "Md.Ebrahim Hossain";
		q[0][2] = "Md.Jehadul Islam Mony";
		q[0][3] = "Md.Jamaner Rahaman";
		q[0][4] = "Prithwiraj Bhattacharjee";

		q[1][0] = "What is always coming, but never arrives?";
		q[1][1] = "Tomorrow";
		q[1][2] = "Yesterday";
		q[1][3] = "Monday";
		q[1][4] = "Today";

		q[2][0] = "What is  the full meaning of JIM?";
		q[2][1] = "Md.Jehadul Islam Mony";
		q[2][2] = "Jubayer Islam Mahin";
		q[2][3] = "Jahin Islam Moon";
		q[2][4] = "None of them";

		q[3][0] = "Which of the painful month of these semester?";
		q[3][1] = "January";
		q[3][2] = "February";
		q[3][3] = "March";
		q[3][4] = "June";

		q[4][0] = "If you have one, you want to share it. But once you share it, you do not have it. what is it?";
		q[4][1] = "A Secret";
		q[4][2] = "Falsehood";
		q[4][3] = "Random speech";
		q[4][4] = "A Story teller";

		q[5][0] = "I have ocean but no water. Who am I?";
		q[5][1] = "A Writter";
		q[5][2] = "A scientist";
		q[5][3] = "A Student";
		q[5][4] = "A World map";

		q[6][0] = "What is your course code?";
		q[6][1] = "CSE-2231";
		q[6][2] = "CSE-3317";
		q[6][3] = "EEE-1123";
		q[6][4] = "MAT-4212";

		q[7][0] = "What Sylhet famous for?";
		q[7][1] = "Tea and tea garden";
		q[7][2] = "Sea";
		q[7][3] = "Forest";
		q[7][4] = "White rice";

		q[8][0] = "What is the amount of current death in COVID-19 in Bangladesh?";
		q[8][1] = "28,256";
		q[8][2] = "31,000";
		q[8][3] = "491k";
		q[8][4] = "16.9M";

		q[9][0] = "Which of the following option leads to the portability and security of Java?";
		q[9][1] = "Bytecode is executed by JVM";
		q[9][2] = "The applet makes the Java code secure and portable";
		q[9][3] = "Use of exception handling";
		q[9][4] = "Dynamic binding between objects";

		correct_ans[0][1] = "Md.Jehadul Islam Mony";
		correct_ans[1][1] = "Tomorrow";
		correct_ans[2][1] = "Md.Jehadul Islam Mony";
		correct_ans[3][1] = "January";
		correct_ans[4][1] = "A Secret";
		correct_ans[5][1] = "A World map";
		correct_ans[6][1] = "CSE-3317";
		correct_ans[7][1] = "Tea and tea garden";
		correct_ans[8][1] = "28,256";
		correct_ans[9][1] = "Bytecode is executed by JVM";

		op1 = new JRadioButton("");
		op1.setBounds(170, 520, 700, 30);
		op1.setFont(new Font("Arial", Font.PLAIN, 20));
		op1.setBackground(Color.WHITE);
		add(op1);

		op2 = new JRadioButton("");
		op2.setBounds(170, 560, 700, 30);
		op2.setFont(new Font("Arial", Font.PLAIN, 20));
		op2.setBackground(Color.WHITE);
		add(op2);

		op3 = new JRadioButton("");
		op3.setBounds(170, 600, 700, 30);
		op3.setFont(new Font("Arial", Font.PLAIN, 20));
		op3.setBackground(Color.WHITE);
		add(op3);

		op4 = new JRadioButton("");
		op4.setBounds(170, 640, 700, 30);
		op4.setFont(new Font("Arial", Font.PLAIN, 20));
		op4.setBackground(Color.WHITE);
		add(op4);

		options = new ButtonGroup(); // multiple option select hobe na
		options.add(op1);
		options.add(op2);
		options.add(op3);
		options.add(op4);

		next = new JButton("Next");
		next.setFont(new Font("Arial", Font.PLAIN, 22));
		next.setForeground(Color.WHITE);
		next.setBackground(Color.MAGENTA);
		next.addActionListener(this);
		next.setBounds(1100, 550, 200, 40);
		add(next);

		submit = new JButton("Submit");
		submit.setFont(new Font("Arial", Font.PLAIN, 22));
		submit.setEnabled(false);
		submit.setForeground(Color.WHITE);
		submit.setBackground(Color.MAGENTA);
		submit.addActionListener(this);
		submit.setBounds(1100, 630, 200, 40);
		add(submit);

		start(0); // value set korbe

		// setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == next) {
			repaint();

			ans_given = 1;
			if (options.getSelection() == null) {
				ans[count][0] = " ";
			} else {
				ans[count][0] = options.getSelection().getActionCommand(); // option select hobe
			}

			if (count == 8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			count++; // next question a move korbe
			start(count);
		} else if (e.getSource() == submit) {
			ans_given = 1;
			if (options.getSelection() == null) {
				ans[count][0] = " ";
			} else {
				ans[count][0] = options.getSelection().getActionCommand();
			}

			for (int i = 0; i < ans.length; i++) {
				if (ans[i][0].equals(correct_ans[i][1])) {
					score += 10;
				} else {
					score += 0;
				}
			}
			this.setVisible(false);
			new Score(username, score).setVisible(true);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		String time = "Time Left - " + timer + "seconds";
		g.setColor(Color.red);
		g.setFont(new Font("Arial", Font.BOLD, 25));

		if (timer > 0) {
			g.drawString(time, 1100, 500);
		} else {
			g.drawString("Times up!!", 1100, 500);
		}

		timer--; // 14,13 aivabe asbe...

		try {
			Thread.sleep(1000);
			repaint(); // paint function bar bar call hocce
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ans_given == 1) { // ans select kore porer option a 15 sec theke start hobe
			ans_given = 0;
			timer = 15;
		} else if (timer < 0) {
			timer = 15;

			if (count == 8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			if (count == 9) {
				if (options.getSelection() == null) {
					ans[count][0] = " ";
				} else {
					ans[count][0] = options.getSelection().getActionCommand(); // option collect korbe
				}

				for (int i = 0; i < ans.length; i++) {
					if (ans[i][0].equals(correct_ans[i][1])) {
						score += 10;
					} else {
						score += 0;
					}
				}
				this.setVisible(false);
				new Score(username, score).setVisible(true);

			} else {
				if (options.getSelection() == null) {
					ans[count][0] = " ";
				} else {
					ans[count][0] = options.getSelection().getActionCommand();
				}
				count++;
				start(count);
			}
		}

	}

	public static void start(int count) { // value set korbe
		qno.setText("" + (count + 1) + " .");
		question.setText(q[count][0]);
		op1.setLabel(q[count][1]);
		op1.setActionCommand(q[count][1]);
		op2.setLabel(q[count][2]);
		op2.setActionCommand(q[count][2]);
		op3.setLabel(q[count][3]);
		op3.setActionCommand(q[count][3]);
		op4.setLabel(q[count][4]);
		op4.setActionCommand(q[count][4]);

		options.clearSelection();

	}

	public static void main(String[] args) {
		new Quiz(" ").setVisible(true);
	}

}
