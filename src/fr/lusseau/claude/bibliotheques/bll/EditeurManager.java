package fr.lusseau.claude.bibliotheques.bll;

import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Editeur;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;
import fr.lusseau.claude.bibliotheques.dal.DAO.EditeurDAO;

public class EditeurManager {

	private EditeurDAO daoEditeur;

	public EditeurManager() {
		this.daoEditeur = DAOFactory.getEditeurDAO();
	}

	/**
	 * Methode en charge d'ajouter une cotisation.
	 *
	 * @param newCotisation
	 * @param businessException
	 * @return
	 */
	public Editeur addEditeur(String nom_Editeur, String adresse_Editeur, String cp_Editeur, String ville_Editeur, String pays_Editeur, String mail_Editeur, String tel_Editeur) throws BusinessException {

		BusinessException businessException = new BusinessException();

		Editeur newEditeur = new Editeur(nom_Editeur, adresse_Editeur, cp_Editeur, ville_Editeur, pays_Editeur, mail_Editeur, tel_Editeur);

		this.validerEditeur(newEditeur, businessException);
	

		if (!businessException.hasErreurs()) {
			this.daoEditeur.insert(newEditeur);
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
		return newEditeur;
	}

	/**
	 * Methode en charge de lister les cotisations.
	 *
	 * @return
	 * @throws BLLException
	 */
	public List<Editeur> allEditeur() throws BLLException {
		List<Editeur> editeur = null;
		try {
			editeur = daoEditeur.selectAll();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if (editeur != null) {
			for (Editeur e : editeur) {
				System.out.println(e);
			}
		}
		return editeur;
	}

	/**
	 * Methode en charge de supprimer un salarié.
	 * 
	 * @return
	 * @throws BLLException
	 */
	public Editeur delEditeur(int id) throws BLLException, BusinessException {

		BusinessException businessException = new BusinessException();

		Editeur editeur = new Editeur();

		if (!businessException.hasErreurs()) {
			this.daoEditeur.delete(id);
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
		return editeur;
	}

	/**
	 * Methode en charge de valider les cotisations.
	 *
	 * @param c
	 * @param businessException
	 */
	public void validerEditeur(Editeur newEditeur, BusinessException businessException) {
		if (newEditeur.getId_Editeur() < 0) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDER_BIBLIOTHEQUE_ERREUR);
		}
	}

	
}
