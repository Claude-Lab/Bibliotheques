package fr.lusseau.claude.bibliotheques.bll;

import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Role;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;
import fr.lusseau.claude.bibliotheques.dal.DAO.RoleDAO;

public class RoleManager {

	private RoleDAO daoRole;

	public RoleManager() {
		this.daoRole = DAOFactory.getRoleDAO();
	}

	public Role addRole(String type_Role) throws BusinessException {

		BusinessException businessException = new BusinessException();

		Role value = new Role(type_Role);

		this.validerRole(value, businessException);

		if (!businessException.hasErreurs()) {
			try {
				this.daoRole.insert(value);
			} catch (fr.lusseau.claude.bibliotheques.dal.BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
		return value;
	}

	public List<Role> allRole() throws BLLException {
		List<Role> roles = null;
		try {
			roles = daoRole.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (roles != null) {
			for (Role r : roles) {
				System.out.println(r);
			}
		}
		return roles;
	}

	public Role delRole(int id) throws BLLException, BusinessException {

		BusinessException businessException = new BusinessException();

		Role role = new Role();

		if (!businessException.hasErreurs()) {
			try {
				this.daoRole.delete(id);
			} catch (fr.lusseau.claude.bibliotheques.dal.BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (businessException.hasErreurs()) {
			throw businessException;
		}
		return role;
	}

	public void validerRole(Role newRole, BusinessException businessException) {

		if (newRole.getType_Role() == null) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_VALIDER_ROLE_ERREUR);
		}
	}

}
