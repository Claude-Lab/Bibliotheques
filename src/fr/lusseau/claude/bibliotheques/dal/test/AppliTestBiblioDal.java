package fr.lusseau.claude.bibliotheques.dal.test;

import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Bibliotheque;
import fr.lusseau.claude.bibliotheques.dal.DAO.BibliothequeDAO;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;

public class AppliTestBiblioDal {

	public static void main(String[] args) {

		BibliothequeDAO bibliothequeDAO = DAOFactory.getBibliothequeDAO();

		Bibliotheque b1 = new Bibliotheque("Bibliothèque municipale de Cleunay", "2 Rue André Trasbot", "35000","RENNES", "cleunay@rennes.fr", "02 23 62 26 70" );
		Bibliotheque b2 = new Bibliotheque("Bibliothèque municipale Clôteaux-Bréquigny", "84 Rue d'Angleterre", "35000","RENNES", "brequigny@rennes.fr", "02 23 62 26 91" );
		Bibliotheque b3 = new Bibliotheque("Bibliothèque municipale La Bellangerais", "5 Rue du Morbihan", "35000","RENNES", "bellengerais@rennes.fr", "02 23 62 26 40");
		Bibliotheque b4 = new Bibliotheque("Bibliothèque municipale Landry", "100 Rue de Châteaugiron", "35200","RENNES", "landry@rennes.fr", "02 23 62 26 39");
		Bibliotheque b5 = new Bibliotheque("Bibliothèque municipale Longs-Champs", "60 Rue Doyen Albert Bouzat", "35700","RENNES", "longs-champs@rennes.fr", "02 23 62 26 36");

		try {
			bibliothequeDAO.insert(b1);
			System.out.println("Cotisation ajoutée : " + b1.toString());
			bibliothequeDAO.insert(b2);
			System.out.println("Cotisation ajoutée : " + b2.toString());
			bibliothequeDAO.insert(b3);
			System.out.println("Cotisation ajoutée : " + b3.toString());
			bibliothequeDAO.insert(b4);
			System.out.println("Cotisation ajoutée : " + b4.toString());
			bibliothequeDAO.insert(b5);
			System.out.println("Cotisation ajoutée : " + b5.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Liste des cotisations... ");
		
		

		List<Bibliotheque> bibliotheques = null;
		try {
			bibliotheques = bibliothequeDAO.selectAll();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if (bibliotheques != null) {
			for (Bibliotheque b : bibliotheques) {
				System.out.println(b);
			}
		}
		return;
	

	}

}
