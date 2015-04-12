<%--
  Created by IntelliJ IDEA.
  User: psimic
  Date: 12.04.15
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Add User To garage</title>
</head>
<body>
<div>
    <form:form method="POST" action="/addCustomer">
        <table>
            <td><form:label path="plates">Insert plates number:</form:label></td>
            <td><form:input path="plates" /></td>
            </tr>
            <tr>
                <td><form:label path="type">Select type:</form:label></td>
                <td><form:checkbox path="type" value="CAR" label="CAR" /> </td>
                <td><form:checkbox path="type" value="BIKE"  label="BIKE"/> </td>
            </tr>
            <tr>
            <tr>
            <td colspan="2">
                <input type="submit" value="Add User"/>
            </td>
        </tr>
        </table>
    </form:form>
</div>

<div>
    <form:form method="POST" action="/removeCustomer">
        <table>
            <tr>
            <td><form:label path="plates">Insert plates number:</form:label></td>
            <td><form:input path="plates" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Remove User"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
