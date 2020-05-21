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

import fr.lusseau.claude.bibliotheques.bo.Emprunt;
import fr.lusseau.claude.bibliotheques.dal.DALException;
import fr.lusseau.claude.bibliotheques.dal.DAO.EmpruntDAO;

/**
 * @author Claude Lusseau
 * 
 */
public class EmpruntDAOJdbcImpl implements EmpruntDAO {

	private static final String sqlInsert = "INSERT INTO EMPRUNTS (depart_Emprunt, retour_emprunt, id_Livre, id_Personne) VALUES (?,?,?,?)";

	private static final String sqlDelete = "DELETE FROM EMPRUNTS WHERE id_Emprunt = ?";

	private static final String sqlUpdate = "UPDATE EMPRUNTS SET depart_Emprunt=?, retour_emprunt=?, id_Livre=?, id_Personne=? WHERE id_Emprunt = ?";

	private static final String sqlSelectAll = "	SELECT id_Emprunt, depart_Emprunt, retour_emprunt, id_Livre, id_Personne FROM EMPRUNTS";

	private static final String sqlSortByTitleLivre = "SELECT id_Emprunt, depart_Emprunt, retour_emprunt, id_Livre, id_Personne FROM EMPRUNTS"
			+ "JOIN LIVRES ON EMPRUNTS.id_Livre = LIVRES.id_Livre"
			+ "LEFT JOIN PERSONNES ON EMPRUNTS.id_Personne = PERSONNES.id_PERSONNE" + "WHERE titre_Livre like ?";

	private static final String sqlSortByPerson = "SELECT id_Emprunt, depart_Emprunt, retour_emprunt, id_Livre, id_Personne FROM EMPRUNTS"
			+ "JOIN LIVRES ON EMPRUNTS.id_Livre = LIVRES.id_Livre"
			+ "LEFT JOIN PERSONNES ON EMPRUNTS.id_Personne = PERSONNES.id_PERSONNE" + "WHERE nom_Personne like ?";

	private static final String sqlSelectById = "id_Emprunt, depart_Emprunt, retour_emprunt, id_Livre, id_Personne FROM EMPRUNTS where id_Emprunt = ? ";

	
	public void insert(Emprunt data) throws DALException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setObject(1, data.getDateEmprunt(), Types.DATE);
			stmt.setObject(2, data.getDateRetour(), Types.DATE);
			stmt.setInt(3, data.getId_Livre());
			stmt.setInt(4, data.getId_Personne());

		} catch (SQLException e) {
			throw new DALException("Update article failed - " + data, e);
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
	}

	
	public void update(Emprunt data) throws DALException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement(sqlUpdate);
			stmt.setObject(1, data.getDateEmprunt(), Types.DATE);
			stmt.setObject(2, data.getDateRetour(), Types.DATE);
			stmt.setInt(3, data.getId_Livre());
			stmt.setInt(4, data.getId_Personne());

		} catch (SQLException e) {
			throw new DALException("Update article failed - " + data, e);
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
	}

	
	public List<Emprunt> SortByTitleLivre(String titre) throws DALException {
		List<Emprunt> emprunts = new ArrayList<Emprunt>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement(sqlSortByTitleLivre);
			stmt.setString(1, titre);
			rs = stmt.executeQuery();
			Emprunt em = null;
			while (rs.next()) {
				em = new Emprunt(rs.getInt("id_Emprunt"), rs.getObject("depart_Emprunt", LocalDate.class), rs.getObject("retour_emprunt", LocalDate.class),
						rs.getInt("id_Livre"), rs.getInt("id_Personne"));
			}
			emprunts.add(em);

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
		return emprunts;
	}

	
	public List<Emprunt> SortByPerson(String nom) throws DALException {
		List<Emprunt> emprunts = new ArrayList<Emprunt>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement(sqlSortByPerson);
			stmt.setString(1, nom);
			rs = stmt.executeQuery();
			Emprunt em = null;
			while (rs.next()) {
				em = new Emprunt(rs.getInt("id_Emprunt"), rs.getObject("depart_Emprunt", LocalDate.class), rs.getObject("retour_emprunt", LocalDate.class),
						rs.getInt("id_Livre"), rs.getInt("id_Personne"));
			}
			emprunts.add(em);

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
		return emprunts;
	}

	
	public List<Emprunt> selectAll() throws DALException {
		List<Emprunt> emprunts = new ArrayList<Emprunt>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = JdbcTools.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlSelectAll);
			Emprunt em = null;
			while (rs.next()) {
				em = new Emprunt(rs.getInt("id_Emprunt"), rs.getObject("depart_Emprunt", LocalDate.class), rs.getObject("retour_Emprunt", LocalDate.class),
						rs.getInt("id_Livre"), rs.getInt("id_Personne"));

				emprunts.add(em);
			}
		} catch (SQLException e) {
			throw new DALException("selectAll failed - ", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		return emprunts;
	}

	
	public Emprunt selectById(int id) throws DALException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Emprunt emprunts = null;
		try {
			con = JdbcTools.getConnection();
			stmt = con.prepareStatement(sqlSelectById);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				emprunts = new Emprunt(rs.getInt("id_Emprunt"), rs.getObject("depart_Emprunt", LocalDate.class),
						rs.getObject("retour_Emprunt", LocalDate.class), rs.getInt("id_Livre"), rs.getInt("id_Personne"));

			}
		} catch (SQLException e) {
			throw new DALException("Select by id failed - id = " + id, e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		return emprunts;
	}

	
	public void delete(int id) throws DALException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = JdbcTools.getConnection();
			// l'intégrité référentielle s'occupe d'invalider la suppression
			// si l'article est référencé dans une ligne de commande
			stmt = con.prepareStatement(sqlDelete);
			stmt.setInt(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Delete livre failed - id = " + id, e);
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

	}

}