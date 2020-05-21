package fr.lusseau.claude.bibliotheques.bll;

import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Etat;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;
import fr.lusseau.claude.bibliotheques.dal.DAO.EtatDAO;

public class EtatManager {

	private  EtatDAO daoEtat;

	public EtatManager() {
		this.daoEtat = DAOFactory.getEtatDAO();
	}

	/**
	 * Methode en charge d'ajouter un état d'usure.
	 *
	 * @param newCotisation
	 * @param businessException
	 * @return
	 */
	public Etat addEtat(String usage_Etat) throws BusinessException {

		BusinessException businessException = new BusinessException();

		Etat value = new Etat(usage_Etat);

		this.validerEtat(value, businessException);
	

		if (!businessException.hasErreurs()) {
			this.daoEtat.insert(value);
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
		return value;
	}

	/**
	 * Methode en charge de lister les états d'usure.
	 *
	 * @return
	 * @throws BLLException
	 */
	public List<Etat> allEtat() throws BLLException {
		List<Etat> value = null;
		try {
			value = daoEtat.selectAll();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if (value != null) {
			for (Etat e : value) {
				System.out.println(e);
			}
		}
		return value;
	}

	/**
	 * Methode en charge de supprimer un état d'usure.
	 * 
	 * @return
	 * @throws BLLException
	 */
	public Etat delEtat(int id) throws BLLException, BusinessException {

		BusinessException businessException = new BusinessException();

		Etat value = new Etat();

		if (!businessException.hasErreurs()) {
			this.daoEtat.delete(id);
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
		return value;
	}

	/**
	 * Methode en charge de valider les états d'usure.
	 *
	 * @param c
	 * @param businessException
	 */
	public void validerEtat(Etat value, BusinessException businessException) {
		if (value.getUsage_Etat() == null) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDER_ETAT_ERREUR);
		}
	}

	
}
