<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<title>Income Tax Calculator</title>

</head>

<body>

	<div id="wrapper">
		<div id="header">

			<h1>Canada's Income Tax Web Calculator 2018</h1>

			<h3>Use the calculator to quickly estimate your 2018 federal and
				provincial taxes.</h3>

		</div>
	</div>

	<hr>

	<div id="container">
		<div id="content">

			<form action="IncomeTaxCalculatorServlet" method="GET">

				<!-- Adds a drop-down list for provinces and territories -->

				Province or territory: <select name="territory">

					<option>Alberta, AB</option>
					<option>British Columbia, BC</option>
					<option>Manitoba, MB</option>
					<option>New Brunswick, NB</option>
					<option>Newfoundland and Labrador, NL</option>
					<option>Northwest Territories, NT</option>
					<option>Nova Scotia, NS</option>
					<option>Nunavut, NU</option>
					<option>Ontario, ON</option>
					<option>Prince Edward Island, PE</option>
					<option>Quebec, QC</option>
					<option>Saskatchewan, SK</option>
					<option>Yukon, YT</option>

				</select>
				
				<br /> <br />

				<!-- Adds a text field for taxable income -->

				<input type="hidden" name="command" value="CALCULATE" /> Taxable income: <input type="text" name="taxableIncome" />
				
				<br /> <br />

				<input type="submit" value="Calculate" />

			</form>

			<hr>

			<!-- Displays results of a calculation -->

			<h3>Results</h3>

			<jsp:include page="results.jsp" />

			<br /> <br />

			<hr>

			<div id="wrapper">
				<div id="footer">
				
				    The calculations are approximate and include
					the basic personal tax amount non-refundable tax credit. After-tax
					income is the total income net of federal tax and provincial tax.
					
				</div>
			</div>

			<hr>

			Rates are up to date as of <%=new java.util.Date()%>

		</div>
	</div>

</body>

</html>