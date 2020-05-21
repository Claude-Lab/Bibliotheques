package fr.lusseau.claude.bibliotheques.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestAppJdbc {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		// charger le driver JDBC en mémoire
		try {
			try {
				// Chargement depuis la classe Settings
				Class.forName(Settings.getPropery("driver"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Obtenir une connexion - Chargement des infos depuis la calsse Settings
			con = DriverManager.getConnection(Settings.getPropery("url"), Settings.getPropery("username"),
					Settings.getPropery("password"));

			// creation d'un Statement
			stmt = con.createStatement();

			// variable de requete
			ResultSet rs = stmt.executeQuery(
					"SELECT ECRITS.id_ECRIT, LIVRES.titre_Livre, EDITEURS.nom_EDITEUR, BIBLIOTEQUES.Nom_BIBLIO, ETAT.usage_ETAT, AUTEURS.prenom_Nom_AUTEUR, ECRITS.isbn_Ecrit" + 
							"			FROM ECRITS" + 
							"			JOIN AUTEURS ON AUTEURS.id_AUTEUR = ECRITS.id_AUTEUR" + 
							"			JOIN LIVRES ON LIVRES.id_LIVRE = ECRITS.id_LIVRE" + 
							"			JOIN EDITEURS ON LIVRES.id_EDITEUR = EDITEURS.id_EDITEUR" + 
							"			LEFT JOIN BIBLIOTEQUES ON LIVRES.id_BIBLIO = BIBLIOTEQUES.id_BIBLIO" + 
							"			LEFT JOIN ETAT ON LIVRES.id_ETAT = ETAT.id_ETAT" + 
							"			ORDER BY LIVRES.id_Livre");

			
			while (rs.next()) {
				System.out.println("- " + rs.getString("titre_Livre") + " \n\tAuteur : " + rs.getString("prenom_Nom_AUTEUR") + "\n\tBibliothèque : " + rs.getString("Nom_BIBLIO")
						+ " \n\tEtat : " + rs.getString("usage_ETAT") + "\n");
			}
		} catch (SQLException exc) {
			exc.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException exc) {
					exc.printStackTrace();
				}
			}
		}

	}

}
