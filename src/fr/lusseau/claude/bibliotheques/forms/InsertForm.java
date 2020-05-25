/**
 * 
 */
package fr.lusseau.claude.bibliotheques.forms;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bll.AuteurManager;
import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.BibliothequeManager;
import fr.lusseau.claude.bibliotheques.bll.CotisationManager;
import fr.lusseau.claude.bibliotheques.bll.EditeurManager;
import fr.lusseau.claude.bibliotheques.bll.EtatManager;
import fr.lusseau.claude.bibliotheques.bll.LivreManager;
import fr.lusseau.claude.bibliotheques.bll.PersonneManager;
import fr.lusseau.claude.bibliotheques.bll.RoleManager;
import fr.lusseau.claude.bibliotheques.bo.Auteur;
import fr.lusseau.claude.bibliotheques.bo.Bibliotheque;
import fr.lusseau.claude.bibliotheques.bo.Cotisation;
import fr.lusseau.claude.bibliotheques.bo.Editeur;
import fr.lusseau.claude.bibliotheques.bo.Etat;
import fr.lusseau.claude.bibliotheques.bo.Livre;
import fr.lusseau.claude.bibliotheques.bo.Personne;
import fr.lusseau.claude.bibliotheques.bo.Role;
import fr.lusseau.claude.bibliotheques.messages.LecteurMessage;
import fr.lusseau.claude.bibliotheques.servlets.CodesResultatServlets;

/**
 * Classe en charge du traitement du formulaire des cotisations.
 * 
 * @version Bibliotheques -v1,0
 * @date 12 mai 2020 - 14:57:23
 * @author Claude LUSSEAU
 *
 */
public class InsertForm {

	private String resultatInsert;
	private String resultatMail;

	/**
	 * Methode en charge de valider l'enregistrement d'un type de cotisation.
	 * 
	 * @param request
	 */
	public void validerCotisation(HttpServletRequest request) {
		String valeurs = request.getParameter("valeurs");
		String nbrEmprunts = request.getParameter("nbrEmprunts");
		Cotisation value = null;

		int valeurs_Caution = Integer.parseInt(valeurs);
		int nbrEmprunts_Caution = Integer.parseInt(nbrEmprunts);

		if (valeurs_Caution >= 0 && nbrEmprunts_Caution >= 0) {
			try {
				CotisationManager manager = new CotisationManager();
				try {
					value = manager.addCotisation(valeurs_Caution, nbrEmprunts_Caution);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("value", value);
				resultatInsert = "Nouvelle cotisation validée !";
			} catch (NumberFormatException e) {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_COTISATION_VALEUR_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);
			}

		} else {
			resultatInsert = "Erreur lors de la saisie";
			@SuppressWarnings("unchecked")
			List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
			if (listeCodesErreur != null) {
				for (int codeErreur : listeCodesErreur) {
					LecteurMessage.getMessageErreur(codeErreur);
				}
			}
		}
	}

