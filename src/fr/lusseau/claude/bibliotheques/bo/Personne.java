package fr.lusseau.claude.bibliotheques.bo;

import java.time.LocalDate;

/**
 * Classe en charge des personnes
 * @version Bibliotheques -v1,0
 * @date  6 mai 2020 - 11:59:19
 * @author Claude LUSSEAU
 *
 */
public class Personne {

	private Integer id_Personne;
	private String prenom_Personne;
	private String nom_Personne;
	private String adresse_Personne;
	private String cp_Personne;
	private String ville_Personne;
	private String mail_Personne;
	private String tel_Personne;
	private String motDePasse_Personne;
	private String type_Personne;
	private int cotisation_Personne;
	private String role_Personne;
	private LocalDate inscription_Personne;

	
	/**
	 * Constructeur.
	 */
	public Personne() {
	}

	/**
	 * Constructeur.
	 * @param id_Personne
	 * @param prenom_Personne
	 * @param nom_Personne
	 * @param adresse_Personne
	 * @param cp_Personne
	 * @param ville_Personne
	 * @param mail_Personne
	 * @param tel_Personne
	 * @param motDePasse_Personne
	 * @param cotisation_Personne
	 * @param role_Personne
	 * @param type_Personne
	 * @param inscription_Personne
	 */
	public Personne(Integer id_Personne, String prenom_Personne, String nom_Personne, String adresse_Personne,
			String cp_Personne, String ville_Personne, String mail_Personne, String tel_Personne, String motDePasse_Personne, int cotisation_Personne, String role_Personne, String type_Personne, LocalDate inscription_Personne) {
		
		setId_Personne(id_Personne);
		setPrenom_Personne(prenom_Personne);
		setNom_Personne(nom_Personne);
		setAdresse_Personne(adresse_Personne);
		setCp_Personne(cp_Personne);
		setVille_Personne(ville_Personne);
		setMail_Personne(mail_Personne);
		setTel_Personne(tel_Personne);
		setMotDePasse_Personne(motDePasse_Personne);
		setInscription_Personne(inscription_Personne);
		setRole_Personne(role_Personne);
		setCotisation_Personne(cotisation_Personne);
		setType_Personne(role_Personne);
	}
	
	/**
	 * Constructeur.
	 * @param prenom_Personne
	 * @param nom_Personne
	 * @param adresse_Personne
	 * @param cp_Personne
	 * @param ville_Personne
	 * @param mail_Personne
	 * @param tel_Personne
	 * @param motDePasse_Personne
	 * @param cotisation_Personne
	 * @param role_Personne
	 * @param type_Personne
	 * @param inscription_Personne
	 */
	public Personne(String prenom_Personne, String nom_Personne, String adresse_Personne,
			String cp_Personne, String ville_Personne, String mail_Personne, String tel_Personne, String motDePasse_Personne, int cotisation_Personne, String role_Personne, String type_Personne, LocalDate inscription_Personne) {
		
		setPrenom_Personne(prenom_Personne);
		setNom_Personne(nom_Personne);
		setAdresse_Personne(adresse_Personne);
		setCp_Personne(cp_Personne);
		setVille_Personne(ville_Personne);
		setMail_Personne(mail_Personne);
		setTel_Personne(tel_Personne);
		setMotDePasse_Personne(motDePasse_Personne);
		setInscription_Personne(inscription_Personne);
		setRole_Personne(role_Personne);
		setCotisation_Personne(cotisation_Personne);
		setType_Personne(type_Personne);
	}

	
	/**
	 * Guetter pour id_Personne.
	 * @return the  id_Personne
	 */
	public Integer getId_Personne() {
		return id_Personne;
	}

	/**
	 * Setter pour id_Personne.
	 * @param id_Personne the id_Personne to set
	 */
	public void setId_Personne(Integer id_Personne) {
		this.id_Personne = id_Personne;
	}

	/**
	 * Guetter pour prenom_Personne.
	 * @return the  prenom_Personne
	 */
	public String getPrenom_Personne() {
		return prenom_Personne;
	}

	/**
	 * Setter pour prenom_Personne.
	 * @param prenom_Personne the prenom_Personne to set
	 */
	public void setPrenom_Personne(String prenom_Personne) {
		this.prenom_Personne = prenom_Personne;
	}

	/**
	 * Guetter pour nom_Personne.
	 * @return the  nom_Personne
	 */
	public String getNom_Personne() {
		return nom_Personne;
	}

