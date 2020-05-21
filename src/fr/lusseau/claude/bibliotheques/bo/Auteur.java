package fr.lusseau.claude.bibliotheques.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe en charge des auteurs.
 * @version Bibliotheques - v1.0
 * @date  6 mai 2020 - 10:59:08
 * @author Claude LUSSEAU
 *
 */
public class Auteur {

	private Integer id_Auteur;
	private String prenom_Nom_Auteur;
	private List<Livre> listLivres = new ArrayList<Livre>();
	
	/**
	 * Constructeur.
	 */
	public Auteur() {
	}
	
	/**
	 * Constructeur.
	 * @param id_Auteur
	 * @param prenom_Nom_Auteur
	 */
	public Auteur(Integer id_Auteur, String prenom_Nom_Auteur) {
		setPrenom_Auteur(prenom_Nom_Auteur);
		setId_Auteur(id_Auteur);
	}
	
	/**
	 * Constructeur.
	 * @param prenom_Nom_Auteur
	 */
	public Auteur(String prenom_Nom_Auteur) {
		setPrenom_Auteur(prenom_Nom_Auteur);
	}

	

	/**
	 * @return the id_Auteur
	 */
	public Integer getId_Auteur() {
		return id_Auteur;
	}

	/**
	 * @param id_Auteur the id_Auteur to set
	 */
	public void setId_Auteur(Integer id_Auteur) {
		this.id_Auteur = id_Auteur;
	}

	/**
	 * @return the prenom_Auteur
	 */
	public String getPrenom_Auteur() {
		return prenom_Nom_Auteur;
	}

	/**
	 * @param prenom_Auteur the prenom_Auteur to set
	 */
	public void setPrenom_Auteur(String prenom_Nom_Auteur) {
		this.prenom_Nom_Auteur = prenom_Nom_Auteur;
	}

	/**
	 * @return the nom_Auteur
	 */
	public String getPrenom_Nom_Auteur() {
		return prenom_Nom_Auteur;
	}

	/**
	 * @param nom_Auteur the nom_Auteur to set
	 */
	public void setPrenom_Nom_Auteur(String prenom_Nom_Auteur) {
		this.prenom_Nom_Auteur = prenom_Nom_Auteur;
	}

	/**
	 * @return the listLivres
	 */
	public List<Livre> getListLivres() {
		return listLivres;
	}

	/**
	 * @param listLivres the listLivres to set
	 */
	public void setListLivres(List<Livre> listLivres) {
		this.listLivres = listLivres;
	}

	/**
	 * @{inheritDoc}
	*/
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("-------------------");
		buffer.append("Auteur : ").append(this.prenom_Nom_Auteur).append(" ");
		buffer.append("Livre(s) de cet auteur : ");
		for (Livre livre : listLivres) {
			buffer.append("\t\t").append(livre.getTitre_Livre());
		}
		return buffer.toString();
	}

	
		
}
