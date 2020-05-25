package fr.lusseau.claude.bibliotheques.servlets.listes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.LivreManager;
import fr.lusseau.claude.bibliotheques.bo.Livre;

/**
 * Servlet implementation class ServletLivres.
 */
@WebServlet("/admin/listelivre")
public class ServletListeLivres extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/admin/listes/listeLivre.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		listeLivres();

		// Transfert de l'affichage à la JSP
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * Methode en charge de lister les livres.
	 */
	private void listeLivres() {
		// Recherche des livres
		LivreManager manager = new LivreManager();
		List<Livre> values = null;

		try {
			values = manager.allLivre();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.getServletContext().setAttribute("listeLivres", values);
	}
}
