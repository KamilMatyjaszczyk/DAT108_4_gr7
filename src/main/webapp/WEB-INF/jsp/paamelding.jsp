<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/simple.css"/>

     <script src="${pageContext.request.contextPath}/JS/script.js" defer></script>
    <title>Påmelding</title>
</head>

<body>
<h2>Påmelding</h2>
    <p style="color: red;">${error}</p>
<form action="/paamelding" method="post" id="deltager">
    <fieldset>
        <div id="root">
            <label>Fornavn</label>
            <input type="text" name="fornavn" />

            <label>Etternavn</label>
            <input type="text" name="etternavn" />

            <label>Mobil (8 siffer)</label>
            <input type="text" name="mobil" >

            <label>Passord</label>
            <input type="password" name="passord"/>
            <label>Passord repetert</label>
            <input type="password" name="passordRepetert" />

            <label>Kjønn</label>
            <input type="radio" name="kjonn" value="Mann"/>Mann
            <input type="radio" name="kjonn" value="Kvinne" />Kvinne

            <br><br><button type="submit">Meld meg på</button>
        </div>
    </fieldset>
</form>
</body>
</html>

