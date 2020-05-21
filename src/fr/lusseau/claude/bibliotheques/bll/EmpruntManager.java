package fr.lusseau.claude.bibliotheques.bll;

import java.time.LocalDate;
import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Emprunt;
import fr.lusseau.claude.bibliotheques.dal.DALException;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;
import fr.lusseau.claude.bibliotheques.dal.DAO.EmpruntDAO;

/**
 * 
 * @author Claude Lusseau
 *
 */
public class EmpruntManager {

	private EmpruntDAO daoEmprunt;

	public EmpruntManager() throws BLLException {
		// Instantiation du DAO
		daoEmprunt = DAOFactory.getEmpruntDAO();
	}

	public List<Emprunt> allEmprunt() throws BLLException {
		List<Emprunt> emprunts = null;
		try {
			emprunts = daoEmprunt.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur lors de la récupération de la liste complète des emprunts", e);
		}

		return emprunts;
	}

	public void addEmprunt(Emprunt newEmprunt) throws BLLException {
		if (newEmprunt.getId_Emprunt() != null) {
			throw new BLLException("Enregeistrement d'emprunt deja existant.");
		}
		try {
			validerEmprunt(newEmprunt);
			daoEmprunt.insert(newEmprunt);

		} catch (DALException e) {
			throw new BLLException("Echec de l'ajout d'un emprunt", e);
		}
	}

	/**
	 * Methode en charge de
	 * @param id
	 * @return
	 * @throws BLLException
	 * @throws BusinessException
	 */
	public Emprunt delEmprunt(int id) throws BLLException, BusinessException {

		BusinessException businessException = new BusinessException();

		Emprunt emprunt = new Emprunt();

		if (!businessException.hasErreurs()) {
			try {
				this.daoEmprunt.delete(id);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
		return emprunt;
	}

	public void updateEmprunt(Emprunt newEmprunt) throws BLLException {
		try {
			validerEmprunt(newEmprunt);
			daoEmprunt.update(newEmprunt);

		} catch (DALException e) {
			throw new BLLException("Echec de la modification de l'emprunt", e);
		}
	}

	public List<Emprunt> SortByTitleLivre(String titre) throws BLLException {
		List<Emprunt> emprunts = null;
		try {
			emprunts = daoEmprunt.SortByTitleLivre(titre);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur lors de la récupération de la liste complète des emprunts", e);
		}

		return emprunts;
	}

	public List<Emprunt> SortByPerson(String nom) throws BLLException {
		List<Emprunt> emprunts = null;
		try {
			emprunts = daoEmprunt.SortByPerson(nom);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Erreur lors de la récupération de la liste complète des emprunts", e);
		}

		return emprunts;
	}

	public void validerEmprunt(Emprunt e) throws BLLException {
		boolean valide = true;
		StringBuffer buffer = new StringBuffer();
		LocalDate dateDuJour = LocalDate.now();
		LocalDate dateEmprunt = e.getDateEmprunt();

		// obligation des attribut à la saisie
		if (e.getDateEmprunt() == null || (dateEmprunt.isBefore(dateDuJour))) {
			buffer.append("la saisie de la date de départ du livre est obligatoire");
			valide = false;
		}

		if (e.getDateRetour() == null || (dateEmprunt.isBefore(dateDuJour))) {
			buffer.append("la saisie de la date de retour du livre est obligatoire");
			valide = false;
		}

		if (e.getId_Livre() == 0 || e.getId_Personne() == 0) {
			buffer.append("la saisie de la date de retour du livre est obligatoire");
			valide = false;
		}

		if (!valide || e==null) {
			throw new BLLException(buffer.toString());
		}
	}
}