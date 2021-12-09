package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import model.Compte;
import model.Passager;
import util.Context;

@WebServlet("/passagers")
public class PassagerController extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Compte> comptes = Context.getInstance().getDaoCompte().findAll();
		List<Passager> passagers = Context.getInstance().getDaoPassager().findAll();
		request.setAttribute("comptes", comptes);
		request.setAttribute("passagers", passagers);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/passagers.jsp").forward(request, response);

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
		
		doGet(request, response);
		
	}

}
