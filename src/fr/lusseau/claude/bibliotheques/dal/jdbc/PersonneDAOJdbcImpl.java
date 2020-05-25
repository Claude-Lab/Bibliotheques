package fr.lusseau.claude.bibliotheques.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Personne;
import fr.lusseau.claude.bibliotheques.dal.DAO.PersonneDAO;
import fr.lusseau.claude.bibliotheques.servlets.CodesResultatDAL;

/**
 * @author Claude Lusseau
 * 
 */

public class PersonneDAOJdbcImpl implements PersonneDAO {

	private static final String TYPE_CLIENT = "CLIENT";
	private static final String TYPE_SALARIE = "SALARIE";

	private static final String sqlSelectById = "SELECT id_Personne, prenom_Personne, nom_Personne, adresse_Personne, codePostal_Personne, ville_Personne, eMail_Personne, tel_Personne, motDePasse_Personne, id_Caution, id_Role, type_Personne"
			+ "FROM PERSONNES WHERE id_Personne = ?";

	private static final String sqlSelectAll = "SELECT id_Personne, prenom_Personne, nom_Personne, adresse_Personne, codePostal_Personne, ville_Personne, eMail_Personne, tel_Personne, motDePasse_Personne, CAUTIONS.valeurs_Caution, ROLES.type_Role, type_Personne, inscription_Personne FROM PERSONNES LEFT JOIN CAUTIONS ON PERSONNES.id_Caution = CAUTIONS.id_Caution LEFT JOIN ROLES ON PERSONNES.id_Role = ROLES.id_Role ORDER BY id_Personne DESC";

	private static final String sqlSelectAllClients = "SELECT id_Personne, prenom_Personne, nom_Personne, adresse_Personne, codePostal_Personne, ville_Personne, eMail_Personne, tel_Personne, motDePasse_Personne, CAUTIONS.valeurs_Caution, ROLES.type_Role, type_Personne, inscription_Personne FROM PERSONNES LEFT JOIN CAUTIONS ON PERSONNES.id_Caution = CAUTIONS.id_Caution LEFT JOIN ROLES ON PERSONNES.id_Role = ROLES.id_Role WHERE PERSONNES.type_Personne = \'"
			+ TYPE_CLIENT + "\' ORDER BY id_Personne DESC";

	private static final String sqlSelectAllSalaries = "SELECT id_Personne, prenom_Personne, nom_Personne, adresse_Personne, codePostal_Personne, ville_Personne, eMail_Personne, tel_Personne, motDePasse_Personne, type_Personne, CAUTIONS.valeurs_Caution, ROLES.type_Role, inscription_Personne FROM PERSONNES LEFT JOIN ROLES ON PERSONNES.id_Role = ROLES.id_Role LEFT JOIN CAUTIONS ON PERSONNES.id_Caution = CAUTIONS.id_Caution WHERE PERSONNES.type_Personne = \'"
			+ TYPE_SALARIE + "\' ORDER BY id_Personne DESC";

	private static final String sqlUpdate = "UPDATE PERSONNES SET prenom_Personne=?,nom_Personne=?,adresse_Personne=?,codePostal_Personne=?,ville_Personne=?,eMail_Personne=?,tel_Personne=?,motDePasse_Personne=?, id_Caution=?, id_Role=?, type_Personne=?  where id_Personne=?";

	private static final String sqlInsert = "INSERT INTO PERSONNES (prenom_Personne, nom_Personne, adresse_Personne, codePostal_Personne, ville_Personne, eMail_Personne, tel_Personne, motDePasse_Personne, id_Caution, id_Role, type_Personne, inscription_Personne) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";

	private static final String sqlDelete = "DELETE FROM PERSONNES WHERE id_Personne=?";

	private static final String sqlSelectByFirstName = "SELECT prenom_Personne, nom_Personne, adresse_Personne, codePostal_Personne, ville_Personne, eMail_Personne, tel_Personne, motDePasse_Personne, id_Caution, id_Role, type_Personne"
			+ "FROM PERSONNES WHERE nom_Personne LIKE ?";

	private static final String sqlSelectByMail = "SELECT prenom_Personne, nom_Personne, adresse_Personne, codePostal_Personne, ville_Personne, eMail_Personne, tel_Personne, motDePasse_Personne, id_Caution, id_Role, type_Personne"
			+ "FROM PERSONNES WHERE eMail_Personne = ?";

	private static final String sqlCountPerson = "SELECT COUNT(*) FROM PERSONNES";

