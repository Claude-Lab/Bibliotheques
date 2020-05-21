package fr.lusseau.claude.bibliotheques.dal.DAO;

import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Cotisation;

public interface CotisationDAO {

	public void insert(Cotisation data) throws BusinessException;

	public void update(Cotisation data) throws BusinessException;

	public void delete(int id) throws BusinessException;

	public List<Cotisation> selectAll() throws BusinessException;

}
