package fr.lusseau.claude.bibliotheques.servlets.listes;

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

/**
 * Servlet implementation class ServlztAfficherRole
 */
@WebServlet("/admin/listeetat")
public class ServletListeEtat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/jsp/admin/listes/listeEtat.jsp";
  
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
		doGet(request, response);
	}
	
	
	/**
	 * Methode en charge de lister les roles.
	 * 
	 * @param request
	 */
	private void listeEtats(HttpServletRequest request) {
		EtatManager manager = new EtatManager();
		List<Etat> values = null;

		try {
			values = manager.allEtat();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("etats", values);
	}

}
