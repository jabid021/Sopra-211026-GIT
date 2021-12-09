package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Planete;
import util.Context;

@WebServlet("/catalogue")
public class CatalogueController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			List<Planete> planetes = Context.getInstance().getDaoPlanete().findAll();
			request.setAttribute("planetes", planetes);
			this.getServletContext().getRequestDispatcher("/WEB-INF/catalogue.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
