package fr.lusseau.claude.bibliotheques.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lusseau.claude.bibliotheques.forms.DeletebyId;

/**
 * Servlet implementation class SupprimerCotisation
 */
@WebServlet("/admin/supprimer")
public class ServletSuppression extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if ((request.getParameter("id_Personne") != null) && (request.getParameter("type_Personne") != null)) {
			// exportation de la suppression par forulaire
			DeletebyId delete = new DeletebyId();
			delete.supprimerPersonne(request);
			RequestDispatcher rd = request.getRequestDispatcher("gestionsalarie");
			rd.forward(request, response);

			// Condition de redirection après suppression.
			//redirectionPersonne(request, response);
		}

		if (request.getParameter("id_Cotisation") != null) {
			// exportation de la suppression par forulaire
			DeletebyId delete = new DeletebyId();
			delete.supprimerCotisation(request);
			request.setAttribute("delete", delete);
			RequestDispatcher rd = request.getRequestDispatcher("gestioncotisation");
			rd.forward(request, response);
		}
		
		if (request.getParameter("id_Bibliotheque") != null) {
			// exportation de la suppression par forulaire
			DeletebyId delete = new DeletebyId();
			delete.supprimerBibliotheque(request);

			RequestDispatcher rd = request.getRequestDispatcher("gestionbibliotheque");
			rd.forward(request, response);
		}
		
		if (request.getParameter("id_Role") != null) {
			// exportation de la suppression par forulaire
			DeletebyId delete = new DeletebyId();
			delete.supprimerRole(request);

			RequestDispatcher rd = request.getRequestDispatcher("gestionrole");
			rd.forward(request, response);
		}
		
		if (request.getParameter("id_Auteur") != null) {
			// exportation de la suppression par forulaire
			DeletebyId delete = new DeletebyId();
			delete.supprimerAuteur(request);

			RequestDispatcher rd = request.getRequestDispatcher("gestionauteur");
			rd.forward(request, response);
		}
		
		if (request.getParameter("id_Livre") != null) {
			// exportation de la suppression par forulaire
			DeletebyId delete = new DeletebyId();
			delete.supprimerLivre(request);

			RequestDispatcher rd = request.getRequestDispatcher("gestionlivre");
			rd.forward(request, response);
		}
		
		if (request.getParameter("id_Emprunt") != null) {
			// exportation de la suppression par forulaire
			DeletebyId delete = new DeletebyId();
			delete.supprimerEmprunt(request);

			RequestDispatcher rd = request.getRequestDispatcher("gestionemprunt");
			rd.forward(request, response);
		}
		
		if (request.getParameter("id_Etat") != null) {
			// exportation de la suppression par forulaire
			DeletebyId delete = new DeletebyId();
			delete.supprimerEtat(request);

			RequestDispatcher rd = request.getRequestDispatcher("gestionetat");
			rd.forward(request, response);
		}
		
		if (request.getParameter("id_Editeur") != null) {
			// exportation de la suppression par forulaire
			DeletebyId delete = new DeletebyId();
			delete.supprimerEditeur(request);

			RequestDispatcher rd = request.getRequestDispatcher("gestionediteur");
			rd.forward(request, response);
		}

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
	 * Methode en charge de rediriger après suppression en fonction du type de
	 * personne.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void redirectionPersonne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			if ("SALARIE".equals(request.getParameter("type_Personne").trim())) {
				RequestDispatcher rd = request.getRequestDispatcher("/gestionsalarie");
				rd.forward(request, response);
			}
			if ("CLIENT".equals(request.getParameter("type_Personne").trim())) {
				RequestDispatcher rd = request.getRequestDispatcher("/gestionclient");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
