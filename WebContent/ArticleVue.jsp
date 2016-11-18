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

<div class="corps">
	<c:import url="/Menu.jsp" />
<section>
	<div id="conteneur">

		<div class="image">
			<img src="${ article.image }" alt="test1" width="300"/>
		</div>

		<div class="infos">
		<h1>
			${ article.nom } 
		</h1>
		 	<div class="infoAvecTitre">
			<c:if test="${ article.type }">
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
<c:if test="${ not empty article.mat }">
		<form action="PanierControleur" method="POST">
			<p>
				 <input type="hidden" name="ref" value="${article.ref}" />
				  <input type="hidden" name="consulter" value="true" /> 
				  <!-- <label>
					Quantité : </label> <input type="text" name="qte" value="" /> --> 
				Quantité : <input type="number" min="0" name="qte" value="${ 1 }"/>
				<input type="submit" value="Ajouter au panier" name="ajouter" />

 				
			</p>
		</form>
			
		</c:if>			
		
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

</div>

</body>
</html>