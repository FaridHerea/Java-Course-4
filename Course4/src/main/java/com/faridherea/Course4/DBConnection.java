package com.faridherea.Course4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	//Add dependencies and declare needed connection variabiles
	private static Connection connect = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	
	//Using the constructor create the connection using DriverManager
    public DBConnection() {
   	
   }
	public static Connection getConn() {
		if(connect==null) {
			 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbFour?"
		                           + "user=admin&password=asds123");
				} catch (Exception e) {
					e.printStackTrace();
				}
			 return connect;
		}
		return connect;
	}
	
	//Get values from DB
	public static void selectRegister(String dbTable) throws Exception{
		connect=getConn();
		statement = connect.createStatement();
		resultSet = statement
				.executeQuery("select * from " + dbTable);
		System.out.println("\nRegistered accounts:\n");
		while(resultSet.next()) {
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String username = resultSet.getString("username");
			String age = resultSet.getString("age");
			String email = resultSet.getString("email");
			System.out.println(firstName + "\t" + lastName + "\t" + username + "\t" + age + "\t" + email);
		}
	}
	
	public static void selectExample(String dbTable) throws Exception{
		connect=getConn();
		statement = connect.createStatement();
		resultSet = statement
				.executeQuery("select * from " + dbTable);
		System.out.println("\nRegistered accounts:\n");
		while(resultSet.next()) {
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String username = resultSet.getString("username");
			String age = resultSet.getString("age");
			String email = resultSet.getString("email");
			System.out.println(firstName + "\t" + lastName + "\t" + username + "\t" + age + "\t" + email);
		}
	}
	
	//Insert values into DB
	public static void InsertRegister(String firstName, String lastName, String username, String password, String age, String email, String dbTable) throws SQLException{
		connect=getConn();
		preparedStatement = connect.prepareStatement("insert into " + dbTable + " (firstName, lastName, username, password, age, email) values (?,?,?,?,?,?)");
		preparedStatement.setString(1, firstName);
		preparedStatement.setString(2, lastName);
		preparedStatement.setString(3, username);
		preparedStatement.setString(4, password);
		preparedStatement.setString(5, age);
		preparedStatement.setString(6, email);
		preparedStatement.executeUpdate();
	}
	
	//Delete values from DB
//	public void deleteExample(String dbTable, String reference) throws SQLException{
//		connect=getConn();
//		preparedStatement = connect.prepareStatement("delete from " + dbTable + " where username =? ; ");
//		preparedStatement.setString(1, reference);
//		preparedStatement.executeUpdate();
//	}
	
	//Update values in DB
//	public void updateExample(String reference, String address, String dbTable) throws SQLException{
//		connect=getConn();
//		preparedStatement = connect.prepareStatement("update " + dbTable + " set address=? where username=?");
//		preparedStatement.setString(1, address);
//		preparedStatement.setString(2, reference);
//		preparedStatement.executeUpdate();
//	}
}
