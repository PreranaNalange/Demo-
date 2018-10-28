package com.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.City;
import com.pojo.State;


@WebServlet("/InsertCity")
public class InsertCity extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	BLManager bl=new BLManager();
    State state=new State();
    City city=new City();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ciname=request.getParameter("ciname");
		String sname=request.getParameter("sname");
		PrintWriter pw=response.getWriter();
		state=bl.searchState(sname);
		if(state!=null)
		{
			city.setCiname(ciname);
			city.setState(state);
			bl.saveCity(city);
			response.sendRedirect("city.jsp");
		}
		else
		{
			pw.println("Incorrect State....");
			response.sendRedirect("city.jsp");
			
		}
	}

}
