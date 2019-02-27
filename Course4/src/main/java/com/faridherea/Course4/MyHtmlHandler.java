package com.faridherea.Course4;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
@SuppressWarnings("restriction")
public class MyHtmlHandler implements HttpHandler{
	public void handle(HttpExchange t) throws IOException{
		//set the response as a string containing html code
		String response = "<html><body><h1>Response from '/html' servlet</h1><br><br><span>Some text added just as an example</span></body></html>";
		//set headers and status code
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		//send response
		os.write(response.getBytes());
		//close request
		os.close();
	}
}