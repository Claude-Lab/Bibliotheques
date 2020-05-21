package fr.lusseau.claude.bibliotheques.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.lusseau.claude.bibliotheques.bo.Role;
import fr.lusseau.claude.bibliotheques.dal.BusinessException;
import fr.lusseau.claude.bibliotheques.dal.DAO.RoleDAO;
import fr.lusseau.claude.bibliotheques.servlets.CodesResultatDAL;

/*
 * @author Claude Lusseau
 * 
 */

public class RoleDAOJdbcImpl implements RoleDAO {

	private static final String sqlInsert = "INSERT INTO ROLES (type_Role) VALUES (?)";

	private static final String sqlupdate = "UPDATE ROLES SET type_Role=?";

	private static final String sqlDelete = "DELETE FROM ROLES WHERE id_Role=?";

	private static final String sqlSelectAll = "SELECT * FROM ROLES";

	
	public void insert(Role data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;

		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ROLE_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, data.getType_Role());

			int nbRows = pstmt.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					data.setId_Role(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Role == null")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_ROLE_ECHEC);
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

	
	public void update(Role data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;

		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_ROLE_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlupdate);
			pstmt.setString(1, data.getType_Role());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Role == null")) {
				businessException.ajouterErreur(CodesResultatDAL.UPDATE_ROLE_ECHEC);
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
			businessException.ajouterErreur(CodesResultatDAL.DELETE_ROLE_NULL);
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
			if (e.getMessage().contains("id_Role == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.DELETE_ROLE_ECHEC);
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

	
	public List<Role> selectAll() throws BusinessException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Role> roles = new ArrayList<Role>();

		try {
			con = ConnectionProvider.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlSelectAll);
			Role r = null;
			while (rs.next()) {
				r = new Role(rs.getInt("id_Role"), rs.getString("type_Role"));
				roles.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Role == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_ROLE_ECHEC);
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
		return roles;
	}

}
