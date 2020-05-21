package fr.lusseau.claude.bibliotheques.dal.DAO;

import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Editeur;

public interface EditeurDAO {
	
	public void insert(Editeur data) throws BusinessException;
	
	public void update(Editeur data) throws BusinessException;
	
	public void delete(int id) throws BusinessException;
	
	public List<Editeur> selectAll() throws BusinessException;

}