	/**
	 * Methode en charge de Valider l'enregistrement d'un client.
	 * 
	 * @param request
	 */
	public void validerClient(HttpServletRequest request) {
		String prenom_Personne = request.getParameter("prenom_Personne");
		String nom_Personne = request.getParameter("nom_Personne");
		String adresse_Personne = request.getParameter("adresse_Personne");
		String cp_Personne = request.getParameter("cp_Personne");
		String ville_Personne = request.getParameter("ville_Personne");
		String mail_Personne = request.getParameter("mail_Personne");
		String tel_Personne = request.getParameter("tel_Personne");
		String motDePasse_Personne = request.getParameter("motDePasse_Personne");
		String role_Personne = request.getParameter("role_Personne");
		String type_Personne = "CLIENT";
		int cotisation_Personne = Integer.parseInt(request.getParameter("cotisation_Personne"));
		Timestamp inscription_Personne = new Timestamp(System.currentTimeMillis());// LocalDate.parse(request.getParameter("inscription_Personne"));
		@SuppressWarnings("unused")
		Personne value = null;
		Personne value_Mail = null;

		if ((prenom_Personne != null) && (nom_Personne != null)) {
			try {
				PersonneManager manager = new PersonneManager();
				try {
					try {
						value = manager.addPersonne(prenom_Personne, nom_Personne, adresse_Personne, cp_Personne,
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

				resultatInsert = "Nouvelle entrée d'un salarié REUSSIE ! ";

			} catch (NumberFormatException e) {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_SALARIE_VALEUR_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);
			}

		} else {
			resultatInsert = "Erreur lors de l'enregistrement !";
			@SuppressWarnings("unchecked")
			List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
			if (listeCodesErreur != null) {
				for (int codeErreur : listeCodesErreur) {
					LecteurMessage.getMessageErreur(codeErreur);
				}
			}
		}
		request.setAttribute("resultatInsert", resultatInsert);
	}

	/**
	 * Methode en charge de valider l'enregistrement d'un salairé.
	 * 
	 * @param request
	 */
	public void validerSalarie(HttpServletRequest request) {
		String prenom_Personne = request.getParameter("prenom_Personne");
		String nom_Personne = request.getParameter("nom_Personne");
		String adresse_Personne = request.getParameter("adresse_Personne");
		String cp_Personne = request.getParameter("cp_Personne");
		String ville_Personne = request.getParameter("ville_Personne");
		String mail_Personne = request.getParameter("mail_Personne");
		String tel_Personne = request.getParameter("tel_Personne");
		String motDePasse_Personne = request.getParameter("motDePasse_Personne");
		String type_Personne = "SALARIE";
		String role_Personne = request.getParameter("role_Personne");
		int cotisation_Personne = Integer.parseInt(request.getParameter("cotisation_Personne"));
		Timestamp inscription_Personne = new Timestamp(System.currentTimeMillis());// LocalDate.parse(request.getParameter("inscription_Personne"));
		@SuppressWarnings("unused")
		Personne value = null;

		if ((prenom_Personne != null) && (nom_Personne != null)) {
			try {
				PersonneManager manager = new PersonneManager();
				try {
					try {
						value = manager.addPersonne(prenom_Personne, nom_Personne, adresse_Personne, cp_Personne,
								ville_Personne, mail_Personne, tel_Personne, motDePasse_Personne, cotisation_Personne,
								role_Personne, type_Personne, inscription_Personne);
					} catch (BLLException e) {
						e.printStackTrace();
					}
				} catch (BusinessException e) {
					e.printStackTrace();
				}

				resultatInsert = "Nouvelle entrée d'un salarié REUSSIE ! ";

			} catch (NumberFormatException e) {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_SALARIE_VALEUR_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);
			}

		} else {
			resultatInsert = "Erreur lors de l'enregistrement !";
			@SuppressWarnings("unchecked")
			List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
			if (listeCodesErreur != null) {
				for (int codeErreur : listeCodesErreur) {
					LecteurMessage.getMessageErreur(codeErreur);
				}
			}
		}
		request.setAttribute("resultatInsert", resultatInsert);
	}

	/**
	 * Methode en charge de valider l'enregistrement d'une bibliothèque.
	 * 
	 * @param request
	 */
	public void validerBibliotheque(HttpServletRequest request) {
		String nom_Bibliotheque = request.getParameter("nom_Bibliotheque");
		String adresse_Bibliotheque = request.getParameter("adresse_Bibliotheque");
		String cp_Bibliotheque = request.getParameter("cp_Bibliotheque");
		String ville_Bibliotheque = request.getParameter("ville_Bibliotheque");
		String mail_Bibliotheque = request.getParameter("mail_Bibliotheque");
		String tel_Bibliotheque = request.getParameter("tel_Bibliotheque");
		@SuppressWarnings("unused")
		Bibliotheque value = null;

		if ((nom_Bibliotheque != null) && (ville_Bibliotheque != null)) {
			try {
				BibliothequeManager manager = new BibliothequeManager();
				try {
					value = manager.addBibliotheque(nom_Bibliotheque, adresse_Bibliotheque, cp_Bibliotheque,
							ville_Bibliotheque, mail_Bibliotheque, tel_Bibliotheque);
				} catch (Exception e) {
					e.printStackTrace();
				}

				resultatInsert = "Nouvelle entrée d'une bibliothèque REUSSIE ! ";

			} catch (NumberFormatException e) {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_BIBLIOTHEQUE_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);
			}

		} else {
			resultatInsert = "Erreur lors de l'enregistrement !";
			@SuppressWarnings("unchecked")
			List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
			if (listeCodesErreur != null) {
				for (int codeErreur : listeCodesErreur) {
					LecteurMessage.getMessageErreur(codeErreur);
				}
			}
		}
		request.setAttribute("resultatInsert", resultatInsert);
	}

