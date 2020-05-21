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
import fr.lusseau.claude.bibliotheques.forms.InsertForm;

/**
 * Servlet implementation class ServlztAfficherRole
 */
@WebServlet("/gestionrole")
public class ServletGestionRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/admin/gestionRole.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recherche des Role
		listeRoles(request);
	

	// Transfert de l'affichage à la JSP
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		insertRole(request);
		
		listeRoles(request);

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	/**
	 * Methode en charge de l'exportation de l'insert des salariés vers la classe InsertForm
	 * InserClientForm.
	 * 
	 * @param request
	 */
	private void insertRole(HttpServletRequest request) {
		InsertForm form = new InsertForm();
		form.validerRole(request);
		request.setAttribute("form", form);
	}
	
	/**
	 * Methode en charge de lister les roles.
	 * 
	 * @param request
	 */
	private void listeRoles(HttpServletRequest request) {
		RoleManager manager = new RoleManager();
		List<Role> value = null;

		try {
			value = manager.allRole();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("roles", value);
	}

}
