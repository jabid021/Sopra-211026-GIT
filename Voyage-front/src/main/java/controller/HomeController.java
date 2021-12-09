package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Admin;
import model.Client;
import model.Compte;
import util.Context;


@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Si on est deja connecté, on doit redirect sur les menus client/admin sinon sur l'index
		
		if(request.getSession().getAttribute("isConnected")=="y") 
		{
			if(request.getSession().getAttribute("typeCompte")=="admin") 
			{
				this.getServletContext().getRequestDispatcher("/WEB-INF/menuAdmin.jsp").forward(request, response);
			}
			else if(request.getSession().getAttribute("typeCompte")=="client") 
			{
				this.getServletContext().getRequestDispatcher("/WEB-INF/menuClient.jsp").forward(request, response);
			}
		}
		else {
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Compte connected = Context.getInstance().getDaoCompte().connect(login, password);
		if(connected instanceof Admin) 
		{
		
			request.getSession().setAttribute("isConnected", "y");
			request.getSession().setAttribute("typeCompte", "admin");
			request.getSession().setAttribute("login", login);
			this.getServletContext().getRequestDispatcher("/WEB-INF/menuAdmin.jsp").forward(request, response);
		}
		else if(connected instanceof Client) 
		{
			request.getSession().setAttribute("isConnected", "y");
			request.getSession().setAttribute("typeCompte", "client");
			request.getSession().setAttribute("login", login);
			this.getServletContext().getRequestDispatcher("/WEB-INF/menuClient.jsp").forward(request, response);
		}
		else if(connected == null) 
		{
			request.setAttribute("error", "identifiants invalides !");
			this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
		}
		
		
	}

}
