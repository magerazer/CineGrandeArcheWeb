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
		
		HttpSession session = request.getSession();
		Donnees d = (Donnees) session.getAttribute("donnees");
		
		Map<String, String> erreursConnexion = new HashMap<String, String>();
		request.setAttribute("erreursConnexion", erreursConnexion);
		Map<String, String> erreursCompte = new HashMap<String, String>();
		request.setAttribute("erreursCompte", erreursCompte);
		
		String connexion = request.getParameter("connexion");
		String deconnexion = request.getParameter("deconnexion");
		String creationCompte = request.getParameter("creationCompte");
		String validerCompte = request.getParameter("validerCompte");
		
		Compte compte = null;
		
		
		boolean erreur = false;
		// si l'utilisateur de connecte
		if (connexion != null) {
			
			String mail = request.getParameter("mail");
			String pwd = request.getParameter("pwd");

			/*
			 * gestion de la saisie du mail et du mot de passe renvoyer une
			 * erreur si la saisie est incorrecte : - soit l'utilisateur ne
			 * saisi rien - soit le compte n'est pas présent en bdd
			 */
			if (mail == null || mail.equals("")) {
				erreur = true;
				erreursConnexion.put("mail", "Vous devez saisir un mail");
			} else {
				if(!d.userValide(mail)) {
					erreursConnexion.put("mail", "mail incorrect");
				} else {
					if (pwd == null || pwd.equals("")) {
						erreur = true;
						erreursConnexion.put("pwd", "Vous devez saisir un mot de passe");
					}
					else {
						if(!d.pwdValide(mail, pwd)) {
							erreur = true;
							erreursConnexion.put("pwd", "Votre mot de passe n'est pas valide");
						}
						else {
							erreur = false;
							Compte c = new Compte(mail, pwd);
							session.setAttribute("compte", c);
						}
					}
				}
					
			}
			
		}
		// si l'utilisateur se déconnecte
		if (deconnexion != null) {
			session.setAttribute("compte", null);

		}
		// si l'utilisateur veut créer un compte
		if (creationCompte != null) {
			
			String mail = request.getParameter("mail");
			String pwd = request.getParameter("pwd");
			
			if(d.userValide(mail)) {
				erreursCompte.put("mail", "Le mail existe déjà. Veuillez en choisir un autre.");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/CreerCompte.jsp");
			rd.forward(request, response);
		}
		
		if(validerCompte != null) {
			
			RequestDispatcher rd = request.getRequestDispatcher("/CreerCompte.jsp");
			rd.forward(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/ListeArticlesVue.jsp");
		rd.forward(request, response);
	}
	
	

}
