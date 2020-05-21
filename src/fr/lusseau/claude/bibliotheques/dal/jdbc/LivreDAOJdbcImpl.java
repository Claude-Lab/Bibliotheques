package fr.lusseau.claude.bibliotheques.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.lusseau.claude.bibliotheques.bo.Auteur;
import fr.lusseau.claude.bibliotheques.bo.Bibliotheque;
import fr.lusseau.claude.bibliotheques.bo.Editeur;
import fr.lusseau.claude.bibliotheques.bo.Livre;
import fr.lusseau.claude.bibliotheques.dal.BusinessException;
import fr.lusseau.claude.bibliotheques.dal.DAO.LivreDAO;
import fr.lusseau.claude.bibliotheques.servlets.CodesResultatDAL;

public class LivreDAOJdbcImpl implements LivreDAO {

	private static final String sqlSelectById = "SELECT id_Livre, titre_Livre, dateAchat_Livre, isbn_Livre, description_Livre, nom_Biblio, usage_Etat, nom_Editeur, GROUP_CONCAT(DISTINCT AUTEURS.prenom_Nom_Auteur ORDER BY AUTEURS.prenom_Nom_Auteur DESC SEPARATOR \", \") "
			+ "FROM LIVRES " + "LEFT JOIN AUTEURS ON AUTEURS.id_Auteurs = ECRITS.id_Auteurs "
			+ "LEFT JOIN LIVRES ON LIVRES.id_Livre = ECRITS.id_Livre "
			+ "LEFT JOIN EDITEURS ON LIVRES.id_Editeur = EDITEURS.id_Editeur "
			+ "LEFT JOIN BIBLIOTEQUES ON LIVRES.id_Biblio = BIBLIOTEQUES.id_Biblio "
			+ "LEFT JOIN ETAT ON LIVRES.id_Etat = ETAT.id_Etat " + "WHERE id_Livre = ?";

	private static final String sqlSelectAll = "SELECT ECRITS.id_ECRIT, LIVRES.id_Livre, LIVRES.dateAchat_Livre, LIVRES.description_Livre, LIVRES.titre_Livre, EDITEURS.nom_EDITEUR, BIBLIOTEQUES.Nom_BIBLIO, ETAT.usage_ETAT, GROUP_CONCAT(DISTINCT AUTEURS.prenom_Nom_Auteur ORDER BY AUTEURS.prenom_Nom_Auteur DESC SEPARATOR \", \") AS Auteurs, ECRITS.isbn_Ecrit"
			+ "FROM ECRITS" + "JOIN AUTEURS ON ECRITS.id_AUTEUR = AUTEURS.id_AUTEUR"
			+ "JOIN LIVRES ON LIVRES.id_LIVRE = ECRITS.id_LIVRE"
			+ "JOIN EDITEURS ON LIVRES.id_EDITEUR = EDITEURS.id_EDITEUR"
			+ "LEFT JOIN BIBLIOTEQUES ON LIVRES.id_BIBLIO = BIBLIOTEQUES.id_BIBLIO"
			+ "LEFT JOIN ETAT ON LIVRES.id_ETAT = ETAT.id_ETAT" 
			+ "ORDER BY LIVRES.id_Livre";

	private static final String sqlUpdate = "UPDATE LIVRES SET titre_Livre=?, dateAchat_Livre=?, isbn_Livre=?, description_Livre=?, nom_Biblio=?, usage_Etat=?, nom_Editeur=? WHERE id_Livre=?";

	private static final String sqlInsertLivre = "START TRANSACTION; " + "SET autocommit = 0; "
			+ "INSERT INTO AUTEURS (prenom_Nom_Auteur) VALUES (?);" + "SET @id_Auteur = LAST_INSERT_ID();"
			+ "INSERT INTO EDITEURS (nom_Editeur, adresse_Editeur, codePostal_Editeur, ville_Editeur, pays_Editeur, mail_Editeur, tel_Editeur) VALUES (?, ?, ?, ?, ?, ?, ?);"
			+ "SET @id_Editeur = LAST_INSERT_ID();"
			+ "INSERT INTO BIBLIOTEQUES (nom_Biblio, adresse_Biblio, codePostal_Biblio, ville_Biblio, tel_Biblio) VALUES (?, ?, ?, ?, ?);"
			+ "SET @id_Biblio = LAST_INSERT_ID();"
			+ "INSERT INTO LIVRES (titre_Livre, dateAchat_Livre, description_Livre, id_Biblio, id_Etat,id_Editeur) VALUES (?, ?, ?, @id_Biblio, ?, @id_Editeur);"
			+ "SET @id_Livre = LAST_INSERT_ID();"
			+ "INSERT INTO ECRITS (id_Ecrit, id_Livre, id_Auteur, isbn_Ecrit) VALUES (1, @id_Livre , @id_Auteur, ?);"
			+ "COMMIT";

