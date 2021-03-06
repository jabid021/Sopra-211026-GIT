package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import util.Context;


@WebServlet("/inscription")
public class InscriptionController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/creerCompte.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("id");
		String password=request.getParameter("mdp");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		
		Client c = new Client(login,password,nom,prenom);
		Context.getInstance().getDaoCompte().save(c);
		
		response.sendRedirect("home");
	}

}
