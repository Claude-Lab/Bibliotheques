package fr.lusseau.claude.bibliotheques.dal.DAO;

import java.util.List;

import fr.lusseau.claude.bibliotheques.bo.Auteur;
import fr.lusseau.claude.bibliotheques.bo.Editeur;
import fr.lusseau.claude.bibliotheques.bo.Livre;
import fr.lusseau.claude.bibliotheques.dal.BusinessException;



public interface LivreDAO {
	
	// Sélectionner un Livre par son id_Livre
		public Livre selectById(int id) throws BusinessException;

		// Sélectionner tous les Livre
		public List<Livre> selectAll() throws BusinessException;

		// Modifier les attributs d'un Livre connu en BD
		public void update(Livre data) throws BusinessException;
	 
		// Insérer un nouvel Livre
		public void insert(Livre data) throws BusinessException;
		
		// Insérer un nouvel auteur
		public void insertAuthor(Auteur data) throws BusinessException;
		
		// Insérer un nouvel Editeur
		public void insertEditor(Editeur data) throws BusinessException;

		// Supprimer un Livre
		public void delete(int id) throws BusinessException;

		// On recherche le mot clé par titre
		public List<Livre> selectByTitle(String data) throws BusinessException;

		// On recherche le mot clé dans l'auteur
		public List<Livre> selectByAuthor(String data) throws BusinessException;

}
