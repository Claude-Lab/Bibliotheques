package fr.lusseau.claude.bibliotheques.dal.DAO;

import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Auteur;

public interface AuteurDAO {
	
	public void insert(Auteur data) throws BusinessException;
	
	public void update(Auteur data) throws BusinessException;
	
	public void delete(int id) throws BusinessException;
	
	public List<Auteur> selectAll() throws BusinessException;
	
	public List<Auteur> selectByAuteur(String data) throws BusinessException;

}
