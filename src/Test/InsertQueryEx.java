package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQueryEx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub


		Class.forName("com.mysql.cj.jdbc.Driver");  

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "admin");

		Statement stm = con.createStatement();

		stm.executeUpdate("insert into eproduct (name, price, date_added) values ('Tablet', 1500.00, now())");
		
	

		ResultSet result = stm.executeQuery("select * from eproduct");

		while(result.next()) {

			System.out.println(result.getInt("ID"));
			System.out.println(result.getString("name"));
			System.out.println(result.getDouble("price"));
			System.out.println(result.getTimestamp("date_added"));
		}
	}

}
