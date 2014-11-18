<%@ include file="../fragments/header.jspf" %>
<div id="principal">

<h1>Formulario para subir un fichero</h1>

<form method="POST" enctype="multipart/form-data" action="user">
		Fichero a subir <input type="file" name="photo"><br />
		<input hidden="submit" name="id" value="${user.id}" />
		<button type="submit" name="upload" value="ok">Pulsa para subir esa foto</button>
</form>

</div>
<%@ include file="../fragments/footer.jspf" %>
