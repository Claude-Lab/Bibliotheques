package fr.lusseau.claude.bibliotheques.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe en charge des roles des salariés
 * @version Bibliotheques -v1,0
 * @date  6 mai 2020 - 12:00:14
 * @author Claude LUSSEAU
 *
 */
public class Role {
	
	private Integer id_Role;
	private String type_Role;
	private List<Personne> listePersonne = new ArrayList<Personne>();
	
	/**
	 * Constructeur.
	 */
	public Role() {
	}
	
	/**
	 * Constructeur.
	 * @param id_Role
	 * @param type_Role
	 */
	public Role(Integer id_Role, String type_Role) {
		setId_Role(id_Role);
		setType_Role(type_Role);
	}
	
	/**
	 * Constructeur.
	 * @param type_Role
	 */
	public Role(String type_Role) {
		setType_Role(type_Role);
	}

	

	/**
	 * Guetter pour id_Role.
	 * @return the  id_Role
	 */
	public Integer getId_Role() {
		return id_Role;
	}

	/**
	 * Setter pour id_Role.
	 * @param id_Role the id_Role to set
	 */
	public void setId_Role(Integer id_Role) {
		this.id_Role = id_Role;
	}

	/**
	 * Guetter pour type_Role.
	 * @return the  type_Role
	 */
	public String getType_Role() {
		return type_Role;
	}

	/**
	 * Setter pour type_Role.
	 * @param type_Role the type_Role to set
	 */
	public void setType_Role(String type_Role) {
		this.type_Role = type_Role;
	}

	/**
	 * Guetter pour listePersonne.
	 * @return the  listePersonne
	 */
	public List<Personne> getListePersonne() {
		return listePersonne;
	}

	/**
	 * Setter pour listePersonne.
	 * @param listePersonne the listePersonne to set
	 */
	public void setListePersonne(List<Personne> listePersonne) {
		this.listePersonne = listePersonne;
	}

	/**
	 *
	 *  @return {@inheritDoc} 
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ID du role : ").append(" ").append(this.getId_Role()).append("\n");
		sb.append("Type du role : ").append(" ").append(this.getType_Role()).append("\n");
		return sb.toString();
	}
	
	

}
