<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/simple.css"/>    <title>Logg inn</title>
</head>
<body>
<h2>Logg inn</h2>
<p style="color:red;">${melding}</p>
<fieldset>
    <form method="post" action="/innlogging">

        <label for="mobil">Mobil:</label> <input type="text" name="mobil" id="mobil"/>
        <label for="passord">Passord:</label> <input type="password" name="passord" id="passord" />
        <br><br><button type="submit">Logg inn</button>
    </form>
    <form action="/paamelding" method="get">
        <button>Registrer deg her</button>
    </form>
</fieldset>


</body>
</html>