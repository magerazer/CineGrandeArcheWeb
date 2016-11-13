package fr.demos.projet.metier;

import java.util.ArrayList;
import java.util.Iterator;

public class Panier implements Iterable<LignePanier> {

	private Compte compte;
	private ArrayList<LignePanier> panier = new ArrayList<>();;

	public Panier() {
		compte = new Compte();
	}

	public Panier(Compte compte) {
		this.compte = compte;
	}

	// recalcule à chaque fois le prix total
	public int getPrixTotal() {
		int prixTotal = 0;
		for (LignePanier l : panier) {
			prixTotal += l.getArticle().getPrixHT() * l.getQuantite();
		}
		return prixTotal;
	}
	public void ajouter(Article a) {		
		if (!panier.contains(a)) {
			panier.add(new LignePanier(a, 1));
		}		

	}
	
	private void verifStock(Article a, int qte) throws StockException {
		int stock = 0;
		if (a.getMat() != null) {
			stock = a.getMat().getStock();
		}
		if (qte > stock) {
			throw new StockException(a, stock, qte);
		}

	}	

	public void ajouter(Article a, int qte) throws StockException {
		if (qte < 0) {
			throw new IllegalArgumentException("La quantite est negative");
		}
		/*
		 On crée une ligne du panier à partir de l'article car la comparaison de 
		 2 lignes se fait selon l'article. 2 cas se présentent :
		 */
		LignePanier l = new LignePanier(a, qte);
		int index = panier.indexOf(l);

		// 1) cas d'une ligne existante
		if (index != -1) {
			LignePanier ligneExistante = panier.get(index);
			qte = ligneExistante.getQuantite() + qte;

			// gestion de l'erreur sur le stock dans le cas d'une ligne
			// existante

			verifStock(a, qte);

			ligneExistante.setQuantite(qte);
		}
		// 2) cas d'une ligne inexistante
		else
		{
			verifStock(a, qte);
			panier.add(l);
		}

	}

	public void supprimerLigne(Article a) {
		LignePanier lp = new LignePanier(a, 0);
		int index = panier.indexOf(lp);
		if (index != -1)
			panier.remove(index);
	}

	public void modifierQte(Article argA, int qte) {
		LignePanier l = new LignePanier(argA, qte);
		int index = panier.indexOf(l);
		if (index != -1) {
			LignePanier lp = panier.get(index);
			lp.setQuantite(qte);
		}
	}

	public void diminuerQuantite(Article argA) {
		LignePanier l = new LignePanier(argA, 0);
		int index = panier.indexOf(l);
		if (index != -1) {
			LignePanier lp = panier.get(index);
			lp.setQuantite(lp.getQuantite() - 1);
		}
	}

	public void augmenterQuantite(Article argA) {
		LignePanier l = new LignePanier(argA, 0);
		int index = panier.indexOf(l);
		LignePanier lp = panier.get(index);
		lp.setQuantite(lp.getQuantite() + 1);
	}

	public void vider() {
		panier.removeAll(panier);
	}

	@Override
	public String toString() {
		String str = "\n============== Mon panier ===================\n";
		str += this.getCompte().getMail() + " total = " + this.getPrixTotal() + " €\n";
		for (LignePanier lignePanier : panier) {
			str += lignePanier.getArticle().getNom() + " " + lignePanier.getQuantite() + " \n";
		}
		str += "================ fin du panier ==================\n";
		return str;
	}

	public Compte getCompte() {
		return compte;
	}

	@Override
	public Iterator<LignePanier> iterator() {
		
		return panier.iterator();
	}

}
