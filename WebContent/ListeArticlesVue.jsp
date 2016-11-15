<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>

	<c:import url="/Menu.jsp" />
	<c:import url="/RechercheVue.jsp" />



	<p>la liste des articles : ${listeArticles}</p>
	<table>
		<!-- <tr>
			<th>Titre</th>
			<th>Auteur</th>
			<th>Prix</th>
			<th></th>
		</tr> -->

		<c:forEach var="article" items="${listeArticles}">
			<tr>
				<%-- 				<td>${article.getClass()}</td> --%>
				<td><a
					href="ListeArticlesControleur?consultation=true&ref=${ article.ref }"><img
						src="${ article.image }" alt="test1" /></a></td>
				<td><a
					href="ListeArticlesControleur?consultation=true&ref=${ article.ref }">${article.nom}</a>
				</td>
				<td>${article.auteur}</td>
				<td>${article.prixHT}€</td>
				<td>
					<form action="PanierControleur" method="POST">
						<p>
							<input type="hidden" name="ref" value="${article.ref}" /> 
							<input type="hidden" name="qte" value="1" /> 
							<input type="hidden" name="consulter" value="false" /> 
							<input type="submit" value="Ajouter" name="ajouter" />

						</p>
					</form>
				</td>
				<br>
			</tr>
		</c:forEach>


	</table>

</body>
</html>