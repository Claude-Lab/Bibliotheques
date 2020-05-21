package fr.lusseau.claude.bibliotheques.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.EditeurManager;
import fr.lusseau.claude.bibliotheques.bo.Editeur;
import fr.lusseau.claude.bibliotheques.forms.InsertForm;

/**
 * Servlet implementation class ServletBibliotheque
 */
@WebServlet("/gestionediteur")
public class ServletGestionEditeur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/admin/gestionEditeur.jsp";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recherche des bibliotheques
		listeEditeur(request);

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
		insertEditeur(request);

		// Recherche des bibliotheques
		listeEditeur(request);

		// Transfert de l'affichage à la JSP
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * Methode en charge de lister toutes les bibliotheques.
	 * 
	 * @param request
	 */
	private void listeEditeur(HttpServletRequest request) {
		// Recherche des bibliotheques
		EditeurManager manager = new EditeurManager();
		List<Editeur> values = null;

		try {
			values = manager.allEditeur();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("bibliotheques", values);
	}

	/**
	 * Methode en charge de l'insertion des bibliotheques en bases.
	 * 
	 * @param request
	 */
	private void insertEditeur(HttpServletRequest request) {

		// insertion des bibliotheques en bases.

		InsertForm form = new InsertForm();
		form.validerEditeur(request);
		request.setAttribute("form", form);
	}
}
