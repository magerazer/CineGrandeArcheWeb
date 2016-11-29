package fr.demos.projet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.demos.projet.metier.Article;
import fr.demos.projet.metier.Etat;
import fr.demos.projet.metier.Livre;

public class ArticleDAOMySQL implements ArticleDAO {

	private Context context;
	private DataSource dataSource;

	public ArticleDAOMySQL() throws Exception {
		context= new InitialContext();
		dataSource = 
				(DataSource)context.lookup("java:comp/env/jdbc/CineGrandeArche");
	}
	
	@Override
	public void insert(Article a) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Article a) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Article a) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Article> select(String critere) {
		// TODO Auto-generated method stub
		List<Article> liste = new ArrayList<>();

		try (Connection cx = dataSource.getConnection()) {

			PreparedStatement pstm = cx
					.prepareStatement("SELECT referenceLivre, prix, nom, stock, description, image, type, stock "
							+ ", etat, coutLivraison, format, url, isbn, auteur "
							+ " FROM Livre INNER JOIN Article "
							+ "ON Article.reference = Livre.referenceLivre");

			// pstm.setString(1, critere);

			ResultSet rs = pstm.executeQuery();
						
			while (rs.next()) {
				String reference = rs.getString("referenceLivre");
				double prix = rs.getDouble("prix");
				String nom = rs.getString("nom");
				String description = rs.getString("description");
				String image = rs.getString("image");
				String type = rs.getString("type");
				
				int stock = rs.getInt("stock");
				Etat etat = null;
				if(rs.getString("etat") != null) {
					etat = Etat.valueOf(rs.getString("etat"));
				}
				int coutLivraison = rs.getInt("coutLivraison");
				
				String format = rs.getString("format");
				String url = rs.getString("url");
				
				String isbn = rs.getString("isbn");
				String auteur = rs.getString("auteur");
				
				Livre liv = null;
				if(type.equals("livre")) {
					if(url.equals("")) {
						liv = new Livre(reference, prix, nom, stock, auteur, isbn);
						liv.setImage(image);
					} else {
						liv = new Livre(reference, prix, nom, format, url, auteur, isbn);
						liv.setImage(image);
					}
				}
				//Article a = new Article(rs.getString(1), rs.getDouble(2),
				// rs.getString(3));
				liste.add(liv);
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return liste;
	}

}
