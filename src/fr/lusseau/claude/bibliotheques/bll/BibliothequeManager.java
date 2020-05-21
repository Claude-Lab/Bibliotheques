package fr.lusseau.claude.bibliotheques.bll;

import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Bibliotheque;
import fr.lusseau.claude.bibliotheques.dal.DAO.BibliothequeDAO;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;

public class BibliothequeManager {

	private BibliothequeDAO daoBibliotheque;

	public BibliothequeManager() {
		this.daoBibliotheque = DAOFactory.getBibliothequeDAO();
	}

	/**
	 * Methode en charge d'ajouter une bibliotheque.
	 *
	 * @param newCotisation
	 * @param businessException
	 * @return
	 */
	public Bibliotheque addBibliotheque(String nom_Bibliotheque, String adresse_Bibliotheque, String cp_Bibliotheque, String ville_Bibliotheque, String tel_Bibliotheque, String mail_Bibliotheque) throws BusinessException {

		BusinessException businessException = new BusinessException();

		Bibliotheque newBibliotheque = new Bibliotheque(nom_Bibliotheque, adresse_Bibliotheque, cp_Bibliotheque, ville_Bibliotheque, tel_Bibliotheque, mail_Bibliotheque);

		this.validerBibliotheque(newBibliotheque, businessException);
	

		if (!businessException.hasErreurs()) {
			this.daoBibliotheque.insert(newBibliotheque);
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
		return newBibliotheque;
	}

	/**
	 * Methode en charge de lister les bibliotheques.
	 *
	 * @return
	 * @throws BLLException
	 */
	public List<Bibliotheque> allBibliotheque() throws BLLException {
		List<Bibliotheque> bibliotheques = null;
		try {
			bibliotheques = daoBibliotheque.selectAll();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if (bibliotheques != null) {
			for (Bibliotheque b : bibliotheques) {
				System.out.println(b);
			}
		}
		return bibliotheques;
	}

	/**
	 * Methode en charge de supprimer une bibliotheque.
	 * 
	 * @return
	 * @throws BLLException
	 */
	public Bibliotheque delBibliotheque(int id) throws BLLException, BusinessException {

		BusinessException businessException = new BusinessException();

		Bibliotheque bibliotheque = new Bibliotheque();

		if (!businessException.hasErreurs()) {
			this.daoBibliotheque.delete(id);
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
		return bibliotheque;
	}

	/**
	 * Methode en charge de valider les bibliotheques.
	 *
	 * @param c
	 * @param businessException
	 */
	public void validerBibliotheque(Bibliotheque newBibliotheque, BusinessException businessException) {
		if (newBibliotheque.getNom_Bibliotheque() ==  null) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDER_BIBLIOTHEQUE_ERREUR);
		}
	}

	
}