	/**
	 * Setter pour nom_Personne.
	 * @param nom_Personne the nom_Personne to set
	 */
	public void setNom_Personne(String nom_Personne) {
		this.nom_Personne = nom_Personne;
	}

	/**
	 * Guetter pour adresse_Personne.
	 * @return the  adresse_Personne
	 */
	public String getAdresse_Personne() {
		return adresse_Personne;
	}

	/**
	 * Setter pour adresse_Personne.
	 * @param adresse_Personne the adresse_Personne to set
	 */
	public void setAdresse_Personne(String adresse_Personne) {
		this.adresse_Personne = adresse_Personne;
	}

	/**
	 * Guetter pour cp_Personne.
	 * @return the  cp_Personne
	 */
	public String getCp_Personne() {
		return cp_Personne;
	}

	/**
	 * Setter pour cp_Personne.
	 * @param cp_Personne the cp_Personne to set
	 */
	public void setCp_Personne(String cp_Personne) {
		this.cp_Personne = cp_Personne;
	}

	/**
	 * Guetter pour ville_Personne.
	 * @return the  ville_Personne
	 */
	public String getVille_Personne() {
		return ville_Personne;
	}

	/**
	 * Setter pour ville_Personne.
	 * @param ville_Personne the ville_Personne to set
	 */
	public void setVille_Personne(String ville_Personne) {
		this.ville_Personne = ville_Personne;
	}

	/**
	 * Guetter pour mail_Personne.
	 * @return the  mail_Personne
	 */
	public String getMail_Personne() {
		return mail_Personne;
	}

	/**
	 * Setter pour mail_Personne.
	 * @param mail_Personne the mail_Personne to set
	 */
	public void setMail_Personne(String mail_Personne) {
		this.mail_Personne = mail_Personne;
	}

	/**
	 * Guetter pour tel_Personne.
	 * @return the  tel_Personne
	 */
	public String getTel_Personne() {
		return tel_Personne;
	}

	/**
	 * Setter pour tel_Personne.
	 * @param tel_Personne the tel_Personne to set
	 */
	public void setTel_Personne(String tel_Personne) {
		this.tel_Personne = tel_Personne;
	}

	/**
	 * Guetter pour motDePasse_Personne.
	 * @return the  motDePasse_Personne
	 */
	public String getMotDePasse_Personne() {
		return motDePasse_Personne;
	}

	/**
	 * Setter pour motDePasse_Personne.
	 * @param motDePasse_Personne the motDePasse_Personne to set
	 */
	public void setMotDePasse_Personne(String motDePasse_Personne) {
		this.motDePasse_Personne = motDePasse_Personne;
	}

	/**
	 * Guetter pour type_Personne.
	 * @return the  type_Personne
	 */
	public String getType_Personne() {
		return type_Personne;
	}

	/**
	 * Setter pour type_Personne.
	 * @param type_Personne the type_Personne to set
	 */
	public void setType_Personne(String type_Personne) {
		this.type_Personne = type_Personne;
	}

	/**
	 * Guetter pour inscription_Personne.
	 * @return the inscription_Personne
	 */
	public LocalDate getInscription_Personne() {
		return inscription_Personne;
	}

	/**
	 * Setter pour inscription_Personne.
	 * @param inscription_Personne the inscription_Personne to set
	 */
	public void setInscription_Personne(LocalDate inscription_Personne) {
		this.inscription_Personne = inscription_Personne;
	}
	

	public String getRole_Personne() {
		return role_Personne;
	}

	public void setRole_Personne(String role_Personne) {
		this.role_Personne = role_Personne;
	}

	public int getCotisation_Personne() {
		return cotisation_Personne;
	}

	public void setCotisation_Personne(int cotisation_Personne) {
		this.cotisation_Personne = cotisation_Personne;
	}

	/**
	 *
	 *  @return {@inheritDoc} 
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("------------------------\n");
		buffer.append("id : ").append(this.getId_Personne()).append("\n");
		buffer.append("Prenom : ").append(this.getPrenom_Personne()).append("\n");
		buffer.append("Nom : ").append(this.getNom_Personne()).append("\n");
		buffer.append("Adresse : ").append(this.getAdresse_Personne()).append("\n");
		buffer.append("Code postal : ").append(this.getCp_Personne()).append("\n");
		buffer.append("Ville : ").append(this.getVille_Personne()).append("\n");
		buffer.append("Mail : ").append(this.getMail_Personne()).append("\n");
		buffer.append("Tel : ").append(this.getTel_Personne()).append("\n");
		buffer.append("Type : ").append(this.getType_Personne()).append("\n");
		return buffer.toString();
	}
}
