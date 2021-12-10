package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vaisseau;
import util.Context;

@WebServlet("/vaisseau")
public class VaisseauController extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Vaisseau> vaisseau = Context.getInstance().getDaoVaisseau().findAll();
	
		request.setAttribute("vaisseau", vaisseau);
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/vaisseau.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tache = request.getParameter("tache");
		String nom = request.getParameter("Nom");
		double vitesse = Double.parseDouble(request.getParameter("Vitesse"));
		int capacite = Integer.parseInt(request.getParameter("Capacite"));
		double distance = Double.parseDouble(request.getParameter("Distance"));

		Vaisseau p=null;
		if(tache.equals("insert")) 
		{
			p = new Vaisseau(nom,vitesse,capacite,distance);

		}
		else if(tache.equals("update"))
		{
			int id = Integer.parseInt(request.getParameter("id"));

			p = new Vaisseau(id,nom,vitesse,capacite,distance);
		}
		
		Context.getInstance().getDaoVaisseau().save(p);
		
		response.sendRedirect("vaisseau");

		
	}

}
