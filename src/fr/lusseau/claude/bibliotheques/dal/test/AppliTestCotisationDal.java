package fr.lusseau.claude.bibliotheques.dal.test;

import java.util.List;

import fr.lusseau.claude.bibliotheques.bo.Cotisation;
import fr.lusseau.claude.bibliotheques.dal.DALException;
import fr.lusseau.claude.bibliotheques.dal.DAO.CotisationDAO;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;

public class AppliTestCotisationDal {

	public static void main(String[] args) throws DALException {

		CotisationDAO cotisationDAO = DAOFactory.getCotisationDAO();
		// CotisationDAOJdbcImpl cotisationDAO = new CotisationDAOJdbcImpl();
		// CotisationDAO cotisationDAO = new CotisationDAOJdbcImpl();

		Cotisation c1 = new Cotisation(0, 0);
		Cotisation c2 = new Cotisation(10, 1);
		Cotisation c3 = new Cotisation(20, 2);
		Cotisation c4 = new Cotisation(30, 3);
		Cotisation c5 = new Cotisation(40, 4);
		Cotisation c6 = new Cotisation(50, 5);

		System.out.println("Ajout des cotisations... ");

		try {
			cotisationDAO.insert(c1);
			System.out.println("Cotisation ajoutée : " + c1.toString());
			cotisationDAO.insert(c2);
			System.out.println("Cotisation ajoutée : " + c2.toString());
			cotisationDAO.insert(c3);
			System.out.println("Cotisation ajoutée : " + c3.toString());
			cotisationDAO.insert(c4);
			System.out.println("Cotisation ajoutée : " + c4.toString());
			cotisationDAO.insert(c5);
			System.out.println("Cotisation ajoutée : " + c5.toString());
			cotisationDAO.insert(c6);
			System.out.println("Cotisation ajoutée : " + c6.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

			System.out.println("Liste des cotisations... ");

			List<Cotisation> cotisations = null;
			try {
				cotisations = cotisationDAO.selectAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (cotisations != null) {
				for (Cotisation c : cotisations) {
					System.out.println(c);
				}
			}
		

	}
}
