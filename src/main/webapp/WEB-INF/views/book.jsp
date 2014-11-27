<%@ include file="../fragments/header.jspf" %>
<div id="principal">

<h1>Formulario para ver un libro</h1>

<table>
	<tr><td>campo</td><td>valor</td></tr>
	<tr><td>id</td><td>${book.id}</td></tr>
	<tr><td>description</td><td>${book.description}</td></tr>
	<tr><td>title<td>${book.title}</td></tr>
	<tr><td>authors</td><td>book.authors</td></tr>
</table>

</div>
<%@ include file="../fragments/footer.jspf" %>
