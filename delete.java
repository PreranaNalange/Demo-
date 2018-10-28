package com.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.City;


@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	City city=new City();
	BLManager bl=new BLManager();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ciid=Integer.parseInt(request.getParameter("ciid"));
		city=bl.searchCity(ciid);
		if(city!=null)
		{
			bl.deleteCity(city);
			
		}
		else
		{
			System.out.println("nullllllllllllllll");
		}
		response.sendRedirect("view.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
