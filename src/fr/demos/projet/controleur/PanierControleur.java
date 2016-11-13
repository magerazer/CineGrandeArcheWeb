package fr.demos.projet.controleur;

import java.io.IOException;
import java.util.List;

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
import fr.demos.projet.metier.StockException;

/**
 * Servlet implementation class PanierControleur
 */
@WebServlet("/PanierControleur")
public class PanierControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PanierControleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	/*	HttpSession session = request.getSession();
		Donnees d = (Donnees) session.getAttribute("donnees");
		List<Article> liste = d.remplirCatalogue();
		String action = request.getParameter("ajoutPanier");
		Panier panier = (Panier) session.getAttribute("panier");
		
		if (action != null && action.equals("Ajouter au panier")) {
			String qteStr = request.getParameter("qte");
			String reference = request.getParameter("ref");
			int qte = 0;
			try {
				qte = Integer.parseInt(qteStr);
			} catch (NumberFormatException ex) {
				// gestion erreur conversion
			}

			Article a = d.rechercheArticle(reference);
			try {
				panier.ajouter(a, qte);
			} catch (StockException e) {
				
				e.printStackTrace();
			}
			
		}
*/
		RequestDispatcher rd = request.getRequestDispatcher("/ArticleVue.jsp");
		rd.forward(request, response);

	}

}
