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
	
	
	<c:if test="${ !consultationCompte && !validationConfirm}">
			<form action="CompteControleur" method="post">
			<fieldset class="compte">
					<label for="nom">Nom : </label> 
					<input type="text" name="nom" value="${ compte.nom }"/>
					<span class="erreur">${erreursCompte['nom']}</span> <br><br>
									
					<label for="prenom">Prénom  : </label> 
					<input type="text" name="prenom" value="${ compte.prenom }"/> 
					<span class="erreur">${erreursCompte['prenom']}</span> <br> <br>
					
					<label for="email">Adresse email : </label>
					<input type="email" name="email" value="${ compte.mail }"/> 
					<span class="erreur">${erreursCompte['mail']}</span> <br><br>
					
					<label for="pwd">Mot de passe : </label> 
					<input type="password" name="pwd" value="${ compte.pwd }"/> 
					<span class="erreur">${erreursCompte['pwd']}</span> <br> <br>
					
					
					<label for="pwdConfirm">Confirmez le mot de passe : </label>
					<input type="password" name="pwdConfirm" value="${ compte.pwd }"/>
					<span class="erreur">${erreursCompte['pwdConfirm']}</span> <br> <br>
					
					<label for="adrLiv">Adresse de livraison : </label>
					<input type="text" name="adrLiv" value="${ compte.adrLiv }"/>  
					<span class="erreur">${erreursCompte['adrLiv']}</span> <br> <br>
					
					<label for="adrFact">Adresse de facturation </label> 
					<input type="text" name="adrFact" value="${ compte.adrFact }"/>	
					<span class="erreur">${erreursCompte['adrFact']}</span> <br> <br>
													
					<c:if test="${ !modifier }">
						<input type=submit value="Valider le compte" name="validerCompte" />
					</c:if>
					<c:if test="${ modifier }">
						<input type=submit value="Valider modifications" name="modifier" />
					</c:if>
					
					<span class="erreur">${erreursCompte['formNonRempli']}</span> <br>
				 </fieldset>
					</form>
	</c:if>
	<c:if test="${ consultationCompte && !validationConfirm}">
	<fieldset class="compte">
		<form action="CompteControleur" method="post">
					
		
					<label>Nom : ${ compte.nom } </label><br>									
									
					<label>Prénom : ${ compte.prenom } </label> <br>
					
					<label>Adresse email : ${ compte.mail } </label> <br>
										
					<label>Adresse de livraison : ${ compte.adrLiv }</label> <br>
					
					<label>Adresse de facturation : ${ compte.adrFact }</label> <br>
						
					<input type=submit value="Modifier votre compte" name="modifierCompte" />							
					
	</fieldset>
	</c:if>
	<c:if test="${ validationConfirm }">
	<fieldset class="compte">
		<h2>Votre compte a été crée avec succès.</h2><br><br>
					<label>Nom : ${ confirmCompte.nom } </label><br>									
									
					<label>Prénom : ${ confirmCompte.prenom } </label> <br>
					
					<label>Adresse email : ${ confirmCompte.mail } </label> <br>
										
					<label>Adresse de livraison : ${ confirmCompte.adrLiv }</label> <br>
					
					<label>Adresse de facturation : ${ confirmCompte.adrFact }</label> <br>
													
					
					
		</form>
	</fieldset>
	</c:if>

</div>
</body>
</html>