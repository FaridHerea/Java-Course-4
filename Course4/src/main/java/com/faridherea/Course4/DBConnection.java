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
	public static void selectExample(String dbTable) throws Exception{
		connect=getConn();
		statement = connect.createStatement();
		resultSet = statement
				.executeQuery("select * from " + dbTable);
		while(resultSet.next()) {
			String user = resultSet.getString("username");
			String address = resultSet.getString("address");
			System.out.println("Username : " + user + " , Address : " + address);
		}
		
	}
	
	//Insert values into DB
	public static void InsertExample(String username, String address, String dbTable) throws SQLException{
		connect=getConn();
		preparedStatement = connect.prepareStatement("insert into " + dbTable + " (username, address) values (?,?)");
		preparedStatement.setString(1, "Vlad");
		preparedStatement.setString(2, "Iasi");
		preparedStatement.executeUpdate();
	}
	
	//Delete values from DB
	public void deleteExample(String dbTable, String reference) throws SQLException{
		connect=getConn();
		preparedStatement = connect.prepareStatement("delete from " + dbTable + " where username =? ; ");
		preparedStatement.setString(1, reference);
		preparedStatement.executeUpdate();
	}
	
	//Update values in DB
	public void updateExample(String reference, String address, String dbTable) throws SQLException{
		connect=getConn();
		preparedStatement = connect.prepareStatement("update " + dbTable + " set address=? where username=?");
		preparedStatement.setString(1, address);
		preparedStatement.setString(2, reference);
		preparedStatement.executeUpdate();
	}
}
