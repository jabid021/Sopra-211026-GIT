package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coordonnees;
import model.Passager;
import model.Planete;
import model.TypePlanete;
import util.Context;

@WebServlet("/planetes")
public class PlaneteController extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Planete> planetes = Context.getInstance().getDaoPlanete().findAll();
		request.setAttribute("planetes", planetes);
		this.getServletContext().getRequestDispatcher("/WEB-INF/planete.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tache = request.getParameter("tache");
		String nom = request.getParameter("nom");
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = Integer.parseInt(request.getParameter("z"));
		TypePlanete type_planete = TypePlanete.valueOf(request.getParameter("type"));
		String description = request.getParameter("description");
		String img = (request.getParameter("image")!="")?request.getParameter("image"):null;
		
		Coordonnees coordonnees = new Coordonnees(x,y,z);
		
		
		Planete p = null;
		if(tache.equals("insert")) 
		{
			 p = new Planete(nom,type_planete,coordonnees);
			 p.setDescription(description);
			 p.setImg(img);
		}
		else if(tache.equals("update"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			 p = new Planete(id,nom,type_planete,coordonnees);
			 p.setDescription(description);
			 p.setImg(img);
		}
		Context.getInstance().getDaoPlanete().save(p);
		
		response.sendRedirect("planetes");
	}

}
