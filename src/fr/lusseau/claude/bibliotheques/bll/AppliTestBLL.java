package fr.lusseau.claude.bibliotheques.bll;

import java.util.ArrayList;
import java.util.List;

import fr.lusseau.claude.bibliotheques.bo.Cotisation;

public class AppliTestBLL {

	public static void main(String[] args) throws BLLException {
		
		
		List<Cotisation> cotisations = new ArrayList<>();
		CotisationManager manager = null;
		try {
			manager = new CotisationManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			for (@SuppressWarnings("unused") Cotisation cot : cotisations) {
				try {
					manager.addCotisation(10, 20);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(manager.allCotisation());
			
		} catch (BLLException e1) {
			e1.printStackTrace();
		}
		

	}

}
