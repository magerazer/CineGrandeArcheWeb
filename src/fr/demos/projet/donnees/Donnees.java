package fr.demos.projet.donnees;

import java.util.ArrayList;
import java.util.List;

import fr.demos.projet.metier.Article;
import fr.demos.projet.metier.ArticleDivers;
import fr.demos.projet.metier.Compte;
import fr.demos.projet.metier.Etat;
import fr.demos.projet.metier.Livre;

public class Donnees {

	List<Article> liste;
	List<Compte> comptes;
	
	public Donnees() {
		liste = new ArrayList<>();
		comptes = new ArrayList<>();
		
		comptes.add(new Compte("id1", "pwd1"));
		comptes.add(new Compte("id2", "pwd2"));
		comptes.add(new Compte("id3", "pwd3"));
		
	}
	
	public List<Article> remplirCatalogue() {
		
		Article livre1 = new Livre("matLivre1", 25.0, "seigneur des anneaux1", 5, "Tolkien", "matLivre1");
		Article livre2 = new Livre("matOccasLivre1", 20.0, "seigneur anneaux2", 6, Etat.NEUF, "Tolkien", "matOccasLivre1");
		Article livre3 = new Livre("dematLivre1", 80.0, "seigneur des anneaux3", "kindle", "https://livrevirtuel.fr", "Tolkien","dematLivre1");
		
		Article dvd1 = new ArticleDivers("dvd1", 10.0, "Le cinma d'almodovar", 3);
		Article affiche1 = new ArticleDivers("affiche1", 5.0, "anneau", 1);
		
		Article pdf1 = new Livre("demat1", 3.0, "seigneurs des anneaux1", "pdf", "https://pdf1.com", "Tolkien", "123");
		Article kindle1 = new Livre("dematLivre2", 4.0, "Cinéma: Charlot", "kindle", "https://kindle1.com", "Felix", "123");
		 
		livre1.setImage("images/ref1.jpg");
		livre2.setImage("images/ref2.jpg");
		livre3.setImage("images/ref3.jpg");
		
		dvd1.setImage("images/dvd1.jpg");
		
		kindle1.setImage("images/kindle1.jpg");
		
		livre1.setDescription("La Terre est peuplée d'innombrables créatures étranges. Les Hobbits, apparentés à l'homme, mais proches également des Elfes et des Nains, vivent en paix au nord-ouest de l'Ancien Monde, dans la Comté. Paix précaire et menacée, cependant, depuis que Bilbon Sacquet a dérobé au monstre Gollum l'anneau de Puissance jadis forgé par Sauron de Mordor. Car cet anneau est doté d'un pouvoir immense et maléfique. Il permet à son détenteur de se rendre invisible et lui confère une autorité sans limite sur les possesseurs des autres anneaux. Bref, il fait de lui le Maître du Monde. C'est pourquoi Sauron s'est juré de reconquérir l'anneau par tous les moyens. Déjà ses Cavaliers Noirs rôdent aux frontières de la Comté…. Ainsi débute la trilogie du Seigneur des anneaux.");
		livre2.setDescription("La Terre est peuplée d'innombrables créatures étranges. Les Hobbits, apparentés à l'homme, mais proches également des Elfes et des Nains, vivent en paix au nord-ouest de l'Ancien Monde, dans la Comté. Paix précaire et menacée, cependant, depuis que Bilbon Sacquet a dérobé au monstre Gollum l'anneau de Puissance jadis forgé par Sauron de Mordor. Car cet anneau est doté d'un pouvoir immense et maléfique. Il permet à son détenteur de se rendre invisible et lui confère une autorité sans limite sur les possesseurs des autres anneaux. Bref, il fait de lui le Maître du Monde. C'est pourquoi Sauron s'est juré de reconquérir l'anneau par tous les moyens. Déjà ses Cavaliers Noirs rôdent aux frontières de la Comté…. Ainsi débute la trilogie du Seigneur des anneaux.");
		livre3.setDescription("La Terre est peuplée d'innombrables créatures étranges. Les Hobbits, apparentés à l'homme, mais proches également des Elfes et des Nains, vivent en paix au nord-ouest de l'Ancien Monde, dans la Comté. Paix précaire et menacée, cependant, depuis que Bilbon Sacquet a dérobé au monstre Gollum l'anneau de Puissance jadis forgé par Sauron de Mordor. Car cet anneau est doté d'un pouvoir immense et maléfique. Il permet à son détenteur de se rendre invisible et lui confère une autorité sans limite sur les possesseurs des autres anneaux. Bref, il fait de lui le Maître du Monde. C'est pourquoi Sauron s'est juré de reconquérir l'anneau par tous les moyens. Déjà ses Cavaliers Noirs rôdent aux frontières de la Comté…. Ainsi débute la trilogie du Seigneur des anneaux.");
		
		
		
		dvd1.setDescription("La Terre est peuplée d'innombrables créatures étranges. Les Hobbits, apparentés à l'homme, mais proches également des Elfes et des Nains, vivent en paix au nord-ouest de l'Ancien Monde, dans la Comté. Paix précaire et menacée, cependant, depuis que Bilbon Sacquet a dérobé au monstre Gollum l'anneau de Puissance jadis forgé par Sauron de Mordor. Car cet anneau est doté d'un pouvoir immense et maléfique. Il permet à son détenteur de se rendre invisible et lui confère une autorité sans limite sur les possesseurs des autres anneaux. Bref, il fait de lui le Maître du Monde. C'est pourquoi Sauron s'est juré de reconquérir l'anneau par tous les moyens. Déjà ses Cavaliers Noirs rôdent aux frontières de la Comté…. Ainsi débute la trilogie du Seigneur des anneaux.");
		
		kindle1.setDescription("La Terre est peuplée d'innombrables créatures étranges. Les Hobbits, apparentés à l'homme, mais proches également des Elfes et des Nains, vivent en paix au nord-ouest de l'Ancien Monde, dans la Comté. Paix précaire et menacée, cependant, depuis que Bilbon Sacquet a dérobé au monstre Gollum l'anneau de Puissance jadis forgé par Sauron de Mordor. Car cet anneau est doté d'un pouvoir immense et maléfique. Il permet à son détenteur de se rendre invisible et lui confère une autorité sans limite sur les possesseurs des autres anneaux. Bref, il fait de lui le Maître du Monde. C'est pourquoi Sauron s'est juré de reconquérir l'anneau par tous les moyens. Déjà ses Cavaliers Noirs rôdent aux frontières de la Comté…. Ainsi débute la trilogie du Seigneur des anneaux.");
		
		
		
		liste.add(livre1);
		liste.add(livre2);
		liste.add(livre3);
		liste.add(dvd1);
		liste.add(kindle1);
		
		return liste;
	}
	
	public Article rechercheArticle(String reference) {
		
		for(Article article : liste) {
			if(article.getRef().equals(reference))
				return article;
		}
		return null;		
	}
	
	public boolean compteValide(Compte c) {
		if(comptes.contains(c)) return true;
		return false;
	}
	
	public boolean userValide(String user) {
		Compte c = new Compte(user, "");
		if(comptes.contains(c)) return true;
		return false;
	}
	public boolean pwdValide(String user, String pwd) {
		Compte c = new Compte(user, "");
		int index = comptes.indexOf(c);
		if(index != -1) {
			Compte compteTrouve = comptes.get(index);
			if(compteTrouve.getPwd().equals(pwd)) return true;
		}
		return false;
	}

	public List<Compte> getComptes() {
		return comptes;
	}
	
	
	
}
