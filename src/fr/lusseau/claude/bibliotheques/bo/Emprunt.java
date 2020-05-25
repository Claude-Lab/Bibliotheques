package fr.lusseau.claude.bibliotheques.bo;

import java.time.LocalDateTime;

/**
 * Classe en charge des emprunts.
 * @version Bibliotheques -v1,0
 * @date  6 mai 2020 - 11:53:20
 * @author Claude LUSSEAU
 *
 */
public class Emprunt {

	private Integer id_Emprunt;
	private LocalDateTime DateEmprunt;
	private LocalDateTime DateRetour;
	private int id_Livre;
	private int id_Personne;

	/**
	 * Constructeur.
	 */
	public Emprunt() {
	}

	/**
	 * Constructeur.
	 * @param id_Emprunt
	 * @param DateEmprunt
	 * @param DateRetour
	 * @param id_Livre
	 * @param id_Personne
	 */
	public Emprunt(Integer id_Emprunt, LocalDateTime DateEmprunt, LocalDateTime DateRetour, int id_Livre, int id_Personne) {
		setId_Emprunt(id_Emprunt);
		setDateEmprunt(DateEmprunt);
		setDateRetour(DateRetour);
		setId_Livre(id_Livre);
		setId_Personne(id_Personne);
	}

	/**
	 * Constructeur.
	 * @param DateEmprunt
	 * @param DateRetour
	 * @param id_Livre
	 * @param id_Personne
	 */
	public Emprunt(LocalDateTime DateEmprunt, LocalDateTime DateRetour, int id_Livre, int id_Personne) {
		setDateEmprunt(DateEmprunt);
		setDateRetour(DateRetour);
		setId_Livre(id_Livre);
		setId_Personne(id_Personne);
	}

	/**
	 * Guetter pour id_Emprunt.
	 * @return the  id_Emprunt
	 */
	public Integer getId_Emprunt() {
		return id_Emprunt;
	}

	/**
	 * Setter pour id_Emprunt.
	 * @param id_Emprunt the id_Emprunt to set
	 */
	public void setId_Emprunt(Integer id_Emprunt) {
		this.id_Emprunt = id_Emprunt;
	}

	/**
	 * Guetter pour dateEmprunt.
	 * @return the  dateEmprunt
	 */
	public LocalDateTime getDateEmprunt() {
		return DateEmprunt;
	}

	/**
	 * Setter pour dateEmprunt.
	 * @param dateEmprunt the dateEmprunt to set
	 */
	public void setDateEmprunt(LocalDateTime dateEmprunt) {
		DateEmprunt = dateEmprunt;
	}

	/**
	 * Guetter pour dateRetour.
	 * @return the  dateRetour
	 */
	public LocalDateTime getDateRetour() {
		return DateRetour;
	}

	/**
	 * Setter pour dateRetour.
	 * @param dateRetour the dateRetour to set
	 */
	public void setDateRetour(LocalDateTime dateRetour) {
		DateRetour = dateRetour;
	}

	/**
	 * Guetter pour id_Livre.
	 * @return the  id_Livre
	 */
	public int getId_Livre() {
		return id_Livre;
	}

	/**
	 * Setter pour id_Livre.
	 * @param id_Livre the id_Livre to set
	 */
	public void setId_Livre(int id_Livre) {
		this.id_Livre = id_Livre;
	}

	/**
	 * Guetter pour id_Personne.
	 * @return the  id_Personne
	 */
	public int getId_Personne() {
		return id_Personne;
	}

	/**
	 * Setter pour id_Personne.
	 * @param id_Personne the id_Personne to set
	 */
	public void setId_Personne(int id_Personne) {
		this.id_Personne = id_Personne;
	}

	/**
	 *
	 *  @return {@inheritDoc} 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emprunt [id_Emprunt=");
		builder.append(id_Emprunt);
		builder.append(", DateEmprunt=");
		builder.append(DateEmprunt);
		builder.append(", DateRetour=");
		builder.append(DateRetour);
		builder.append(", id_Livre=");
		builder.append(id_Livre);
		builder.append(", id_Personne=");
		builder.append(id_Personne);
		builder.append("]");
		return builder.toString();
	}

	
	

}
