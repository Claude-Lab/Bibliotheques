package fr.lusseau.claude.bibliotheques.servlets.gestion;

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
import fr.lusseau.claude.bibliotheques.forms.InsertForm;

/**
 * Servlet implementation class ServletListePersonnes
 */
@WebServlet("/admin/gestionsalarie")
public class ServletGestionSalaries extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/admin/gestions/gestionSalarie.jsp";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		listeSalaries(request);

		listeRoles(request);
		
		listeCautions(request);

		// Transfert de l'affichage à la JSP
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// exportation de la l'insertion salarié par forulaire
		insertSalaries(request);

		// Recherche des personnes
		listeSalaries(request);

		// Recherche des roles
		listeRoles(request);
		// Recherche des cautions
		listeCautions(request);
		// Recherche de mail identique
//		checkMail(request);

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * Methode en charge de l'exportation de l'insert des salariés vers la classe InsertForm
	 * InserClientForm.
	 * 
	 * @param request
	 */
	private void insertSalaries(HttpServletRequest request) {
		InsertForm form = new InsertForm();
		form.validerSalarie(request);

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
	private void listeSalaries(HttpServletRequest request) {
		PersonneManager manager = new PersonneManager();
		List<Personne> salaries = null;

		try {

			salaries = manager.allSalaries();
		} catch (BLLException e) {
			e.printStackTrace();
		}

		request.setAttribute("salaries", salaries);
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
