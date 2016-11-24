package fr.demos.projet.controleur;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.projet.donnees.Donnees;
import fr.demos.projet.metier.Article;
import fr.demos.projet.metier.Panier;

/**
 * Servlet implementation class ListeArticleControleur
 */
@WebServlet("/ListeArticlesControleur")
public class ListeArticlesControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeArticlesControleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * Gestion du cas dematerialise : le client ne peut pas commander plus d'un article
		 * la variable quantiteDemat est presente lors de la premiere consultation puis des autres
		 * donc elle est en-dehors du if
		 * */
		int quantiteDemat = 0;
		HttpSession session = request.getSession();
		Donnees d = (Donnees) session.getAttribute("donnees");
		
		Panier p = (Panier) session.getAttribute("panier");
		
		Map<Article, Integer> dematListe = (Map<Article, Integer>) session.getAttribute("dematListe");
		/*
		 * Redirige vers la page de la liste des articles ou de la consultation
		 * d'un article selon que le paramètre consultation soit true ou false
		 * dans la requête
		 */
		if (request.getParameter("consultation") != null && request.getParameter("consultation").equals("true")) {
			System.out.println("consult qteDemat = " + quantiteDemat);
					
			
			
			String reference = request.getParameter("ref");
			System.out.println("ref = " + reference);
			Article a = d.rechercheArticle(reference);
		
			request.setAttribute("article", a);
			
			if(a.getMat() == null) {
				
				quantiteDemat = p.rechercherQte(a);
				dematListe.put(a, quantiteDemat);
				System.out.println("liste qteDemat = " + quantiteDemat);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/ArticleVue.jsp");
			rd.forward(request, response);
		} else {
			
			/*
			 * On veut connaitre la quantite dans le cas d'un article
			 * dématérialisé. Si elle est supérieure à 1, alors le bouton
			 * ajouter est bloqué.
			 * */
			for(Article a : (List<Article>)session.getAttribute("listeArticles")) {
				
				if(a.getMat() == null) {
					
					quantiteDemat = p.rechercherQte(a);
					dematListe.put(a, quantiteDemat);
					System.out.println("liste qteDemat = " + quantiteDemat);
				}
				
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ListeArticlesVue.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * Gestion de la recherche
		 */
		String action = request.getParameter("action");
		if (action != null && action.equals("Rechercher")) {
			RequestDispatcher rd = request.getRequestDispatcher("/ListeArticlesVue.jsp");
			rd.forward(request, response);
		}

	}

}
