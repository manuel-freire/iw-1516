<%@ include file="../fragments/header.jspf" %>

<script type="text/javascript">
$(function() {
	$(".pideAutores").click(function() {
		// en un manejador de eventos jquery, el "this" inicial es el elemento DOM sobre el que se lanza el evento
		// por tanto, $(this) es el elemento JQuery que lo envuelve 
		var target = $(this); 
		// el id del libro cuyos autores buscamos
		var id = $(this).attr("id").substring("b_".length); 
		$.ajax({
			dataType: "json",
			url: "${prefix}bookAuthors",
			type: "POST",
			data: "id=" + id,
			success: function(d) {
				refreshAuthors(target, d);
			}
		})		
	})	
})
function refreshAuthors(target, authorData) {
	// 'authorData' contiene un array de objetos
	// ejemplo: [ {id : "1", familyName: "Adams", lastName: "Adam"} ]
	var list = $("<ul>"); // creo una lista HTML, todavia no insertada en el documento
	console.log(authorData);
	// llama a la funcion con i=indice y o=objeto para cada elemento del array authorData
	console.log(authorData);
	$.each(authorData, function(i, o) {
		var li = $("<li>");
		li.append(authorToLink(o)); 
		list.append(li)
	})			
	target.replaceWith(list); // reemplazo el boton por la lista
}

function authorToLink(author) {
	return $("<a href='${prefix}author/" + author.id + "'>" 
				+ author.familyName + ", " + author.lastName 
			+ "</a>");		
}
</script>

<div id="principal">

<h1>Formulario para ver un libro</h1>

<table>
	<tr><td>campo</td><td>valor</td></tr>
	<tr><td>id</td><td>${book.id}</td></tr>
	<tr><td>description</td><td>${book.description}</td></tr>
	<tr><td>title<td>${book.title}</td></tr>
	<tr><td>authors</td><td><button id="b_${book.id}" class="pideAutores">Ver autores</button></td></tr>
</table>

</div>
<%@ include file="../fragments/footer.jspf" %>
