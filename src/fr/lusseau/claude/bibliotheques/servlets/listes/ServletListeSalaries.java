package fr.lusseau.claude.bibliotheques.servlets.listes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.PersonneManager;
import fr.lusseau.claude.bibliotheques.bo.Personne;

/**
 * Servlet implementation class ServletListePersonnes
 */
@WebServlet("/admin/listesalarie")
public class ServletListeSalaries extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/admin/listes/listeSalarie.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		listeSalaries(request);

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
	 * Methode en charge de lister les salariés.
	 * 
	 * @param request
	 */
	private void listeSalaries(HttpServletRequest request) {
		PersonneManager manager = new PersonneManager();
		List<Personne> values = null;

		try {

			values = manager.allSalaries();
		} catch (BLLException e) {
			e.printStackTrace();
		}

		request.setAttribute("personnes", values);
	}

}
