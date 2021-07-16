package com.File_Manipulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/changeFile")
public class FileManipulatorServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		String message; 
		String filePath = req.getParameter("filePath");
		System.out.println(filePath);
	
		// Check if the file ends with .txt and if is not send message to the user
		if(!filePath.endsWith(".txt")) {  
			message = "File must ends with \".txt\"";
    		req.setAttribute("message", message);
    		req.getRequestDispatcher("/index.jsp").forward(req, res);
		}
		
		MyFile file = null;
		
		try {
			file =  new MyFile(filePath);			
		} catch(Exception e) {
			message = "File not found.";
    		req.setAttribute("message", message);
    		req.getRequestDispatcher("/index.jsp").forward(req, res);
		}
		
		// Collect the data from the page
		 String radio = req.getParameter("change");
		 System.out.println(radio);
		 
		 int line1 = Integer.parseInt(req.getParameter("line1"));
	   	 int line2 = Integer.parseInt(req.getParameter("line2"));
		 
	   	 int word1Position = 0;   
	   	 int word2Position = 0;
		    
		  // Check what button user selected
		    	if(radio.equalsIgnoreCase("swapLines")) {
		    		
		    		// Try to swap lines/rows and print message(File after the change) on the web page
		    		// If swapping the lines was unsuccessful catch the error and print it
		    		try {
			    		file.swapLines(line1, line2);
		    		} catch(CustomException e) {
		    			message = e.getMessage();
		    			req.setAttribute("message", message);
			    		System.out.println(message);
			    		req.getRequestDispatcher("/index.jsp").forward(req, res);
		    		}
		    		
		    		message = file.printFile();
		    		req.setAttribute("message", message);
		    		System.out.println(message);
		    		req.getRequestDispatcher("/index.jsp").forward(req, res);
		    	
		    	// Almost same as above, this time tries to swap words
		    	// Again user will receive message according to the outcomes 
		    	} else if(radio.equalsIgnoreCase("swapWords")){
		    		
		    	  word1Position = Integer.parseInt(req.getParameter("word1"));
		   		  word2Position = Integer.parseInt(req.getParameter("word2"));

		   		  try {
		   			 file.swapWords(line1, line2, word1Position, word2Position);
		   			 
		   		  } catch(CustomException e) {
		    			message = e.getMessage();
		    			req.setAttribute("message", message);
			    		System.out.println(message);
			    		req.getRequestDispatcher("/index.jsp").forward(req, res);
		    		}
		   		 
		   		  	message = file.printFile();
		    		System.out.println(message);
		    		req.setAttribute("message", message);
		    		req.getRequestDispatcher("/index.jsp").forward(req, res);
		    
		    	} 

	}
}