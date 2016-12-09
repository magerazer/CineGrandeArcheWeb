<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css" />
<link type="text/css" rel="stylesheet" href="styleConsultation.css" />
</head>
<body>
<div class = "contentListe">

<jsp:include page="/Menu.jsp" />

	<h1>Créer un compte</h1>
	
			<form action="CompteControleur" method="post">
			<fieldset class="compte">
					<label for="nom">Nom </label> <br>
					<input type="text" name="nom" value=""/><br/>
					<span class="erreur">${erreursCompte['nom']}</span> <br>
									
					<label for="prenom">Prénom </label> <br>
					<input type="text" name="prenom"/>  <br>
					
					<label for="email">Adresse email </label><br>
					<input type="email" name="email" value=""/> <br>
					<span class="erreur">${erreursCompte['mail']}</span> <br>
					
					<label for="pwd">Mot de passe </label> <br>
					<input type="password" name="pwd" value=""/> <br>
					
					<label for="pwdConfirm">Confirmez le mot de passe</label><br>
					<input type="password" name="pwdConfirm"/> <br>
					<span class="erreur">${erreursCompte['pwd']}</span> <br>
					
					<label for="adrLiv">Adresse de livraison </label> <br>
					<input type="text" name="adrLiv"/>  <br>
					
					<label for="adrFact">Adresse de facturation </label> <br>
					<input type="text" name="adrFact"/>  <br>	
													
					
					<input type=submit value="Valider" name="validerCompte" />
					
					<span class="erreur">${erreursCompte['formNonRempli']}</span> <br>
				 </fieldset>
					</form>


</div>
</body>
</html>