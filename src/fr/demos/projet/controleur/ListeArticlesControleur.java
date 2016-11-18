package fr.demos.projet.controleur;

import java.io.IOException;

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
		if (request.getParameter("consultation") != null 
				&& request.getParameter("consultation").equals("true")) {
			HttpSession session = request.getSession();
			Donnees d = (Donnees) request.getServletContext().getAttribute("donnees");
			String reference = request.getParameter("ref");
			System.out.println("ref = " + reference);
			Article a = d.rechercheArticle(reference);
			Panier p = (Panier) session.getAttribute("panier");
			
			request.setAttribute("article", a);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/ArticleVue.jsp");
			rd.forward(request, response);
		}
		else {
			
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
		String action = request.getParameter("action");
		if (action != null && action.equals("Rechercher")) {
			RequestDispatcher rd = request.getRequestDispatcher("/ListeArticlesVue.jsp");
			rd.forward(request, response);
		}
		
	}

}
