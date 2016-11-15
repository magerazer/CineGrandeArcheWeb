package fr.demos.projet.controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.projet.donnees.Donnees;
import fr.demos.projet.metier.Article;
import fr.demos.projet.metier.LignePanier;
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

		RequestDispatcher rd = request.getRequestDispatcher("/PanierVue.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Donnees d = (Donnees) request.getServletContext().getAttribute("donnees");
		// List<Article> liste = d.remplirCatalogue();
		String ajouter = request.getParameter("ajouter");
		Panier panier = (Panier) session.getAttribute("panier");
		// permet de se repositionner sur la page à partir de laquelle on a
		// ajoute l'article
		String consulter = request.getParameter("consulter");
		String reference = request.getParameter("ref");
		String modifier = request.getParameter("modifierPanier");
		
		if ((ajouter != null && ajouter.equals("Ajouter")) || (
				modifier != null)) {
			String qteStr = request.getParameter("qte");

			int qte = 0;
			try {
				qte = Integer.parseInt(qteStr);
			} catch (NumberFormatException ex) {
				// gestion erreur conversion
			}
			//System.out.println("panier rempli : " + panier);
			Article a = d.rechercheArticle(reference);
			//System.out.println("article rempli : " + a);
			try {
				panier.ajouter(a, qte);
			} catch (StockException e) {

				e.printStackTrace();
			}
		}
		
		ArrayList<LignePanier> l = panier.getPanier();
		session.setAttribute("lignes", l);
			
		
		RequestDispatcher rd = null;
		if (consulter != null) {
			if (consulter.equals("false")) {

				rd = request.getRequestDispatcher("/ListeArticlesVue.jsp");
			} else{// garder l'article sur lequel on etait positionne

				System.out.println("ref = " + reference);
				Article a = d.rechercheArticle(reference);

				request.setAttribute("article", a);
				rd = request.getRequestDispatcher("/ArticleVue.jsp");
			} 
		} 
		
		if(modifier != null) {

			rd = request.getRequestDispatcher("/PanierVue.jsp");

		}
		
		
		rd.forward(request, response);

	}

}
