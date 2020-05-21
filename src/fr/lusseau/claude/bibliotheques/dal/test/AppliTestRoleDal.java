package fr.lusseau.claude.bibliotheques.dal.test;

import java.util.List;

import fr.lusseau.claude.bibliotheques.bo.Role;
import fr.lusseau.claude.bibliotheques.dal.BusinessException;
import fr.lusseau.claude.bibliotheques.dal.DALException;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;
import fr.lusseau.claude.bibliotheques.dal.DAO.RoleDAO;

public class AppliTestRoleDal {

	public static void main(String[] args) throws BusinessException, DALException{

		RoleDAO roleDAO = DAOFactory.getRoleDAO();

		// Jeux d'essais
		Role r1 = new Role("SuperAdmin");
		Role r2 = new Role("Admin");
		Role r3 = new Role("Salarie");
		Role r4 = new Role("Client");
		Role r5 = new Role("Visiteur");

		System.out.println("Ajout des Roles... ");
		roleDAO.insert(r1);
		System.out.println(r1.toString());
		roleDAO.insert(r2);
		System.out.println(r2.toString());
		roleDAO.insert(r3);
		System.out.println(r3.toString());
		roleDAO.insert(r4);
		System.out.println(r4.toString());
		roleDAO.insert(r5);
		System.out.println(r5.toString());

		System.out.println("Liste des Roles... ");
		// List Role
		List<Role> roles = null;
		roles = roleDAO.selectAll();
		if (roles != null) {
			for (Role r : roles) {
				System.out.println(r);

			}
		}
	}
}
