package fr.lusseau.claude.bibliotheques.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.RoleManager;
import fr.lusseau.claude.bibliotheques.bo.Role;

/**
 * Servlet implementation class ServlztAfficherRole
 */
@WebServlet("/listerole")
public class ServletRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String VUE = "/WEB-INF/jsp/public/listes/listeRole.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response).
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recherche des Role
		listeRoles(request);
	

	// Transfert de l'affichage à la JSP.
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	/**
	 * Methode en charge de lister les roles.
	 * 
	 * @param request
	 */
	private void listeRoles(HttpServletRequest request) {
		RoleManager manager = new RoleManager();
		List<Role> values = null;

		try {
			values = manager.allRole();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("roles", values);
	}

}
