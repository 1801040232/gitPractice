package dBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	private static String db_url = "jdbc:mysql://localhost:3306/newspaper?useSSL=false";
	private static String db_user = "root";
	private static String db_pass = "Qu@ngVan20";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(db_url, db_user, db_pass);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public static void main(String[] args) {

		try {
			Connection conn = getConnection();
			Statement stm;
			stm = conn.createStatement();
			String query = "select * from newspaper";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				System.out.println("id: " + rs.getInt("id"));
				System.out.println("title: " + rs.getString("title"));
				System.out.println("content: " + rs.getString("content"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
