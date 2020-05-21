package fr.lusseau.claude.bibliotheques.dal.DAO;

import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Etat;

public interface EtatDAO {
	
	public void insert(Etat data) throws BusinessException;
	
	public void update(Etat data) throws BusinessException;
	
	public void delete(int id) throws BusinessException;
	
	public List<Etat> selectAll() throws BusinessException;

}
