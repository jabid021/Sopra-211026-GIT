package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Planete;
import model.Trajet;
import model.Vaisseau;
import util.Context;

@WebServlet("/ficheTrajet")
public class FicheTrajetController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Trajet trajet = Context.getInstance().getDaoTrajet().findById(id);
		List<Planete> planetes = Context.getInstance().getDaoPlanete().findAll();
		List<Vaisseau> vaisseaux = Context.getInstance().getDaoVaisseau().findAll();
		request.setAttribute("ft", trajet);
		request.setAttribute("planetes", planetes);
		request.setAttribute("vaisseaux", vaisseaux);

		this.getServletContext().getRequestDispatcher("/WEB-INF/ficheTrajet.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tache = request.getParameter("tache");
		LocalDate dateDepart = LocalDate.parse(request.getParameter("dateDepart"));
		LocalTime heureDepart = LocalTime.parse(request.getParameter("heureDepart"));
		int planeteDepart = Integer.parseInt(request.getParameter("planeteDepart"));
		int planeteArrivee = Integer.parseInt(request.getParameter("planeteArrivee"));
		int vaisseau = Integer.parseInt(request.getParameter("vaisseau"));

		Planete pDep = Context.getInstance().getDaoPlanete().findById(planeteDepart);
		Planete pArr = Context.getInstance().getDaoPlanete().findById(planeteArrivee);
		Vaisseau v = Context.getInstance().getDaoVaisseau().findById(vaisseau);
		Trajet t=null;

		if(tache.equals("insert")) 
		{
			t = new Trajet(dateDepart, heureDepart, pDep, pArr, v);
		}
		else if(tache.equals("update"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			t = new Trajet(id, dateDepart, heureDepart, pDep, pArr, v);
		}
		
		Context.getInstance().getDaoTrajet().save(t);
		response.sendRedirect("trajets");

	}

}
