package fr.demos.projet.metier;

public class Compte {

	private String mail;
	private String pwd;
	
	public Compte() {
		
	}
	
	public Compte(String mail, String pwd) {
		this.mail = mail;
		this.pwd = pwd;
	}

	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
}
