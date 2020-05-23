package fr.lusseau.claude.bibliotheques.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.PersonneManager;

/**
 * Servlet implementation class ServletAcceuilAdmin
 */
@WebServlet("/client/accueil")
public class ServletAccueilClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/client/accueil.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		nbrPersonne(request);
	

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
	 * Methode en charge de compter le nombre de personne dans la base.
	 * 
	 * @param request
	 */
	private void nbrPersonne(HttpServletRequest request) {
		PersonneManager manager = new PersonneManager();
		int value = 0;
		try {
			value = manager.compterPerson();
			request.getAttribute("value");
		} catch (BLLException e) {
			e.printStackTrace();
		}
		request.setAttribute("value", value);
		
	}
}
