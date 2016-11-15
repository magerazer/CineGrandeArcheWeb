<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<header>

	<div id="conteneur">
		<div class="element">
			<a href="ListeArticlesControleur"> <img src="images/CineMag.png"
				alt="CineMag">
			</a>
		</div>
		<div class="element">
			<form action="CompteControleur" method="POST">
				<p>
					<input type="text" name="id" value="" placeholder="identifiant" /> 
					<input type="text" name="pwd" value="" placeholder="mot de passe" /> 
					<input type="submit" value="Se connecter" name="action" />

				</p>
			</form>
		</div>
		<div class="element">
			<p>
				<a href="PanierControleur">Panier : </a>
			</p>
		</div>

	</div>
</header>