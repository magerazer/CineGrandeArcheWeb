package fr.demos.projet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fr.demos.projet.metier.Article;
import fr.demos.projet.metier.Etat;
import fr.demos.projet.metier.Livre;

public class ArticleDAOMySQL implements ArticleDAO {

	private Context context;
	private DataSource dataSource;

	public ArticleDAOMySQL() throws Exception {
		context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/CineGrandeArche");
	}

	@Override
	public void insert(Article a) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Article a) throws Exception {
		// TODO Auto-generated method stub
		try (Connection cx = dataSource.getConnection()) {
			PreparedStatement pstm = null;

			pstm = cx.prepareStatement("UPDATE article SET stock = ? " + "WHERE reference = ?");

			// pstm.setString(1, a.getMat().getStock() - );
			// pstm.setString(2, crit);

			ResultSet rs = pstm.executeQuery();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateStock(Article a, int qte) throws Exception {
		// TODO Auto-generated method stub
		try (Connection cx = dataSource.getConnection()) {
			PreparedStatement pstm = null;

			pstm = cx.prepareStatement("UPDATE article SET stock = ? " + "WHERE reference = ?");

			pstm.setInt(1, a.getMat().getStock() - qte);
			pstm.setString(2, a.getRef());

			pstm.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
			PreparedStatement pstm = null;
			if (critere.equals("")) {
				pstm = cx.prepareStatement("SELECT referenceLivre, prix, nom, stock, description, image, type, stock "
						+ ", etat, coutLivraison, formatLivre, format, url, isbn, auteur, dateParution, genre, nbPages "
						+ " FROM Livre INNER JOIN Article " + "ON Article.reference = Livre.referenceLivre "
						+ "ORDER BY reference DESC");
			} else {
				pstm = cx.prepareStatement("SELECT referenceLivre, prix, nom, stock, description, image, type, stock "
						+ ", etat, coutLivraison, formatLivre, format, url, isbn, auteur, dateParution, genre, nbPages"
						+ " FROM Livre INNER JOIN Article " + "ON Article.reference = Livre.referenceLivre "
						+ "WHERE auteur LIKE ? || nom LIKE ? || description LIKE ? "
						+ "|| formatLivre LIKE ? || format LIKE ? || url LIKE ? " + "ORDER BY reference DESC");
				String crit = "%" + critere + "%";
				pstm.setString(1, crit);
				pstm.setString(2, crit);
				pstm.setString(3, crit);
				pstm.setString(4, crit);
				pstm.setString(5, crit);
				pstm.setString(6, crit);
			}

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				// attributs communs à tous les articles
				String reference = rs.getString("referenceLivre");
				double prix = rs.getDouble("prix");
				String nom = rs.getString("nom");
				String description = rs.getString("description");
				String image = rs.getString("image");
				
				String type = rs.getString("type");
			
				// attributs communs aux livres
				String isbn = rs.getString("isbn");
				String auteur = rs.getString("auteur");
				String formatLivre = rs.getString("formatLivre");
				String genre = rs.getString("genre");
				int nbPages = rs.getInt("nbPages");
				LocalDate dateParution = rs.getDate("dateParution").toLocalDate();
				
				Livre liv = null;

				// dans le cas d'un livre materialisé
				if (rs.getString("url").equals("")) {

					int stock = rs.getInt("stock");
					Etat etat = null;
					if (rs.getString("etat") != null) {
						etat = Etat.valueOf(rs.getString("etat"));
					}
					int coutLivraison = rs.getInt("coutLivraison");

					liv = new Livre(reference, prix, nom, stock, auteur, isbn);
					
					
				}
				// dans le cas d'un livre dematérialisé
				else {
					
					String format = rs.getString("format");
					String url = rs.getString("url");
					
					liv = new Livre(reference, prix, nom, format, url, auteur, isbn);
					
				}
				// attributs communs aux livres materialises et dematerialises
				liv.setImage(image);
				liv.setDescription(description);
				liv.setGenre(genre);
				liv.setNbPages(nbPages);
				liv.setDateParution(dateParution);
				// Article a = new Article(rs.getString(1), rs.getDouble(2),
				// rs.getString(3));
				liste.add(liv);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return liste;
	}

	@Override
	public Article selectArticle(String reference) {
		// TODO Auto-generated method stub
		Article a = null;

		try (Connection cx = dataSource.getConnection()) {
			PreparedStatement pstm = null;

			pstm = cx.prepareStatement("SELECT referenceLivre, prix, nom, stock, description, image, type, stock "
					+ ", etat, coutLivraison, format, url, isbn, auteur " + " FROM Livre INNER JOIN Article "
					+ "ON Article.reference = Livre.referenceLivre " + "WHERE referenceLivre = ? ");
			pstm.setString(1, reference);

			ResultSet rs = pstm.executeQuery();
			rs.next();

			String ref = rs.getString("referenceLivre");
			double prix = rs.getDouble("prix");
			String nom = rs.getString("nom");
			String description = rs.getString("description");
			String image = rs.getString("image");
			String type = rs.getString("type");

			int stock = rs.getInt("stock");
			Etat etat = null;
			if (rs.getString("etat") != null) {
				etat = Etat.valueOf(rs.getString("etat"));
			}
			int coutLivraison = rs.getInt("coutLivraison");

			String format = rs.getString("format");
			String url = rs.getString("url");

			String isbn = rs.getString("isbn");
			String auteur = rs.getString("auteur");

			if (type.equals("livre")) {
				if (url.equals("")) {
					a = new Livre(reference, prix, nom, stock, auteur, isbn);
					a.setImage(image);
				} else {
					a = new Livre(reference, prix, nom, format, url, auteur, isbn);
					a.setImage(image);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return a;
	}

}
