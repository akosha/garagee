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

<h1>Set initial capacity of garage in flors and parking lots per flor</h1>
<form:form method="POST" action="/addCapacity">
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
