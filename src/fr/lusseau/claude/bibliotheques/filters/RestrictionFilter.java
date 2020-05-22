/**
 * 
 */
package fr.lusseau.claude.bibliotheques.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Classe en charge de filtrer les accès aux pages restreintes.
 * 
 * @Version Bibliotheques -v1,0
 * @date 22 mai 2020 - 15:16:11
 * @author claudelusseau
 *
 */
public class RestrictionFilter implements Filter {
	public static final String ACCES_ACCEUIL = "/WEB-INF/jsp/public/index.jsp";
	public static final String ATT_SESSION_USER = "sessionPersonne";

	public void init(FilterConfig config) throws ServletException {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		/* Cast des objets request et response */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		/* Non-filtrage des ressources statiques */
        String chemin = request.getRequestURI().substring( request.getContextPath().length() );
        if ( chemin.startsWith( "/WEB-INF/jsp/inc" ) ) {
            chain.doFilter( request, response );
            return;
        }

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();

		/**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( session.getAttribute( ATT_SESSION_USER ) == null ) {
            /* Redirection vers la page publique */
            request.getRequestDispatcher( ACCES_ACCEUIL ).forward( request, response );
        } else {
            /* Affichage de la page restreinte */
            chain.doFilter( request, response );
        }
	}

	public void destroy() {
	}
}
