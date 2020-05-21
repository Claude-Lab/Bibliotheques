package fr.lusseau.claude.bibliotheques.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Cotisation;
import fr.lusseau.claude.bibliotheques.dal.DAO.CotisationDAO;
import fr.lusseau.claude.bibliotheques.servlets.CodesResultatDAL;

public class CotisationDAOJdbcImpl implements CotisationDAO {

	private static final String sqlInsert = "INSERT INTO CAUTIONS (valeurs_Caution, nbrEmprunts_Caution) VALUES (?,?)";

	private static final String sqlupdate = "UPDATE CAUTIONS SET valeurs_Caution=? nbrEmprunts_Caution =?";

	private static final String sqlDelete = "DELETE FROM CAUTIONS WHERE id_Caution=?";

	private static final String sqlSelectAll = "SELECT id_Caution, valeurs_Caution, nbrEmprunts_Caution FROM CAUTIONS";

	@Override
	public void insert(Cotisation data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;

		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_COTISATION_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, data.getValeurs_Caution());
			pstmt.setInt(2, data.getNbrEmprunts_Caution());

			int nbRows = pstmt.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					data.setId_Caution(rs.getInt(1));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Caution == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_COTISATION_ECHEC);
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

	@Override
	public void update(Cotisation data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;

		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_COTISATION_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlupdate);
			pstmt.setInt(1, data.getValeurs_Caution());
			pstmt.setInt(2, data.getNbrEmprunts_Caution());

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Caution == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.UPDATE_COTISATION_ECHEC);
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

	@Override
	public void delete(int id) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;

		if (id == 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_COTISATION_NULL);
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
			if (e.getMessage().contains("id_Caution == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.DELETE_COTISATION_ECHEC);
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

	@Override
	public List<Cotisation> selectAll() throws BusinessException {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Cotisation> cotisation = new ArrayList<Cotisation>();

		try {
			con = ConnectionProvider.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlSelectAll);
			Cotisation c = null;
			while (rs.next()) {
				c = new Cotisation(rs.getInt("id_Caution"), rs.getInt("valeurs_Caution"),
						rs.getInt("nbrEmprunts_Caution"));
				cotisation.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_COTISATION_ECHEC);
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
		return cotisation;
	}

}
