<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>


<div id='jqxMenuLeft' style='visibility: hidden; margin-left:auto; margin-right:auto'>
	<ul>
		<li><a href="${f:url('/admin/')}">Admin</a></li>
		<li><a href="${f:url('addProgetto')}">Crea un nuovo progetto</a></li>
		<li><a href="${f:url('addPartner')}">Crea un nuovo partner o cancella quelli già presenti</a></li>
	</ul>
</div>