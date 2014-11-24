<%@ include file="../fragments/header.jspf" %>
<div id="principal">

<h1>Formulario para ver un autor</h1>

<table>
	<tr><td>campo</td><td>valor</td></tr>
	<tr><td>id</td><td>${author.id}</td></tr>
	<tr><td>familyName</td><td>${author.familyName}</td></tr>
	<tr><td>lastName<td>${author.lastName}</td></tr>
	<tr><td>writings</td><td>${author.writings}</td></tr>
</table>

</div>
<%@ include file="../fragments/footer.jspf" %>
