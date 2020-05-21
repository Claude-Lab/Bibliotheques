package fr.lusseau.claude.bibliotheques.bo;

/**
 * Classe en charge des Ecrits (liaison entre livres et auteurs).
 * @version Bibliotheques -v1,0
 * @date  6 mai 2020 - 11:51:31
 * @author Claude LUSSEAU
 *
 */
public class Ecrit {

	private Integer id_Ecrit;
	private String isbn;
	
	/**
	 * Constructeur.
	 */
	public Ecrit() {
	}
	
	/**
	 * Constructeur.
	 * @param id_Ecrit
	 * @param isbn
	 */
	public Ecrit (Integer id_Ecrit, String isbn) {
		setId_Ecrit(id_Ecrit);
		setIsbn(isbn);
	}
	
	/**
	 * Constructeur.
	 * @param isbn
	 */
	public Ecrit (String isbn) {
		setIsbn(isbn);
	}

	/**
	 * Guetter pour id_Ecrit.
	 * @return the  id_Ecrit
	 */
	public Integer getId_Ecrit() {
		return id_Ecrit;
	}

	/**
	 * Setter pour id_Ecrit.
	 * @param id_Ecrit the id_Ecrit to set
	 */
	public void setId_Ecrit(Integer id_Ecrit) {
		this.id_Ecrit = id_Ecrit;
	}

	/**
	 * Guetter pour isbn.
	 * @return the  isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Setter pour isbn.
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 *
	 *  @return {@inheritDoc} 
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ecrit [id_Ecrit=");
		builder.append(id_Ecrit);
		builder.append(", isbn=");
		builder.append(isbn);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
