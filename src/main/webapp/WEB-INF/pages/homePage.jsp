<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Garage</title>
</head>
<body>

<h2>Home page</h2>
<table>
    <tr>
        <td>Flors</td>
        <td>${flors}</td>
    </tr>
    <tr>
        <td>parkingSlotsPerFlor</td>
        <td>${parkingSlotsPerFlor}</td>
    </tr>
</table>
<div>
    <form:form method="GET" action="/userPage">
        <table>
            <tr>
                <td>
                    <input type="submit" value="Add User"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>