package fr.lusseau.claude.bibliotheques.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Bibliotheque;
import fr.lusseau.claude.bibliotheques.dal.DAO.BibliothequeDAO;
import fr.lusseau.claude.bibliotheques.servlets.CodesResultatDAL;

public class BibliothequeDAOJdbcImpl implements BibliothequeDAO {
	
	private static final String sqlSelectById = "SELECT id_Biblio, nom_Biblio, adresse_Biblio, codePostal_Biblio, ville_Biblio, mail_Biblio, tel_Biblio"
			+ "FROM BIBLIOTHEQUES WHERE id_Biblio = ?";

	private static final String sqlSelectAll = "SELECT id_Biblio, nom_Biblio, adresse_Biblio, codePostal_Biblio, ville_Biblio, mail_Biblio, tel_Biblio FROM BIBLIOTHEQUES ORDER BY id_Biblio DESC";

	private static final String sqlUpdate = "UPDATE BIBLIOTHEQUES SET nom_Biblio=?,adresse_Biblio=?,codePostal_Biblio=?,ville_Biblio=?,mail_Biblio=?,tel_Biblio=?  where id_Biblio=?";
	
	private static final String sqlInsert = "INSERT INTO BIBLIOTHEQUES (nom_Biblio, adresse_Biblio, codePostal_Biblio, ville_Biblio, mail_Biblio, tel_Biblio) VALUES (?,?,?,?,?,?)";
		
	private static final String sqlDelete = "DELETE FROM BIBLIOTHEQUES WHERE id_Biblio=?";
	
	private static final String sqlSelectByLivre = "SELECT nom_Biblio, adresse_Biblio, codePostal_Biblio, ville_Biblio, mail_Biblio, tel_Biblio"
						+ "FROM BIBLIOTHEQUES WHERE nom_Biblio LIKE ?";
	
	

	@Override
	public void insert(Bibliotheque data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_BIBLIOTHEQUE_NULL);
			throw businessException;
		}
		try {
			con = JdbcTools.getConnection();
			pstmt = con.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, data.getNom_Bibliotheque());
			pstmt.setString(2, data.getAdresse_Bibliotheque());
			pstmt.setString(3, data.getCp_Bibliotheque());
			pstmt.setString(4, data.getVille_Bibliotheque());
			pstmt.setString(5, data.getMail_Bibliotheque());
			pstmt.setString(6, data.getTel_Bibliotheque());
			
			int nbRows = pstmt.executeUpdate();
			if(nbRows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					data.setId_Bibliotheque(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Biblio == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_BIBLIOTHEQUE_ECHEC);
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
	public void update(Bibliotheque data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_BIBLIOTHEQUE_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlUpdate);
			pstmt.setString(2, data.getNom_Bibliotheque());
			pstmt.setString(3, data.getAdresse_Bibliotheque());
			pstmt.setString(4, data.getCp_Bibliotheque());
			pstmt.setString(5, data.getVille_Bibliotheque());
			pstmt.setString(6, data.getMail_Bibliotheque());
			pstmt.setString(7, data.getTel_Bibliotheque());
			pstmt.setInt(8, data.getId_Bibliotheque());
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Biblio == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.UPDATE_BIBLIOTHEQUE_ECHEC);
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
			businessException.ajouterErreur(CodesResultatDAL.DELETE_BIBLIOTHEQUE_NULL);
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
			if (e.getMessage().contains("id_Biblio == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.DELETE_BIBLIOTHEQUE_ECHEC);
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
	public List<Bibliotheque> selectAll() throws BusinessException {
		List<Bibliotheque> liste = new ArrayList<Bibliotheque>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = ConnectionProvider.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlSelectAll);
			Bibliotheque b = null;
			while (rs.next()) {
					b = new Bibliotheque(rs.getInt("id_Biblio"),
							rs.getString("nom_Biblio"),
							rs.getString("adresse_Biblio"), 
							rs.getString("codePostal_Biblio"), 
							rs.getString("ville_Biblio"),
							rs.getString("mail_Biblio"), 
							rs.getString("tel_Biblio"));
				liste.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Biblio == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_BIBLIOTHEQUE_ECHEC);
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
		return liste;
	}

	@Override
	public Bibliotheque selectById(int id) throws BusinessException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Bibliotheque b = null;
		
		if (id == 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_BIBLIOTHEQUE_BY_ID_NULL);
			throw businessException;
		}
		try {

			con = ConnectionProvider.getConnection();
			stmt = con.prepareStatement(sqlSelectById);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
					b = new Bibliotheque(rs.getInt("id_Biblio"),
							rs.getString("nom_Biblio"),
							rs.getString("adresse_Biblio"), 
							rs.getString("codePostal_Biblio"), 
							rs.getString("ville_Biblio"),
							rs.getString("mail_Biblio"), 
							rs.getString("tel_Biblio"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Biblio == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_BIBLIOTHEQUE_BY_ID_ECHEC);
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
		return b;
	}
	
	@Override
	public List<Bibliotheque> selectByName(String data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Bibliotheque> bibliotheque = new ArrayList<Bibliotheque>();
		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_BIBLIOTHEQUE_BY_NAME_NULL);
			throw businessException;
		}
		try {
			con = JdbcTools.getConnection();
			pstmt = con.prepareStatement(sqlSelectByLivre);
			pstmt.setString(1,  data);
			rs = pstmt.executeQuery();
			Bibliotheque b = null;
			while (rs.next()) {

					b = new Bibliotheque(rs.getInt("id_Biblio"),
							rs.getString("nom_Biblio"),
							rs.getString("adresse_Biblio"), 
							rs.getString("codePostal_Biblio"), 
							rs.getString("ville_Biblio"),
							rs.getString("mail_Biblio"), 
							rs.getString("tel_Biblio"));
				
					bibliotheque.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Biblio == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_BIBLIOTHEQUE_BY_NAME_ECHEC);
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
		return bibliotheque;
	}

}
