package com.synerzip.dbconnection;

import java.sql.*;

public class DbConnection {
	public void getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from record");
		while(rs.next()){
			System.out.println(rs.getInt(1)+""+rs.getString(2)+""+rs.getInt(3));
		}
		st.close();
		con.close();
	}
}

