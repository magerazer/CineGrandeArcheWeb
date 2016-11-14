package fr.demos.projet.donnees;

import java.util.ArrayList;
import java.util.List;

import fr.demos.projet.metier.Article;
import fr.demos.projet.metier.ArticleDivers;
import fr.demos.projet.metier.Livre;

public class Donnees {

	List<Article> liste;
	
	public Donnees() {
		liste = new ArrayList<>();
	}
	
	public List<Article> remplirCatalogue() {
		
		Article livre1 = new Livre("ref1", 25.0, "seigneur des anneaux1", 50, "Tolkien", "575");
		Article livre2 = new Livre("ref2", 20.0, "seigneur des anneaux2", 60, "Tolkien", "575");
		Article livre3 = new Livre("ref3", 80.0, "seigneur des anneaux3", 70, "Tolkien", "575");
		
		Article dvd1 = new ArticleDivers("dvd1", 10.0, "seigneur des anneaux1", 3);
		Article affiche1 = new ArticleDivers("affiche1", 5.0, "anneau", 1);
		
		Article pdf1 = new Livre("demat1", 3.0, "seigneurs des anneaux1", "pdf", "https://pdf1.com", "Tolkien", "123");
		Article kindle1 = new Livre("demat2", 4.0, "seigneurs des anneaux1", "kindle", "https://kindle1.com", "Tolkien", "123");
		 
		livre1.setImage("images/ref1.jpg");
		livre2.setImage("images/ref2.jpg");
		livre3.setImage("images/ref3.jpg");
		
		liste.add(livre1);
		liste.add(livre2);
		liste.add(livre3);
		
		return liste;
	}
	
	public Article rechercheArticle(String reference) {
		
		for(Article article : liste) {
			if(article.getRef().equals(reference))
				return article;
		}
		return null;		
	}
	
	
}