	/**
	 * Methode en charge de valider l'enregistrement d'une bibliothèque.
	 * 
	 * @param request
	 */
	public void validerEditeur(HttpServletRequest request) {
		String nom_Editeur = request.getParameter("nom_Editeur");
		String adresse_Editeur = request.getParameter("adresse_Editeur");
		String cp_Editeur = request.getParameter("cp_Editeur");
		String ville_Editeur = request.getParameter("ville_Editeur");
		String pays_Editeur = request.getParameter("pays_Editeur");
		String mail_Editeur = request.getParameter("mail_Editeur");
		String tel_Editeur = request.getParameter("mail_Editeur");
		@SuppressWarnings("unused")
		Editeur value = null;

		if ((nom_Editeur != null) && (ville_Editeur != null)) {
			try {
				EditeurManager manager = new EditeurManager();
				try {
					value = manager.addEditeur(nom_Editeur, adresse_Editeur, cp_Editeur, ville_Editeur, mail_Editeur,
							pays_Editeur, tel_Editeur);
				} catch (Exception e) {
					e.printStackTrace();
				}

				resultatInsert = "Nouvelle entrée d'un éditeur REUSSIE ! ";

			} catch (NumberFormatException e) {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_SALARIE_VALEUR_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);
			}

		} else {
			resultatInsert = "Erreur lors de l'enregistrement !";
			@SuppressWarnings("unchecked")
			List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
			if (listeCodesErreur != null) {
				for (int codeErreur : listeCodesErreur) {
					LecteurMessage.getMessageErreur(codeErreur);
				}
			}
		}
		request.setAttribute("resultatInsert", resultatInsert);
	}

	/**
	 * Methode en charge de valider l'enregistrement d'un etat.
	 * 
	 * @param request
	 */
	public void validerEtat(HttpServletRequest request) {
		String usage_Etat = request.getParameter("usage_Etat");

		@SuppressWarnings("unused")
		Etat value = null;

		if (usage_Etat != null) {
			try {
				EtatManager manager = new EtatManager();
				try {
					value = manager.addEtat(usage_Etat);
				} catch (Exception e) {
					e.printStackTrace();
				}

				resultatInsert = "Nouvelle entrée d'un état d'usure REUSSIE ! ";

			} catch (NumberFormatException e) {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_SALARIE_VALEUR_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);
			}

		} else {
			resultatInsert = "Erreur lors de l'enregistrement !";
			@SuppressWarnings("unchecked")
			List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
			if (listeCodesErreur != null) {
				for (int codeErreur : listeCodesErreur) {
					LecteurMessage.getMessageErreur(codeErreur);
				}
			}
		}
		request.setAttribute("resultatInsert", resultatInsert);
	}

	/**
	 * Methode en charge de valider l'enregistrement d'un Role.
	 * 
	 * @param request
	 */
	public void validerRole(HttpServletRequest request) {
		String type_Role = request.getParameter("type_Role");

		@SuppressWarnings("unused")
		Role value = null;

		if (type_Role != null) {
			try {
				RoleManager manager = new RoleManager();
				try {
					value = manager.addRole(type_Role);
				} catch (Exception e) {
					e.printStackTrace();
				}

				resultatInsert = "Nouvelle entrée d'un rôle REUSSIE ! ";

			} catch (NumberFormatException e) {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_SALARIE_VALEUR_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);
			}

		} else {
			resultatInsert = "Erreur lors de l'enregistrement !";
			@SuppressWarnings("unchecked")
			List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
			if (listeCodesErreur != null) {
				for (int codeErreur : listeCodesErreur) {
					LecteurMessage.getMessageErreur(codeErreur);
				}
			}
		}
		request.setAttribute("resultatInsert", resultatInsert);
	}

	/**
	 * Methode en charge de valider l'enregistrement d'un auteur.
	 * 
	 * @param request
	 */
	public void validerAuteur(HttpServletRequest request) {
		String nom_Auteur = request.getParameter("nom_Auteur");

		@SuppressWarnings("unused")
		Auteur value = null;

		if (nom_Auteur != null) {
			try {
				AuteurManager manager = new AuteurManager();
				try {
					value = manager.addAuteur(nom_Auteur);
				} catch (Exception e) {
					e.printStackTrace();
				}

				resultatInsert = "Nouvelle entrée d'un auteur REUSSIE ! ";

			} catch (NumberFormatException e) {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_SALARIE_VALEUR_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);
			}

		} else {
			resultatInsert = "Erreur lors de l'enregistrement !";
			@SuppressWarnings("unchecked")
			List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
			if (listeCodesErreur != null) {
				for (int codeErreur : listeCodesErreur) {
					LecteurMessage.getMessageErreur(codeErreur);
				}
			}
		}
		request.setAttribute("resultatInsert", resultatInsert);
	}

	/**
	 * Methode en charge de valider l'enregistrement d'un livre.
	 * 
	 * @param request
	 */
	public void validerLivre(HttpServletRequest request) {
		String titre_Livre = request.getParameter("titre_Livre");
		LocalDateTime dateAchat_Livre = LocalDateTime.parse(request.getParameter("dateAchat_Livre"));
		String description_Livre = request.getParameter("description_Livre");
		String prenom_Nom_Auteur = request.getParameter("prenom_Nom_Auteur");
		String isbn_Ecrit = request.getParameter("isbn_Ecrit");
		String nom_Bibliotheque = request.getParameter("nom_Bibliotheque");
		String nom_Editeur = request.getParameter("nom_Editeur");
		String usage_Etat = request.getParameter("usage_Etat");

		@SuppressWarnings("unused")
		Livre value = null;

		if (titre_Livre != null) {
			try {
				LivreManager manager = new LivreManager();
				try {
					value = manager.addLivre(titre_Livre, dateAchat_Livre, description_Livre, prenom_Nom_Auteur,
							isbn_Ecrit, nom_Bibliotheque, nom_Editeur, usage_Etat);
				} catch (Exception e) {
					e.printStackTrace();
				}

				resultatInsert = "Nouvelle entrée d'un livre REUSSIE ! ";

			} catch (NumberFormatException e) {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_SALARIE_VALEUR_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);
			}

		} else {
			resultatInsert = "Erreur lors de l'enregistrement !";
			@SuppressWarnings("unchecked")
			List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
			if (listeCodesErreur != null) {
				for (int codeErreur : listeCodesErreur) {
					LecteurMessage.getMessageErreur(codeErreur);
				}
			}
		}
		request.setAttribute("resultatInsert", resultatInsert);
	}

	/**
	 * Guetter pour resultatInsert.
	 * 
	 * @return the resultatInsert
	 */
	public String getresultatInsert() {
		return resultatInsert;
	}

	/**
	 * Setter pour resultatInsert.
	 * 
	 * @param resultatInsert the resultatInsert to set
	 */
	public void setresultatInsert(String resultatInsert) {
		this.resultatInsert = resultatInsert;
	}

	/**
	 * Guetter pour resultatMail.
	 * 
	 * @return the resultatMail
	 */
	public String getResultatMail() {
		return resultatMail;
	}

	/**
	 * Setter pour resultatMail.
	 * 
	 * @param resultatMail the resultatMail to set
	 */
	public void setResultatMail(String resultatMail) {
		this.resultatMail = resultatMail;
	}

}
