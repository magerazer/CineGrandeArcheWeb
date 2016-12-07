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
	
			<form action="CompteControleur" method="post">
			<fieldset class="compte">
					<label for="nom">Nom </label> <br>
					<input type="text" name="nom" value=""/><br/>				
					<label for="prenom">Prénom </label> <br>
					<input type="text" name="prenom"/>  <br>
					
					<fieldset class="adresse">
                    <legend>Adresse de livraison : </legend>
                                   
					<label for="rueLivraison">rue : </label>
					<input type="text" name="rueLivraison"/> <br>
					<label for="codePostalLivraison"> code postal : </label>
					<input type="text" name="codePostalLivraison"/> <br>
					<label for="paysLivraison">pays : </label>
					<select name="enterAddressCountryCode" >
<option value="">--</option>
<option value="ZA">Afrique du Sud</option>
<option value="AL">Albanie</option>
<option value="DZ">Algérie</option>
<option value="DE">Allemagne</option>
<option value="AD">Andorre</option>
<option value="AO">Angola</option>
<option value="AI">Anguilla</option>
<option value="AQ">Antarctique</option>
<option value="AG">Antigua-et-Barbuda</option>
<option value="AN">Antilles néerlandaises</option>
<option value="SA">Arabie Saoudite</option>
<option value="AR">Argentine</option>
<option value="AM">Arménie</option>
<option value="AW">Aruba</option>
<option value="AU">Australie</option>
<option value="AT">Autriche</option>
<option value="AZ">Azerbaïdjan</option>
<option value="BS">Bahamas</option>
<option value="BH">Bahreïn</option>
<option value="BD">Bangladesh</option>
<option value="BB">Barbade</option>
<option value="BE">Belgique</option>
<option value="BZ">Bélize</option>
<option value="BJ">Bénin</option>
<option value="BM">Bermudes</option>
<option value="BT">Bhoutan</option>
<option value="BY">Biélorussie</option>
<option value="BO">Bolivie</option>
<option value="BQ">Bonaire, Saint Eustatius et Saba</option>
<option value="BA">Bosnie-Herzégovine</option>
<option value="BW">Botswana</option>
<option value="BR">Brésil</option>
<option value="BN">Brunéi Darussalam</option>
<option value="BG">Bulgarie</option>
<option value="BF">Burkina Faso</option>
<option value="BI">Burundi</option>
<option value="KH">Cambodge</option>
<option value="CM">Cameroun</option>
<option value="CA">Canada</option>
<option value="CV">Cap Vert</option>
<option value="CL">Chili</option>
<option value="CN">Chine</option>
<option value="CY">Chypre</option>
<option value="CO">Colombie</option>
<option value="KM">Comores</option>
<option value="CG">Congo</option>
<option value="CD">Congo, République démocratique du</option>
<option value="KR">Corée, République de</option>
<option value="CR">Costa Rica</option>
<option value="CI">Côte d'ivoire</option>
<option value="HR">Croatie</option>
<option value="CW">Curaçao</option>
<option value="DK">Danemark</option>
<option value="DJ">Djibouti</option>
<option value="DM">Dominique</option>
<option value="EG">Égypte</option>
<option value="SV">El Salvador</option>
<option value="AE">Émirats arabes unis</option>
<option value="EC">Équateur</option>
<option value="ER">Érythrée</option>
<option value="ES">Espagne</option>
<option value="EE">Estonie</option>
<option value="US">États-Unis</option>
<option value="ET">Ethiopie</option>
<option value="RU">Fédération de Russie</option>
<option value="FJ">Fidji</option>
<option value="FI">Finlande</option>
<option value="FR" selected="">France</option>
<option value="GA">Gabon</option>
<option value="GM">Gambie</option>
<option value="GE">Géorgie </option>
<option value="GS">Géorgie du Sud et les Îles Sandwich du Sud</option>
<option value="GH">Ghana</option>
<option value="GI">Gibraltar</option>
<option value="GR">Grèce</option>
<option value="GD">Grenade</option>
<option value="GL">Groenland</option>
<option value="GP">Guadeloupe</option>
<option value="GU">Guam</option>
<option value="GT">Guatemala</option>
<option value="GN">Guinée</option>
<option value="GQ">Guinée équatoriale</option>
<option value="GW">Guinée-Bissau</option>
<option value="GY">Guyane</option>
<option value="GF">Guyane française</option>
<option value="HT">Haïti</option>
<option value="HN">Honduras</option>
<option value="HK">Hong Kong</option>
<option value="HU">Hongrie</option>
<option value="BV">Île Bouvet</option>
<option value="CX">Île Christmas</option>
<option value="HM">Île Heard et îles McDonald</option>
<option value="NF">Île Norfolk</option>
<option value="KY">Îles Caïmans</option>
<option value="CC">Îles Cocos (Keeling)</option>
<option value="CK">Îles Cook</option>
<option value="FK">Îles Falkland (Malouines)</option>
<option value="FO">Îles Féroé</option>
<option value="MP">Îles Mariannes du Nord</option>
<option value="MH">Îles Marshall</option>
<option value="UM">Îles mineures éloignées des États-Unis</option>
<option value="SB">Îles Salomon</option>
<option value="TC">Îles Turques-et-Caïques</option>
<option value="VI">Îles Vierges américaines</option>
<option value="VG">Îles Vierges britanniques</option>
<option value="IN">Inde</option>
<option value="ID">Indonésie</option>
<option value="IE">Irlande</option>
<option value="IS">Islande</option>
<option value="IL">Israël</option>
<option value="IT">Italie</option>
<option value="JM">Jamaïque</option>
<option value="JP">Japon</option>
<option value="JO">Jordanie</option>
<option value="KZ">Kazakhstan</option>
<option value="KE">Kenya</option>
<option value="KG">Kirghizistan</option>
<option value="KI">Kiribati</option>
<option value="XK">Kosovo</option>
<option value="KW">Koweït</option>
<option value="LS">Lesotho</option>
<option value="LV">Lettonie</option>
<option value="LB">Liban</option>
<option value="LR">Liberia</option>
<option value="LY">Libye </option>
<option value="LI">Liechtenstein</option>
<option value="LT">Lituanie</option>
<option value="LU">Luxembourg</option>
<option value="MO">Macao</option>
<option value="MK">Macédoine, Ex-République yougoslave de</option>
<option value="MG">Madagascar</option>
<option value="MY">Malaisie</option>
<option value="MW">Malawi</option>
<option value="MV">Maldives</option>
<option value="ML">Mali</option>
<option value="MT">Malte</option>
<option value="MA">Maroc</option>
<option value="MQ">Martinique</option>
<option value="MU">Maurice</option>
<option value="MR">Mauritanie</option>
<option value="YT">Mayotte</option>
<option value="MX">Mexique</option>
<option value="FM">Micronésie, États fédérés de</option>
<option value="MC">Monaco</option>
<option value="MN">Mongolie</option>
<option value="ME">Montenegro</option>
<option value="MS">Montserrat</option>
<option value="MZ">Mozambique</option>
<option value="MM">Myanmar</option>
<option value="NA">Namibie</option>
<option value="NR">Nauru</option>
<option value="NP">Népal</option>
<option value="NI">Nicaragua</option>
<option value="NE">Niger</option>
<option value="NG">Nigeria</option>
<option value="NU">Niué</option>
<option value="NO">Norvège</option>
<option value="NC">Nouvelle-Calédonie</option>
<option value="NZ">Nouvelle-Zélande</option>
<option value="OM">Oman</option>
<option value="UG">Ouganda</option>
<option value="UZ">Ouzbékistan</option>
<option value="PK">Pakistan</option>
<option value="PW">Palaos</option>
<option value="PA">Panama</option>
<option value="PG">Papouasie-Nouvelle-Guinée</option>
<option value="PY">Paraguay</option>
<option value="NL">Pays-Bas</option>
<option value="PE">Pérou</option>
<option value="PH">Philippines</option>
<option value="PN">Pitcairn</option>
<option value="PL">Pologne</option>
<option value="PF">Polynésie française</option>
<option value="PR">Porto Rico</option>
<option value="PT">Portugal</option>
<option value="QA">Qatar</option>
<option value="CF">République centrafricaine</option>
<option value="MD">République de Moldavie</option>
<option value="LA">République démocratique populaire lao</option>
<option value="DO">République dominicaine</option>
<option value="CZ">République Tchèque</option>
<option value="RE">Réunion</option>
<option value="RO">Roumanie</option>
<option value="GB">Royaume-Uni</option>
<option value="RW">Rwanda</option>
<option value="EH">Sahara occidental</option>
<option value="BL">Saint-Barthélemy </option>
<option value="KN">Saint-Kitts-et-Nevis</option>
<option value="SM">Saint-Marin</option>
<option value="MF">Saint-Martin (France)</option>
<option value="SX">Saint-Martin (Pays Bas)</option>
<option value="PM">Saint-Pierre-et-Miquelon</option>
<option value="VA">Saint-Siège</option>
<option value="VC">Saint-Vincent-et-les Grenadines</option>
<option value="SH">Sainte-Hélène, Ascension et Tristan da Cunha</option>
<option value="LC">Sainte-Lucie</option>
<option value="WS">Samoa</option>
<option value="AS">Samoa américaines</option>
<option value="ST">Sao-Tomé-et-Principe</option>
<option value="SN">Sénégal</option>
<option value="RS">Serbie</option>
<option value="SC">Seychelles</option>
<option value="SL">Sierra Leone</option>
<option value="SG">Singapour</option>
<option value="SK">Slovaquie</option>
<option value="SI">Slovénie</option>
<option value="SO">Somalie</option>
<option value="LK">Sri Lanka</option>
<option value="SE">Suède</option>
<option value="CH">Suisse</option>
<option value="SR">Surinam</option>
<option value="SJ">Svalbard et Jan Mayen</option>
<option value="SZ">Swaziland</option>
<option value="TJ">Tadjikistan</option>
<option value="TW">Taïwan</option>
<option value="TZ">Tanzanie, République unie de</option>
<option value="TD">Tchad</option>
<option value="TF">Terres australes et antarctiques françaises</option>
<option value="IO">Territoire britannique de l'océan Indien</option>
<option value="TH">Thaïlande</option>
<option value="TL">Timor-leste</option>
<option value="TG">Togo</option>
<option value="TK">Tokelau</option>
<option value="TO">Tonga</option>
<option value="TT">Trinité-et-Tobago</option>
<option value="TN">Tunisie</option>
<option value="TM">Turkménistan</option>
<option value="TR">Turquie</option>
<option value="TV">Tuvalu</option>
<option value="UA">Ukraine</option>
<option value="UY">Uruguay</option>
<option value="VU">Vanuatu</option>
<option value="VE">Venezuela</option>
<option value="VN">Vietnam</option>
<option value="WF">Wallis-et-Futuna</option>
<option value="YE">Yémen</option>
<option value="ZM">Zambie</option>
<option value="ZW">Zimbabwe</option>
</select>
					 <br>
					 </fieldset>
					<fieldset class="adresse">
                    <legend>Adresse de facturation : </legend>
                                   
					<label for="rueFacturation">rue : </label>
					<input type="text" name="rueFacturation" size="50"/> <br>
					<label for="codePostalFacturation"> code postal : </label>
					<input type="text" name="codePostalFacturation"/> <br>
					<label for="paysFacturation">pays : </label>
					<input type="text" name="paysFacturation"/> <br>
					
					 </fieldset>
					
					<label for="email">Adresse email </label><br>
					<input type="email" name="email" value=""/> <br>
					<label for="pwd">Mot de passe </label> <br>
					<input type="password" name="pwd" value=""/> <br>
					<label for="pwdConfirm">Confirmez le mot de passe</label><br>
					<input type="password" name="pwdConfirm"/> <br>
					<input type=submit value="Valider" name="validerCompte" />
				 </fieldset>
					</form>


</div>
</body>
</html>