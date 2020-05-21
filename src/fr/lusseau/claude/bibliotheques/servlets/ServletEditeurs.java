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

/**
 * Servlet implementation class ServletAfficherCotisations
 */
@WebServlet("/listeediteur")
public class ServletEditeurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/public/listes/listeEditeur.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		listeEditeurs(request);
		
		// Transfert de l'affichage à la JSP
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Methode en charge de récuperer pour affichage la liste des cotisations.
	 * @param request
	 */
	private void listeEditeurs(HttpServletRequest request) {
		EditeurManager manager = new EditeurManager();
		List<Editeur> values = null;

		try {
			values = manager.allEditeur();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("cotisations", values);
	}

}
