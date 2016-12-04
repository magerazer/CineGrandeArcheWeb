package fr.demos.projet.metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Commande implements  Iterable<LigneCommande>{
	
	ArrayList<LigneCommande> commandes;
	private LocalDate date;
	
	public Commande(LocalDate date) {  
		this.date = date;
		commandes = new ArrayList<>();
	}
	
	public void ajouter(LigneCommande ligne) {
		//commandes.add(new LigneCommande(reference, nom, prixHT));
		commandes.add(ligne);
	}

	@Override
	public Iterator<LigneCommande> iterator() {
		return commandes.iterator();
	}

	public LocalDate getDate() {
		return date;
	}
	
		
}


