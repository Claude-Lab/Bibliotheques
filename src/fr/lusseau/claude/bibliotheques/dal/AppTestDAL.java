package fr.lusseau.claude.bibliotheques.dal;

import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Personne;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;
import fr.lusseau.claude.bibliotheques.dal.DAO.PersonneDAO;

//import java.util.List;
//
//import fr.claudelusseau.bibliotheque.bo.Livre;

public class AppTestDAL {

	public static void main(String[] args) throws DALException, BusinessException {

//		LivreDAOJdbcImpl daoLivre = new LivreDAOJdbcImpl();
//
//		List<Livre> livres = null;
//		try {
//			livres = daoLivre.selectAll();
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (livres != null) {
//			for (Livre l : livres) {
//				System.out.println(l);
//			}
//		}

		PersonneDAO daoPersonne = DAOFactory.getPersonneDAO();

		List<Personne> personnes = null;
		try {
			personnes = daoPersonne.selectAll();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if (personnes != null) {
			for (Personne p : personnes) {
				System.out.println(p);
			}
		}

	}

}
