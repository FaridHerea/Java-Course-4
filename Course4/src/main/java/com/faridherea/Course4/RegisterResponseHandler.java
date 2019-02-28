package com.faridherea.Course4;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class RegisterResponseHandler implements HttpHandler {
	public void handle(HttpExchange t) throws IOException{
		String firstName = Globals.getUriValue(t, "firstName");
		String lastName = Globals.getUriValue(t, "lastName");
		String username = Globals.getUriValue(t, "username");
		String password = Globals.getUriValue(t, "password");
		String age = Globals.getUriValue(t, "age");
		String email = Globals.getUriValue(t, "email");
		if(firstName!=null && lastName!=null && username!=null && password!=null && age!=null && email!=null) {
			try {
				DBConnection.InsertExample(username, lastName, "client");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//set the response as a string containg html code
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
					"            section{\r\n" + 
					"                margin:0 20%;\r\n" + 
					"            }\r\n" + 
					"            fieldset{\r\n" + 
					"                padding:10px 5%;\r\n" + 
					"            }\r\n" + 
					"            .input{\r\n" + 
					"                text-align:left;\r\n" + 
					"            }\r\n" + 
					"            input{\r\n" + 
					"                margin:1px;\r\n" + 
					"            }\r\n" + 
					"        </style>\r\n" + 
					"    </head>\r\n" + 
					"    <body>\r\n" + 
					"        <nav>\r\n" + 
					"            <a href=\"/index/\">Home</a> |\r\n" + 
					"            <a href=\"/list/\">List</a> |\r\n" + 
					"            <a href=\"/article/\">Article</a> |\r\n" + 
					"            <a href=\"/login/\">Login</a> |\r\n" + 
					"            <a href=\"/register/\">Register</a> |\r\n" + 
					"            <a href=\"/form/\">Form</a> |\r\n" + 
					"            <a href=\"/address/\">Address</a> |\r\n" + 
					"            <a href=\"/contact/\">Contact</a>\r\n" + 
					"        </nav>\r\n" + 
					"        <section>\r\n" + 
					"                <fieldset>\r\n" + 
					"                    <legend>Registration Successful!</legend>\r\n" + 
					"                    Go to login page:" +
					"                    <input onclick=\"window.location.href = '/login/';\" type=\"button\" value=\"Login\">\r\n" + 
					"                </fieldset>\r\n" + 
					"        </section>\r\n" + 
					"    </body>\r\n" + 
					"</html>";
			//set headers and status code
			t.sendResponseHeaders(200,response.length());
			OutputStream os = t.getResponseBody();
			//send response
			os.write(response.getBytes());
			//close request
			os.close();
		} else {
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
					"            section{\r\n" + 
					"                margin:0 20%;\r\n" + 
					"            }\r\n" + 
					"            fieldset{\r\n" + 
					"                padding:10px 5%;\r\n" + 
					"            }\r\n" + 
					"            .input{\r\n" + 
					"                text-align:left;\r\n" + 
					"            }\r\n" + 
					"            input{\r\n" + 
					"                margin:1px;\r\n" + 
					"            }\r\n" + 
					"        </style>\r\n" + 
					"    </head>\r\n" + 
					"    <body>\r\n" + 
					"        <nav>\r\n" + 
					"            <a href=\"/index/\">Home</a> |\r\n" + 
					"            <a href=\"/list/\">List</a> |\r\n" + 
					"            <a href=\"/article/\">Article</a> |\r\n" + 
					"            <a href=\"/login/\">Login</a> |\r\n" + 
					"            <a href=\"/register/\">Register</a> |\r\n" + 
					"            <a href=\"/form/\">Form</a> |\r\n" + 
					"            <a href=\"/address/\">Address</a> |\r\n" + 
					"            <a href=\"/contact/\">Contact</a>\r\n" + 
					"        </nav>\r\n" + 
					"        <section>\r\n" + 
					"                <fieldset>\r\n" + 
					"                    <legend>Registration Unsuccessful!</legend>\r\n" + 
					"                    You need to complete all the fields. Head back to registration!" +
					"                    <input onclick=\"window.location.href = '/register/';\" type=\"button\" value=\"Register\">\r\n" + 
					"                </fieldset>\r\n" + 
					"        </section>\r\n" + 
					"    </body>\r\n" + 
					"</html>";
			//set headers and status code
			t.sendResponseHeaders(200,response.length());
			OutputStream os = t.getResponseBody();
			//send response
			os.write(response.getBytes());
			//close request
			os.close();
		}
	}
}
