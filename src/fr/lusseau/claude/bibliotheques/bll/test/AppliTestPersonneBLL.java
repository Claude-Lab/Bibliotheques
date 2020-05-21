package fr.lusseau.claude.bibliotheques.bll.test;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bll.BibliothequeManager;
import fr.lusseau.claude.bibliotheques.bo.Bibliotheque;
import fr.lusseau.claude.bibliotheques.dal.DAO.BibliothequeDAO;
import fr.lusseau.claude.bibliotheques.dal.DAO.DAOFactory;

public class AppliTestPersonneBLL {

	public static void main(String[] args) throws BusinessException {

//		addBibliotheque("Bibliothèque municipale de Cleunay", "2 Rue André Trasbot", "35000","RENNES", "02 23 62 26 70", "cleunay@rennes.fr" );
//		addBibliotheque("Bibliothèque municipale de Cleunay", "2 Rue André Trasbot", "35000","RENNES", "02 23 62 26 70", "cleunay@rennes.fr" );
//		addBibliotheque("Bibliothèque municipale de Cleunay", "2 Rue André Trasbot", "35000","RENNES", "02 23 62 26 70", "cleunay@rennes.fr" );
//		addBibliotheque("Bibliothèque municipale de Cleunay", "2 Rue André Trasbot", "35000","RENNES", "02 23 62 26 70", "cleunay@rennes.fr" );
//		addBibliotheque("Bibliothèque municipale de Cleunay", "2 Rue André Trasbot", "35000","RENNES", "02 23 62 26 70", "cleunay@rennes.fr" );

		BibliothequeDAO daoBibliotheque = DAOFactory.getBibliothequeDAO();
		BibliothequeManager manager = new BibliothequeManager();

		Bibliotheque b = manager.addBibliotheque("Bibliothèque municipale de Cleunay", "2 Rue André Trasbot", "35000",
				"RENNES", "cleunay@rennes.fr", "02 23 62 26 70");

		try {
			daoBibliotheque.insert(b);
//			daoBibliotheque.insert(b2);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
