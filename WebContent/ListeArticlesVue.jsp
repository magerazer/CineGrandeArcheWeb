<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>

<!-- <div class="corps"> -->
	<jsp:include page="/Menu.jsp" />

<div class = "contentListe">

	<c:import url="/RechercheVue.jsp" />



	<%-- <p>la liste des articles : ${listeArticles}</p> --%>
	
<ul>
		<c:forEach var="article" items="${listeArticles}">
			<li>
			<div class="container">
				<div class="elementLi1">
				<%-- 				<td>${article.getClass()}</td> --%>
				<div class="imgLi">
				<a
					href="ListeArticlesControleur?consultation=true&ref=${ article.ref }">
				<img src="${ article.image }" alt="test1"  width="160" /></a>
				
				</div>
				<div class="infoListe">
				<div class="nomLi">
				<a
					href="ListeArticlesControleur?consultation=true&ref=${ article.ref }">${article.nom}</a>
				<%-- <c:if test="${ not empty article }">${article.getClass().name}</c:if> --%>
								
				<%-- <td>${article.auteur}</td> --%>
				</div>				
				<c:if test="${ article.type == 'Livre' }">
				<div>				
					Auteur : ${ article.auteur }				
				</div>
				</c:if>
				<c:if test="${not empty article.mat }">
				<div>Etat : ${ article.mat.etat }</div>
				</c:if>
				<div>
				${article.prixHT}€
				</div>
				<c:if test="${not empty article.mat }">
				
				Stock : ${article.mat.stock } <br>
				<span class="erreur">${erreurs[article] }</span>
				</c:if>
				
				</div>
			</div>
				<div class="elementLi2">			
					<c:choose>
						<c:when test="${ (not empty article.mat) or ((quantiteDemat == 0 ))  }">
					<form action="PanierControleur" method="POST">
						<p>
							<input type="hidden" name="ref" value="${article.ref}" /> 
							<input type="hidden" name="qte" value="1" /> 
							<input type="hidden" name="consulter" value="false" /> 
							<input type="submit" value="Ajouter" name="ajouter" />
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
				
				</div>
				
				
					<%-- <span class="erreur">${erreurs[article] }</span> --%>
				</div>
			</li>
				
				<br>
			
		</c:forEach>

</ul>
	
<!-- </div> -->
</div>

</body>
</html>