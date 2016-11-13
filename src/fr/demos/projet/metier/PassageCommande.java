package fr.demos.projet.metier;

public class PassageCommande {

	Panier panier;
	
	public PassageCommande(Panier panier) {
		this.panier = panier;
	}
	
	public void creerCommande() throws AuthentificationException {
		Commande commande = new Commande();
		
		if(panier.getCompte() == null) {
			throw new AuthentificationException("Pas authentifié");
		}
		
		/*
		 ajout du panier à la commande
		 */
		LigneCommande ligCde;
		for (LignePanier lignePanier : panier) {
			ligCde = new LigneCommande(lignePanier.getArticle().getRef(), lignePanier.getArticle().getNom(), lignePanier.getArticle().getPrixHT());
			commande.ajouter(ligCde);
		}
		
		
	}

}
