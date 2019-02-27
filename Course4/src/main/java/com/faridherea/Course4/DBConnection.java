package com.faridherea.Course4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	//Add dependencies and declare needed connection variabiles
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	//Using the constructor create the connection using DriverManager
	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/dataBase?" + "user=sqluser&password=sqluserpw");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Get values from DB
	public void selectExample(String dbTable) throws Exception{
		statement = connect.createStatement();
		resultSet = statement
				.executeQuery("select * from " + dbTable);
		String user = resultSet.getString("username");
		String address = resultSet.getString("address");
		System.out.println("Username : " + user + " , Address : " + address);
	}
	
	//Inser values into DB
	public void InsertExample(String username, String address, String dbTable) throws SQLException{
		preparedStatement = connect.prepareStatement("insert into " + dbTable + "values (?,?)");
		preparedStatement.setString(1, "Vlad");
		preparedStatement.setString(2, "Iasi");
		preparedStatement.executeUpdate();
	}
	
	//Delete values from DB
	public void deleteExample(String dbTable, String reference) throws SQLException{
		preparedStatement = connect.prepareStatement("delete from " + dbTable + " where username =? ; ");
		preparedStatement.setString(1, reference);
		preparedStatement.executeUpdate();
	}
	
	//Update values in DB
	public void updateExample(String reference, String address, String dbTable) throws SQLException{
		preparedStatement = connect.prepareStatement("update " + dbTable + " set address=? where username=?");
		preparedStatement.setString(1, address);
		preparedStatement.setString(2, reference);
		preparedStatement.executeUpdate();
	}
}
