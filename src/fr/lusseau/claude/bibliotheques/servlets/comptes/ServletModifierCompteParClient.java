package fr.lusseau.claude.bibliotheques.servlets.comptes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.lusseau.claude.bibliotheques.forms.UpdateForm;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/client/modifiercompte")
public class ServletModifierCompteParClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/client/modifierCompte.jsp";
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		// exportation de la l'update par forulaire.
		updateClient(request);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/client/compte.jsp").forward(request, response);
	}

	/**
	 * Methode en charge de l'exportation de l'insert des salariés vers la classe InsertForm
	 * InserClientForm.
	 * 
	 * @param request
	 */
	private void updateClient(HttpServletRequest request) {
		
		
		UpdateForm form = new UpdateForm();
		form.validerPersonne(request);

		request.setAttribute("form", form);
	}
}
