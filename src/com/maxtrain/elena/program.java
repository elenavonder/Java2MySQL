package com.maxtrain.elena;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class program {

	public static void main(String[] args) throws SQLException {
		//connection statement: "connection string", "user", "password"
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/salesdb" , "root" , "Train@MAX");
		PreparedStatement stmt = conn.prepareStatement("SELECT * from customers where id = ?;");
		stmt.setInt(1, 1);
		//execute query brings back a result set
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			var id = rs.getInt("id");
			var name = rs.getString("Name");
			System.out.println(id + " | " + name);
		}
	}

}