	// private static final String sqlInsert = "INSERT INTO
	// LIVRES(titre_Livre,dateAchat_Livre, description_Livre, nom_Biblio,
	// usage_Etat, nom_Editeur) VALUES (?,?,?,?,?,?)";

	private static final String sqlInsertAuthor = "INSERT INTO AUTEURS (prenom_Nom_Auteur VALUE(?)";

	private static final String sqlInsertEditor = "INSERT INTO EDITEURS (nom_Editeur, adresse_Editeur, codePostal_Editeur, ville_Editeur, pays_Editeur, mail_Editeur, tel_Editeur) VALUES(?,?,?,?,?,?,?)";

	// private static final String sqlInsertEtat = "INSERT INTO ETATS (usage_Etat)
	// VALUES(?)";

	private static final String sqlInsertBiblio = "INSERT INT BIBLIOTHEQUES (nom_Biblio, adresse_Biblio, codePostal_Biblio, ville_Biblio, tel_Biblio) VALUES (?,?,?,?,?)";

	// private static final String sqlInsertEcrit = "INSERT INTO ECRIT (id_Livre,
	// id_Auteur, isbn_Ecrit) VALUE (?,?,?)";

	private static final String sqlDeleteLivre = "DELETE FROM LIVRES WHERE id_Livre=?";

	private static final String sqlSelectByTitle = "SELECT id_Livre, titre_Livre, dateAchat_Livre, isbn_Livre, description_Livre, nom_Biblio, usage_Etat, nom_Editeur, GROUP_CONCAT(AUTEURS.prenom_Nom_Auteur SEPARATOR ',') AS concat_auteurs "
			+ "FROM LIVRES " + "JOIN AUTEURS ON AUTEURS.id_Auteurs = ECRITS.id_Auteurs "
			+ "JOIN LIVRES ON LIVRES.id_Livre = ECRITS.id_Livre "
			+ "JOIN EDITEURS ON LIVRES.id_Editeur = EDITEURS.id_Editeur "
			+ "LEFT JOIN BIBLIOTEQUES ON LIVRES.id_Biblio = BIBLIOTEQUES.id_Biblio "
			+ "LEFT JOIN ETAT ON LIVRES.id_Etat = ETAT.id_Etat " + "WHERE titre_Livre = ?";

	private static final String sqlSelectByAuthor = "SELECT id_Livre, titre_Livre, dateAchat_Livre, isbn_Livre, description_Livre, nom_Biblio, usage_Etat, nom_Editeur, GROUP_CONCAT(AUTEURS.prenom_Nom_Auteur SEPARATOR ',') AS concat_auteurs "
			+ "FROM LIVRES " + "JOIN AUTEURS ON AUTEURS.id_Auteurs = ECRITS.id_Auteurs "
			+ "JOIN LIVRES ON LIVRES.id_Livre = ECRITS.id_Livre "
			+ "JOIN EDITEURS ON LIVRES.id_Editeur = EDITEURS.id_Editeur "
			+ "LEFT JOIN BIBLIOTEQUES ON LIVRES.id_Biblio = BIBLIOTEQUES.id_Biblio "
			+ "LEFT JOIN ETAT ON LIVRES.id_Etat = ETAT.id_Etat " + "WHERE prenom_Nom_Auteur like ?";

