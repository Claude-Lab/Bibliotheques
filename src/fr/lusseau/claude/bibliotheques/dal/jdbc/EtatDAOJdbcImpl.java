package fr.lusseau.claude.bibliotheques.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.lusseau.claude.bibliotheques.BusinessException;
import fr.lusseau.claude.bibliotheques.bo.Etat;
import fr.lusseau.claude.bibliotheques.dal.DAO.EtatDAO;
import fr.lusseau.claude.bibliotheques.servlets.CodesResultatDAL;

public class EtatDAOJdbcImpl implements EtatDAO {
	
	private static final String sqlInsert = "INSERT INTO ETAT (usage_Etat) VALUE (?)";
	
	private static final String sqlupdate = "UPDATE ETAT SET usage_Etat=?";
	
	private static final String sqlDelete = "DELETE FROM ETAT WHERE id_Etat=?";
	
	private static final String sqlSelectAll = "SELECT * FROM ETAT";

	@Override
	public void insert(Etat data) throws BusinessException {

		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ETAT_NULL);
			throw businessException;
		}
		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(sqlInsert,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, data.getUsage_Etat());
			
			int nbRows = pstmt.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					data.setId_Etat(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Etat == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_ETAT_ECHEC);
			}
			throw businessException;
		}
	}
	
	@Override
	public void update(Etat data) throws BusinessException {
		if (data == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_ETAT_NULL);
			throw businessException;
		}
		try (Connection con = ConnectionProvider.getConnection()) {
			
			PreparedStatement pstmt = con.prepareStatement(sqlupdate);
			pstmt.setString(1, data.getUsage_Etat());

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Etat == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.UPDATE_ETAT_ECHEC);
			} throw businessException;
		} 
	}
	
	@Override
	public void delete(int id) throws BusinessException {
		if (id == 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.DELETE_ETAT_NULL);
			throw businessException;
		}
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(sqlDelete);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Etat == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.DELETE_ETAT_ECHEC);
			} throw businessException;
		} 
	}
	
	@Override
	public List<Etat> selectAll() throws BusinessException {
		List<Etat> etat = new ArrayList<Etat>();
		

		try (Connection con = ConnectionProvider.getConnection()) {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelectAll);
			Etat e = null;
			while (rs.next()) {
				e = new Etat(rs.getInt("id_Etat"), rs.getString("usage_Etat"));
				etat.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("id_Etat == 0")) {
				businessException.ajouterErreur(CodesResultatDAL.LECTURE_ETAT_ECHEC);
			} throw businessException;
		}
		return etat;
	}

}
