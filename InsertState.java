package com.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.BLManager;
import com.pojo.Country;
import com.pojo.State;


@WebServlet("/InsertState")
public class InsertState extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Country country=new Country();  
    BLManager bl=new BLManager();
    State state=new State();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cname=request.getParameter("cname");
		String sname=request.getParameter("sname");
		PrintWriter pw=response.getWriter();
		country=bl.searchCountry(cname);
		if(country!=null)
		{
			state.setSname(sname);
			state.setCountry(country);
			bl.saveState(state);
			response.sendRedirect("State.jsp");
		}
		else
		{
			pw.println("Incorrect Country....");
			response.sendRedirect("State.jsp");
			
		}
	}

}