	public List<Livre> selectAll() throws BusinessException {
		List<Livre> livres = new ArrayList<Livre>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlSelectAll);
			rs = pstmt.executeQuery();
			Livre l = null;
			while (rs.next()) {
				l = new Livre(rs.getInt("id_Livre"), rs.getString("titre_Livre"), rs.getObject("dateAchat_Livre", LocalDate.class),
						rs.getString("description_Livre"), rs.getString("Auteurs"), rs.getString("isbn_Ecrit"),
						rs.getString("nom_Editeur"), rs.getString("nom_Biblio"), rs.getString("usage_Etat"));
				livres.add(l);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Livre == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_LIVRE_ECHEC);
			}
			throw businessException;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return livres;
	}

	public Livre selectById(int id) throws BusinessException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Livre livre = null;
		if (id == 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_LIVRE_BY_ID_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			stmt = con.createStatement();
			((PreparedStatement) stmt).setInt(1, id);
			rs = stmt.executeQuery(sqlSelectById);

			while (rs.next()) {
				livre = new Livre(rs.getInt("id_Livre"), rs.getString("titre_Livre"),
						rs.getObject("dateAchat_Livre", LocalDate.class), rs.getString("description_Livre"),
						rs.getString("prenom_Nom_Auteur"), rs.getString("isbn_Ecrit"), rs.getString("nom_Bibliotheque"),
						rs.getString("nom_Editeur"), rs.getString("usage_Etat"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Livre == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_LIVRE_BY_ID_ECHEC);
			}
			throw businessException;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return livre;
	}

	public void update(Livre data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlUpdate);
			pstmt.setString(1, data.getTitre_Livre());
			pstmt.setObject(2, data.getDateAchat_Livre(), Types.DATE);
			pstmt.setString(3, data.getDescription_Livre());
			pstmt.setString(5, data.getPrenom_Nom_Auteur());
			pstmt.setString(7, data.getNom_Bibliotheque());
			pstmt.setString(8, data.getNom_Editeur());
			pstmt.setString(9, data.getUsage_Etat());

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Livre == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.UPDATE_LIVRE_ECHEC);
			}
			throw businessException;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void insertAuthor(Auteur data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_AUTEUR_LIVRE_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlInsertAuthor, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, data.getPrenom_Nom_Auteur());
			int nbRows = pstmt.executeUpdate();
			if (nbRows == 1) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					data.setId_Auteur(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Auteur == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_AUTEUR_LIVRE_ECHEC);
			}
			throw businessException;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertEditor(Editeur data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_EDITEUR_LIVRE_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlInsertEditor, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, data.getNom_Editeur());
			pstmt.setString(2, data.getAdresse_Editeur());
			pstmt.setString(3, data.getCp_Editeur());
			pstmt.setString(3, data.getVille_Editeur());
			pstmt.setString(5, data.getPays_Editeur());
			pstmt.setString(6, data.getMail_Editeur());
			pstmt.setString(7, data.getTel_Editeur());
			int nbRows = pstmt.executeUpdate();
			if (nbRows == 1) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					data.setId_Editeur(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Editeur == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_EDITEUR_LIVRE_ECHEC);
			}
			throw businessException;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void insertBiblio(Bibliotheque data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_BIBLIO_LIVRE_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlInsertBiblio, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, data.getNom_Bibliotheque());
			pstmt.setString(2, data.getAdresse_Bibliotheque());
			pstmt.setString(3, data.getCp_Bibliotheque());
			pstmt.setString(4, data.getVille_Bibliotheque());
			pstmt.setString(5, data.getTel_Bibliotheque());
			int nbRows = pstmt.executeUpdate();
			if (nbRows == 1) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					data.setId_Bibliotheque(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Bibliotheque == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_BIBLIO_LIVRE_ECHEC);
			}
			throw businessException;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void insert(Livre data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_LIVRE_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlInsertLivre, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, data.getTitre_Livre());
			pstmt.setObject(2, data.getDateAchat_Livre(), Types.DATE);
			pstmt.setString(3, data.getDescription_Livre());
			pstmt.setString(5, data.getPrenom_Nom_Auteur());
			pstmt.setString(7, data.getNom_Bibliotheque());
			pstmt.setString(8, data.getNom_Editeur());
			pstmt.setString(9, data.getUsage_Etat());
			int nbRows = pstmt.executeUpdate();
			if (nbRows == 1) {
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					data.setId_Livre(rs.getInt(1));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Livre == null")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_LIVRE_ECHEC);
			}
			throw businessException;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void delete(int id) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		if (id == 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_LIVRE_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlDeleteLivre);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Livre == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.DELETE_LIVRE_ECHEC);
			}
			throw businessException;
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Livre> selectByTitle(String data) throws BusinessException {
		List<Livre> livres = new ArrayList<Livre>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionProvider.getConnection();
			stmt = con.createStatement();
			((PreparedStatement) stmt).setString(1, data);
			rs = stmt.executeQuery(sqlSelectByTitle);
			Livre l = null;
			while (rs.next()) {
				l = new Livre(rs.getInt("id_Livre"), rs.getString("titre_Livre"), rs.getObject("dateAchat_Livre", LocalDate.class),
						rs.getString("description_Livre"), rs.getString("prenom_Nom_Auteur"),
						rs.getString("isbn_Ecrit"), rs.getString("nom_Bibliotheque"), rs.getString("nom_Editeur"),
						rs.getString("usage_Etat"));
			}
			livres.add(l);

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Role == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_LIVRE_BY_TITLE_ECHEC);
			}
			throw businessException;
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return livres;
	}

	public List<Livre> selectByAuthor(String data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Livre> listeLivres = new ArrayList<Livre>();
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlSelectByAuthor);
			pstmt.setString(1, data);
			rs = pstmt.executeQuery();
			Livre l = null;
			while (rs.next()) {
				l = new Livre(rs.getInt("id_Livre"), rs.getString("titre_Livre"), rs.getObject("dateAchat_Livre", LocalDate.class),
						rs.getString("description_Livre"), rs.getString("prenom_Nom_Auteur"),
						rs.getString("isbn_Ecrit"), rs.getString("nom_Bibliotheque"), rs.getString("nom_Editeur"),
						rs.getString("usage_Etat"));
			}
			listeLivres.add(l);

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Auteur == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_LIVRE_BY_AUTHORS_ECHEC);
			}
			throw businessException;
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listeLivres;
	}

}
