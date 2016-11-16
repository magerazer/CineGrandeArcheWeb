package fr.demos.projet.controleur;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.projet.donnees.Donnees;
import fr.demos.projet.metier.Compte;

/**
 * Servlet implementation class CompteControleur
 */
@WebServlet("/CompteControleur")
public class CompteControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompteControleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/ListeArticlesVue.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Donnees d = (Donnees) request.getServletContext().getAttribute("donnees");
		HttpSession session = request.getSession();
		Map<String, String> erreursConnexion = (Map<String, String>) session.getAttribute("erreursConnexion");
		String connexion = request.getParameter("connexion");
		String deconnexion = request.getParameter("deconnexion");
		Compte compte = null;
		String mail;
		String pwd;
		boolean erreur = false;
		if (connexion != null) {
			
			mail = request.getParameter("mail");
			pwd = request.getParameter("pwd");

			/*
			 * gestion de la saisie du mail et du mot de passe renvoyer une
			 * erreur si la saisie est incorrecte : - soit l'utilisateur ne
			 * saisi rien - soit le compte n'est pas présent en bdd
			 */
			if (mail == null || mail.equals("")) {
				erreur = true;
				erreursConnexion.put("mail", "Vous devez saisir un mail");
			} else {
				if(d.userValide(mail)) {
					
				}
			}
			if (pwd == null || pwd.equals("")) {
				erreur = true;
				erreursConnexion.put("pwd", "Vous devez saisir un mot de passe");
			}

			
			
			if (!erreur) {
				compte = new Compte();
				compte.setMail(mail);
				compte.setPwd(pwd);
			}
			session.setAttribute("compte", compte);

		}
		if (deconnexion != null) {
			session.setAttribute("compte", null);

		}

		RequestDispatcher rd = request.getRequestDispatcher("/ListeArticlesVue.jsp");
		rd.forward(request, response);
	}
	
	

}
