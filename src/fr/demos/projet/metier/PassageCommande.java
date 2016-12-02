package fr.demos.projet.metier;

import java.util.List;

import fr.demos.projet.data.ArticleDAOMySQL;

public class PassageCommande {

	Panier panier;
	
	public PassageCommande(Panier panier) {
		this.panier = panier;
	}
	
	public Commande creerCommande(ArticleDAOMySQL articleDao) throws AuthentificationException {
		
		
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
			
			Article a = lignePanier.getArticle();
			Article article = articleDao.selectArticle(a.getRef()); 
			
			try {
				articleDao.updateStock(article, lignePanier.getQuantite());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("stock avant : " + a.getMat().getStock());		
			a.getMat().setStock(a.getMat().getStock() - lignePanier.getQuantite());
			System.out.println("stock après : " + a.getMat().getStock());
		}
		
		return commande;
	}

}
