package fr.lusseau.claude.bibliotheques.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Editeur;
import fr.lusseau.claude.bibliotheques.dal.DAO.EditeurDAO;
import fr.lusseau.claude.bibliotheques.servlets.CodesResultatDAL;

public class EditeurDAOJdbcImpl implements EditeurDAO {

	private static final String sqlInsert = "INSERT INTO EDITEURS (usage_Etat) VALUE (?)";

	private static final String sqlUpdate = "UPDATE EDITEURS SET usage_Etat=?";

	private static final String sqlDelete = "DELETE FROM EDITEURS WHERE id_Etat=?";

	private static final String sqlSelectAll = "SELECT * FROM EDITEURS";

	public void insert(Editeur data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;

		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_EDITEUR_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, data.getNom_Editeur());
			pstmt.setString(2, data.getAdresse_Editeur());
			pstmt.setString(3, data.getCp_Editeur());
			pstmt.setString(4, data.getVille_Editeur());
			pstmt.setString(5, data.getPays_Editeur());
			pstmt.setString(6, data.getMail_Editeur());
			pstmt.setString(7, data.getTel_Editeur());

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Editeur == null")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_EDITEUR_ECHEC);
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

	public void update(Editeur data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;

		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_EDITEUR_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlUpdate);
			pstmt.setString(1, data.getNom_Editeur());
			pstmt.setString(2, data.getAdresse_Editeur());
			pstmt.setString(3, data.getCp_Editeur());
			pstmt.setString(4, data.getVille_Editeur());
			pstmt.setString(5, data.getPays_Editeur());
			pstmt.setString(6, data.getMail_Editeur());
			pstmt.setString(7, data.getTel_Editeur());

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Editeur == null")) {
				businessException.ajouterErreur(CodesResultatDAL.UPDATE_EDITEUR_ECHEC);
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
			businessException.ajouterErreur(CodesResultatDAL.DELETE_EDITEUR_NULL);
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
			if (e.getMessage().contains("id_Editeur == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.DELETE_EDITEUR_ECHEC);
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

	public List<Editeur> selectAll() throws BusinessException {
		List<Editeur> editeur = new ArrayList<Editeur>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = ConnectionProvider.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlSelectAll);
			Editeur e = null;
			while (rs.next()) {
				e = new Editeur(rs.getInt("id_Editeur"), rs.getString("nom_Editeur"), rs.getString("adresse_Editeur"),
						rs.getString("codePostal_Editeur"), rs.getString("ville_Editeur"), rs.getString("pays_Editeur"),
						rs.getString("eMail_Editeur"), rs.getString("tel_Editeur"));
				editeur.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Role == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_EDITEUR_ECHEC);
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
		return editeur;
	}

}
