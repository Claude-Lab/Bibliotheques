package fr.lusseau.claude.bibliotheques.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Auteur;
import fr.lusseau.claude.bibliotheques.dal.DAO.AuteurDAO;
import fr.lusseau.claude.bibliotheques.servlets.CodesResultatDAL;

public class AuteurDAOJdbcImpl implements AuteurDAO {

	private static final String sqlInsert = "INSERT INTO AUTEURS (prenom_Nom_Auteur) VALUE (?)";

	private static final String sqlUpdate = "UPDATE AUTEURS SET prenom_Nom_Auteur=?";

	private static final String sqlDelete = "DELETE FROM AUTEURS WHERE id_Auteur=?";

	private static final String sqlSelectAll = "SELECT * FROM AUTEURS";

	private static final String sqlSortByLivre = "SELECT * FROM AUTEURS";

	public void insert(Auteur data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;

		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_AUTEUR_NULL);
			throw businessException;
		}

		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, data.getPrenom_Nom_Auteur());

			int nbRows = pstmt.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					data.setId_Auteur(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Auteur == null")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_AUTEUR_ECHEC);
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

	public void update(Auteur data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_AUTEUR_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlUpdate);
			pstmt.setString(1, data.getPrenom_Nom_Auteur());

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Auteur == null")) {
				businessException.ajouterErreur(CodesResultatDAL.UPDATE_AUTEUR_ECHEC);
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

	public void delete(int id) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		if (id == 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_AUTEUR_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlDelete);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Auteur == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.DELETE_AUTEUR_ECHEC);
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

	public List<Auteur> selectAll() throws BusinessException {
		List<Auteur> auteur = new ArrayList<Auteur>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = ConnectionProvider.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlSelectAll);
			Auteur a = null;
			while (rs.next()) {
				a = new Auteur(rs.getInt("id_Auteur"), rs.getString("prenom_Nom_Auteur"));
				auteur.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Auteur == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_AUTEUR_ECHEC);
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
		return auteur;
	}

	public List<Auteur> selectByTitle(String data) throws BusinessException {
		List<Auteur> auteur = new ArrayList<Auteur>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionProvider.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlSortByLivre);
			Auteur a = null;
			while (rs.next()) {
				a = new Auteur(rs.getInt("prenom_Nom_Auteur"), rs.getString("titre_Auteur"));
			}
			auteur.add(a);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return auteur;
	}

	/**
	 *
	 *  @return {@inheritDoc} 
	 */
	@Override
	public List<Auteur> selectByAuteur(String data) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
