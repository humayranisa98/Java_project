import java.sql.*;
import javax.swing.JOptionPane;

public class DbConnect {
	private Connection con;
	private Statement st;
	ResultSet rs;
	int flag=0;
	
	public DbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","");
		     st = con.createStatement();
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}

	}
	
	public void InsertRegister(String insertQuery) {
		//System.out.println(insertQuery);
		try {
			st.executeUpdate(insertQuery);
			JOptionPane.showMessageDialog(null,"Successfully Registered!!");
			
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Successfully Not Registered!!");
		}
		
	}


	public void Login(String queryLogin, String userName, String password) {
		
		try {
			rs = st.executeQuery(queryLogin);
			
			while(rs.next()) {
				String tableUseName = rs.getString(2);
				String tablePass = rs.getString(5);
				
				if(userName.equals(tableUseName) && password.equals(tablePass)) {
					JOptionPane.showMessageDialog(null, "You are a valid User!!");
					flag = 1;
					
					break;
				}
			}
			if(flag == 0) {
				JOptionPane.showMessageDialog(null, "You are not a valid User!!");
			}
				
				
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
}
