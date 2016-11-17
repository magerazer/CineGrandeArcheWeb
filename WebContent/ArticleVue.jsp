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
		<c:if test="${ article.getClass().name == 'fr.demos.projet.metier.Livre' }">de ${ article.auteur }</c:if>
		</div>
		
		<aside>
		<p>
		${ article.prixHT }
		</p>

		<form action="PanierControleur" method="POST">
			<p>
				<input type="hidden" name="ref" value="${article.ref}" /> <input
					type="hidden" name="consulter" value="true" /> <label>
					Quantité : </label> <input type="text" name="qte" value="" /> <input
					type="submit" value="Ajouter" name="ajouter" />

			</p>
		</form>

	</aside>
		
		


	</div>

</section>



</body>
</html>