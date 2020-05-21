package fr.lusseau.claude.bibliotheques.bo;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe en charge des bibliothèques.
 * @version Bibliotheques -v1,0
 * @date  6 mai 2020 - 11:36:19
 * @author Claude LUSSEAU
 *
 */
public class Bibliotheque {

	private Integer id_Bibliotheque;
	private String nom_Bibliotheque;
	private String adresse_Bibliotheque;
	private String cp_Bibliotheque;
	private String ville_Bibliotheque;
	private String mail_Bibliotheque;
	private String tel_Bibliotheque;
	private List<Livre> listeLivre = new ArrayList<Livre>();
	
	/**
	 * Constructeur.
	 */
	public Bibliotheque() {
	}
	
	/**
	 * Constructeur.
	 * @param id_Bibliotheque
	 * @param nom_Bibliotheque
	 * @param adresse_Bibliotheque
	 * @param cp_Bibliotheque
	 * @param ville_Bibliotheque
	 * @param mail_Bibliotheque
	 * @param tel_Bibliotheque
	 */
	public Bibliotheque(Integer id_Bibliotheque, String nom_Bibliotheque, String adresse_Bibliotheque, String cp_Bibliotheque, String ville_Bibliotheque, String mail_Bibliotheque, String tel_Bibliotheque) {
		setId_Bibliotheque(id_Bibliotheque);
		setNom_Bibliotheque(nom_Bibliotheque);
		setAdresse_Bibliotheque(adresse_Bibliotheque);
		setCp_Bibliotheque(cp_Bibliotheque);
		setVille_Bibliotheque(ville_Bibliotheque);
		setMail_Bibliotheque(mail_Bibliotheque);
		setTel_Bibliotheque(tel_Bibliotheque);
	}
	
	/**
	 * Constructeur.
	 * @param nom_Bibliotheque
	 * @param adresse_Bibliotheque
	 * @param cp_Bibliotheque
	 * @param ville_Bibliotheque
	 * @param mail_Bibliotheque
	 * @param tel_Bibliotheque
	 */
	public Bibliotheque(String nom_Bibliotheque, String adresse_Bibliotheque, String cp_Bibliotheque, String ville_Bibliotheque, String mail_Bibliotheque, String tel_Bibliotheque) {
		setNom_Bibliotheque(nom_Bibliotheque);
		setAdresse_Bibliotheque(adresse_Bibliotheque);
		setCp_Bibliotheque(cp_Bibliotheque);
		setVille_Bibliotheque(ville_Bibliotheque);
		setMail_Bibliotheque(mail_Bibliotheque);
		setTel_Bibliotheque(tel_Bibliotheque);
	}

	

	/**
	 * Guetter pour id_Bibliotheque.
	 * @return the  id_Bibliotheque
	 */
	public Integer getId_Bibliotheque() {
		return id_Bibliotheque;
	}

	/**
	 * Setter pour id_Bibliotheque.
	 * @param id_Bibliotheque the id_Bibliotheque to set
	 */
	public void setId_Bibliotheque(Integer id_Bibliotheque) {
		this.id_Bibliotheque = id_Bibliotheque;
	}

	/**
	 * Guetter pour nom_Bibliotheque.
	 * @return the  nom_Bibliotheque
	 */
	public String getNom_Bibliotheque() {
		return nom_Bibliotheque;
	}

	/**
	 * Setter pour nom_Bibliotheque.
	 * @param nom_Bibliotheque the nom_Bibliotheque to set
	 */
	public void setNom_Bibliotheque(String nom_Bibliotheque) {
		this.nom_Bibliotheque = nom_Bibliotheque;
	}

	/**
	 * Guetter pour adresse_Bibliotheque.
	 * @return the  adresse_Bibliotheque
	 */
	public String getAdresse_Bibliotheque() {
		return adresse_Bibliotheque;
	}

	/**
	 * Setter pour adresse_Bibliotheque.
	 * @param adresse_Bibliotheque the adresse_Bibliotheque to set
	 */
	public void setAdresse_Bibliotheque(String adresse_Bibliotheque) {
		this.adresse_Bibliotheque = adresse_Bibliotheque;
	}

	/**
	 * Guetter pour cp_Bibliotheque.
	 * @return the  cp_Bibliotheque
	 */
	public String getCp_Bibliotheque() {
		return cp_Bibliotheque;
	}

	/**
	 * Setter pour cp_Bibliotheque.
	 * @param cp_Bibliotheque the cp_Bibliotheque to set
	 */
	public void setCp_Bibliotheque(String cp_Bibliotheque) {
		this.cp_Bibliotheque = cp_Bibliotheque;
	}

	/**
	 * Guetter pour ville_Bibliotheque.
	 * @return the  ville_Bibliotheque
	 */
	public String getVille_Bibliotheque() {
		return ville_Bibliotheque;
	}

	/**
	 * Setter pour ville_Bibliotheque.
	 * @param ville_Bibliotheque the ville_Bibliotheque to set
	 */
	public void setVille_Bibliotheque(String ville_Bibliotheque) {
		this.ville_Bibliotheque = ville_Bibliotheque;
	}

	/**
	 * Guetter pour mail_Bibliotheque.
	 * @return the  mail_Bibliotheque
	 */
	public String getMail_Bibliotheque() {
		return mail_Bibliotheque;
	}

	/**
	 * Setter pour mail_Bibliotheque.
	 * @param mail_Bibliotheque the mail_Bibliotheque to set
	 */
	public void setMail_Bibliotheque(String mail_Bibliotheque) {
		this.mail_Bibliotheque = mail_Bibliotheque;
	}

	/**
	 * Guetter pour tel_Bibliotheque.
	 * @return the  tel_Bibliotheque
	 */
	public String getTel_Bibliotheque() {
		return tel_Bibliotheque;
	}

	/**
	 * Setter pour tel_Bibliotheque.
	 * @param tel_Bibliotheque the tel_Bibliotheque to set
	 */
	public void setTel_Bibliotheque(String tel_Bibliotheque) {
		this.tel_Bibliotheque = tel_Bibliotheque;
	}

	/**
	 * Guetter pour listeLivre.
	 * @return the  listeLivre
	 */
	public List<Livre> getListeLivre() {
		return listeLivre;
	}

	/**
	 * Setter pour listeLivre.
	 * @param listeLivre the listeLivre to set
	 */
	public void setListeLivre(List<Livre> listeLivre) {
		this.listeLivre = listeLivre;
	}

	/**
	 *
	 *  @return {@inheritDoc} 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bibliotheque [id_Bibliotheque=");
		builder.append(id_Bibliotheque);
		builder.append(", nom_Bibliotheque=");
		builder.append(nom_Bibliotheque);
		builder.append(", adresse_Bibliotheque=");
		builder.append(adresse_Bibliotheque);
		builder.append(", cp_Bibliotheque=");
		builder.append(cp_Bibliotheque);
		builder.append(", ville_Bibliotheque=");
		builder.append(ville_Bibliotheque);
		builder.append(", mail_Bibliotheque=");
		builder.append(mail_Bibliotheque);
		builder.append(", tel_Bibliotheque=");
		builder.append(tel_Bibliotheque);
		builder.append(", listeLivre=");
		builder.append(listeLivre);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
