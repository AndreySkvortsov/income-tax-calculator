<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>

<body>

	<!-- Displays results of a calculation -->

	Federal tax:
	
	<fmt:setLocale value="en_CA" />
	
	<fmt:formatNumber type="currency" value="${INCOME_TAX.federalTax}" />

	<br />
	<br /> 
	
	Provincial tax:	<fmt:formatNumber type="currency" value="${INCOME_TAX.provincialTax}" />

	<br />
	<br /> 
	
	Total tax: <fmt:formatNumber type="currency" value="${INCOME_TAX.totalTax}" />

	<br />
	<br /> 
	
	After-tax income: <fmt:formatNumber type="currency" value="${INCOME_TAX.afterTaxIncome}" />

	<br />
	<br /> 
	
	Average tax rate: <fmt:formatNumber type="percent" maxIntegerDigits="3" minFractionDigits="2" maxFractionDigits="2" value="${INCOME_TAX.averageTaxRate}" />

</body>

</html>