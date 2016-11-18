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

	<%-- <p>panier : ${ lignes }</p> --%>
<div class="conteneurBoutonCommande">
	<aside>
	<div>${ panier.prixTotal } €</div>

	<form action="CommandeControleur" method="POST">
		<input type="submit" value="Commander" name="commander" />
	</form>
	</aside>
</div>

	<div class="listePanier">

		<ul>
			<li class="liPanier">
				<div class="conteneur">
					<div class="imagePanier"></div>
					<div class="infosPanier"></div>
					<div>Prix</div>
					<div>Quantite</div>
					<div>Total Article</div>
				</div>

			</li>
			<c:forEach var="lignePanier" items="${panier.iterator()}">
				<li class="liPanier">
					<div class="conteneur">
						<div class="imagePanier">
							<img src="${ lignePanier.article.image }" width="50px" />
						</div>
						<div class="infosPanier">

							<h2>${lignePanier.article.nom}</h2>

							<form action="PanierControleur" method="POST">
								<input type="hidden" name="ref"
									value="${lignePanier.article.ref}" /> <input type="submit"
									value="Delete" name="delete" />
							</form>



						</div>
						<div>${lignePanier.article.prixHT}</div>

						<div>
							<form action="PanierControleur" method="POST">
								<input type="hidden" name="ref"
									value="${lignePanier.article.ref}" /> <input type="number"
									min="0" name="qte" value="${ lignePanier.quantite }" /> <input
									type="submit" value="Modifier quantité" name="modifierPanier" />
							</form>




						</div>
						<div>
						${ lignePanier.article.prixHT * lignePanier.quantite }
						</div>
					</div>

				</li>
			</c:forEach>
		</ul>
	</div>

<!-- 
<div class="column-layout">
  <div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Velit quia, quam delectus sequi odio fugit pariatur architecto, deleniti exercitationem quae adipisci ipsum ullam officia ea!</div>
  <div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consectetur adipisci, quod voluptates, vel nostrum ea distinctio, a tempore voluptas reiciendis doloremque veniam, accusantium. Veritatis ipsum modi doloribus enim sint magnam, delectus dolorum, aperiam! Eaque dolor, veniam eum sunt dolorem nostrum. Dolores, corporis! Magnam, amet quas? Voluptates eaque quaerat quia inventore, earum eveniet hic alias rem atque neque ab, reprehenderit dolore culpa, blanditiis! Maiores enim rerum architecto voluptatibus cumque. Debitis accusamus ea aut incidunt voluptatibus quibusdam rem sint laboriosam qui sit odio expedita illum iste consectetur fugit eaque commodi pariatur, porro ex delectus officia ratione necessitatibus totam. Necessitatibus est autem et.</div>
  <div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Atque velit dolores ipsa maiores molestias minus iusto nulla consequatur saepe. Aspernatur nulla optio laborum ducimus dignissimos nisi itaque aliquam doloremque, iure qui. Corporis quas atque minus, eveniet delectus officiis dolor, neque, animi, deleniti adipisci esse! Ullam nesciunt, nemo fugit totam itaque.</div>
</div>
 -->

	<div>${ panier.prixTotal } €</div>

	<form action="CommandeControleur" method="POST">
		<input type="submit" value="Commander" name="commander" />
	</form>


</body>
</html>