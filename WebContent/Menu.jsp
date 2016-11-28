<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header>

	<div id="conteneurMenu">
		<div class="logo">
			<a href="ListeArticlesControleur"> <img src="images/CineMag.png"
				alt="CineMag">
			</a>
		</div>
		<c:if test="${ empty sessionScope.compte }">
			<div class="connexionMenu">
				<form action="CompteControleur" method="POST">
					<p>
						<input type="text" name="mail" value="${ param.mail }" placeholder="mail" /> <span
							class="erreur">${ erreursConnexion['mail'] }</span><br> <input
							type="text" name="pwd" value="" placeholder="mot de passe" /> <span
							class="erreur">${ erreursConnexion['pwd'] }</span> <br> <input
							type="submit" value="Se connecter" name="connexion" />
					</p>
				</form>
			</div>
			<div class="creeMenu">
				<form action="CompteControleur" method="POST">
					<p>
						<input type="submit" value="Créer un compte" name="creationCompte" />
					</p>
				</form>
			</div>
		</c:if>
		<c:if test="${ not empty sessionScope.compte }">
			<div class="msgConnecte">
				<span class="connecteMsg">${sessionScope.compte.mail} est
					connecté</span> <a href="CompteControleur"> Compte </a>
				<form action="CompteControleur" method="POST">
					<p>
						<input type="submit" value="Se déconnecter" name="deconnexion" />

					</p>
			</div>
		</c:if>
		<div class="panierMenu">
			<p>
				<a href="PanierControleur" class="panierStyle">Panier : ${ panier.quantite }</a>
			</p>
		</div>

	</div>
</header>