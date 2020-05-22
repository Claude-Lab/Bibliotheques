package fr.lusseau.claude.bibliotheques.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.PersonneManager;

/**
 * Servlet implementation class ServletAcceuilAdmin
 */
@WebServlet("/acceuiladmin")
public class ServletAcceuilAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/admin/acceuilAdmin.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		nbrPersonne(request);
	

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		nbrPersonne(request);

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * Methode en charge de compter le nombre de personne dans la base.
	 * 
	 * @param request
	 */
	private int nbrPersonne(HttpServletRequest request) {
		PersonneManager manager = new PersonneManager();
		int value = 0;
		try {
			value = manager.compterPerson();
			request.getAttribute("value");
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		return value;
	}
}
