package fr.lusseau.claude.bibliotheques.servlets.comptes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.CotisationManager;
import fr.lusseau.claude.bibliotheques.bll.PersonneManager;
import fr.lusseau.claude.bibliotheques.bll.RoleManager;
import fr.lusseau.claude.bibliotheques.bo.Cotisation;
import fr.lusseau.claude.bibliotheques.bo.Personne;
import fr.lusseau.claude.bibliotheques.bo.Role;
import fr.lusseau.claude.bibliotheques.forms.UpdateForm;

/**
 * Servlet implementation class ServletModifierPersonne
 */
@WebServlet("/admin/modifierpersonne")
public class ServletModifierPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/jsp/admin/gestions/modifierpersonne.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		selectPersonne(request);
		
		listeRoles(request);

		listeCautions(request);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		updatePersonne(request);
		doGet(request, response);
	}

	/**
	 * Methode en charge de l'exportation de l'insert des salariés vers la classe
	 * InsertForm InserClientForm.
	 * 
	 * @param request
	 */
	private void updatePersonne(HttpServletRequest request) {
		UpdateForm form = new UpdateForm();
		form.validerPersonne(request);

		request.setAttribute("form", form);
	}
	
	/**
	 * Methode en charge de lister les roles.
	 * 
	 * @param request
	 */
	private void listeRoles(HttpServletRequest request) {
		RoleManager manager = new RoleManager();
		List<Role> roles = null;

		try {
			roles = manager.allRole();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("roles", roles);
	}

	/**
	 * Methode en charge de lister les salariés.
	 * 
	 * @param request
	 */
	private void selectPersonne(HttpServletRequest request) {
		int id_Personne = Integer.parseInt(request.getParameter("id_Personne"));
		PersonneManager manager = new PersonneManager();
		Personne personne = null;
		
		try {
			personne = manager.selectById(id_Personne);
		} catch (BLLException e) {
			e.printStackTrace();
		}

		request.setAttribute("personne", personne);
	}
	
	/**
	 * Methode en charge de lister les cotisations.
	 * 
	 * @param request
	 */
	private void listeCautions(HttpServletRequest request) {
		CotisationManager manager = new CotisationManager();
		List<Cotisation> cautions = null;

		try {
			cautions = manager.allCotisation();
		} catch (BLLException e) {
			e.printStackTrace();
		}

		request.setAttribute("cautions", cautions);
	}
}
