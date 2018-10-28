package com.contoller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.City;
import com.pojo.Country;
import com.pojo.State;


@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Country country=new Country();
	State state=new State();
	City city=new City();
	BLManager bl=new BLManager();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ciid=Integer.parseInt(request.getParameter("ciid"));
		city=bl.searchCity(ciid);
		if(city!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("city", city);
			
		}
		else
		{
			System.out.println("nullllllllllllllll");
		}
		response.sendRedirect("updateform.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		int ciid=Integer.parseInt(request.getParameter("ciid"));
		String ciname=request.getParameter("ciname");
		String sname=request.getParameter("sname");
		String cname=request.getParameter("cname");
		country=bl.searchCountry(cname);
		state=bl.searchState(sname);
		if(country!=null&&state!=null)
		{
		city.setCiid(ciid);
		city.setCiname(ciname);
		country.setCname(cname);
		state.setSname(sname);
		state.setCountry(country);
		city.setState(state);
		bl.updateData(city);
		}
		else
		{
			pw.println("Wrong country or state......");
		}
		response.sendRedirect("view.jsp");
	}

}
