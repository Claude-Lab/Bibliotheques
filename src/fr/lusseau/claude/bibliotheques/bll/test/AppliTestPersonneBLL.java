package fr.lusseau.claude.bibliotheques.bll.test;

import java.sql.Timestamp;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bll.BLLException;
import fr.lusseau.claude.bibliotheques.bll.PersonneManager;
import fr.lusseau.claude.bibliotheques.bo.Personne;
import fr.lusseau.claude.bibliotheques.dal.DALException;

public class AppliTestPersonneBLL {

	public static void main(String[] args) throws BusinessException, DALException {

//		addBibliotheque("Bibliothèque municipale de Cleunay", "2 Rue André Trasbot", "35000","RENNES", "02 23 62 26 70", "cleunay@rennes.fr" );
//		addBibliotheque("Bibliothèque municipale de Cleunay", "2 Rue André Trasbot", "35000","RENNES", "02 23 62 26 70", "cleunay@rennes.fr" );
//		addBibliotheque("Bibliothèque municipale de Cleunay", "2 Rue André Trasbot", "35000","RENNES", "02 23 62 26 70", "cleunay@rennes.fr" );
//		addBibliotheque("Bibliothèque municipale de Cleunay", "2 Rue André Trasbot", "35000","RENNES", "02 23 62 26 70", "cleunay@rennes.fr" );
//		addBibliotheque("Bibliothèque municipale de Cleunay", "2 Rue André Trasbot", "35000","RENNES", "02 23 62 26 70", "cleunay@rennes.fr" );

//		BibliothequeDAO daoBibliotheque = DAOFactory.getBibliothequeDAO();
//		BibliothequeManager manager = new BibliothequeManager();
//
//		Bibliotheque b = manager.addBibliotheque("Bibliothèque municipale de Cleunay", "2 Rue André Trasbot", "35000",
//				"RENNES", "cleunay@rennes.fr", "02 23 62 26 70");
//
//		try {
//			daoBibliotheque.insert(b);
//		} catch (BusinessException e) {
//			e.printStackTrace();
//		}

//		PersonneDAO daoPersonne = DAOFactory.getPersonneDAO();
//		PersonneDAOJdbcImpl manager = new PersonneDAOJdbcImpl();
		

		int id_Personne = 3;
		String prenom_Personne = "Claude";
		String nom_Personne = "Benoit";
		String adresse_Personne = "1 rue Jeanne Malivel";
		String cp_Personne = "Benoit";
		String ville_Personne = "Benoit";
		String mail_Personne = "Benoit";
		String tel_Personne ="Benoit";
		String motDePasse_Personne ="Benoit";
		int cotisation_Personne = 20;
		String role_Personne = "Benoit";
		String type_Personne = "Benoit";
		Timestamp inscription_Personne = new Timestamp(System.currentTimeMillis());
		
		Personne p = null;
		PersonneManager man = null;
		try {
			man = new PersonneManager();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			p = man.selectById(id_Personne);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println("L'utilisateur Avant modification "+p.toString());
		
		PersonneManager manager = null;
		try {
			manager = new PersonneManager();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Personne personne = null;
		try {
			personne = new Personne(id_Personne,prenom_Personne, nom_Personne, adresse_Personne, cp_Personne, ville_Personne, mail_Personne, tel_Personne, motDePasse_Personne, cotisation_Personne, role_Personne,type_Personne, inscription_Personne);
			personne.setId_Personne(id_Personne);
			personne.setPrenom_Personne(prenom_Personne);
			personne.setNom_Personne(nom_Personne);
			personne.setAdresse_Personne(adresse_Personne);
			personne.setCp_Personne(cp_Personne);
			personne.setVille_Personne(ville_Personne);
			personne.setMail_Personne(mail_Personne);
			personne.setTel_Personne(tel_Personne);
			personne.setMotDePasse_Personne(motDePasse_Personne);
			personne.setCotisation_Personne(cotisation_Personne);
			personne.setRole_Personne(role_Personne);
			personne.setType_Personne(type_Personne);
			personne.setInscription_Personne(inscription_Personne);
			
			manager.updatePersonne(personne);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		PersonneManager mnger = null;
		Personne personneOK = null;
		try {
			mnger = new PersonneManager();
			personneOK = new Personne();
			personneOK = mnger.selectById(id_Personne);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("L'utilisateur après modification "+personneOK.toString());
		
	}

}
