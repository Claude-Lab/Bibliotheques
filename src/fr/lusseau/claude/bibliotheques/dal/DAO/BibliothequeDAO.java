package fr.lusseau.claude.bibliotheques.dal.DAO;

import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Bibliotheque;

public interface BibliothequeDAO {
	
	public List<Bibliotheque> selectAll() throws BusinessException;
	
	public Bibliotheque selectById(int id) throws BusinessException;
	
	public void update(Bibliotheque data) throws BusinessException;
	
	public void insert(Bibliotheque data) throws BusinessException;
	
	public void delete(int id) throws BusinessException;
	
	public List<Bibliotheque> selectByName(String data) throws BusinessException;

}
