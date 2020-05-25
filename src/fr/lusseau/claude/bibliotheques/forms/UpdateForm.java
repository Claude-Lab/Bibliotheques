/**
 * 
 */
package fr.lusseau.claude.bibliotheques.forms;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.PersonneManager;
import fr.lusseau.claude.bibliotheques.bo.Personne;
import fr.lusseau.claude.bibliotheques.messages.LecteurMessage;
import fr.lusseau.claude.bibliotheques.servlets.CodesResultatServlets;

/**
 * Classe en charge de la mise à jour de données.
 * 
 * @Version Bibliotheques -v1,0
 * @date 25 mai 2020 - 15:27:11
 * @author claudelusseau
 *
 */
public class UpdateForm {

	private String resultatUpdate;
	private String resultatMail;
	
	
	/**
	 * Methode en charge de Valider l'enregistrement d'un client.
	 * 
	 * @param request
	 */
	public void validerClient(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		@SuppressWarnings("unused")
		int id_Personne = (int) session.getAttribute("id_Personne");
		String prenom_Personne = request.getParameter("prenom_Personne");
		String nom_Personne = request.getParameter("nom_Personne");
		String adresse_Personne = request.getParameter("adresse_Personne");
		String cp_Personne = request.getParameter("cp_Personne");
		String ville_Personne = request.getParameter("ville_Personne");
		String mail_Personne = request.getParameter("mail_Personne");
		String tel_Personne = request.getParameter("tel_Personne");
		String motDePasse_Personne = request.getParameter("motDePasse_Personne");
		String role_Personne = request.getParameter("role_Personne");
		String type_Personne = request.getParameter("type_Personne");
		int cotisation_Personne = 0;
		Timestamp inscription_Personne = null;
		@SuppressWarnings("unused")
		Personne value = null;
		Personne value_Mail = null;

		if (session.getAttribute("id_Personne") != null) {
			try {
				PersonneManager manager = new PersonneManager();
				try {
					try {
						value = manager.updatePersonne(prenom_Personne, nom_Personne, adresse_Personne, cp_Personne,
								ville_Personne, mail_Personne, tel_Personne, motDePasse_Personne, cotisation_Personne,
								role_Personne, type_Personne, inscription_Personne);
					} catch (BLLException e) {
						e.printStackTrace();
					}
				} catch (BusinessException e) {
					e.printStackTrace();
				}

				if (mail_Personne != null) {
					try {
						PersonneManager man = new PersonneManager();
						value_Mail = man.rechercherMail(mail_Personne);
					} catch (BLLException e) {
						e.printStackTrace();
					}

					if (value_Mail != null) {
						resultatMail = "Cet eMail est déjà utilisé";
					}
				}

				resultatUpdate = "Modification des informations REUSSIE ! ";
				request.setAttribute("resultatUpdate", resultatUpdate);

			} catch (NumberFormatException e) {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_UPDATE_PERSONNE_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);
			}

		} else {
			resultatUpdate = "Erreur lors de l'enregistrement !";
			@SuppressWarnings("unchecked")
			List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
			if (listeCodesErreur != null) {
				for (int codeErreur : listeCodesErreur) {
					LecteurMessage.getMessageErreur(codeErreur);
				}
			}
		}
		request.setAttribute("resultatUpdate", resultatUpdate);
	}


	/**
	 * Guetter pour resultatInsert.
	 * @return the resultatInsert
	 */
	public String getResultatUpdate() {
		return resultatUpdate;
	}


	/**
	 * Setter pour resultatInsert.
	 * @param resultatInsert the resultatInsert to set
	 */
	public void setResultatUpdate(String resultatUpdate) {
		this.resultatUpdate = resultatUpdate;
	}


	/**
	 * Guetter pour resultatMail.
	 * @return the resultatMail
	 */
	public String getResultatMail() {
		return resultatMail;
	}


	/**
	 * Setter pour resultatMail.
	 * @param resultatMail the resultatMail to set
	 */
	public void setResultatMail(String resultatMail) {
		this.resultatMail = resultatMail;
	}
	
	
}
