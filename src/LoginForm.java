import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;



public class LoginForm extends JFrame{
	Container c;
    JLabel l1, l2, l3;
    JTextField t1, t2;
    JButton btn1, btn2;
    Font f1,f2;
    
    LoginForm(){
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 100, 400, 400);
        this.setTitle("Login");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.lightGray);
        
        f1 = new Font("Arial", Font.BOLD+Font.ITALIC, 18);
        f2 = new Font("Arial", Font.BOLD+Font.ITALIC, 22);
       
        l1 = new JLabel("Login ");
        l1.setBounds(150,10,150,50);
        l1.setFont(f2);
        c.add(l1);
        
        l2 = new JLabel("User Name  : ");
        l2.setBounds(10,100 , 200, 50);
        l2.setFont(f1);
        c.add(l2);
       
        t1 = new JTextField();
        t1.setBounds(130, 100, 200, 40);
        t1.setBackground(Color.pink);
        t1.setFont(f1);
        c.add(t1);
        
        l2 = new JLabel("Password : ");
        l2.setBounds(10, 155, 200, 50);
        l2.setFont(f1);
        c.add(l2);
        
        t2 = new JTextField();
        t2.setBounds(130, 150, 200, 40);
        t2.setBackground(Color.pink);
        t2.setFont(f1);
        c.add(t2);
        
        btn1 = new JButton("Register");
        btn1.setBounds(40, 250, 150, 60);
        btn1.setFont(f1);
        btn1.setBackground(Color.red);
        c.add(btn1);

        btn2 = new JButton("Login");
        btn2.setBounds(200, 250, 150, 60);
        btn2.setFont(f1);
        btn2.setBackground(Color.orange);
        c.add(btn2);
        
        btn1.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new RegisterForm();
        		
        	}
        });
        
        
        btn2.addActionListener(new ActionListener() {
    		 @Override
    		 public void actionPerformed(ActionEvent e) {
    			 String UserName = t1.getText();
	        	 String Password = t2.getText();
	        	 
	        	 DbConnect db = new DbConnect();
	        	 String queryLogin = "SELECT * FROM `studentregister`";
	        	 db.Login(queryLogin,UserName,Password);
	        	 
	        	 dispose();
	        	 new FontPage();
	        	  
    		 }   
        });
        setVisible(true);
    } 
    public static void main(String[] args) {
		new LoginForm();
	}
}   

