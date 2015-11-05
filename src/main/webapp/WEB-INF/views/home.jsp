<%@ include file="../fragments/header.jspf" %>
<div id="principal">

<h1>Aplicación de ejemplo de IW</h1>

<h3>En esta versión: algo de AJAX</h3>
<ul>
	<li>el código de <code>src/main/webapp/WEB-INF/header.jspf</code>: una cabecera "rica", 
		uso de control de flujo JSP vía "tags" de la JSP Standard Tag Library (JSTL): 
		if, choose/when/otherwise, uso de condiciones JSP Expression Language (EL))</li>
	<li>el código de <code>src/main/webapp/WEB-INF/footer.jspf</code>: información de "debug" sobre contextos, 
		e iteración sobre mapas usando EL</li>
	<li>si pulsas "más información" en el "footer" se pone una bandera "debug" en la sesión</li>
	<li>los recursos en <code>src/main/webapp/resources</code> están accesibles bajo 
		<code>mi-contexto/resources</code>; 
		aquellos bajo <code>src/main/webapp/WEB-INF</code> sólo se pueden acceder desde dentro del JSP 
		(pero no externamente: no puedes acceder a 'header.jspf' cambiando la URL del navegador)</li>
	<li>usuarios existentes: admin, user, test (<b>contraseña: "bbbb"</b>)</li>
	<li>usuario inexistente con contraseña de <b>4</b> caracteres: crea el usuario</li>
	<li>si no crea usuario, y login ó contraseña no corresponden a un usuario existente, no permite login</li>
	<li>si pulsas en <a href="logout">logout</a> se cierra la sesión</li>
	<li>un <a href="book/1">libro</a> y sus autores (¡usa <b>Ajax</b>!)</li>
	<li>un <a href="books">lista de libros</a> y sus autores (¡también usa <b>Ajax</b>!)</li>
	<li>un <a href="author/1">autor</a> y sus libros - ¿serías capaz de hacer que se viesen de forma bonita y con enlaces?</li>
</ul>

Pulsa en <a href="about">este enlace</a> para saber más sobre esta aplicación, y ver una tabla de usuarios.

</div>
<%@ include file="../fragments/footer.jspf" %>
