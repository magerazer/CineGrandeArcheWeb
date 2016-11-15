<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<header>

	<div id="conteneur">
		<div class="element">
			<a href="ListeArticlesControleur"> <img src="images/CineMag.png"
				alt="CineMag">
			</a>
		</div>
		<c:if test="${ empty sessionScope.compte }">
		<div class="element">
			<form action="CompteControleur" method="POST">
				<p>
					<input type="text" name="mail" value="" placeholder="mail" /> <input
						type="text" name="pwd" value="" placeholder="mot de passe" /> <input
						type="submit" value="Se connecter" name="connection" />

				</p>
			</form>
		</div>
		</c:if>
		<c:if test="${ not empty sessionScope.compte }">
			<div class="element">
				<span class="connecteMsg">${sessionScope.compte.mail} est connecté</span>
				<a href="CompteControleur"> Compte </a>
				<form action="CompteControleur" method="POST">
				<p>
					<input type="submit" value="Se déconnecter" name="deconnection" />

				</p>
			</div>
		</c:if>
		<div class="element">
			<p>
				<a href="PanierControleur">Panier : </a>
			</p>
		</div>

	</div>
</header>