package fr.lusseau.claude.bibliotheques.bo;

/**
 * Classe en charge des Editeur.
 * @version Bibliotheques -v1,0
 * @date  6 mai 2020 - 11:52:36
 * @author Claude LUSSEAU
 *
 */
public class Editeur {
	
	private Integer id_Editeur;
	private String nom_Editeur;
	private String adresse_Editeur;
	private String cp_Editeur;
	private String ville_Editeur;
	private String pays_Editeur;
	private String mail_Editeur;
	private String tel_Editeur;
	
	/**
	 * Constructeur.
	 */
	public Editeur() {
	}
	
	/**
	 * Constructeur.
	 * @param id_Editeur
	 * @param nom_Editeur
	 * @param adresse_Editeur
	 * @param cp_Editeur
	 * @param ville_Editeur
	 * @param pays_Editeur
	 * @param mail_Editeur
	 * @param tel_Editeur
	 */
	public Editeur(Integer id_Editeur, String nom_Editeur, String adresse_Editeur, String cp_Editeur, String ville_Editeur, String pays_Editeur, String mail_Editeur, String tel_Editeur) {
		setId_Editeur(id_Editeur);
		setNom_Editeur(nom_Editeur);
		setAdresse_Editeur(adresse_Editeur);
		setCp_Editeur(cp_Editeur);
		setVille_Editeur(ville_Editeur);
		setPays_Editeur(pays_Editeur);
		setMail_Editeur(mail_Editeur);
		setTel_Editeur(tel_Editeur);
	}
	
	/**
	 * Constructeur.
	 * @param nom_Editeur
	 * @param adresse_Editeur
	 * @param cp_Editeur
	 * @param ville_Editeur
	 * @param pays_Editeur
	 * @param mail_Editeur
	 * @param tel_Editeur
	 */
	public Editeur(String nom_Editeur, String adresse_Editeur, String cp_Editeur, String ville_Editeur, String pays_Editeur, String mail_Editeur, String tel_Editeur) {
		setNom_Editeur(nom_Editeur);
		setAdresse_Editeur(adresse_Editeur);
		setCp_Editeur(cp_Editeur);
		setVille_Editeur(ville_Editeur);
		setPays_Editeur(pays_Editeur);
		setMail_Editeur(mail_Editeur);
		setTel_Editeur(tel_Editeur);
	}

	/**
	 * Guetter pour id_Editeur.
	 * @return the  id_Editeur
	 */
	public Integer getId_Editeur() {
		return id_Editeur;
	}

	/**
	 * Setter pour id_Editeur.
	 * @param id_Editeur the id_Editeur to set
	 */
	public void setId_Editeur(Integer id_Editeur) {
		this.id_Editeur = id_Editeur;
	}

	/**
	 * Guetter pour nom_Editeur.
	 * @return the  nom_Editeur
	 */
	public String getNom_Editeur() {
		return nom_Editeur;
	}

	/**
	 * Setter pour nom_Editeur.
	 * @param nom_Editeur the nom_Editeur to set
	 */
	public void setNom_Editeur(String nom_Editeur) {
		this.nom_Editeur = nom_Editeur;
	}

	/**
	 * Guetter pour adresse_Editeur.
	 * @return the  adresse_Editeur
	 */
	public String getAdresse_Editeur() {
		return adresse_Editeur;
	}

	/**
	 * Setter pour adresse_Editeur.
	 * @param adresse_Editeur the adresse_Editeur to set
	 */
	public void setAdresse_Editeur(String adresse_Editeur) {
		this.adresse_Editeur = adresse_Editeur;
	}

	/**
	 * Guetter pour cp_Editeur.
	 * @return the  cp_Editeur
	 */
	public String getCp_Editeur() {
		return cp_Editeur;
	}

	/**
	 * Setter pour cp_Editeur.
	 * @param cp_Editeur the cp_Editeur to set
	 */
	public void setCp_Editeur(String cp_Editeur) {
		this.cp_Editeur = cp_Editeur;
	}

	/**
	 * Guetter pour ville_Editeur.
	 * @return the  ville_Editeur
	 */
	public String getVille_Editeur() {
		return ville_Editeur;
	}

	/**
	 * Setter pour ville_Editeur.
	 * @param ville_Editeur the ville_Editeur to set
	 */
	public void setVille_Editeur(String ville_Editeur) {
		this.ville_Editeur = ville_Editeur;
	}

	/**
	 * Guetter pour pays_Editeur.
	 * @return the  pays_Editeur
	 */
	public String getPays_Editeur() {
		return pays_Editeur;
	}

	/**
	 * Setter pour pays_Editeur.
	 * @param pays_Editeur the pays_Editeur to set
	 */
	public void setPays_Editeur(String pays_Editeur) {
		this.pays_Editeur = pays_Editeur;
	}

	/**
	 * Guetter pour mail_Editeur.
	 * @return the  mail_Editeur
	 */
	public String getMail_Editeur() {
		return mail_Editeur;
	}

	/**
	 * Setter pour mail_Editeur.
	 * @param mail_Editeur the mail_Editeur to set
	 */
	public void setMail_Editeur(String mail_Editeur) {
		this.mail_Editeur = mail_Editeur;
	}

	/**
	 * Guetter pour tel_Editeur.
	 * @return the  tel_Editeur
	 */
	public String getTel_Editeur() {
		return tel_Editeur;
	}

	/**
	 * Setter pour tel_Editeur.
	 * @param tel_Editeur the tel_Editeur to set
	 */
	public void setTel_Editeur(String tel_Editeur) {
		this.tel_Editeur = tel_Editeur;
	}

	/**
	 *
	 *  @return {@inheritDoc} 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Editeur [id_Editeur=");
		builder.append(id_Editeur);
		builder.append(", nom_Editeur=");
		builder.append(nom_Editeur);
		builder.append(", adresse_Editeur=");
		builder.append(adresse_Editeur);
		builder.append(", cp_Editeur=");
		builder.append(cp_Editeur);
		builder.append(", ville_Editeur=");
		builder.append(ville_Editeur);
		builder.append(", pays_Editeur=");
		builder.append(pays_Editeur);
		builder.append(", mail_Editeur=");
		builder.append(mail_Editeur);
		builder.append(", tel_Editeur=");
		builder.append(tel_Editeur);
		builder.append("]");
		return builder.toString();
	}

}
