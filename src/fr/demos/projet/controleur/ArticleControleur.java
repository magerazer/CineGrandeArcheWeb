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

/**
 * Servlet implementation class ArticleControleur
 */
@WebServlet("/ArticleControleur")
public class ArticleControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleControleur() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Donnees d = (Donnees) request.getSession().getAttribute("donnees");
		List<Article> liste = (List<Article>) request.getAttribute("listeArticles");
		String reference = request.getParameter("ref");
		System.out.println("ref = " + reference);
		Article a = d.rechercheArticle(reference);
		
		request.setAttribute("article", a);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/ArticleVue.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
