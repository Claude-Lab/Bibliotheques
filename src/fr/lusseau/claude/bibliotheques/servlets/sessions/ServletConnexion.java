package fr.lusseau.claude.bibliotheques.servlets.sessions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.PersonneManager;
import fr.lusseau.claude.bibliotheques.bo.Personne;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/public/connexion.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		connexion(request, response);

	}

	/**
	 * Methode en charge de la connexion des personnes.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void connexion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mail_Personne = request.getParameter("mail_Personne");
		String motDePasse_Personne = request.getParameter("motDePasse_Personne");

		PersonneManager manager = new PersonneManager();

		Personne sessionPersonne = null;
		try {
			sessionPersonne = manager.connexionPersonne(mail_Personne, motDePasse_Personne);

			if (sessionPersonne != null) {
				HttpSession session = request.getSession();
				
				if ("SALARIE".equals(sessionPersonne.getType_Personne()))  {

					session.setAttribute("sessionPersonne", sessionPersonne);
					response.sendRedirect(request.getContextPath() + "/admin/accueil");

				}
				if ("CLIENT".equals(sessionPersonne.getType_Personne())) {
					session.setAttribute("sessionPersonne", sessionPersonne);
					response.sendRedirect(request.getContextPath() + "/client/accueil");
				}

			} else {
				String message = "Mail ou mot de passe invalide !";
				request.setAttribute("message", message);
				response.sendRedirect(request.getContextPath() + "/");
			}

		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}