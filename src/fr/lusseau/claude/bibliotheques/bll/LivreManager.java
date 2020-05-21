package fr.lusseau.claude.bibliotheques.bll;

import java.time.LocalDate;
import java.util.List;

import fr.lusseau.claude.bibliotheques.bo.Livre;
import fr.lusseau.claude.bibliotheques.dal.BusinessException;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;
import fr.lusseau.claude.bibliotheques.dal.DAO.LivreDAO;

/*
 * @author Claude Lusseau
 * 
 */
public class LivreManager {

	private LivreDAO daoLivre;

	public LivreManager() {
		this.daoLivre = DAOFactory.getLivreDAO();
	}


	public List<Livre> getCatalogue() throws BLLException {
		List<Livre> livres = null;
		try {
			livres = daoLivre.selectAll();
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new BLLException("Erreur récupération catalogue", e);
		}

		return livres;
	}

	public Livre addLivre(String titre_Livre, LocalDate dateAchat_Livre, String description_Livre,
			String prenom_Nom_Auteur, String isbn_Ecrit, String nom_Edideur, String nom_Bibliotheque, String usage_Etat)
					throws BLLException, BusinessException {

		Livre livre = new Livre(titre_Livre, dateAchat_Livre, description_Livre, prenom_Nom_Auteur, isbn_Ecrit,
				nom_Edideur, nom_Bibliotheque, usage_Etat);
		if (livre.getId_Livre() != null) {
			throw new BLLException("Livre déjà existant en base");
		}

		validerLivre(livre);
		try {
			daoLivre.insert(livre);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return livre;
	}
	
	/**
	 * Methode en charge de
	 * @param id
	 * @return
	 * @throws BLLException
	 * @throws BusinessException
	 */
	public Livre delLivre(int id) throws BLLException, BusinessException {

		BusinessException businessException = new BusinessException();

		Livre livre = new Livre();

		if (!businessException.hasErreurs()) {
			try {
				this.daoLivre.delete(id);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
		return livre;
	}


	public List<Livre> allLivre() throws BLLException {
		List<Livre> listeLivres = null;
		try {
			listeLivres = daoLivre.selectAll();
		} catch (BusinessException e) {
			e.printStackTrace();
			throw new BLLException("Erreur lors de la récupération de la liste complète des emprunts", e);
		}

		return listeLivres;
	}

	public void validerLivre(Livre l) throws BLLException {
		boolean valide = true;
		StringBuffer buffer = new StringBuffer();
		// LocalDate dateAchat =
		// l.getDateAchat_Livre().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		// obligation des attribut à la saisie

		if (l.getTitre_Livre() == null) {
			buffer.append("la saisie du titre du livre est obligatoire");
			valide = false;
		}

		if (l.getDateAchat_Livre() == null) {
			buffer.append("la saisie de la date d'achat du livre est obligatoire");
			valide = false;
		}

		if (l.getDescription_Livre() == null) {
			buffer.append("la saisie d'une description du livre est obligatoire");
			valide = false;
		}

		if (l.getPrenom_Nom_Auteur() == null) {
			buffer.append("la saisie du nom d'un auteur du livre est obligatoire");
			valide = false;
		}

		if (l.getNom_Bibliotheque() == null) {
			buffer.append("la saisie de la bibliotheque où ce trouve le livre est obligatoire");
			valide = false;
		}

		if (l.getNom_Editeur() == null) {
			buffer.append("la saisie de l'editeur du livre est obligatoire");
			valide = false;
		}

		if (l.getUsage_Etat() == null) {
			buffer.append("la saisie de l'état du livre est obligatoire");
			valide = false;
		}

		if (!valide || l == null) {
			throw new BLLException(buffer.toString());
		}
	}

}
