<%@ include file="../fragments/header.jspf" %>

<script type="text/javascript">
$(function() {
	$("td.delete").click(function(){
		var id = $(this).attr("id").substring("d_".length); 
		var row = $("#d_"+id).parent();
		$.ajax({
			url: "${prefix}book/"+id,
			type: "DELETE",
			success: function(d) {
				console.log("ok - this worked");
				row.remove();
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

<h1>Lista de libros (aprovecha para eliminarlos!)</h1>

<table>
	<tr><th>id<th>title<th>description<th>authors<th>owner
	<c:forEach items="${books}" var="b">
	<tr><td>${b.id}<td>${b.title}<td>${b.description}
	<td>
	<c:forEach items="${b.authors}" var="a">
			${a.lastName}, ${a.familyName}; 
	</c:forEach>
	<td>${b.owner.login}
	<td class="edit">e<td class="delete" id="d_${b.id}">x
	</c:forEach>
</table>

<h1>Formulario para añadir un libro al sistema</h1>

<form action="${prefix}book" method="post">
<table>
	<tr><td>campo</td><td>valor</td></tr>
	<tr><td>description</td><td><input name="description" /></td></tr>
	<tr><td>title<td><input name="title" /></td></tr>
	<tr><td>authors</td><td><select name="authors" multiple="multiple" >
		<c:forEach items="${authors}" var="a">
			<option value="${a.id}">${a.lastName}, ${a.familyName}</option>
		</c:forEach>
	</select>
	</tr>
	<tr><td>owner</td><td><select name="owner">
		<c:forEach items="${owners}" var="o">
			<option value="${o.id}">${o.login}</option>
		</c:forEach>
	</select>
	</tr>
	<tr><td><button type="submit">Confirmar</button>	
</table>
</form>

</div>
<%@ include file="../fragments/footer.jspf" %>
