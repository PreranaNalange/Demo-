package com.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Country;


@WebServlet("/InsertCountry")
public class InsertCountry extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
     Country country=new Country();  
     BLManager bl=new BLManager();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname=request.getParameter("cname");
		country.setCname(cname);
		bl.saveCountry(country);
		response.sendRedirect("Country.jsp");
	}

}
