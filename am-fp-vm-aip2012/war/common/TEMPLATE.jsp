<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<jsp:include page="common/meta-head.jsp" />
<title>PAGE_TITLE</title>
</head>
<body>
<div id="container">
<jsp:include page="common/header.jsp" />
<!-- CONTENT START -->
<div id="middle">
	<div id="leftmenu">Menu LEFT</div>
	<div id="content">
<h1>CONTENT</h1>
	</div>
</div>
<!-- CONTENT END -->
<jsp:include page="common/footer.jsp" />
</div>
</body>
</html>
