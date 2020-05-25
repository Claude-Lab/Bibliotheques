package fr.lusseau.claude.bibliotheques.servlets.gestion;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.EtatManager;
import fr.lusseau.claude.bibliotheques.bo.Etat;
import fr.lusseau.claude.bibliotheques.forms.InsertForm;

/**
 * Servlet implementation class ServlztAfficherRole
 */
@WebServlet("/admin/gestionetat")
public class ServletGestionEtat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String VUE = "/WEB-INF/jsp/admin/gestions/gestionEtat.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recherche des Role
		listeEtats(request);
	

	// Transfert de l'affichage à la JSP
	this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		insertEtat(request);
		
		listeEtats(request);

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	/**
	 * Methode en charge de l'exportation de l'insert des salariés vers la classe InsertForm
	 * InserClientForm.
	 * 
	 * @param request
	 */
	private void insertEtat(HttpServletRequest request) {
		InsertForm form = new InsertForm();
		form.validerEtat(request);
		request.setAttribute("form", form);
	}
	
	/**
	 * Methode en charge de lister les roles.
	 * 
	 * @param request
	 */
	private void listeEtats(HttpServletRequest request) {
		EtatManager manager = new EtatManager();
		List<Etat> value = null;

		try {
			value = manager.allEtat();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("etats", value);
	}

}
