package fr.lusseau.claude.bibliotheques.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.CotisationManager;
import fr.lusseau.claude.bibliotheques.bo.Cotisation;
import fr.lusseau.claude.bibliotheques.forms.InsertForm;

/**
 * Servlet implementation class ServletAfficherCotisations
 */
@WebServlet("/admin/gestioncotisation")
public class ServletGestionCotisations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/admin/gestionCotisation.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		listeCotisation(request);

		// Transfert de l'affichage à la JSP
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		insertCotisation(request);
		
		listeCotisation(request);
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * Methode en charge de l'insertion des Cotisations en bases.
	 * @param request
	 */
	private void insertCotisation(HttpServletRequest request) {
		
		InsertForm form = new InsertForm();
		form.validerCotisation(request);
		request.setAttribute("form", form);
	}

	/**
	 * Methode en charge de récuperer pour affichage la liste des cotisations.
	 * @param request
	 */
	private void listeCotisation(HttpServletRequest request) {
		CotisationManager cotisationManager = new CotisationManager();
		List<Cotisation> cotisations = null;

		try {
			cotisations = cotisationManager.allCotisation();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("cotisations", cotisations);
	}
	
	

}
