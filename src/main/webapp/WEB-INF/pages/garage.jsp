<%--
  Created by IntelliJ IDEA.
  User: psimic
  Date: 31.03.15
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Garage</title>
</head>
<body>

<h2>Set capacity</h2>
<form:form method="POST" action="/mvc-dispatcher/addGarage">
    <table>
        <tr>
            <td><form:label path="flors">Flors:</form:label></td>
            <td><form:input path="flors" /></td>
        </tr>
        <tr>
            <td><form:label path="parkingSlotsPerFlor">parkingSlotsPerFlor</form:label></td>
            <td><form:input path="parkingSlotsPerFlor" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
