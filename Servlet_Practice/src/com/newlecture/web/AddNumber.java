package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddNumber")
public class AddNumber extends HttpServlet {
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
    	resp.setContentType("text/html; charset=UTF-8");
    	int firstNum = Integer.parseInt(req.getParameter("firstNum"));
    	int secondNum = Integer.parseInt(req.getParameter("secondNum"));
    	
    	int add = firstNum + secondNum;
    	PrintWriter out = resp.getWriter();
    	out.println("µ¡¼À °á°ú : "+ add);
    	
	}

}
