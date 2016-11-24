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

<!-- <div class="corps"> -->
	<jsp:include page="/Menu.jsp" />
	
	<div class = "contentListe">
<section>
	<div id="conteneurArticle">

		<div class="imageArticle">
			<img src="${ article.image }" alt="test1" width="300px" />
		</div>

		<div class="infosArticle">
		<h1>
			${ article.nom } 
		</h1>
		 	<div class="infoAvecTitre">
			<c:if test="${ article.type == 'Livre' }">
			Format : ${ article.format } <br>
			Auteur : ${ article.auteur } <br>
			</c:if>
			</div>
			<div class="infoAchat">
			<c:if test="${ not empty article.mat}">			
			Etat : ${ article.mat.etat } <br>
			Stock : ${ article.mat.stock } <br>
			Cout livraison : ${ article.mat.coutLivraison } <br>
			</div>
			</c:if>
			
			<p>
		Prix : ${ article.prixHT } €
		</p>
<c:choose>
<c:when test="${ (not empty article.mat) or (dematListe[article] == 0)}">
		<form action="PanierControleur" method="POST">
			<p>
				 <input type="hidden" name="ref" value="${article.ref}" />
				  <input type="hidden" name="consulter" value="true" /> 
				 Quantité : <input type="number" min="0" name="qte" value="${ 1 }"/>
				<input type="submit" value="Ajouter au panier" name="ajouter" />
				<span class="erreur">${erreurs[article] }</span>
 				
			</p>
		</form>
			
		</c:when>			
		<c:otherwise>
						<form action="PanierControleur" method="POST">
						<p>
							<input type="submit" value="Ajouter" name="ajouter" disabled="true"/>
						</p>
						</form>						
					</c:otherwise>
		</c:choose>
		
		 <div class="infoDetail">
		 Détails sur le produit : <br>
		 <c:if test="${ article.type == 'Livre'}">
		 isbn : ${ article.isbn } <br> 
		 </c:if>
		 reference : ${ article.ref } <br>
		</div>
	
		
		<p>
		Description du produit : <br>
			${ article.description }
		</p>

		</div>
		


	</div>

</section>

<!-- </div> -->

</div>

</body>
</html>