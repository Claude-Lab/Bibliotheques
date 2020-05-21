package fr.lusseau.claude.bibliotheques.dal.DAO;

import java.util.List;

import fr.lusseau.claude.bibliotheques.bo.Role;
import fr.lusseau.claude.bibliotheques.dal.BusinessException;

public interface RoleDAO {
	
	public void insert(Role data) throws BusinessException;
	
	public void update(Role data) throws BusinessException;
	
	public void delete(int id) throws BusinessException;
	
	public List<Role> selectAll() throws BusinessException;

}
