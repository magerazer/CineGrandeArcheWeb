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

import fr.demos.projet.data.CompteDAOMySQL;
import fr.demos.projet.donnees.Donnees;
import fr.demos.projet.metier.Authentification;
import fr.demos.projet.metier.Compte;
import fr.demos.projet.metier.CreationCompte;
import fr.demos.projet.metier.LoginException;
import fr.demos.projet.metier.UtilisateurException;

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
		String pageCourante = (String) session.getAttribute("pageCourante");
		
		//Map<String, String> erreursConnexion = new HashMap<String, String>();
		//request.setAttribute("erreursConnexion", erreursConnexion);
		Map<String, String> erreursCompte = new HashMap<String, String>();
		request.setAttribute("erreursCompte", erreursCompte);
		
		String connexion = request.getParameter("connexion");
		String deconnexion = request.getParameter("deconnexion");
		String creationCompte = request.getParameter("creationCompte");
		String validerCompte = request.getParameter("validerCompte");
		
				//Compte compte = null;
		//ArrayList<Compte> listeComptes = (ArrayList<Compte>) session.getAttribute("listeComptes");
		CompteDAOMySQL compteDao = (CompteDAOMySQL) request.getServletContext().getAttribute("compteDao");
		boolean erreur = false;
		
		
		
    	
		// si l'utilisateur se connecte
		if (connexion != null) {
			
			String mail = request.getParameter("mail");
			String pwd = request.getParameter("pwd");
			
			Compte compte = null;
			try {
				compte = new Authentification().login(mail, pwd);
			} catch (LoginException e) {
				String loginErreur = e.getMessage();
				request.setAttribute("loginErreur", loginErreur);
			}
			
			session.setAttribute("compte", compte);
			
			RequestDispatcher rd = request.getRequestDispatcher(pageCourante);
			rd.forward(request, response);
		}
		// si l'utilisateur se d�connecte
		if (deconnexion != null) {
			session.setAttribute("compte", null);
			
			
			RequestDispatcher rd = request.getRequestDispatcher(pageCourante);
			rd.forward(request, response);
		}
		// si l'utilisateur veut cr�er un compte
		if (creationCompte != null) {
			
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/CreerCompte.jsp");
			rd.forward(request, response);
		}
		/*
		 * Lorsque l'utilisateur cr�e son compte
		 * */
		if(validerCompte != null) {
			String email = request.getParameter("email");		
			String pwd = request.getParameter("pwd");			
			String pwdConfirm = request.getParameter("pwdConfirm");			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String adrFact = request.getParameter("adrFact");
			String adrLiv = request.getParameter("adrLiv");
			
			CreationCompte creeCompte = new CreationCompte();
			Compte compte = creeCompte.creationCompte(nom, prenom, email, pwd, pwdConfirm, adrLiv, adrFact);
			
			erreursCompte = creeCompte.getErreurs();			
			System.out.println("erreursCompte vide ? " + erreursCompte);
			request.setAttribute("erreursCompte", erreursCompte);
			//Compte c = new Compte(nom, prenom, email, pwd, adrFact, adrLiv);
			if(erreursCompte.size() == 0) {
			try {
				compteDao.insert(compte);
			} catch (Exception e) {				
				e.printStackTrace();
			}
			}
			RequestDispatcher rd = request.getRequestDispatcher("/CreerCompte.jsp");
			rd.forward(request, response);
		}
		
		
	}
	
	
	
	
	

}
