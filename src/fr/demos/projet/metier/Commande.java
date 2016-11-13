package fr.demos.projet.metier;

import java.time.LocalDate;
import java.util.ArrayList;

public class Commande {
	
	ArrayList<LigneCommande> commandes;
		
	
	public Commande() {  
		
		commandes = new ArrayList<>();
	}
	
	public void ajouter(LigneCommande ligne) {
		//commandes.add(new LigneCommande(reference, nom, prixHT));
		commandes.add(ligne);
	}
	
		
}



