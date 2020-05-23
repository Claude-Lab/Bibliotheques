package fr.lusseau.claude.bibliotheques.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltreAccesInterdit
 */
@WebFilter(urlPatterns = "/WEB-INF/jsp/admin/*",
			dispatcherTypes = {
					DispatcherType.REQUEST,
					DispatcherType.INCLUDE,
					DispatcherType.FORWARD,
					DispatcherType.ERROR
			})
public class FiltreAccesInterdit implements Filter {

	public static final String ATT_SESSION_USER = "sessionPersonne";
	
    /**
     * Default constructor. 
     */
    public FiltreAccesInterdit() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
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
        	response.sendRedirect( request.getContextPath() + "/");
        } else {
            /* Affichage de la page restreinte */
            chain.doFilter( request, response );
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
