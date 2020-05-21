package fr.lusseau.claude.bibliotheques.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.lusseau.claude.bibliotheques.bo.Personne;

/**
 * Classe en charge de traiter les formulaires de connexion.
 * 
 * @Version Bibliotheques -v1,0
 * @date 19 mai 2020 - 18:39:07
 * @author CLoD
 *
 */
public class ConnectionForm {

	private static final String CHAMP_EMAIL = "mail_Personne";
	private static final String CHAMP_PASS = "motDePasse_Personne";
	private static final String CHAMP_ID = "id_Personne";
	private int id_Personne = 0;
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	/**
	 * Methode en charge de connecter l'utilisateur.
	 * 
	 * @param request
	 * @return
	 */
	public Personne connecterPersonne(HttpServletRequest request) {
		// Récupération des champs du formulaire
		String mail_Personne = getValeurChamp(request, CHAMP_EMAIL);
		String motDePasse_Personne = getValeurChamp(request, CHAMP_PASS);
		String id_Personne = getValeurChamp(request, CHAMP_ID);

		Personne personne = null;

		// Valider le champ email personne.
		try {
			personne = new Personne();
			validationEmail(mail_Personne);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		personne.setMail_Personne(mail_Personne);


		try {
			validationMotDePasse(motDePasse_Personne);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
		}
		personne.setMotDePasse_Personne(motDePasse_Personne);

		

		// Initialiser le résultat global de la validation.
		if (erreurs.isEmpty()) {
			resultat = "Succès de la connexion.";
		} else {
			resultat = "Échec de la connexion.";
		}

		return personne;
	}

	/**
	 * Methode en charge de valider l'adresse mail saisie.
	 * 
	 * @param email
	 * @throws Exception
	 */
	private void validationEmail(String mail_Personne) throws Exception {
		if (mail_Personne != null && !mail_Personne.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			throw new Exception("Merci de saisir une adresse mail valide.");
		}
	}

	/**
	 * Methode en charge de valider le mot de passe saisi.
	 * 
	 * @param motDePasse
	 * @throws Exception
	 */
	private void validationMotDePasse(String motDePasse_Personne) throws Exception {
		if (motDePasse_Personne != null) {
			if (motDePasse_Personne.length() < 3) {
				throw new Exception("Le mot de passe doit contenir au moins 3 caractères.");
			}
		} else {
			throw new Exception("Merci de saisir votre mot de passe.");
		}
	}

	/**
	 * Methode en charge d'ajouter un message correspondant au champ spécifié à la
	 * map des erreurs.
	 * 
	 * @param champ
	 * @param message
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/**
	 * Methode en charge de retourner null si un champ est vide, et son contenu
	 * sinon.
	 * 
	 * @param request
	 * @param nomChamp
	 * @return
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	/**
	 * Guetter pour resultat.
	 * 
	 * @return the resultat
	 */
	public String getResultat() {
		return resultat;
	}

	/**
	 * Setter pour resultat.
	 * 
	 * @param resultat the resultat to set
	 */
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public int getId_Personne() {
		return id_Personne;
	}

	public void setId_Personne(int id_Personne) {
		this.id_Personne = id_Personne;
	}
	
	
}