package fr.lusseau.claude.bibliotheques.bo;

/**
 * @author Claude Lusseau
 */

public class AppTestBO {

	public static void main(String[] args) {

//		List<Livre> livres = null;
//		List<Client> clients = null;
//		List<Salarie> salaries = null;
//		List<LigneFiche> fiches = null;
//		List<Biblio> biblio = null;

		/**
		 * Test de la gestion des livres
		 */
//		try {
//			// Constitution d'une liste de livre
//			livres = new ArrayList<Livre>();

//			Livre l1 = new Livre(1, "Une Etique pou La Nature", "10/02/2019",
//					"Un traité phylosophique sus les écologismes et leur possibles rapports à la science de l'écologie.",
//					"Hans", "Jonnas", "978-2070729685", "Presse Universitaire", "Les Champs Libre", "neuf");
//
//			Livre l2 = new Livre(2, "La crise de la Culture", "10/10/2019",
//					"Un traité phylosophique sur les incohérences idéologiques.", "Hanna", "Arent",
//					"La Classe à Dallas", "978-2081410770", "Lucien Rose", "Usagé");
//
//			Livre l3 = new Livre(3, "Surveiller et Punir", "10/04/2020", "Tout est dans le titre !", "Hanna", "Arent",
//					"Poche", "978-2070326211", "Lucien Rose", "Bon");

			// Ajout des livres à la liste
//			livres.add(l1);
//			livres.add(l2);
//			livres.add(l3);

//			System.out.println("\nREM : Affichage du catalogue\n\n");
//
//			// Affichage de la liste des Livres
//			afficherCatalogue(livres);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		/**
//		 * Test de la gestion des Personnes
//		 */
//		try {
//			// Constitution d'une liste de salaries et de clients
//			clients = new ArrayList<Client>();
//
//			Personne p1 = new Client(1, "Adam", "Moreau", "Appartement 660-511 Eu Chemin", "11871", "My",
//					"Sed@vehicula.com", "02 56 17 16 48", "SXB21OYO7WF", 20);
//			Personne p2 = new Client(2, "Antonin", "Le roux", "3146 Phasellus Avenue", "32362", "İmamoğlu",
//					"orci.tincidunt@consectetuercursus.org", "04 45 61 88 10", "DMK92MXP7FF", 40);
//			Personne p3 = new Client(3, "Eva", "Perez", "5567 In Avenue", "89130", "Arbre",
//					"Vivamus.nibh.dolor@Suspendisseeleifend.co.uk", "07 33 52 98 11", "NZZ67WFZ7CR", 0);
//			Personne p4 = new Client(4, "Lamia", "Schneider", "7116 Nibh Rd.", "00532", "Provost",
//					"lacus.Mauris@enim.org", "08 51 23 13 02", "VXZ81UKU0BT", 80);
//
//			// Ajout des Clients à la liste
//			clients.add((Client) p1);
//			clients.add((Client) p2);
//			clients.add((Client) p3);
//			clients.add((Client) p4);
//
//			// Affichage de la liste des Client
//			afficherClients(clients);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		/**
//		 * Test de la gestion des Personnes
//		 */
//		try {
//			// Constitution d'une liste de salaries
//			salaries = new ArrayList<Salarie>();
//
//			Personne p5 = new Salarie(5, "Alexandre", "Perrin", "Appartement 405-3842 Ullamcorper. Route", "66362",
//					"Barchi", "nunc@nisi.org", "07 83 31 28 40", "ISR14FGN2HB", "Technicien");
//			Personne p6 = new Salarie(6, "Gilbert", "Robin", "8738 Ad Rue", "04123", "Sart-Dames-Avelines",
//					"non.egestas.a@augueac.com", "04 45 37 27 64", "BMQ44KNZ8XT", "Administrateur");
//
//			// Ajout des salaries à la liste
//			salaries.add((Salarie) p5);
//			salaries.add((Salarie) p6);
//
//			// Affichage de la liste des Salaries
//			afficherSalaries(salaries);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		/**
//		 * Test de la gestion des bibliotheque
//		 */
//		try {
//			// Constitution d'une liste des bibliotheques
//			biblio = new ArrayList<Biblio>();
//
//			Biblio b1 = new Biblio(1, "Les Champs Libre", "Place Charles de Gaule", "35000", "Rennes",
//					"07 83 31 28 40");
//			Biblio b2 = new Biblio(2, "Lucien Rose", "Boulevard de la Duchesse Anne", "35000", "Rennes",
//					"07 83 31 28 40");
//
//			// Ajout des bibliotheques à la liste
//			biblio.add(b1);
//			biblio.add(b2);
//
//			// Affichage de la liste des bibliotheques
//			afficherBiblio(biblio);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		/**
//		 * Test du Panier
//		 */
//
//		PanierEmprunt panier = new PanierEmprunt();
//		try {
//			panier.addLigne(livres.get(1),clients.get(2), ("12/10/2019"), ("12/11/2019"), biblio.get(1));
//			panier.addLigne(((Livre)livres.get(2)), (Personne)clients.get(1), ("03/09/2019"), ("05/11/2019"), (Biblio)biblio.get(0));
//			System.out.println("\nREM : Affichage de les articles du panier");
//			System.out.println(panier.getLigne(0));
//			System.out.println(panier.getLigne(1));
//
//		} catch (Exception e) {
//			System.out.println("Erreur : " + e.getMessage());
//		}
//
//	}
//
//	private static void afficherCatalogue(List<Livre> livres) {
//		for (Livre livre : livres) {
//			System.out.println(livre.toString());
//		}
//	}
//
//	private static void afficherSalaries(List<Salarie> salaries) {
//		for (Salarie salarie : salaries) {
//			System.out.println(salarie.toString());
//		}
//	}
//
//	private static void afficherClients(List<Client> clients) {
//		for (Client client : clients) {
//			System.out.println(client.toString());
//		}
//	}
//
//	private static void afficherBiblio(List<Biblio> biblio) {
//		for (Biblio bib : biblio) {
//			System.out.println(bib.toString());
//		}
	}

}
