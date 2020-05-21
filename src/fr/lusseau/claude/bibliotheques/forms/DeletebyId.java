/**
 * 
 */
package fr.lusseau.claude.bibliotheques.forms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bll.AuteurManager;
import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.BibliothequeManager;
import fr.lusseau.claude.bibliotheques.bll.CotisationManager;
import fr.lusseau.claude.bibliotheques.bll.EditeurManager;
import fr.lusseau.claude.bibliotheques.bll.EmpruntManager;
import fr.lusseau.claude.bibliotheques.bll.EtatManager;
import fr.lusseau.claude.bibliotheques.bll.LivreManager;
import fr.lusseau.claude.bibliotheques.bll.PersonneManager;
import fr.lusseau.claude.bibliotheques.bll.RoleManager;
import fr.lusseau.claude.bibliotheques.bo.Auteur;
import fr.lusseau.claude.bibliotheques.bo.Bibliotheque;
import fr.lusseau.claude.bibliotheques.bo.Cotisation;
import fr.lusseau.claude.bibliotheques.bo.Editeur;
import fr.lusseau.claude.bibliotheques.bo.Emprunt;
import fr.lusseau.claude.bibliotheques.bo.Etat;
import fr.lusseau.claude.bibliotheques.bo.Livre;
import fr.lusseau.claude.bibliotheques.bo.Personne;
import fr.lusseau.claude.bibliotheques.bo.Role;
import fr.lusseau.claude.bibliotheques.messages.LecteurMessage;

/**
 * Classe en charge de
 * 
 * @version Bibliotheques -v1,0
 * @date 14 mai 2020 - 19:23:45
 * @author Claude LUSSEAU
 *
 */
public class DeletebyId {

	private String resultatDelete;
	private String typePersonne;

