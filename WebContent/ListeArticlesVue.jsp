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


	<jsp:include page="/Menu.jsp" />



<div class="corps">

	<c:import url="/RechercheVue.jsp" />



	<%-- <p>la liste des articles : ${listeArticles}</p> --%>
	
<ul>
		<c:forEach var="article" items="${listeArticles}">
			<li>
			<div class="container">
				<div class="elementLi">
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
				<div>
				${article.prixHT}€
				</div>
				</div>
			</div>
				<div class="elementLi">			
					<form action="PanierControleur" method="POST">
						<p>
							<input type="hidden" name="ref" value="${article.ref}" /> 
							<input type="hidden" name="qte" value="1" /> 
							<input type="hidden" name="consulter" value="false" /> 
							<input type="submit" value="Ajouter" name="ajouter" />

						</p>
					</form>
				</div>
				
				
					<%-- <span class="erreur">${erreurs[article] }</span> --%>
				</div>
				</li>
				
				<br>
			
		</c:forEach>

</ul>
	
</div>


</body>
</html>