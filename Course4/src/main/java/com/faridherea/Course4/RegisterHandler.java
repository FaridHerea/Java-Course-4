package com.faridherea.Course4;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
@SuppressWarnings("restriction")
public class RegisterHandler implements HttpHandler{
	public void handle(HttpExchange t) throws IOException{
		System.out.println(t.getRequestURI().getQuery());
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
				"            <form action=\"/registerResponse/\" method=\"GET\">\r\n" + 
				"                <fieldset>\r\n" + 
				"                    <legend>Register:</legend>\r\n" + 
				"                    <div class=\"input\">\r\n" + 
				"                        First Name: <input type=\"text\" name=\"firstName\" placeholder=\"Type your first name\" size=\"120\" maxlength=\"40\"><br>\r\n" + 
				"                        Last Name: <input type=\"text\" name=\"lastName\" placeholder=\"Type your last name\" size=\"120\" maxlength=\"40\"><br>\r\n" + 
				"                        Username: <input type=\"text\" name=\"username\" placeholder=\"Type your username\" size=\"120\" maxlength=\"40\"><br>\r\n" + 
				"                        Password: <input type=\"password\" name=\"password\" placeholder=\"Type your password\" size=\"120\" maxlength=\"40\"><br>\r\n" + 
				"                        Age: <input type=\"number\" name=\"age\" placeholder=\"Type your age\" size=\"120\" maxlength=\"2\"><br>\r\n" + 
				"                        Email: <input type=\"text\" name=\"email\" placeholder=\"Type your email address\" size=\"120\" maxlength=\"200\"><br>\r\n" + 
				"                    </div>\r\n" + 
				"                    <input onclick=\"window.location.href = 'localhost:8001/registerResponse/';\" type=\"submit\" value=\"Register\">\r\n" + 
				"                </fieldset>\r\n" + 
				"            </form>\r\n" + 
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
