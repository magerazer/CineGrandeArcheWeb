package fr.demos.projet.controleur.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.demos.projet.donnees.Donnees;
import fr.demos.projet.metier.Article;
import fr.demos.projet.metier.Panier;

/**
 * Application Lifecycle Listener implementation class PanierListener
 *
 */
@WebListener
public class PanierListener implements ServletContextListener, HttpSessionListener {

    /**
     * Default constructor. 
     */
    public PanierListener() {
       
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	Panier panier = new Panier();    	
    	arg0.getSession().setAttribute("panier", panier);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
        
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
       
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  {     	
    	Donnees donnees = new Donnees();
		List<Article> listeArticles = donnees.remplirCatalogue();
		
		arg0.getServletContext().setAttribute("donnees", donnees);
		arg0.getServletContext().setAttribute("listeArticles", listeArticles);
		
    }
	
}
