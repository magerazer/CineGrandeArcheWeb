package fr.demos.projet.controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Donnees donnees = new Donnees();
		List<Article> listeArticles = donnees.remplirCatalogue();		
		Panier panier = new Panier();
		
		request.getSession().setAttribute("donnees", donnees);
		request.setAttribute("listeArticles", listeArticles);
		request.setAttribute("panier", panier);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/ListeArticlesVue.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("reference"));
		Donnees d = (Donnees) request.getSession().getAttribute("donnees");
		List<Article> liste = (List<Article>) request.getAttribute("listeArticles");
		String reference = request.getParameter("ref");
		System.out.println("ref = " + reference);
		Article a = d.rechercheArticle(reference);
		
		request.setAttribute("article", a);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/ArticleVue.jsp");
		rd.forward(request, response);
		
		
	}

}
