<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>

	<c:import url="/Menu.jsp" />

	<table>
		<!-- <tr>
		<th></th>
		</tr> -->
		
		<td>
			${ article.nom } 
		</td>
		<td>
			${ article.prixHT } 
		</td>
		<td>
		
		</td>
		
		
	</table>	

	<form action="PanierControleur" method="POST">
		<p>			
		<input type="hidden" name="ref" value="${article.ref}" />
		<input type="hidden" name="consulter" value="true" />
		<label> Quantité : </label>
		<input type="text" name="qte" value="" />
		
		<input type="submit" value="Ajouter" name="ajouter" />

		</p>
	</form>


	


</body>
</html>