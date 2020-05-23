package fr.lusseau.claude.bibliotheques.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.BibliothequeManager;
import fr.lusseau.claude.bibliotheques.bo.Bibliotheque;
import fr.lusseau.claude.bibliotheques.forms.InsertForm;

/**
 * Servlet implementation class ServletBibliotheque
 */
@WebServlet("/admin/gestionbibliotheque")
public class ServletGestionBibliotheque extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/admin/gestionBibliotheque.jsp";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recherche des bibliotheques
		listeBibliotheque(request);

		// Transfert de l'affichage à la JSP
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// insertion des bibliotheques en bases.
		insertBiblio(request);

		// Recherche des bibliotheques
		listeBibliotheque(request);

		// Transfert de l'affichage à la JSP
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * Methode en charge de lister toutes les bibliotheques.
	 * 
	 * @param request
	 */
	private void listeBibliotheque(HttpServletRequest request) {
		// Recherche des bibliotheques
		BibliothequeManager bibliothequeManager = new BibliothequeManager();
		List<Bibliotheque> bibliotheques = null;

		try {
			bibliotheques = bibliothequeManager.allBibliotheque();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("bibliotheques", bibliotheques);
	}

	/**
	 * Methode en charge de l'insertion des bibliotheques en bases.
	 * 
	 * @param request
	 */
	private void insertBiblio(HttpServletRequest request) {

		// insertion des bibliotheques en bases.

		InsertForm form = new InsertForm();
		form.validerBibliotheque(request);
		request.setAttribute("form", form);
	}
}