	private static final String sqlLogin = "SELECT * ,CAUTIONS.valeurs_Caution, ROLES.type_Role FROM PERSONNES LEFT JOIN CAUTIONS ON PERSONNES.id_Caution = CAUTIONS.id_Caution LEFT JOIN ROLES ON PERSONNES.id_Role = ROLES.id_Role WHERE eMail_Personne = ? AND motDePasse_Personne = ?";

	private static final String sqlSearchMail = "SELECT eMail_Personne, prenom_Personne, nom_Personne FROM PERSONNES WHERE eMail_Personne = ?";

	/**
	 * Methode en charge de chercher si un mail existe déjaà en base.
	 * 
	 * @param mail_Personne
	 * @return
	 * @throws BusinessException
	 */
	public Personne rechercherMail(String mail_Personne) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Personne mail = null;

		if (mail_Personne == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CONNEXION_PERSONNE_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlSearchMail);
			pstmt.setString(1, mail_Personne);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mail = new Personne();
				mail.setPrenom_Personne(rs.getString("prenom_Personne"));
				mail.setNom_Personne(rs.getString("nom_Personne"));
				mail.setMail_Personne(rs.getString("eMail_Personne"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Personne == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.CONNEXION_PERSONNE__ECHEC);
			}
		}
		return mail;

	}

	/**
	 * Methode en charge de compter le nombres de personnes inscrites en base.
	 * 
	 * @return
	 * @throws BusinessException
	 * @throws SQLException
	 */
	public int countPerson() throws BusinessException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int nbPersonne = 0;

		try {
			// con = JdbcTools.getConnection();
			con = ConnectionProvider.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlCountPerson);
			rs.next();
			nbPersonne = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

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
		return nbPersonne;
	}

	/**
	 *
	 * @return {@inheritDoc}
	 */
	public void insert(Personne data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;

		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_PERSONNE_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, data.getPrenom_Personne());
			pstmt.setString(2, data.getNom_Personne());
			pstmt.setString(3, data.getAdresse_Personne());
			pstmt.setString(4, data.getCp_Personne());
			pstmt.setString(5, data.getVille_Personne());
			pstmt.setString(6, data.getMail_Personne());
			pstmt.setString(7, data.getTel_Personne());
			pstmt.setString(8, data.getMotDePasse_Personne());
			pstmt.setInt(9, data.getCotisation_Personne());
			pstmt.setString(10, data.getRole_Personne());
			pstmt.setString(11, data.getType_Personne());
			pstmt.setObject(12, data.getInscription_Personne());

			int nbRows = pstmt.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					data.setId_Personne(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Personne == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_PERSONNE_ECHEC);
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

	/**
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public void update(Personne data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;

		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_PERSONNE_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlUpdate);
			pstmt.setString(1, data.getPrenom_Personne());
			pstmt.setString(2, data.getNom_Personne());
			pstmt.setString(3, data.getAdresse_Personne());
			pstmt.setString(4, data.getCp_Personne());
			pstmt.setString(5, data.getVille_Personne());
			pstmt.setString(6, data.getMail_Personne());
			pstmt.setString(7, data.getTel_Personne());
			pstmt.setString(8, data.getMotDePasse_Personne());
			pstmt.setInt(9, data.getCotisation_Personne());
			pstmt.setString(10, data.getRole_Personne());
			pstmt.setString(11, data.getType_Personne());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Personne == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.UPDATE_PERSONNE_ECHEC);
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

	/**
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public void delete(int id) throws BusinessException {

		Connection con = null;
		PreparedStatement pstmt = null;

		if (id == 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_PERSONNE_NULL);
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
			if (e.getMessage().contains("id_Personne == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.DELETE_PERSONNE_ECHEC);
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

	/**
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public List<Personne> selectByName(String nom_Personne) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Personne> personnes = new ArrayList<Personne>();
		if (nom_Personne == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_PERSONNE_BY_FIRST_NAME_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlSelectByFirstName);
			rs = pstmt.executeQuery();
			Personne p = null;
			while (rs.next()) {

				if (TYPE_CLIENT.equalsIgnoreCase(rs.getString("type").trim())) {
					p = new Personne(rs.getInt("id_Personne"), rs.getString("prenom_Personne"),
							rs.getString("nom_Personne"), rs.getString("adresse_Personne"),
							rs.getString("codePostal_Personne"), rs.getString("ville_Personne"),
							rs.getString("eMail_Personne"), rs.getString("tel_Personne"),
							rs.getString("motDePasse_Personne"), rs.getInt("valeurs_Caution"),
							rs.getString("type_Personne"), rs.getString("type_Role"),
							rs.getObject("inscription_Personne", Timestamp.class));
				}
				if (TYPE_SALARIE.equalsIgnoreCase(rs.getString("type").trim())) {
					p = new Personne(rs.getInt("id_Personne"), rs.getString("prenom_Personne"),
							rs.getString("nom_Personne"), rs.getString("adresse_Personne"),
							rs.getString("codePostal_Personne"), rs.getString("ville_Personne"),
							rs.getString("eMail_Personne"), rs.getString("tel_Personne"),
							rs.getString("motDePasse_Personne"), rs.getInt("valeurs_Caution"),
							rs.getString("type_Personne"), rs.getString("type_Role"),
							rs.getObject("inscription_Personne", Timestamp.class));
				}
				personnes.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Personne == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_PERSONNE_BY_FIRST_NAME_ECHEC);
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
		return personnes;
	}

	/**
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public List<Personne> selectAllClients() throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Personne> clients = new ArrayList<>();

		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlSelectAllClients);
			rs = pstmt.executeQuery();
			Personne c = null;
			while (rs.next()) {

				c = new Personne(rs.getInt("id_Personne"), rs.getString("prenom_Personne"),
						rs.getString("nom_Personne"), rs.getString("adresse_Personne"),
						rs.getString("codePostal_Personne"), rs.getString("ville_Personne"),
						rs.getString("eMail_Personne"), rs.getString("tel_Personne"),
						rs.getString("motDePasse_Personne"), rs.getInt("valeurs_Caution"),
						rs.getString("type_Personne"), rs.getString("type_Role"),
						rs.getObject("inscription_Personne", Timestamp.class));

				clients.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Personne == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_CLIENTS_ECHEC);
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
		return clients;
	}

	@Override
	public List<Personne> selectAllSalaries() throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Personne> salairie = new ArrayList<>();

		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlSelectAllSalaries);
			rs = pstmt.executeQuery();
			Personne s = null;
			while (rs.next()) {

				s = new Personne(rs.getInt("id_Personne"), rs.getString("prenom_Personne"),
						rs.getString("nom_Personne"), rs.getString("adresse_Personne"),
						rs.getString("codePostal_Personne"), rs.getString("ville_Personne"),
						rs.getString("eMail_Personne"), rs.getString("tel_Personne"),
						rs.getString("motDePasse_Personne"), rs.getInt("valeurs_Caution"),
						rs.getString("type_Personne"), rs.getString("type_Role"),
						rs.getObject("inscription_Personne", Timestamp.class));

				salairie.add(s);

			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Personne == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_SALARIES_ECHEC);
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
		return salairie;
	}

	@Override
	public Personne selectById(int id) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Personne personne = null;

		if (id == 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_PERSONNE_BY_ID_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlSelectById);
			rs = pstmt.executeQuery(sqlSelectById);
			((PreparedStatement) pstmt).setInt(1, id);

			if (rs.next()) {

				if (TYPE_CLIENT.equalsIgnoreCase(rs.getString("type_Personne").trim())) {
					personne = new Personne(rs.getInt("id_Personne"), rs.getString("prenom_Personne"),
							rs.getString("nom_Personne"), rs.getString("adresse_Personne"),
							rs.getString("codePostal_Personne"), rs.getString("ville_Personne"),
							rs.getString("eMail_Personne"), rs.getString("tel_Personne"),
							rs.getString("motDePasse_Personne"), rs.getInt("valeurs_Caution"),
							rs.getString("type_Personne"), rs.getString("type_Role"),
							rs.getObject("inscription_Personne", Timestamp.class));
				}
				if (TYPE_SALARIE.equalsIgnoreCase(rs.getString("type_Personne").trim())) {
					personne = new Personne(rs.getInt("id_Personne"), rs.getString("prenom_Personne"),
							rs.getString("nom_Personne"), rs.getString("adresse_Personne"),
							rs.getString("codePostal_Personne"), rs.getString("ville_Personne"),
							rs.getString("eMail_Personne"), rs.getString("tel_Personne"),
							rs.getString("motDePasse_Personne"), rs.getInt("valeurs_Caution"),
							rs.getString("type_Personne"), rs.getString("type_Role"),
							rs.getObject("inscription_Personne", Timestamp.class));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Personne == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_PERSONNE_BY_ID_ECHEC);
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
		return personne;
	}

	/**
	 * Methode en charge de
	 * 
	 * @return
	 */
	@Override
	public List<Personne> selectAll() throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Personne> personnes = new ArrayList<Personne>();

		try {
			// con = JdbcTools.getConnection();
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlSelectAll);
			rs = pstmt.executeQuery();
			Personne p = null;
			while (rs.next()) {

				if (TYPE_CLIENT.equalsIgnoreCase(rs.getString("type_Personne").trim())) {
					p = new Personne(rs.getInt("id_Personne"), rs.getString("prenom_Personne"),
							rs.getString("nom_Personne"), rs.getString("adresse_Personne"),
							rs.getString("codePostal_Personne"), rs.getString("ville_Personne"),
							rs.getString("eMail_Personne"), rs.getString("tel_Personne"),
							rs.getString("motDePasse_Personne"), rs.getInt("valeurs_Caution"),
							rs.getString("type_Personne"), rs.getString("type_Role"),
							rs.getObject("inscription_Personne", Timestamp.class));
				}
				if (TYPE_SALARIE.equalsIgnoreCase(rs.getString("type_Personne").trim())) {
					p = new Personne(rs.getInt("id_Personne"), rs.getString("prenom_Personne"),
							rs.getString("nom_Personne"), rs.getString("adresse_Personne"),
							rs.getString("codePostal_Personne"), rs.getString("ville_Personne"),
							rs.getString("eMail_Personne"), rs.getString("tel_Personne"),
							rs.getString("motDePasse_Personne"), rs.getInt("valeurs_Caution"),
							rs.getString("type_Personne"), rs.getString("type_Role"),
							rs.getObject("inscription_Personne", Timestamp.class));
				}
				personnes.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Personne == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_PERSONNE_BY_FIRST_NAME_ECHEC);
			}

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
		return personnes;
	}

	public Personne login(String mail_Personne, String motDePasse_Personne) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Personne personne = null;

		if ((mail_Personne == null) || (motDePasse_Personne == null)) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CONNEXION_PERSONNE_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlLogin);
			pstmt.setString(1, mail_Personne);
			pstmt.setString(2, motDePasse_Personne);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				personne = new Personne();
				personne.setId_Personne(rs.getInt("id_Personne"));
				personne.setPrenom_Personne(rs.getString("prenom_Personne"));
				personne.setNom_Personne(rs.getString("nom_Personne"));
				personne.setAdresse_Personne(rs.getString("adresse_Personne"));
				personne.setCp_Personne(rs.getString("codePostal_Personne"));
				personne.setVille_Personne(rs.getString("ville_Personne"));
				personne.setMail_Personne(rs.getString("eMail_Personne"));
				personne.setTel_Personne(rs.getString("tel_Personne"));
				personne.setMotDePasse_Personne(rs.getString("motDePasse_Personne"));
				personne.setCotisation_Personne(rs.getInt("valeurs_Caution"));
				personne.setRole_Personne(rs.getString("type_Role"));
				personne.setType_Personne(rs.getString("type_Personne"));
				personne.setInscription_Personne(rs.getObject("inscription_Personne", Timestamp.class));

			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Personne == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.CONNEXION_PERSONNE__ECHEC);
			}
		}
		return personne;
	}

	/**
	 * Methode en charge de seletionner une personne par son eMail (connection
	 * session).
	 * 
	 * @param data
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public Personne selectByMail(String data) throws BusinessException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Personne personne = null;

		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_PERSONNE_BY_ID_NULL);
			throw businessException;
		}
		try {
			con = ConnectionProvider.getConnection();
			pstmt = con.prepareStatement(sqlSelectByMail);
			rs = pstmt.executeQuery();
			((PreparedStatement) pstmt).setString(1, data);

			if (rs.next()) {

				if (TYPE_CLIENT.equalsIgnoreCase(rs.getString("type_Personne").trim())) {
					personne = new Personne(rs.getInt("id_Personne"), rs.getString("prenom_Personne"),
							rs.getString("nom_Personne"), rs.getString("adresse_Personne"),
							rs.getString("codePostal_Personne"), rs.getString("ville_Personne"),
							rs.getString("eMail_Personne"), rs.getString("tel_Personne"),
							rs.getString("motDePasse_Personne"), rs.getInt("valeurs_Caution"),
							rs.getString("type_Personne"), rs.getString("type_Role"),
							rs.getObject("inscription_Personne", Timestamp.class));
				}
				if (TYPE_SALARIE.equalsIgnoreCase(rs.getString("type_Personne").trim())) {
					personne = new Personne(rs.getInt("id_Personne"), rs.getString("prenom_Personne"),
							rs.getString("nom_Personne"), rs.getString("adresse_Personne"),
							rs.getString("codePostal_Personne"), rs.getString("ville_Personne"),
							rs.getString("eMail_Personne"), rs.getString("tel_Personne"),
							rs.getString("motDePasse_Personne"), rs.getInt("valeurs_Caution"),
							rs.getString("type_Personne"), rs.getString("type_Role"),
							rs.getObject("inscription_Personne", Timestamp.class));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Personne == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_PERSONNE_BY_ID_ECHEC);
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
		return personne;
	}

}
