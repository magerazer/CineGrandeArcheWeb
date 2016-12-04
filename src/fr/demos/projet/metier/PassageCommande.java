package fr.demos.projet.metier;

import java.time.LocalDate;
import java.time.LocalDateTime;

import fr.demos.projet.data.ArticleDAOMySQL;

public class PassageCommande {

	Panier panier;
	Compte compte;
	
	public PassageCommande(Panier panier, Compte compte) {
		this.panier = panier;
		this.compte = compte;
	}
	
	public Commande creerCommande(ArticleDAOMySQL articleDao) throws AuthentificationException {
		System.out.println("erreur Compte disparait bouton commande");
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate dateCde = currentTime.toLocalDate();
		Commande commande = new Commande(dateCde);
		System.out.println("erreur Compte disparait bouton commande");
		
		if(compte == null) {
			throw new AuthentificationException("Pas authentifié");
		}
		System.out.println("erreur Compte disparait bouton commande");
		/*
		 ajout du panier à la commande
		 */
		LigneCommande ligCde;
		for (LignePanier lignePanier : panier) {
			System.out.println("erreur Compte disparait bouton commande");
			ligCde = new LigneCommande(dateCde, lignePanier.getArticle().getRef(), lignePanier.getArticle().getNom(), lignePanier.getArticle().getPrixHT(), lignePanier.getQuantite(), lignePanier.getArticle().getImage());
			commande.ajouter(ligCde);
			
			Article a = lignePanier.getArticle();
			Article article = articleDao.selectArticle(a.getRef()); 
			
			try {
				articleDao.updateStock(article, lignePanier.getQuantite());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			/*
			System.out.println("stock avant : " + a.getMat().getStock());		
			a.getMat().setStock(a.getMat().getStock() - lignePanier.getQuantite());
			System.out.println("stock après : " + a.getMat().getStock());
			*/
		}
		
		
		return commande;
	}

}
