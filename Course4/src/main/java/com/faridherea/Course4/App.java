package com.faridherea.Course4;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class App 
{
	@SuppressWarnings("restriction")
    public static void main( String[] args ) throws IOException {
        //create webserver service
    	HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);
    	//set handler to specified path
    	server.createContext("/", new MyStringHandler());
    	server.createContext("/html/", new MyHtmlHandler());
    	server.createContext("/index/", new IndexHandler());
    	server.createContext("/list/", new ListHandler());
    	server.createContext("/article/", new ArticleHandler());
    	server.createContext("/login/", new LoginHandler());
    	server.createContext("/register/", new RegisterHandler());
    	server.createContext("/registerResponse/", new RegisterResponseHandler());
    	server.createContext("/form/", new FormHandler());
    	server.createContext("/address/", new AddressHandler());
    	server.createContext("/contact/", new ContactHandler());
    	//creates a default executor
    	server.setExecutor(null);
    	//start the server
    	server.start();
    	System.out.println("Server Started on Port 8001");
    	//instance DBConnection
    	DBConnection connection = new DBConnection();
    	try {
    		connection.selectExample("client");
    	} catch (Exception e) 
    	{
    		e.printStackTrace();
    	}
    }
}
