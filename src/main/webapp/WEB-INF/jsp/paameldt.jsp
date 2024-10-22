<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/simple.css"/>
  <title>Påmeldingsbekreftelse</title>
</head>
<body>
<h2>Påmeldingsbekreftelse</h2>
<p>Påmeldingen er mottatt for</p>
<p>
   <c:out value=" ${deltager.fornavn}"/><br>
   <c:out value=" ${deltager.etternavn}"/><br>
    <c:out value="${deltager.mobil}"/><br>
    <c:out value="${deltager.kjonn}"/><br>
</p>


<a href="${pageContext.request.contextPath}/deltager" >Gå til deltagerlisten</a>
</body>
</html>