package jdbc;

import java.sql.*;

public class Example {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql//localhost/employee";
	
	//credentials
	static final String USER = "root";
	static final String PASS = "";
	
	public static void main (String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// connecting to dabase
			System.out.println("Connecting to dabase"); 
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//executing query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			
			
			sql = "SELECT id, first, last, age FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//by column name
				int id  = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getString("age");
				
				System.out.println("ID: " + id);
				System.out.println("Age: " + age);
				System.out.println("First name: " + first);
				System.out.println("Last name: " + last);
				
				//cleaning up the mess
				
				rs.close();
				stmt.close();
				conn.close();
			}}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				if(stmt!=null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}	
		
	}
			
}
