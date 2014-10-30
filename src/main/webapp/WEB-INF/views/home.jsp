<%@ include file="../fragments/header.jspf" %>
<div id="principal">

<h1>Aplicación de ejemplo de IW</h1>

<h3>En esta versión: "includes" jspf y soporte para sesiones</h3>

<ul>
	<li>admin / cualquier contraseña de más de 3 caracteres = login de administrador</li>
	<li>cualquier otro login de más de 3 caracteres / contraseña de más de 3 caracteres = usuario raso</li>
	<li>si pulsas "logout" se cierra la sesión</li>
</ul>

<h3>Cosas a mirar</h3>
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
</ul>

Pulsa en <a href="about">este enlace</a> para saber más sobre esta aplicación.

</div>
<%@ include file="../fragments/footer.jspf" %>
