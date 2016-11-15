package fr.demos.projet.controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/ListeArticlesVue.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String connection = request.getParameter("connection");
		String deconnection = request.getParameter("deconnection");
		Compte compte;
		String mail;
		String pwd;
		if (connection != null) {
			compte = new Compte();
			mail = request.getParameter("mail");
			pwd = request.getParameter("pwd");
			compte.setMail(mail);
			compte.setPwd(pwd);
			
			request.getSession().setAttribute("compte", compte);
			
		
		}
		if (deconnection != null) {
			request.getSession().setAttribute("compte", null);
			
		}
	
		RequestDispatcher rd = request.getRequestDispatcher("/ListeArticlesVue.jsp");
		rd.forward(request, response);
	}

}
