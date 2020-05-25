package fr.lusseau.claude.bibliotheques.bo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe en charge des livres.
 * @version Bibliotheques -v1,0
 * @date  6 mai 2020 - 11:58:26
 * @author Claude LUSSEAU
 *
 */
public class Livre {

	private Integer id_Livre;
	private String titre_Livre;
	private LocalDateTime dateAchat_Livre;
	private String description_Livre;
	private String prenom_Nom_Auteur;
	private String isbn_Ecrit;
	private String nom_Bibliotheque;
	private String nom_Editeur;
	private String usage_Etat;
	private List<Auteur> listeAuteurs = new ArrayList<Auteur>();


	/**
	 * Constructeur.
	 */
	public Livre() {
	}

	/**
	 * Constructeur.
	 * @param id_Livre
	 * @param titre_Livre
	 * @param dateAchat_Livre
	 * @param description_Livre
	 * @param prenom_Nom_Auteur
	 * @param isbn_Ecrit
	 * @param nom_Editeur
	 * @param nom_Bibliotheque
	 * @param usage_Etat
	 */
	public Livre(Integer id_Livre, String titre_Livre, LocalDateTime dateAchat_Livre, String description_Livre,
			String prenom_Nom_Auteur, String isbn_Ecrit, String nom_Editeur, String nom_Bibliotheque, String usage_Etat) {
		setId_Livre(id_Livre);
		setTitre_Livre(titre_Livre);
		setDateAchat_Livre(dateAchat_Livre);
		setDescription_Livre(description_Livre);
		setPrenom_Nom_Auteur(prenom_Nom_Auteur);
		setIsbn_Ecrit(isbn_Ecrit);
		setNom_Bibliotheque(nom_Bibliotheque);
		setNom_Editeur(nom_Editeur);;
		setUsage_Etat(usage_Etat);

	}

	/**
	 * Constructeur.
	 * @param titre_Livre
	 * @param dateAchat_Livre
	 * @param description_Livre
	 * @param prenom_Nom_Auteur
	 * @param isbn_Ecrit
	 * @param nom_Editeur
	 * @param nom_Bibliotheque
	 * @param usage_Etat
	 */
	public Livre(String titre_Livre, LocalDateTime dateAchat_Livre, String description_Livre, String prenom_Nom_Auteur,
			String isbn_Ecrit, String nom_Editeur, String nom_Bibliotheque, String usage_Etat) {
		setTitre_Livre(titre_Livre);
		setDateAchat_Livre(dateAchat_Livre);
		setDescription_Livre(description_Livre);
		setPrenom_Nom_Auteur(prenom_Nom_Auteur);
		setIsbn_Ecrit(isbn_Ecrit);
		setNom_Bibliotheque(nom_Bibliotheque);
		setNom_Editeur(nom_Editeur);;
		setUsage_Etat(usage_Etat);
	}

	/**
	 * Guetter pour id_Livre.
	 * @return the  id_Livre
	 */
	public Integer getId_Livre() {
		return id_Livre;
	}

	/**
	 * Setter pour id_Livre.
	 * @param id_Livre the id_Livre to set
	 */
	public void setId_Livre(Integer id_Livre) {
		this.id_Livre = id_Livre;
	}

	/**
	 * Guetter pour titre_Livre.
	 * @return the  titre_Livre
	 */
	public String getTitre_Livre() {
		return titre_Livre;
	}

	/**
	 * Setter pour titre_Livre.
	 * @param titre_Livre the titre_Livre to set
	 */
	public void setTitre_Livre(String titre_Livre) {
		this.titre_Livre = titre_Livre;
	}

	/**
	 * Guetter pour dateAchat_Livre.
	 * @return the  dateAchat_Livre
	 */
	public LocalDateTime getDateAchat_Livre() {
		return dateAchat_Livre;
	}

	/**
	 * Setter pour dateAchat_Livre.
	 * @param dateAchat_Livre the dateAchat_Livre to set
	 */
	public void setDateAchat_Livre(LocalDateTime dateAchat_Livre) {
		this.dateAchat_Livre = dateAchat_Livre;
	}

	/**
	 * Guetter pour description_Livre.
	 * @return the  description_Livre
	 */
	public String getDescription_Livre() {
		return description_Livre;
	}

	/**
	 * Setter pour description_Livre.
	 * @param description_Livre the description_Livre to set
	 */
	public void setDescription_Livre(String description_Livre) {
		this.description_Livre = description_Livre;
	}

	/**
	 * Guetter pour prenom_Nom_Auteur.
	 * @return the  prenom_Nom_Auteur
	 */
	public String getPrenom_Nom_Auteur() {
		return prenom_Nom_Auteur;
	}

	/**
	 * Setter pour prenom_Nom_Auteur.
	 * @param prenom_Nom_Auteur the prenom_Nom_Auteur to set
	 */
	public void setPrenom_Nom_Auteur(String prenom_Nom_Auteur) {
		this.prenom_Nom_Auteur = prenom_Nom_Auteur;
	}

	/**
	 * Guetter pour isbn_Ecrit.
	 * @return the  isbn_Ecrit
	 */
	public String getIsbn_Ecrit() {
		return isbn_Ecrit;
	}

	/**
	 * Setter pour isbn_Ecrit.
	 * @param isbn_Ecrit the isbn_Ecrit to set
	 */
	public void setIsbn_Ecrit(String isbn_Ecrit) {
		this.isbn_Ecrit = isbn_Ecrit;
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
	 * Guetter pour listeAuteurs.
	 * @return the  listeAuteurs
	 */
	public List<Auteur> getListeAuteurs() {
		return listeAuteurs;
	}

	/**
	 * Setter pour listeAuteurs.
	 * @param listeAuteurs the listeAuteurs to set
	 */
	public void setListeAuteurs(List<Auteur> listeAuteurs) {
		this.listeAuteurs = listeAuteurs;
	}

	/**
	 *
	 *  @return {@inheritDoc} 
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("----------------------------------------------------").append("\n");
		buffer.append("id :  \t").append(this.id_Livre).append("\n");
		buffer.append("Livre :  \t").append(this.titre_Livre).append("\n");
		buffer.append("Auteur : ").append("\t").append(this.prenom_Nom_Auteur).append(" ").append("\n");
		buffer.append("description du livre : \t").append(this.description_Livre);
		buffer.append("\n\n");
		buffer.append("Numero ISBN : \t").append(this.isbn_Ecrit).append("\n");
		buffer.append("Bibliotheque : \t").append(this.nom_Bibliotheque).append("\n");
		buffer.append("Editeur : \t").append(this.nom_Editeur).append("\n");
		buffer.append("Date d'achat : \t").append(this.dateAchat_Livre).append("\n");
		buffer.append("Etat du livre : ").append(this.usage_Etat).append("\n");
		buffer.append("----------------------------------------------------\n");
		return buffer.toString();
	}

}
