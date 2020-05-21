package fr.lusseau.claude.bibliotheques.dal.test;

import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Personne;
import fr.lusseau.claude.bibliotheques.dal.DALException;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;
import fr.lusseau.claude.bibliotheques.dal.DAO.PersonneDAO;

public class AppliTestPersonneDal {

	public static void main(String[] args) throws DALException {

		// PersonneDAOJdbcImpl daoPersonne = new PersonneDAOJdbcImpl();
		// PersonneDAO daoPersonne = new PersonneDAOJdbcImpl();
		PersonneDAO daoPersonne = DAOFactory.getPersonneDAO();

		// Init
//		Personne p1 = new Client("Thomas", "Serre", "124 Avenue Delcassé", "33610" ,"Cestas", "thomasserre@gmail.com", "06 37 28 59 34", "5jl6xYdT", 1);
//		Personne p2 = new Client("Guillaume", "Fouquet", "196 Rue Aimé-Morot", "68690", "Moosch", "guillaumefouquet@gmail.com", "06 37 68 45 15", "VGLYmHUP", 2);
//		Personne p3 = new Client("Théo", "Legrand", "147 Place Georges-Guillaumin","42340","Veauchette", "theolegrand@gmail.com", "06 14 26 93 35", "b2@Yb7Ht", 3);
//		Personne p4 = new Salarie("Claude", "Lusseau", "17 rue Paul Bert", "35000", "Rennes", "claude.lusseau@yahoo.fr", "06 22 05 50 42", "pouiki35", 1);
//		
//		System.out.println("Ajout des Personnes... ");
//		// Add Person
//		try {
//			daoPersonne.insert(p1);
//			System.out.println("Personne ajoutée  : " + p1.toString() );
//			daoPersonne.insert(p2);
//			System.out.println("Personne ajoutée  : " + p2.toString() );
//			daoPersonne.insert(p3);
//			System.out.println("Personne ajoutée  : " + p3.toString() );
//			daoPersonne.insert(p4);
//			System.out.println("Personne ajoutée  : " + p4.toString() );
//			
//		} catch (DALException e) {
//			e.printStackTrace();
//		}

		System.out.println("Liste des Personnes... ");
		// Liste Personnes
		List<Personne> personnes = null;
		try {
			personnes = daoPersonne.selectAll();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (personnes != null) {
			for (Personne p : personnes) {
				System.out.println(p);
				;
			}
		}

		int nbrPersonne = 0;

		try {
			nbrPersonne = daoPersonne.countPerson();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Le nombre de personnes utilisant la base est de " + nbrPersonne+" personnes.");

	}

}