	/**
	 * Methode en charge de supprimer par ID.
	 * 
	 * @param request
	 */
	public void supprimerCotisation(HttpServletRequest request) {
		int id_Cotisation = Integer.parseInt(request.getParameter("id_Cotisation"));

		if (id_Cotisation != 0) {
			try {
				CotisationManager manager = new CotisationManager();
				try {
					@SuppressWarnings("unused")
					Cotisation cotisation = manager.delCotisation(id_Cotisation);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			} catch (BusinessException e) {
				e.printStackTrace();
			}
			resultatDelete = "Suppression REUSSIE ! ";
			request.setAttribute("resultatDelete", resultatDelete);
		} else {
			resultatDelete = "Erreur lors de la suppression !";
			request.setAttribute("resultatDelete", resultatDelete);
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
	 * Methode en charge de supprimer un role par ID.
	 * 
	 * @param request
	 */
	public void supprimerRole(HttpServletRequest request) {
		int id_Role = Integer.parseInt(request.getParameter("id_Role"));

		if (id_Role != 0) {
			try {
				RoleManager manager = new RoleManager();
				try {
					@SuppressWarnings("unused")
					Role role = manager.delRole(id_Role);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			} catch (BusinessException e) {
				e.printStackTrace();
			}

			resultatDelete = "Suppression REUSSIE ! ";
			request.setAttribute("resultatDelete", resultatDelete);
		} else {
			resultatDelete = "Erreur lors de la suppression !";
			request.setAttribute("resultatDelete", resultatDelete);
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
	 * Methode en charge de
	 * 
	 * @param request
	 */
	public void supprimerAuteur(HttpServletRequest request) {
		int id_Auteur = Integer.parseInt(request.getParameter("id_Auteur"));

		if (id_Auteur != 0) {
			try {
				AuteurManager manager = new AuteurManager();
				try {
					@SuppressWarnings("unused")
					Auteur auteur = manager.delAuteur(id_Auteur);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			} catch (BusinessException e) {
				e.printStackTrace();
			}

			resultatDelete = "Suppression REUSSIE ! ";
			request.setAttribute("resultatDelete", resultatDelete);
		} else {
			resultatDelete = "Erreur lors de la suppression !";
			request.setAttribute("resultatDelete", resultatDelete);
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
	 * Methode en charge de
	 * 
	 * @param request
	 */
	public void supprimerEmprunt(HttpServletRequest request) {
		int id_Emprunt = Integer.parseInt(request.getParameter("id_Auteur"));

		if (id_Emprunt != 0) {
			try {
				EmpruntManager manager = new EmpruntManager();
				try {
					@SuppressWarnings("unused")
					Emprunt emprunt = manager.delEmprunt(id_Emprunt);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			} catch (BusinessException e) {
				e.printStackTrace();
			} catch (BLLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			resultatDelete = "Suppression REUSSIE ! ";
			request.setAttribute("resultatDelete", resultatDelete);
		} else {
			resultatDelete = "Erreur lors de la suppression !";
			request.setAttribute("resultatDelete", resultatDelete);
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
	 * Methode en charge de
	 * 
	 * @param request
	 */
	public void supprimerEtat(HttpServletRequest request) {
		int id_Etat = Integer.parseInt(request.getParameter("id_Etat"));

		if (id_Etat != 0) {
			try {
				EtatManager manager = new EtatManager();
				try {
					@SuppressWarnings("unused")
					Etat etat = manager.delEtat(id_Etat);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			} catch (BusinessException e) {
				e.printStackTrace();
			}

			resultatDelete = "Suppression REUSSIE ! ";
			request.setAttribute("resultatDelete", resultatDelete);
		} else {
			resultatDelete = "Erreur lors de la suppression !";
			request.setAttribute("resultatDelete", resultatDelete);
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
	 * Methode en charge de
	 * 
	 * @param request
	 */
	public void supprimerLivre(HttpServletRequest request) {
		int id_Livre = Integer.parseInt(request.getParameter("id_Auteur"));

		if (id_Livre != 0) {

			LivreManager manager = new LivreManager();

			try {
				@SuppressWarnings("unused")
				Livre livre = manager.delLivre(id_Livre);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			resultatDelete = "Suppression REUSSIE ! ";
			request.setAttribute("resultatDelete", resultatDelete);
		} else {
			resultatDelete = "Erreur lors de la suppression !";
			request.setAttribute("resultatDelete", resultatDelete);
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
	 * Methode en charge de supprimer un role par ID.
	 * 
	 * @param request
	 */
	public void supprimerBibliotheque(HttpServletRequest request) {
		int id_Bibliotheque = Integer.parseInt(request.getParameter("id_Bibliotheque"));

		if (id_Bibliotheque != 0) {
			try {
				BibliothequeManager manager = new BibliothequeManager();
				try {
					@SuppressWarnings("unused")
					Bibliotheque bibliotheque = manager.delBibliotheque(id_Bibliotheque);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			} catch (BusinessException e) {
				e.printStackTrace();
			}

			resultatDelete = "Suppression REUSSIE ! ";
			request.setAttribute("resultatDelete", resultatDelete);
		} else {
			resultatDelete = "Erreur lors de la suppression !";
			request.setAttribute("resultatDelete", resultatDelete);
			@SuppressWarnings("unchecked")
			List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
			if (listeCodesErreur != null) {
				for (int codeErreur : listeCodesErreur) {
					LecteurMessage.getMessageErreur(codeErreur);
				}
			}
		}
	}

	public void supprimerEditeur(HttpServletRequest request) {
		int id_Editeur = Integer.parseInt(request.getParameter("id_Editeur"));

		if (id_Editeur != 0) {
			try {
				EditeurManager manager = new EditeurManager();
				try {
					@SuppressWarnings("unused")
					Editeur editeur = manager.delEditeur(id_Editeur);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			} catch (BusinessException e) {
				e.printStackTrace();
			}

			resultatDelete = "Suppression REUSSIE ! ";
			request.setAttribute("resultatDelete", resultatDelete);
		} else {
			resultatDelete = "Erreur lors de la suppression !";
			request.setAttribute("resultatDelete", resultatDelete);
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
	 * Methode en charge de supprimer par ID.
	 * 
	 * @param request
	 */
	public void supprimerPersonne(HttpServletRequest request) {
		int id_Personne = Integer.parseInt(request.getParameter("id_Personne"));
		String type = request.getParameter("type_Personne");
		typePersonne = type;

		if (id_Personne != 0) {
			try {
				PersonneManager manager = new PersonneManager();
				try {
					@SuppressWarnings("unused")
					Personne personne = manager.delPersonne(id_Personne);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			} catch (BusinessException e) {
				e.printStackTrace();
			}

			resultatDelete = "Suppression REUSSIE ! ";
			request.setAttribute("resultatDelete", resultatDelete);
		} else {
			resultatDelete = "Erreur lors de la suppression !";
			request.setAttribute("resultatDelete", resultatDelete);
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
	 * Guetter pour resultatDelete.
	 * 
	 * @return the resultatDelete
	 */
	public String getresultatDelete() {
		return resultatDelete;
	}

	/**
	 * Setter pour resultatDelete.
	 * 
	 * @param resultatDelete the resultatDelete to set
	 */
	public void setresultatDelete(String resultatDelete) {
		this.resultatDelete = resultatDelete;
	}

	/**
	 * Guetter pour typePersonne.
	 * 
	 * @return the typePersonne
	 */
	public String getTypePersonne() {
		return typePersonne;
	}

	/**
	 * Setter pour typePersonne.
	 * 
	 * @param typePersonne the typePersonne to set
	 */
	public void setTypePersonne(String typePersonne) {
		this.typePersonne = typePersonne;
	}

}