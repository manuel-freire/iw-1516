<%@ include file="../fragments/header.jspf" %>
<div id="principal">

<h1>Sobre esta aplicación</h1>
<ul>
	<li>El autor de esta aplicación es Manuel Freire, y los fuentes actualizados están disponibles
		<a href="https://github.com/manuel-freire/iw">en Github</a>.
	<li>Esta aplicación se distribuye bajo licencia BSD-Simplificada: 
		esencialmente por amor al arte, y puedes reutilizarla impunemente 
		siempre y cuando cites fuente y autoría en tu leeme.html ó equivalente.</li>
	<li>Realmente, esta segunda página sólo sirve para que veas que la sesión se mantiene entre
		páginas, y que me puedo registrar (hacer login) en cualquier página si pierdo mi sesión --
		pero "sin cambiar" de página.</li>
</ul>

<h1>Usuarios del sistema</h1>
<table class="users">
<thead>
	<tr><td>id<td>login<td>rol<td>hash<td>salt</tr>
</thead>
<tbody>
	<c:forEach items="${users}" var="u">
		<tr><td>${u.id}<td>${u.login}<td>${u.role}
		<td>${u.hashedAndSalted}<td>${u.salt}<td><img src="user/photo?id=${u.id}"/></tr>
	</c:forEach>
</tbody>	
</table>

</div>
<%@ include file="../fragments/footer.jspf" %>
