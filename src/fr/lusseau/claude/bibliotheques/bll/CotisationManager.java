package fr.lusseau.claude.bibliotheques.bll;

import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Cotisation;
import fr.lusseau.claude.bibliotheques.dal.DAO.CotisationDAO;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;

public class CotisationManager {

	private CotisationDAO daoCotisation;

	public CotisationManager() {
		this.daoCotisation = DAOFactory.getCotisationDAO();
	}

	/**
	 * Methode en charge d'ajouter une cotisation.
	 *
	 * @param newCotisation
	 * @param businessException
	 * @return
	 */
	public Cotisation addCotisation(int valeurs, int nbrEmprunts) throws BusinessException {

		BusinessException businessException = new BusinessException();

		Cotisation newCotisation = new Cotisation(valeurs, nbrEmprunts);

		this.validerValeur(newCotisation, businessException);
		this.validerNbrEmprunts_Caution(newCotisation, businessException);

		if (!businessException.hasErreurs()) {
			this.daoCotisation.insert(newCotisation);
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
		return newCotisation;
	}

	/**
	 * Methode en charge de lister les cotisations.
	 *
	 * @return
	 * @throws BLLException
	 */
	public List<Cotisation> allCotisation() throws BLLException {
		List<Cotisation> cotisations = null;
		try {
			cotisations = daoCotisation.selectAll();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if (cotisations != null) {
			for (Cotisation c : cotisations) {
				System.out.println(c);
			}
		}
		return cotisations;
	}

	/**
	 * Methode en charge de supprimer un salarié.
	 * 
	 * @return
	 * @throws BLLException
	 */
	public Cotisation delCotisation(int id) throws BLLException, BusinessException {

		BusinessException businessException = new BusinessException();

		Cotisation cotisation = new Cotisation();

		if (!businessException.hasErreurs()) {
			this.daoCotisation.delete(id);
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
		return cotisation;
	}

	/**
	 * Methode en charge de valider les cotisations.
	 *
	 * @param c
	 * @param businessException
	 */
	public void validerValeur(Cotisation newCotisation, BusinessException businessException) {
		if (newCotisation.getValeurs_Caution() < 0) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDER_VALEUR_COTISATION_ERREUR);
		}
	}

	public void validerNbrEmprunts_Caution(Cotisation newCotisation, BusinessException businessException) {
		if (newCotisation.getValeurs_Caution() < 0) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDER_NBR_EMPRUNT_COTISATION_ERREUR);
		}

	}
}
