<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/simple.css"/>
    <title>Deltagerliste</title>
</head>
<body>
<p style="font-weight: bold">Innlogget som:<c:out value=" ${deltager.mobil} / ${deltager.fornavn} ${deltager.etternavn}"/></p>
<h2>Deltagerliste</h2>

<%-- MANN = &#9794 KVINNE = &#9792; --%>

<table>
    <tr>
        <th>Kjønn</th>
        <th align="left">Navn</th>
        <th align="left">Mobil</th>
    </tr>

    <%-- Har med c:out for navn og mobil fordi man kan aldri være for sikker på input fra bruker.
        i teorien så skal det gå fint uten <c:out> fordi vi har valdiert input tidligere --%>

    <c:forEach var="deltagerListe" items="${liste}">
        <c:if test="${deltagerListe.mobil.equals(deltager.mobil)}"><tr style=background-color:darkseagreen;></c:if>
        <td> ${deltagerListe.kjonn.equals("Mann")?"&#9794":"&#9792"}</td>
        <td><c:out value=" ${deltagerListe.fornavn}  ${deltagerListe.etternavn}"/></td>
        <td><c:out value=" ${deltagerListe.formatterNr()}"/></td>
    </tr></c:forEach>



</table>
<br>
<form action="/logut" method="post">
    <button type="submit">Logg ut</button>
</form>
</body>
</html>