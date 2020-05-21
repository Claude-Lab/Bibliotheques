package fr.lusseau.claude.bibliotheques.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe en charge des cotisations.
 * @version Bibliotheques -v1,0
 * @date  6 mai 2020 - 11:50:11
 * @author Claude LUSSEAU
 *
 */
public class Cotisation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer id_Caution;
	private int valeurs_Caution;
	private int nbrEmprunts_Caution;
	private List<Personne> listePersonne = new ArrayList<Personne>();
	private List<Cotisation> listeCotisation = new ArrayList<Cotisation>();
	
	
	/**
	 * Constructeur.
	 */
	public Cotisation() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructeur.
	 * @param id_Caution
	 * @param valeurs_Caution
	 * @param nbrEmprunts_Caution
	 */
	public Cotisation(Integer id_Caution, int valeurs_Caution, int nbrEmprunts_Caution) {
		setId_Caution(id_Caution);
		setValeurs_Caution(valeurs_Caution);
		setNbrEmprunts_Caution(nbrEmprunts_Caution);
	}
	
	/**
	 * Constructeur.
	 * @param valeurs_Caution
	 * @param nbrEmprunts_Caution
	 */
	public Cotisation(int valeurs_Caution, int nbrEmprunts_Caution) {
		setValeurs_Caution(valeurs_Caution);
		setNbrEmprunts_Caution(nbrEmprunts_Caution);
	}

	/**
	 * Guetter pour id_Caution.
	 * @return the  id_Caution
	 */
	public Integer getId_Caution() {
		return id_Caution;
	}

	/**
	 * Setter pour id_Caution.
	 * @param id_Caution the id_Caution to set
	 */
	public void setId_Caution(Integer id_Caution) {
		this.id_Caution = id_Caution;
	}

	/**
	 * Guetter pour valeurs_Caution.
	 * @return the  valeurs_Caution
	 */
	public int getValeurs_Caution() {
		return valeurs_Caution;
	}

	/**
	 * Setter pour valeurs_Caution.
	 * @param valeurs_Caution the valeurs_Caution to set
	 */
	public void setValeurs_Caution(int valeurs_Caution) {
		this.valeurs_Caution = valeurs_Caution;
	}

	/**
	 * Guetter pour nbrEmprunts_Caution.
	 * @return the  nbrEmprunts_Caution
	 */
	public int getNbrEmprunts_Caution() {
		return nbrEmprunts_Caution;
	}

	/**
	 * Setter pour nbrEmprunts_Caution.
	 * @param nbrEmprunts_Caution the nbrEmprunts_Caution to set
	 */
	public void setNbrEmprunts_Caution(int nbrEmprunts_Caution) {
		this.nbrEmprunts_Caution = nbrEmprunts_Caution;
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
	 * Guetter pour listeCotisation.
	 * @return the  listeCotisation
	 */
	public List<Cotisation> getListeCotisation() {
		return listeCotisation;
	}

	/**
	 * Setter pour listeCotisation.
	 * @param listeCotisation the listeCotisation to set
	 */
	public void setListeCotisation(List<Cotisation> listeCotisation) {
		this.listeCotisation = listeCotisation;
	}

	/**
	 *
	 *  @return {@inheritDoc} 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cotisation [id_Caution=");
		builder.append(id_Caution);
		builder.append(", valeurs_Caution=");
		builder.append(valeurs_Caution);
		builder.append(", nbrEmprunts_Caution=");
		builder.append(nbrEmprunts_Caution);
		builder.append(", listePersonne=");
		builder.append(listePersonne);
		builder.append(", listeCotisation=");
		builder.append(listeCotisation);
		builder.append("]");
		return builder.toString();
	}

}
