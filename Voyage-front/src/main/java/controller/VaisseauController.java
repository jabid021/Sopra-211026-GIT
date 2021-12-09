package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vaisseau;
import model.Compte;
import model.Passager;
import util.Context;

@WebServlet("/vaisseau")
public class VaisseauController extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Vaisseau> vaisseau = Context.getInstance().getDaoVaisseau().findAll();
		//pas de Join ?
		//List<Passager> passagers = Context.getInstance().getDaoPassager().findAll();
		request.setAttribute("vaisseau", vaisseau);
		
		//pas de Join ?
		//request.setAttribute("passagers", passagers);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/vaisseau.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tache = request.getParameter("tache");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int client = Integer.parseInt(request.getParameter("client"));
		Client c = (Client) Context.getInstance().getDaoCompte().findById(client);
		Passager p=null;
		if(tache.equals("insert")) 
		{
			 p = new Passager(nom,prenom,c);
		}
		else if(tache.equals("update"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			 p = new Passager(id,nom,prenom,c);
		}
		Context.getInstance().getDaoPassager().save(p);
		
		response.sendRedirect("passagers");
		
	}

}
