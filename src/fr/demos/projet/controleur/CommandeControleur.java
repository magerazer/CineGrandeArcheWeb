package fr.demos.projet.controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.projet.data.ArticleDAOMySQL;
import fr.demos.projet.metier.AuthentificationException;
import fr.demos.projet.metier.Commande;
import fr.demos.projet.metier.Panier;
import fr.demos.projet.metier.PassageCommande;

/**
 * Servlet implementation class CommandeControleur
 */
@WebServlet("/CommandeControleur")
public class CommandeControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Panier p = (Panier) session.getAttribute("panier");
		ArticleDAOMySQL articleDao = (ArticleDAOMySQL) request.getServletContext().getAttribute("articleDao");
		
		PassageCommande creationCommande = new PassageCommande(p);
		try {
			Commande com = creationCommande.creerCommande(articleDao);
		} catch (AuthentificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/PanierVue.jsp");
		rd.forward(request, response);
	}

}
