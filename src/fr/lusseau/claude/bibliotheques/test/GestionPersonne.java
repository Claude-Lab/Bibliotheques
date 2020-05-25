/**
 * 
 */
package fr.lusseau.claude.bibliotheques.test;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import fr.lusseau.claude.bibliotheques.bo.Personne;

/**
 * Classe en charge de gerer les personnes.
 * 
 * @Version Bibliotheques -v1,0
 * @date 25 mai 2020 - 22:09:45
 * @author claudelusseau
 *
 */
@Path("/personnes")
public class GestionPersonne {

	private static List<Personne> listePersonnes = new ArrayList<Personne>();

	static {
		listePersonnes.add(new Personne(1, "Claude", "Lusseau", "17 rue Paul Bert", "35000", "Rennes",
				"claude.lusseau@yahoo.fr", "06 22 05 50 42", "aeaeae", 1, null, null, null));
	}

	@GET
	public List<Personne> getPersonne() {
		return listePersonnes;
	}

	@GET
	@Path("/{id_Personne: \\d+")
	public Personne getPersonne(@PathParam("id_Personne") int id_Personne) {
		Personne personneARetourner = null;
		for (Personne personne : listePersonnes) {
			if (personne.getId_Personne() == id_Personne) {
				personneARetourner = personne;
				break;
			}
		}
		return personneARetourner;
	}

}
