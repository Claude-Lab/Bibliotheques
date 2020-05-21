package fr.lusseau.claude.bibliotheques.dal.DAO;

import fr.lusseau.claude.bibliotheques.dal.jdbc.AuteurDAOJdbcImpl;
import fr.lusseau.claude.bibliotheques.dal.jdbc.BibliothequeDAOJdbcImpl;
import fr.lusseau.claude.bibliotheques.dal.jdbc.CotisationDAOJdbcImpl;
import fr.lusseau.claude.bibliotheques.dal.jdbc.EditeurDAOJdbcImpl;
import fr.lusseau.claude.bibliotheques.dal.jdbc.EmpruntDAOJdbcImpl;
import fr.lusseau.claude.bibliotheques.dal.jdbc.EtatDAOJdbcImpl;
import fr.lusseau.claude.bibliotheques.dal.jdbc.LivreDAOJdbcImpl;
import fr.lusseau.claude.bibliotheques.dal.jdbc.PersonneDAOJdbcImpl;
import fr.lusseau.claude.bibliotheques.dal.jdbc.RoleDAOJdbcImpl;

public class DAOFactory {
	
	public static LivreDAO getLivreDAO()  {
		return new LivreDAOJdbcImpl();
	}
	
	public static PersonneDAO getPersonneDAO()  {
		return new PersonneDAOJdbcImpl();
	}
	
	public static BibliothequeDAO getBibliothequeDAO()  {
		return new BibliothequeDAOJdbcImpl();
	}
	
	public static AuteurDAO getAuteurDAO()  {
		return new AuteurDAOJdbcImpl();
	}
	
	public static EtatDAO getEtatDAO()  {
		return new EtatDAOJdbcImpl();
	}
	
	public static RoleDAO getRoleDAO()  {
		return new RoleDAOJdbcImpl();
	}
	
	public static CotisationDAO getCotisationDAO()  {
		return new CotisationDAOJdbcImpl();
	}
	
	public static EditeurDAO getEditeurDAO()  {
		return new EditeurDAOJdbcImpl();
	}
	
	public static EmpruntDAO getEmpruntDAO()  {
		return new EmpruntDAOJdbcImpl();
	}
	

}
