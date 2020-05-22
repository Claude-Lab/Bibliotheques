package fr.lusseau.claude.bibliotheques.servlets;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
		
	/**
	 * 
	 * Code Resultat Roles
	 */
	public static final int INSERT_ROLE_NULL = 10020;
	public static final int INSERT_ROLE_ECHEC = 10021;
	public static final int UPDATE_ROLE_NULL = 10022;
	public static final int UPDATE_ROLE_ECHEC = 10023;
	public static final int DELETE_ROLE_NULL = 10024;
	public static final int DELETE_ROLE_ECHEC = 10025;
	public static final int LECTURE_ROLE_ECHEC = 10026;

	/**
	 * 
	 * Code Resultat Cotisations
	 */
	public static final int INSERT_COTISATION_NULL = 10030;
	public static final int INSERT_COTISATION_ECHEC = 10031;
	public static final int UPDATE_COTISATION_NULL = 10032;
	public static final int UPDATE_COTISATION_ECHEC = 10033;
	public static final int DELETE_COTISATION_ECHEC = 10034;
	public static final int DELETE_COTISATION_NULL = 10035;
	public static final int LECTURE_COTISATION_ECHEC = 10036;

	/**
	 * 
	 * Code Resultat Personnes
	 */
	public static final int INSERT_PERSONNE_NULL = 10040;
	public static final int INSERT_PERSONNE_ECHEC = 10041;
	public static final int UPDATE_PERSONNE_NULL = 10042;
	public static final int UPDATE_PERSONNE_ECHEC = 10043;
	public static final int DELETE_PERSONNE_ECHEC = 10044;
	public static final int DELETE_PERSONNE_NULL = 10045;
	public static final int LECTURE_PERSONNE_ECHEC = 10046;
	public static final int LECTURE_PERSONNE_BY_FIRST_NAME_NULL = 10047;
	public static final int LECTURE_PERSONNE_BY_FIRST_NAME_ECHEC = 10048;
	public static final int LECTURE_PERSONNE_BY_ID_NULL = 10049;
	public static final int LECTURE_PERSONNE_BY_ID_ECHEC = 10050;
	public static final int LECTURE_SALARIES_ECHEC = 10051;
	public static final int LECTURE_CLIENTS_ECHEC = 10052;
	public static final int LECTURE_PERSONNE_BY_MAIL_NULL = 10053;

	
	/**
	 * 
	 * Code Resultat Etat
	 */
	public static final int INSERT_ETAT_NULL = 10060;
	public static final int INSERT_ETAT_ECHEC = 10061;
	public static final int UPDATE_ETAT_NULL = 10062;
	public static final int UPDATE_ETAT_ECHEC = 10063;
	public static final int DELETE_ETAT_NULL = 10064;
	public static final int DELETE_ETAT_ECHEC = 10065;
	public static final int LECTURE_ETAT_ECHEC = 10066;
	
	/**
	 * 
	 * Code Resultat Auteur
	 */
	public static final int INSERT_AUTEUR_NULL = 10070;
	public static final int INSERT_AUTEUR_ECHEC = 10071;
	public static final int UPDATE_AUTEUR_NULL = 10072;
	public static final int UPDATE_AUTEUR_ECHEC = 10073;
	public static final int DELETE_AUTEUR_NULL = 10074;
	public static final int DELETE_AUTEUR_ECHEC = 10075;
	public static final int LECTURE_AUTEUR_ECHEC = 10076;
	
	
	/**
	 * 
	 * Code Resultat Editeur
	 */
	public static final int INSERT_EDITEUR_NULL = 10080;
	public static final int INSERT_EDITEUR_ECHEC = 10081;
	public static final int UPDATE_EDITEUR_NULL = 10082;
	public static final int UPDATE_EDITEUR_ECHEC = 10083;
	public static final int DELETE_EDITEUR_NULL = 10084;
	public static final int DELETE_EDITEUR_ECHEC = 10085;
	public static final int LECTURE_EDITEUR_ECHEC = 10086;

	
	/**
	 * 
	 * Code Resultat Livre
	 */
	public static final int LECTURE_LIVRE_ECHEC = 10100;
	public static final int LECTURE_LIVRE_BY_ID_NULL = 10101;
	public static final int LECTURE_LIVRE_BY_ID_ECHEC = 10102;
	public static final int UPDATE_LIVRE_ECHEC = 10103;
	public static final int INSERT_AUTEUR_LIVRE_NULL = 10104;
	public static final int INSERT_AUTEUR_LIVRE_ECHEC = 10105;
	public static final int INSERT_EDITEUR_LIVRE_NULL = 10106;
	public static final int INSERT_EDITEUR_LIVRE_ECHEC = 10107;
	public static final int INSERT_BIBLIO_LIVRE_NULL = 10108;
	public static final int INSERT_BIBLIO_LIVRE_ECHEC = 10109;
	public static final int INSERT_LIVRE_NULL = 10110;
	public static final int INSERT_LIVRE_ECHEC = 10111;
	public static final int DELETE_LIVRE_NULL = 10112;
	public static final int DELETE_LIVRE_ECHEC = 10113;
	public static final int LECTURE_LIVRE_BY_TITLE_ECHEC = 10114;
	public static final int LECTURE_LIVRE_BY_AUTHORS_ECHEC = 10115;
	
	
	/**
	 * 
	 * Code Resultat Bibliotheque
	 */
	public static final int INSERT_BIBLIOTHEQUE_NULL = 10120;
	public static final int INSERT_BIBLIOTHEQUE_ECHEC = 10121;
	public static final int UPDATE_BIBLIOTHEQUE_NULL = 10122;
	public static final int UPDATE_BIBLIOTHEQUE_ECHEC = 10123;
	public static final int DELETE_BIBLIOTHEQUE_NULL = 10124;
	public static final int DELETE_BIBLIOTHEQUE_ECHEC = 10125;
	public static final int LECTURE_BIBLIOTHEQUE_ECHEC = 10126;
	public static final int LECTURE_BIBLIOTHEQUE_BY_ID_NULL = 10127;
	public static final int LECTURE_BIBLIOTHEQUE_BY_ID_ECHEC = 10128;
	public static final int LECTURE_BIBLIOTHEQUE_BY_NAME_NULL = 10129;
	public static final int LECTURE_BIBLIOTHEQUE_BY_NAME_ECHEC = 10130;
	public static final int CONNEXION_PERSONNE_NULL = 10131;
	public static final int CONNEXION_PERSONNE__ECHEC = 10132;
	
	
	
}
