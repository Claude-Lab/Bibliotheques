package fr.lusseau.claude.bibliotheques.bll;

import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Auteur;
import fr.lusseau.claude.bibliotheques.dal.DAO.AuteurDAO;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;

/**
 * 
 * @author Claude Lusseau
 *
 */
public class AuteurManager {

	private AuteurDAO daoAuteur;

	public AuteurManager() {
		// Instantiation du DAO
		daoAuteur = DAOFactory.getAuteurDAO();
	}

	public List<Auteur> allAuteur() throws BLLException {
		List<Auteur> emprunts = null;
		try {
			emprunts = daoAuteur.selectAll();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emprunts;
	}

	public Auteur addAuteur(String nom_Prenom_Auteur) throws BusinessException {
		BusinessException businessException = new BusinessException();

		Auteur newAuteur = new Auteur(nom_Prenom_Auteur);

		this.validerAuteur(newAuteur, businessException);

		if (!businessException.hasErreurs()) {
			this.daoAuteur.insert(newAuteur);
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
		return newAuteur;
	}

	/**
	 * Methode en charge de
	 * @param id
	 * @return
	 * @throws BLLException
	 * @throws BusinessException
	 */
	public Auteur delAuteur(int id) throws BLLException, BusinessException {

		BusinessException businessException = new BusinessException();

		Auteur auteur = new Auteur();

		if (!businessException.hasErreurs()) {
			this.daoAuteur.delete(id);
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
		return auteur;
	}

	
	public List<Auteur> SortByAuteur(String nom_Prenom_Auteur) throws BusinessException {
		List<Auteur> auteurs = null;
		auteurs = daoAuteur.selectByAuteur(nom_Prenom_Auteur);

		return auteurs;
	}

	public void validerAuteur(Auteur newAuteur, BusinessException businessException) {
		if (newAuteur.getPrenom_Auteur() != null) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDER_AUTEUR_ERREUR);
		}
	}
}