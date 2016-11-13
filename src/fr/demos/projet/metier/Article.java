package fr.demos.projet.metier;

public class Article {
	
	private Dematerialise demat;
	private Materialise mat;	
	private String ref;
	private double prixHT;
	private String nom;
	private String description;
	private String image;
	private Etat etat;
	
	public Article(String ref, double prixHT, String nom) {
		this.ref = ref; 
		this.prixHT = prixHT;
		this.nom = nom;
	}
	// article d�materialis�
	public Article(String ref, double prixHT, String nom, String format, String url) {
		this(ref, prixHT, nom);		
		this.demat = new Dematerialise(format, url);
	}
	// article materialis�
	public Article(String ref, double prixHT, String nom, int stock) {
		this(ref, prixHT, nom);		
		this.mat = new Materialise(stock);
		this.etat = Etat.NEUF;
	}
	// d'occasion
	public Article(String ref, double prixHT, String nom, int stock, Etat etat) {
		this(ref, prixHT, nom);		
		this.mat = new Materialise(stock);
		this.etat = etat;
	}
	
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ref == null) ? 0 : ref.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (ref == null) {
			if (other.ref != null)
				return false;
		} else if (!ref.equals(other.ref))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += "ref=" + ref + ", prixHT=" + prixHT + ", nom=" + nom + ", etat=" + etat + ", description="
				+ description + ", ";
		if(mat == null) str += demat.toString();
		if(demat == null) str += mat.toString();
		str += ", ";
		return str;
	}
	
	// =========== debut getters et setters ================ //

	// getter pour recuperer le stock
	public Materialise getMat() {
		return mat;
	}

	public double getPrixHT() {
		return prixHT;
	}
	
	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRef() {
		return ref;
	}

	public String getNom() {
		return nom;
	}
	
	// =========== fin getters et setters ================ //
	
	
	
	
	
}
