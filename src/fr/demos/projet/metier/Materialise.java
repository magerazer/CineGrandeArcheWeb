package fr.demos.projet.metier;

public class Materialise {

	private int stock;
	private double coutLivraison;
	
	public Materialise(int stock) {
		this.stock = stock;
	}
	
	

	@Override
	public String toString() {
		return "stock=" + stock + ", coutLivraison=" + coutLivraison;
	}



	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getCoutLivraison() {
		return coutLivraison;
	}

	public void setCoutLivraison(double coutLivraison) {
		this.coutLivraison = coutLivraison;
	}
	
	

}
