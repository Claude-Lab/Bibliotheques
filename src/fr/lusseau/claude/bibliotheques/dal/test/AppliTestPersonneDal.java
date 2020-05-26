package fr.lusseau.claude.bibliotheques.dal.test;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Personne;
import fr.lusseau.claude.bibliotheques.dal.DALException;
import fr.lusseau.claude.bibliotheques.dal.jdbc.PersonneDAOJdbcImpl;

public class AppliTestPersonneDal {

	public static void main(String[] args) throws DALException {

		PersonneDAOJdbcImpl daoPersonne = new PersonneDAOJdbcImpl();
		// PersonneDAO daoPersonne = new PersonneDAOJdbcImpl();
		//PersonneDAO daoPersonne = DAOFactory.getPersonneDAO();

		// Init
//		Personne p1 = new Personne("Thomas", "Serre", "124 Avenue Delcassé", "33610" ,"Cestas", "thomasserre@gmail.com", "06 37 28 59 34", "aeaeae", 2, null, null, null);
//		Personne p2 = new Personne("Guillaume", "Fouquet", "196 Rue Aimé-Morot", "68690", "Moosch", "guillaumefouquet@gmail.com", "06 37 68 45 15", "aeaeae", 2, null, null, null);
//		Personne p3 = new Personne("Théo", "Legrand", "147 Place Georges-Guillaumin","42340","Veauchette", "theolegrand@gmail.com", "06 14 26 93 35", "aeaeae", 3, null, null, null);
//		Personne p4 = new Personne("Claude", "Lusseau", "17 rue Paul Bert", "35000", "Rennes", "claude.lusseau@yahoo.fr", "06 22 05 50 42", "aeaeae", 1, null, null, null);
		
		
//		System.out.println("Ajout des Personnes... ");
//		// Add Person
//		try {
//			daoPersonne.update(p1);
//			System.out.println("Personne ajoutée  : " + p1.toString() );
//			daoPersonne.update(p2);
//			System.out.println("Personne ajoutée  : " + p2.toString() );
//			daoPersonne.update(p3);
//			System.out.println("Personne ajoutée  : " + p3.toString() );
//			daoPersonne.update(p4);
//			System.out.println("Personne ajoutée  : " + p4.toString() );
//			
//		} catch (BusinessException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("Liste des Personnes... ");
//		// Liste Personnes
//		List<Personne> personnes = null;
//		try {
//			personnes = daoPersonne.selectAll();
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (personnes != null) {
//			for (Personne p : personnes) {
//				System.out.println(p);
//				;
//			}
//		}
//
//		int nbrPersonne = 0;
//
//		try {
//			nbrPersonne = daoPersonne.countPerson();
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.println("Le nombre de personnes utilisant la base est de " + nbrPersonne+" personnes.");
		
		int id_Personne = 3;
		Personne personne = null;
		
		try {
			personne = daoPersonne.selectById(id_Personne);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String prenom = personne.getPrenom_Personne();
		
		System.out.println("le prenom de l'utilisateur est"+prenom);

	}

}