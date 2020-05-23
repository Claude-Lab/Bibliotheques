package fr.lusseau.claude.bibliotheques.bll;

import java.time.LocalDate;
import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Personne;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;
import fr.lusseau.claude.bibliotheques.dal.DAO.PersonneDAO;

/**
 * Classe en charge de l'insertion des personnes en base.
 * 
 * @version Bibliotheques -v1,0
 * @date 13 mai 2020 - 13:06:40
 * @author Claude LUSSEAU
 *
 */
public class PersonneManager {

	/**
	 * initiate DAO.
	 */
	private PersonneDAO daoPersonne;

	/**
	 * Constructeur.
	 */
	public PersonneManager() {
		this.daoPersonne = DAOFactory.getPersonneDAO();
	}

	/**
	 * Methode en charge d'ajouter les salariés en base.
	 * 
	 * @param prenom_Personne
	 * @param nom_Personne
	 * @param adresse_Personne
	 * @param cp_Personne
	 * @param ville_Personne
	 * @param mail_Personne
	 * @param tel_Personne
	 * @param motDePasse_Personne
	 * @param cotisation_Personne
	 * @param role_Personne
	 * @param type_Personne
	 * @param inscription_Personne
	 * @return
	 * @throws BLLException
	 * @throws BusinessException
	 */
	public Personne addPersonne(String prenom_Personne, String nom_Personne, String adresse_Personne,
			String cp_Personne, String ville_Personne, String mail_Personne, String tel_Personne, String motDePasse_Personne, int cotisation_Personne, String role_Personne, String type_Personne, LocalDate inscription_Personne)
			throws BLLException, BusinessException {

		BusinessException businessException = new BusinessException();

		Personne newSalarie = new Personne(prenom_Personne, nom_Personne, adresse_Personne, cp_Personne,
				ville_Personne, mail_Personne, tel_Personne, motDePasse_Personne, cotisation_Personne, role_Personne, type_Personne, inscription_Personne);
		

			this.validerPersonne(newSalarie, businessException);

			if (!businessException.hasErreurs()) {
				this.daoPersonne.insert(newSalarie);
			}

			if (businessException.hasErreurs()) {
				throw businessException;
			}
		return newSalarie;
	}


	/**
	 * Methode en charge de compter le nombre d'inscrit en base.
	 * 
	 * @return
	 * @throws BLLException
	 */
	public int compterPerson() throws BLLException {
		int value = 0;
		try {
			value = daoPersonne.countPerson();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (value != 0) {
			System.out.println(value);
		}
		return value;
	}
	
	/**
	 * Methode en charge de compter le nombre d'inscrit en base.
	 * 
	 * @return
	 * @throws BLLException
	 */
	public Personne rechercherMail(String mail_Personne) throws BLLException {
		Personne value = null;
		try {
			value = daoPersonne.rechercherMail(mail_Personne);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (value != null) {
			System.out.println(value);
		}
		return value;
	}

	/**
	 * @return
	 * @throws BLLException
	 */
	public Personne connexionPersonne(String mail_Personne, String motDePasse_Personne) throws BLLException {
		Personne personne = null;

		try {
			personne = daoPersonne.login(mail_Personne, motDePasse_Personne);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if (personne != null) {

			return personne;
		}
		return personne;
	}

	
	/**
	 * Methode en charge de récuperer les informations d'une personne.
	 * @return
	 * @throws BLLException
	 */
	public Personne selectByMail(String data) throws BLLException {
		Personne value = null;

		try {
			value = daoPersonne.selectByMail(data);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	/**
	 * Methode en charge de la selection de toutes les personnes
	 * @return
	 * @throws BLLException
	 */
	public List<Personne> allPersonne() throws BLLException{
		List<Personne> personnes = null;

		try {
			personnes = daoPersonne.selectAll();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return personnes;
	}
	
	/**
	 * Methode en charge de la selection de tous les salariés.
	 * @return
	 * @throws BLLException
	 */
	public List<Personne> allSalaries() throws BLLException{
		List<Personne> salaries = null;

		try {
			salaries = daoPersonne.selectAllSalaries();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return salaries;
	}
	
	/**
	 * Methode en charge de la selection de tous les salariés.
	 * @return
	 * @throws BLLException
	 */
	public List<Personne> allClients() throws BLLException{
		List<Personne> clients = null;

		try {
			clients = daoPersonne.selectAllClients();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return clients;
	}
	
	/**
	 * Methode en charge de supprimer un salarié.
	 * 
	 * @return
	 * @throws BLLException
	 */
	public Personne delPersonne(int id) throws BLLException, BusinessException {

		BusinessException businessException = new BusinessException();

		Personne personne = new Personne();

			if (!businessException.hasErreurs()) {
				this.daoPersonne.delete(id);
			}

			if (businessException.hasErreurs()) {
				throw businessException;
			}
		
		return personne;
	}
	
	


	/**
	 * Methode en charge de valider les insertions.
	 * 
	 * @param newPersonne
	 * @param businessException
	 * @throws BLLException
	 */
	public void validerPersonne(Personne newPersonne, BusinessException businessException) throws BLLException {
		if (newPersonne.getNom_Personne() == null || newPersonne.getPrenom_Personne() == null
				|| newPersonne.getAdresse_Personne() == null || newPersonne.getCp_Personne() == null
				|| newPersonne.getVille_Personne() == null || newPersonne.getMail_Personne() == null) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDER_PERSONNE_ERREUR);
		}
	}

}
