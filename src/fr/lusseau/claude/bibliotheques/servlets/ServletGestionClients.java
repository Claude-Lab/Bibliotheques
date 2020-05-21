package fr.lusseau.claude.bibliotheques.servlets;

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
import fr.lusseau.claude.bibliotheques.bo.Cotisation;
import fr.lusseau.claude.bibliotheques.bo.Personne;
import fr.lusseau.claude.bibliotheques.forms.InsertForm;

/**
 * Servlet implementation class ServletListePersonnes
 */
@WebServlet("/gestionclient")
public class ServletGestionClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/admin/gestionClient.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recherche des personnes
		listeClients(request);

		// Recherche Caution
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
		
		// exportation de la validation du forulaire
		insertClients(request);

		// Recherche des personnes
		listeClients(request);

		// Recherche Caution
		listeCautions(request);
		// Transfert de l'affichage à la JSP
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * Methode en charge de l'exportation de l'insertion des clients vers la classe InserClientForm.
	 * @param request
	 */
	private void insertClients(HttpServletRequest request) {
		InsertForm form = new InsertForm();
		form.validerClient(request);
		
		// retour de validation du formulaire
		request.setAttribute("form", form);
	}

	/**
	 * Methode en charge de lister les clients.
	 * 
	 * @param request
	 */
	private void listeClients(HttpServletRequest request) {
		PersonneManager manager = new PersonneManager();
		List<Personne> clients = null;

		try {

			clients = manager.allClients();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("clients", clients);
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
