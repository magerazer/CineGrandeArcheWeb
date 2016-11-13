package fr.demos.projet.metier;

import java.time.LocalDate;

public class LigneCommande {

	private String reference;
	private String nom;
	private double prixHT;
	
	//private LocalDate date;
	
	public LigneCommande(String reference, String nom, double prixHT) {
		this.reference = reference;
		this.nom = nom;
		this.prixHT = prixHT;
		
	}

	public String getReference() {
		return reference;
	}

	public String getNom() {
		return nom;
	}

	public double getPrixHT() {
		return prixHT;
	}

/*	public LocalDate getDate() {
		return date;
	}*/
	
	

}
