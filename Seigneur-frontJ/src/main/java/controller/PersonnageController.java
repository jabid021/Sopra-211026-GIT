package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Personnage;
import model.Race;
import util.Context;

@WebServlet("/personnage")
public class PersonnageController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("on entre en get ");
		
		int id=(request.getParameter("id")!=null)?Integer.parseInt(request.getParameter("id")):1;
		Personnage p = Context.getInstance().getDaoP().findById(id);
		
		request.setAttribute("monPerso", p);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/personnage.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("On entre en post ! ");
		String nom=request.getParameter("nom");
		int pv=Integer.parseInt(request.getParameter("pv"));
		Race race = Race.valueOf(request.getParameter("race"));
		boolean vivant=(request.getParameter("vivant")!=null) ? true : false;
		//LocalTime lt = LocalTime.parse(request.getParameter("time"));
		//LocalDate ld = LocalDate.parse(request.getParameter("date"));
		
		Personnage p = new Personnage(nom,pv,race,vivant);
		p=Context.getInstance().getDaoP().save(p);
		System.out.println(p);
		
		response.sendRedirect("personnage?id="+p.getId());
		
	}
	
	
	
	

}
