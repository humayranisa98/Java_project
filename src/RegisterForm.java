import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.JOptionPane;

public class RegisterForm extends JFrame{
	 Container c; 
	    JLabel l1, l2, l3, l4, l5, l6, l7;
	    JTextField t1, t2, t3, t4, t5, t6;
	    JPanel p1, p2;
	    JButton btn1, btn2, btn3;
	    Font f1, f2;

	    RegisterForm() {
	        initComponent();
	    }

	    public void initComponent() {

	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLayout(null);
	        this.setBounds(200, 100, 500, 600);
	        this.setTitle("RegistrationDemo");
	        this.setLocationRelativeTo(null);
	        this.setResizable(false);
	        
	        c = this.getContentPane();
	        c.setLayout(null);
	        c.setBackground(Color.lightGray);
	        
	        f1 = new Font("Arial", Font.BOLD+Font.ITALIC, 18);
	        f2 = new Font("Arial", Font.BOLD, 18);
	        
	        p1 = new JPanel();
	        p1.setBounds(0,10,500,40);
	        p1.setBackground(Color.ORANGE);
	        p1.setFont(f1);
	        c.add(p1);
	            
	        
	        l1 = new JLabel("Registration");
	        l1.setBounds(100,20, 250, 80);
	        l1.setFont(f1);
	        p1.add(l1);
	        
	        l2 = new JLabel("User Name                 : ");
	        l2.setBounds(10, 90, 200, 50);
	        l2.setFont(f2);
	        c.add(l2);


	        t1 = new JTextField();
	        t1.setBounds(200, 95, 200, 40);
	        t1.setBackground(Color.white);
	        t1.setFont(f2);
	        c.add(t1);
	        
	        l3 = new JLabel("Email                           : ");
	        l3.setBounds(10,150 , 200, 50);
	        l3.setFont(f2);
	        c.add(l3);
	        
	        t2 = new JTextField();
	        t2.setBounds(200, 150, 200, 40);
	        t2.setBackground(Color.white);
	        t2.setFont(f2);
	        c.add(t2);
	        
	        
	        l4 = new JLabel("Mobile                         : ");
	        l4.setBounds(10,200 , 200, 50);
	        l4.setFont(f2);
	        c.add(l4);
	        
	        t3 = new JTextField();
	        t3.setBounds(200, 200, 200, 40);
	        t3.setBackground(Color.white);
	        t3.setFont(f2);
	        c.add(t3);
	        
	        
	        l5 = new JLabel("Password                   : ");
	        l5.setBounds(10,250 , 200, 50);
	        l5.setFont(f2);
	        c.add(l5);
	        
	        t4 = new JTextField();
	        t4.setBounds(200, 250, 200, 40);
	        t4.setBackground(Color.white);
	        t4.setFont(f2);
	        c.add(t4);
	        
	        
	        l6 = new JLabel("Confirm Password   : ");
	        l6.setBounds(10,300 , 200, 50);
	        l6.setFont(f2);
	        c.add(l6);
	        
	        t5 = new JTextField();
	        t5.setBounds(200, 300, 200, 40);
	        t5.setBackground(Color.white);
	        t5.setFont(f2);
	        c.add(t5);
	        
	        l7 = new JLabel("Address                      : ");
	        l7.setBounds(10,350 , 200, 50);
	        l7.setFont(f2);
	        c.add(l7);
	        
	        t6 = new JTextField();
	        t6.setBounds(200, 350, 200, 40);
	        t6.setBackground(Color.white);
	        t6.setFont(f2);
	        c.add(t6);
	        
	        
	        btn1 = new JButton("Login");
	        btn1.setBounds(60, 450, 150, 60);
	        btn1.setFont(f1);
	        btn1.setBackground(Color.blue);
	        c.add(btn1);

	        btn2 = new JButton("Register");
	        btn2.setBounds(280, 450, 150, 60);
	        btn2.setFont(f1);
	        btn2.setBackground(Color.pink);
	        c.add(btn2);
	        
	        btn1.addActionListener(new ActionListener() {
	        	@Override
	        	public void actionPerformed(ActionEvent e) { 
	        		dispose();
	        		new LoginForm();
	        		
	        	}
	        	
	        });
	        
	        btn2.addActionListener(new ActionListener() {
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        		String UserName = t1.getText();
	        		String Email = t2.getText();
	        		String Mobile = t3.getText();
	        		String Password = t4.getText();
	        		String ConfirmPass = t5.getText();
	        		String Address = t6.getText();
	        		
	        		//Validation
	        		
	        		String userNameRegex = "^[a-zA-Z .]+$";
		            
		            String emailRegex = "^[a-z0-9]+@[a-z]+.[a-z]+$";
		            
		            String mobileRegex = "(\\+88)?-?01[3-9]\\d{8}";
		            
		            String passRegex = "(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*()]).{6,20}";
		            
		            if(!Pattern.matches(userNameRegex, UserName)){
		            	JOptionPane.showMessageDialog(null, "Only char is allowed!!");
		            }
		            else if(!Pattern.matches(emailRegex, Email)){
		            	JOptionPane.showMessageDialog(null, "In-valid Email!!");
		            }
		            else if(!Pattern.matches(mobileRegex, Mobile)){
		            	JOptionPane.showMessageDialog(null, "In-valid Mobile Number!!");
		            }
		            else if(!Pattern.matches(passRegex, Password)){
		            	JOptionPane.showMessageDialog(null, "1 digit, 1 lower, 1 upper, 1 special char and length 6-20");
		            }
		            else if(!ConfirmPass.equals(Password)){
		            	JOptionPane.showMessageDialog(null, "Password and confirm password is not matching!!");
		            }
		            else if(Address.equals("")){
		            	JOptionPane.showMessageDialog(null, "In valid address");
		            }
		            
		            else {
		            	String insertQuery = "INSERT INTO `studentregister`(`userName`, `email`, `mobile`, `password`, `address`) VALUES ('"+UserName+"','"+Email+"','"+Mobile+"','"+Password+"','"+Address+"')";
		        		
		        		DbConnect db = new DbConnect();
		        		db.InsertRegister(insertQuery);
		            }	
	        	}
	        	
	        });
	        
	        setVisible(true);
	    }
	    public static void main(String[] args) {
			new RegisterForm();
		}
}
