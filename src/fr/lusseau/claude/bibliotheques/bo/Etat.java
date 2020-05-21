package fr.lusseau.claude.bibliotheques.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe en charge des états des oeuvres.
 * @version Bibliotheques -v1,0
 * @date  6 mai 2020 - 11:57:08
 * @author Claude LUSSEAU
 *
 */
public class Etat {
	
	private Integer id_Etat;
	private String usage_Etat;
	private List<Livre> listeLivres = new ArrayList<Livre>();
	
	/**
	 * Constructeur.
	 */
	public Etat() {
	}
	
	/**
	 * Constructeur.
	 * @param id_Etat
	 * @param usage_Etat
	 */
	public Etat(Integer id_Etat, String usage_Etat) {
		setId_Etat(id_Etat);
		setUsage_Etat(usage_Etat);
	}
	
	/**
	 * Constructeur.
	 * @param usage_Etat
	 */
	public Etat(String usage_Etat) {
		setUsage_Etat(usage_Etat);
	}

	/**
	 * Guetter pour id_Etat.
	 * @return the  id_Etat
	 */
	public Integer getId_Etat() {
		return id_Etat;
	}

	/**
	 * Setter pour id_Etat.
	 * @param id_Etat the id_Etat to set
	 */
	public void setId_Etat(Integer id_Etat) {
		this.id_Etat = id_Etat;
	}

	/**
	 * Guetter pour usage_Etat.
	 * @return the  usage_Etat
	 */
	public String getUsage_Etat() {
		return usage_Etat;
	}

	/**
	 * Setter pour usage_Etat.
	 * @param usage_Etat the usage_Etat to set
	 */
	public void setUsage_Etat(String usage_Etat) {
		this.usage_Etat = usage_Etat;
	}

	/**
	 * Guetter pour listeLivres.
	 * @return the  listeLivres
	 */
	public List<Livre> getListeLivres() {
		return listeLivres;
	}

	/**
	 * Setter pour listeLivres.
	 * @param listeLivres the listeLivres to set
	 */
	public void setListeLivres(List<Livre> listeLivres) {
		this.listeLivres = listeLivres;
	}

	/**
	 *
	 *  @return {@inheritDoc} 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Etat [id_Etat=");
		builder.append(id_Etat);
		builder.append(", usage_Etat=");
		builder.append(usage_Etat);
		builder.append(", listeLivres=");
		builder.append(listeLivres);
		builder.append("]");
		return builder.toString();
	}
}
