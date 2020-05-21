package fr.lusseau.claude.bibliotheques.dal.DAO;

import java.util.List;

import fr.lusseau.claude.bibliotheques.bo.Emprunt;
import fr.lusseau.claude.bibliotheques.dal.DALException;

public interface EmpruntDAO {
	
	public void insert(Emprunt data) throws DALException;
	
	public void update(Emprunt data) throws DALException;
	
	public List<Emprunt> SortByTitleLivre(String titre) throws DALException;
	
	public List<Emprunt> SortByPerson(String nom) throws DALException;
	
	public List<Emprunt> selectAll() throws DALException;
	
	public Emprunt selectById(int id) throws DALException;
	
	public void delete(int id) throws DALException;
}
