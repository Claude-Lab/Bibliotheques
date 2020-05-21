/**
 * 
 */
package fr.lusseau.claude.bibliotheques.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.lusseau.claude.bibliotheques.bo.Personne;

/**
 * Classe en charge de l'inscription d'un nouveau client.
 * 
 * @version Bibliotheques -v1,0
 * @date 17 mai 2020 - 17:41:02
 * @author Claude LUSSEAU
 *
 */
public class InscriptionForm {
	private static final String CHAMP_PRENOM = "prenom_Personne";
	private static final String CHAMP_NOM = "nom_Personne";
	private static final String CHAMP_ADRESSE = "adresse_Personne";
	private static final String CHAMP_CP = "cp_Personne";
	private static final String CHAMP_VILLE = "ville_Personne";
	private static final String CHAMP_TEL = "tel_Personne";
	private static final String CHAMP_MAIL = "mail_Personne";
	private static final String CHAMP_PASS = "motDePasse_Personne";
	private static final String CHAMP_CONF = "confirmation_Personne";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	/**
	 * Guetter pour resultat.
	 * 
	 * @return the resultat
	 */
	public String getResultat() {
		return resultat;
	}

	/**
	 * Guetter pour erreurs.
	 * 
	 * @return the erreurs
	 */
	public Map<String, String> getErreurs() {
		return erreurs;
	}

	/**
	 * Methode en charge de récuperer les valeurs entrées.
	 * @param request
	 * @return
	 */
	public Personne inscriptionClient (HttpServletRequest request) {
    	String nom = getValeurChamp(request, CHAMP_NOM);
    	String prenom = getValeurChamp(request, CHAMP_PRENOM);
    	String adresse = getValeurChamp(request, CHAMP_ADRESSE);
    	String cp = getValeurChamp(request, CHAMP_CP);
    	String ville = getValeurChamp(request, CHAMP_VILLE);
    	String tel = getValeurChamp(request, CHAMP_TEL);
    	String mail = getValeurChamp(request, CHAMP_MAIL);
    	String motDePasse = getValeurChamp(request, CHAMP_PASS);
    	String confirmation = getValeurChamp(request, CHAMP_CONF);
    	
    	Personne client = new Personne();
    	
    	try {
            validationMail( mail );
        } catch ( Exception e ) {
            setErreur( CHAMP_MAIL, e.getMessage() );
        }
        client.setMail_Personne( mail );

        try {
            validationMotsDePasse( motDePasse, confirmation );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, null );
        }
        client.setMotDePasse_Personne( motDePasse );

        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        client.setNom_Personne( nom );
        
        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        client.setPrenom_Personne( prenom );
        
        try {
            validationAdresse( adresse );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        client.setAdresse_Personne( adresse );
        
        try {
            validationCp( cp );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        client.setCp_Personne( cp );
        
        try {
            validationVille( ville );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        client.setVille_Personne( ville );
        
        try {
            validationTel( tel );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        client.setTel_Personne( tel );
        
        client.setCotisation_Personne(0);
        client.setType_Personne("CLIENT");
        

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }

        return client;
    }
	
	/**
	 * Methode en charge de vérifier les conditions de saisies du mail.
	 * @param mail
	 * @throws Exception
	 */
	private void validationMail( String mail ) throws Exception {
	    if ( mail != null ) {
	        if ( !mail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );
	    }
	}

	/**
	 * Methode en charge de vérifier les conditions de saisies du mot de passe.
	 * @param motDePasse
	 * @param confirmation
	 * @throws Exception
	 */
	private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
	    if ( motDePasse != null && confirmation != null ) {
	        if ( !motDePasse.equals( confirmation ) ) {
	            throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
	        } else if ( motDePasse.length() < 3 ) {
	            throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
	    }
	}
	
	/**
	 * Methode en charge de vérifier les conditions de saisies du prénom.
	 * @param prenom
	 * @throws Exception
	 */
	private void validationPrenom( String prenom ) throws Exception {
	    if ( prenom != null && prenom.length() < 3 ) {
	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
	    }
	}

	/**
	 * Methode en charge de vérifier les conditions de saisies du nom.
	 * @param nom
	 * @throws Exception
	 */
	private void validationNom( String nom ) throws Exception {
	    if ( nom != null && nom.length() < 3 ) {
	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
	    }
	}
	
	/**
	 * Methode en charge de vérifier les conditions de saisies de l'adresse.
	 * @param adresse
	 * @throws Exception
	 */
	private void validationAdresse( String adresse ) throws Exception {
	    if ( adresse != null && adresse.length() < 6 ) {
	        throw new Exception( "L'adresse doit contenir au moins 6 caractères." );
	    }
	}
	
	/**
	 * Methode en charge de vérifier les conditions de saisies du code postal.
	 * @param cp
	 * @throws Exception
	 */
	private void validationCp( String cp ) throws Exception {
	    if ( cp != null && cp.length() != 5) {
	        throw new Exception( "Le code postal est composé de 5 chiffres." );
	    }
	}
	
	/**
	 * Methode en charge de vérifier les conditions de saisies dde la ville.
	 * @param ville
	 * @throws Exception
	 */
	private void validationVille( String ville ) throws Exception {
	    if ( ville != null && ville.length() < 3) {
	        throw new Exception( "La ville doit contenir au moins 3 caractères." );
	    }
	}
	
	/**
	 * Methode en charge de vérifier les conditions de saisies du numéro de téléphone.
	 * @param tel
	 * @throws Exception
	 */
	private void validationTel( String tel ) throws Exception {
	    if ( tel != null && tel.length() < 10) {
	        throw new Exception( "Un numéro de téléphone est composé de 10 chiffres." );
	    }
	}
	
	
	/**
	 * Methode en charge d'ajouter un message correspondant au champ spécifié à la map des erreurs.
	 * @param champ
	 * @param message
	 */
	private void setErreur( String champ, String message ) {
	    erreurs.put( champ, message );
	}

	
	/**
	 * Methode en charge de retourner null si un champ est vide, et son contenu sinon.
	 * @param request
	 * @param nomChamp
	 * @return
	 */
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	    String valeur = request.getParameter( nomChamp );
	    if ( valeur == null || valeur.trim().length() == 0 ) {
	        return null;
	    } else {
	        return valeur.trim();
	    }
	}
}