package fr.lusseau.claude.bibliotheques.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	
	/**
	 * Erreur CotisationManager
	 */
	public static final int REGLE_COTISATION_ID_ERREUR = 20000;
	public static final int REGLE_COTISATION_VALEUR_ERREUR = 20001;
	public static final int REGLE_COTISATION_ERREUR_INSERT = 20002;
	public static final int REGLE_VALIDER_COTISATION_ERREUR = 20003;
	public static final int REGLE_NO_VALIDER_COTISATION_ERREUR = 20004;
	public static final int REGLE_VALIDER_VALEUR_COTISATION_ERREUR = 20005;
	public static final int REGLE_VALIDER_NBR_EMPRUNT_COTISATION_ERREUR = 20006;
	
	
	
	/**
	 * Erreur PersonneManager
	 */
	public static final int REGLE_VALIDER_PERSONNE_ERREUR = 20020;
	public static final int REGLE_VALIDER_ROLE_ERREUR = 20030;
	public static final int REGLE_VALIDER_BIBLIOTHEQUE_ERREUR = 20040;
	public static final int REGLE_VALIDER_AUTEUR_ERREUR = 20050;
	public static final int REGLE_VALIDER_ETAT_ERREUR = 20060;
	
	
}
