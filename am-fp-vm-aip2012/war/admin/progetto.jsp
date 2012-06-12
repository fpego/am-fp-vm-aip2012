<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>admin Progetto</title>
</head>
<body>

<h1>Progetto ${f:h(p.titoloProgetto)}</h1>

<h3>Presentazione</h3>

${f:h(p.presentazione)}

<!-- edit, crea collegamenti, file upload -->
</body>
</html>
