package fr.demos.projet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fr.demos.projet.metier.Compte;
import fr.demos.projet.metier.Etat;
import fr.demos.projet.metier.Livre;

public class CompteDAOMySQL implements CompteDAO {

	private Context context;
	private DataSource dataSource;

	public CompteDAOMySQL() throws Exception {
		context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/CineGrandeArche");
	}

	@Override
	public void insert(Compte c) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Compte c) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Compte c) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Compte select(String argMail) {
		// TODO Auto-generated method stub
		Compte c = null;

		try (Connection cx = dataSource.getConnection()) {
			PreparedStatement pstm = null;
			pstm = cx.prepareStatement("SELECT mail, pwd " + "FROM Compte" + " WHERE mail = ?");
			pstm.setString(1, argMail);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				String mail = rs.getString("mail");
				String pwd = rs.getString("pwd");

				c = new Compte(mail, pwd);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return c;
	}

}