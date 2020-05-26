package fr.lusseau.claude.bibliotheques.dal.DAO;

import java.sql.SQLException;
import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Personne;

/**
 * Classe en charge de
 * @version Bibliotheques -v1,0
 * @date  13 mai 2020 - 11:31:21
 * @author Claude LUSSEAU
 *
 */
public interface PersonneDAO {
	
	/**
	 * Methode en charge de chercher si un mail existe déjaà en base.
	 * @param mail_Personne
	 * @return
	 * @throws BusinessException
	 */
	public Personne rechercherMail(String mail_Personne) throws BusinessException;
	/**
	 * Methode en charge de lister tous les clients.
	 * @return
	 * @throws BusinessException
	 */
	public List<Personne> selectAllClients() throws BusinessException;
	
	/**
	 * Methode en charge de lister tous les salariés.
	 * @return
	 * @throws BusinessException
	 */
	public List<Personne> selectAllSalaries() throws BusinessException;
	
	/**
	 * Methode en charge de selectionner une personne par son ID.
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public Personne selectById(int id_Personne) throws BusinessException;
	
	/**
	 * Methode en charge de mettre à jours une personne.
	 * @param data
	 * @return 
	 * @throws BusinessException
	 */
	public void update(Personne data) throws BusinessException;
	
	/**
	 * Methode en charge d'inserer une personne.
	 * @param data
	 * @throws BusinessException
	 */
	public void insert(Personne data) throws BusinessException;
	
	/**
	 * Methode en charge de supprimer une personne.
	 * @param id_Personne
	 * @throws BusinessException
	 */
	public void delete(int id_Personne) throws BusinessException;
	
	/**
	 * Methode en charge de lister par nom.
	 * @param data
	 * @return
	 * @throws BusinessException
	 */
	public List<Personne> selectByName(String nom_Personne) throws BusinessException;


	/**
	 * Methode en charge de lister toutes les personnes.
	 * @return
	 */
	public List<Personne> selectAll() throws BusinessException;
	
	/**
	 * Methode en charge de compter le nombres de personnes inscrites en base.
	 * @return
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public int countPerson() throws BusinessException;
	
	/**
	 * Methode en charge de faire une requete pour selectionner une personne par son mail (connexion :: Session).
	 * @param data
	 * @return
	 * @throws BusinessException
	 */
	public Personne selectByMail(String data) throws BusinessException;
	
	/**
	 * Methode en charge de la connection des personnes.
	 * @param data
	 * @return
	 * @throws BusinessException
	 */
	public Personne login(String mail_Personne, String motDePasse_Personne) throws BusinessException;

}
