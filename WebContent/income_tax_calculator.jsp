<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />

<fmt:setLocale value="${language}" />
<fmt:setBundle
	basename="org.avs.incomeTaxCalculator.i18n.resources.mylabels" />

<!DOCTYPE html>

<html lang="${language}">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />

<title>Income Tax Calculator</title>

<!-- Imports Google Icon Font  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- Imports materialize.css -->
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />

<!-- Let browser know that website is optimized for mobile -->
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />

<!-- Imports compiled and minified CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css"
	rel="stylesheet">

</head>
<body>

	<nav class="black z-depth-4" role="navigation">
		<div class="nav-wrapper container">
			<a href="income_tax_calculator.jsp" class="brand-logo left">AVS</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="income_tax_calculator.jsp?language=en_CA">English</a></li>
				<li><a href="income_tax_calculator.jsp?language=ru_CA">Русский</a></li>
				<li><a href="income_tax_calculator.jsp?language=rs_CA">Srpski</a></li>
			</ul>
		</div>
	</nav>

	<div class="index container center">
	
		<div class="section no-pad-bot" id="index-banner">
			<h3 class="black-text">
				<fmt:message key="label.indexBanner" />
			</h3>
			<div class="row">
				<h6 class="black-text">
					<fmt:message key="label.welcome" />
				</h6>
				<br /> <br />
			</div>
		</div>

		<form action="IncomeTaxCalculatorServlet" method="GET">
			<div class="row">
			
				<!-- Adds a drop-down list for provinces and territories -->
				<div class="col s3 offset-s2">
					<select name="territory">
						<option value="Alberta, AB"><fmt:message key="label.alberta" /></option>
						<option value="British Columbia, BC"><fmt:message key="label.britishColumbia" /></option>
						<option value="Manitoba, MB"><fmt:message key="label.manitoba" /></option>
						<option value="New Brunswick, NB"><fmt:message key="label.newBrunswick" /></option>
						<option value="Newfoundland and Labrador, NL"><fmt:message key="label.newFoundland" /></option>
						<option value="Northwest Territories, NT"><fmt:message key="label.northwestTerritories" /></option>
						<option value="Nova Scotia, NS"><fmt:message key="label.novaScotia" /></option>
						<option value="Nunavut, NU"><fmt:message key="label.nunavut" /></option>
						<option value="Ontario, ON"><fmt:message key="label.ontario" /></option>
						<option value="Prince Edward Island, PE"><fmt:message key="label.princeEdwardIsland" /></option>
						<option value="Quebec, QC"><fmt:message key="label.quebec" /></option>
						<option value="Saskatchewan, SK"><fmt:message key="label.saskatchewan" /></option>
						<option value="Yukon, YT"><fmt:message key="label.yukon" /></option>
					</select>
				</div>
				
				<!-- Adds a text field for taxable income -->
				<div class="col s3 offset-s2">
					<input type="hidden" name="command" value="CALCULATE" /> <input
						type="text"
						placeholder="<fmt:message key="label.taxableIncomePlaceholder" />"
						name="taxableIncome" value="" />
				</div>
			</div>
			
			<!-- Adds a calculate button with a hint-->
			<div class="row">
				<div class="center">
					<a class="btn-floating btn-large pink darken-4 pulse tooltipped"
						data-position="right"
						data-tooltip="<fmt:message key="label.estimateTaxesTooltip" />">
						<input type="submit"
						class="btn-floating btn-large pink darken-4 white-text z-depth-4"
						value="<fmt:message key="label.go" />" />
					</a>
				</div>
			</div>
		</form>
	</div>

	<!-- Displays results of a calculation -->
	<h3 class="header center black-text">
		<fmt:message key="label.results" />
	</h3>

	<jsp:include page="results.jsp" />

	<footer class="page-footer pink darken-4">
		<div class="container">
			<div class="row">
				<div class="center">
					<p class="white-text">
						<fmt:message key="label.disclamer" />
						<c:set var="now" value="<%=new java.util.Date()%>" />
						<fmt:formatDate value="${now}" pattern="dd MMMM yy." />
					</p>
				</div>
			</div>
		</div>

		<div class="footer-copyright">
			<div class="container">
				<div class="center">
					<p class="white-text">
						<fmt:message key="label.madeBy" />
					</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- Imports JavaScript at end of body for optimized loading -->
	<script type="text/javascript" src="js/materialize.min.js"></script>

	<script type="text/javascript">
		M.AutoInit();
	</script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('.tooltipped').tooltip();
		});
	</script>

</body>
</html>