package com.faridherea.Course4;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
@SuppressWarnings("restriction")

public class IndexHandler implements HttpHandler{
	public void handle(HttpExchange t) throws IOException{
		//set the response as a string containing html code
		String response = "<html>\r\n" + 
				"    <head>\r\n" + 
				"        <title>Main page</title>\r\n" + 
				"        <style>\r\n" + 
				"            body {\r\n" + 
				"                margin: 0px;\r\n" + 
				"                padding: 0px;\r\n" + 
				"                text-align: center;\r\n" + 
				"            }\r\n" + 
				"            nav {\r\n" + 
				"                display:inline;\r\n" + 
				"            }\r\n" + 
				"        </style>\r\n" + 
				"    </head>\r\n" + 
				"    <body>\r\n" + 
				"        <nav>\r\n" + 
				"            <a href=\"/index/\">Home</a>\r\n" + 
				"            <a href=\"/list/\">List</a>\r\n" + 
				"            <a href=\"/article/\">Article</a>\r\n" + 
				"            <a href=\"/login/\">Login</a>\r\n" + 
				"            <a href=\"/register/\">Register</a>\r\n" + 
				"            <a href=\"/form/\">Form</a>\r\n" + 
				"            <a href=\"/address/\">Address</a>\r\n" + 
				"            <a href=\"/contact/\">Contact</a>\r\n" + 
				"        </nav>\r\n" + 
				"        <section>\r\n" + 
				"            <h3>Welcome Home!</h3>\r\n" + 
				"            <P>This is the home page, use the navigation at the top to browse through my menus.</P>\r\n" + 
				"        </section>\r\n" + 
				"    </body>\r\n" + 
				"</html>";
		//set headers and status code
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		//send response
		os.write(response.getBytes());
		//close request
		os.close();
	}
}