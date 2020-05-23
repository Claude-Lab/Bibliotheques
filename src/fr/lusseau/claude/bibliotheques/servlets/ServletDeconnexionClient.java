package fr.lusseau.claude.bibliotheques.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletDeconnexionClient
 */
@WebServlet("/client/deconnexion")
public class ServletDeconnexionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String URL_REDIRECTION = "/Bibliotheques/index";
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer et destruir la session en cours.
        HttpSession session = request.getSession();
        session.invalidate();

        // Redirection vers la page d'accueil.
        response.sendRedirect( URL_REDIRECTION );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
