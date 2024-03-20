package com.octest.servlets1;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.octest.beans.Html;
import com.octest.beans.sql;
import java.sql.*;



/**
 * Servlet implementation class Firsttest
 */
public class Firsttest extends HttpServlet  {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Firsttest() {
        // TODO Auto-generated constructor stub
    }

	/**
	 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 this.getServletContext().getRequestDispatcher("/WEB-INF/morgen.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		sql main = new sql();
		
		
		boolean bool = main.insert(request);
		
		Html Html = new Html();
		
		String table = null;
		
		
		ResultSet rs = main.result();
		

		try {
			
		
			table = Html.generateTable(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("table", table);
		
		request.setAttribute("bool", bool);
		
		//doGet(request, response);
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}

}
