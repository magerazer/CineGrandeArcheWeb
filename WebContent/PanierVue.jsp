<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>

	<c:import url="/Menu.jsp" />

	<p>panier : ${ lignes }</p>
	<table>
		<c:forEach var="lignePanier" items="${lignes}">
			<tr>
				<td>${lignePanier.article.ref}</td>
				<td>${lignePanier.article.nom}</td>
				<td>${lignePanier.article.prixHT}</td>
				<td>${lignePanier.quantite}</td>
				<td>
					<form action="PanierControleur" method="POST">
						<input type="hidden" name="ref" value="${lignePanier.article.ref}" />
						<label> QuantitÃ© : </label> <input type="text" name="qte" value="" />
						<input type="submit" value="Modifier quantitÃ©"
							name="modifierPanier" />
					</form>

				</td>
				<td>
					<form action="PanierControleur" method="POST">
						<input type="hidden" name="ref" value="${lignePanier.article.ref}" />
						<input type="submit" value="Delete" name="delete" />
					</form>

				</td>

			</tr>
		</c:forEach>
	</table>

	<div>
		${ panier.prixTotal } â¬
	</div>

	<form action="CommandeControleur" method="POST">	
		<input type="submit" value="Commander" name="commander" />
	</form>


</body>
</html>