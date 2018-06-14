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
	content="width=device-width, initial-scale=0.6, maximum-scale=1.0" />

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

	<!-- Displays results of a calculation -->
	<div class="row">

		<div class="col s12 m12 l4 offset-l2">
			<table>
				<tr>
					<th>
						<h6>
							<fmt:message key="label.federalTax" />
						</h6>
					</th>
					<td>
						<h6 align="right">
							<fmt:formatNumber type="currency"
								value="${INCOME_TAX.federalTax}" pattern="CA$###,###,###.##" />
						</h6>
					</td>
				</tr>
				<tr>
					<th>
						<h6>
							<fmt:message key="label.provincialTax" />
						</h6>
					</th>
					<td>
						<h6 align="right">
							<fmt:formatNumber type="currency"
								value="${INCOME_TAX.provincialTax}" pattern="CA$###,###,###.##" />
						</h6>
					</td>
				</tr>
			</table>
		</div>
		
		<div class="col s12 m12 l4">
			<table>
				<tr>
					<th>
						<h6>
							<fmt:message key="label.totalTax" />
						</h6>
					</th>
					<td>
						<h6 align="right">
							<font color="red"> <fmt:formatNumber type="currency"
									value="${INCOME_TAX.totalTax}" pattern="CA$###,###,###.##" />
							</font>
						</h6>
					</td>
				</tr>
				<tr>
					<th>
						<h6>
							<fmt:message key="label.averageTaxRate" />
						</h6>
					</th>
					<td>
						<h6 align="right">
							<fmt:formatNumber type="percent" maxIntegerDigits="3"
								minFractionDigits="2" maxFractionDigits="2"
								value="${INCOME_TAX.averageTaxRate}" />
						</h6>
					</td>
				</tr>
			</table>
		</div>

		<div class="row">
			<div class="col s12 m12 l4 offset-l4">
				<table>
					<tr>
						<th>
							<h6>
								<fmt:message key="label.afterTaxIncome" />
							</h6>
						</th>
						<td>
							<h6 align="right">
								<font color="green"> <fmt:formatNumber type="currency"
										value="${INCOME_TAX.afterTaxIncome}"
										pattern="CA$###,###,###.##" />
								</font>
							</h6>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>