<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<div id='jqxMenuLeft' style='visibility: hidden; margin-left:auto; margin-right:auto'>
	<ul>
		<li><a href="${f:url('/commissioneEuropea')}">Chi siamo</a></li>
		<li><a href="${f:url('/commissioneEuropea?page=visione')}">La nostra visione</a></li>
		<li><a href="${f:url('/commissioneEuropea?page=storia')}">La nostra storia</a></li>
		<li><a href="${f:url('/commissioneEuropea?page=contatti')}">Contatti</a></li>
	</ul>
</div>