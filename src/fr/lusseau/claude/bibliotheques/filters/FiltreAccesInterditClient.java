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
@WebFilter(urlPatterns = "/WEB-INF/jsp/client/*",
			dispatcherTypes = {
					DispatcherType.REQUEST,
					DispatcherType.INCLUDE,
					DispatcherType.FORWARD,
					DispatcherType.ERROR
			})
public class FiltreAccesInterditClient implements Filter {

	public static final String ATT_SESSION_USER = "sessionPersonne";
	public static final String ACCES_CLIENT = "/client/accueil";
	public static final String ACCES_PUBLIC = "/index";
	public static final String TYPE = "type_Personne";
	public static final String TYPE_CLIENT = "CLIENT";
	
    /**
     * Default constructor. 
     */
    public FiltreAccesInterditClient() {
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
		HttpSession session = request.getSession();
		
		/* Non-filtrage des ressources statiques */
        String chemin = request.getRequestURI().substring( request.getContextPath().length() );
        if ( chemin.startsWith( "/WEB-INF/jsp/includes" ) ) {
            chain.doFilter( request, response );
            return;
        }


		/**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( request.getSession().getAttribute( ATT_SESSION_USER ) == null ) {
            /* Redirection vers la page publique */
        	response.sendRedirect( request.getContextPath() + ACCES_PUBLIC);
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
