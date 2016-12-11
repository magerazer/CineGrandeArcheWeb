package fr.demos.projet.metier;

import java.util.HashMap;
import java.util.Map;

import fr.demos.projet.data.CompteDAOMySQL;

public class CreationCompte {

	private Map<String, String> erreurs = new HashMap<String, String>();
	boolean existant = false;

	public CreationCompte(boolean existant) {
		this.existant = existant;
	}

	public Compte creationCompte(String nom, String prenom, String mail, String pwd, String pwdConfirm, String adrLiv,
			String adrFact) {
		Compte compte = null;
		CompteDAOMySQL compteDao = null;
		try {
			compteDao = new CompteDAOMySQL();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!existant) {
			Compte c = compteDao.select(mail, pwd);
			System.out.println("Compte = " + c + " mail = " + mail + " pwd = " + pwd);
			if (c != null) {

				erreurs.put("mail", "Le mail existe déjà. Veuillez en choisir un autre.");
			}
		}
		try {
			validationMotsDePasse(pwd, pwdConfirm);
		} catch (UtilisateurException e) {
			erreurs.put("pwd", e.getMessage());
		}

		try {
			champsNonRempli(nom, prenom, mail, pwd, pwdConfirm, adrLiv, adrFact);
		} catch (UtilisateurException e) {
			erreurs.put("formNonRempli", e.getMessage());
		}

		compte = new Compte(nom, prenom, mail, pwd, adrLiv, adrFact);

		return compte;

	}

	private void validationMotsDePasse(String motDePasse, String confirmation) throws UtilisateurException {
		if (motDePasse != null && confirmation != null && motDePasse != "" && confirmation != "") {
			if (!motDePasse.equals(confirmation)) {
				throw new UtilisateurException(
						"Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			} else if (motDePasse.length() < 2) {
				throw new UtilisateurException("Les mots de passe doivent contenir au moins 2 caractères.");
			}
		} else {
			throw new UtilisateurException("Merci de saisir et confirmer votre mot de passe.");
		}
	}

	private void validationNom(String nom) throws UtilisateurException {
		if (nom == "") {
			throw new UtilisateurException("Merci de saisir un nom d'utilisateur");
		}
	}

	private void validationMail(String mail) throws UtilisateurException {
		if (mail == "") {
			throw new UtilisateurException("Merci de saisir un nom d'utilisateur");
		}
	}

	private void champsNonRempli(String nom, String prenom, String mail, String pwd, String pwdConfirm, String adrLiv,
			String adrFact) throws UtilisateurException {
		if (nom == "" || prenom == "" || mail == "" || pwd == "" || pwdConfirm == "" || adrLiv == "" || adrFact == "") {
			throw new UtilisateurException("Merci de remplir tous les champs");
		}
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

}
