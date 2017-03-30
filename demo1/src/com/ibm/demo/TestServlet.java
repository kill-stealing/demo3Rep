package com.ibm.demo;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="TestServlet",urlPatterns="/test",loadOnStartup=100)
public class TestServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		String param1 = request.getParameter("param1");//user_id
		String param2=request.getParameter("param2");//topic_id
		response.setContentType("text/plain;");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().println("{\"name\":\""+param1+"\",\"type\":\""+param2+"\"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
