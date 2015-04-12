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
    <title>Garage</title>
</head>
<body>
<div>
    <h2>ADDING USERS</h2>
    <form:form method="POST" action="/addCustomer">
        <table>
            <td><form:label path="plates">Insert plates number ( min 3 letters/numbers... ):</form:label></td>
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
        </tr>  <br/><br/>
            <td><b>${message}</b></td>
        </table>
    </form:form>
</div>

<br/><br/><br/>
<div>
    <h2>REMOVING USERS</h2>
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
    <td><b>${messageRemove}</b></td>
</div>

<br/><br/><br/>
<div>
    <h2>FREE SPACES IN GARAGE</h2>
    <form:form method="POST" action="/getFreeSpaces">
        <table>
           <tr>
                <td colspan="2">
                    <input type="submit" value="Get Free Spaces At Moment"/>
                </td>
            </tr>
        </table>
    </form:form>
    <tr>
        <td>Free Spaces in garage</td><br/>
        <td><b>${spaces}</b></td>
    </tr>
</div>

<br/><br/><br/>
<div>
    <h2>FIND CAR LOCATION BY PLATES</h2>
    <form:form method="POST" action="/findCar">
        <table>
            <tr>
                <td colspan="2">
                <td><form:label path="plates">Insert plates number:</form:label></td>
                <td><form:input path="plates" /></td>
                </td>
                <td colspan="2">
                    <input type="submit" value="Find Car Location"/>
                </td>
            </tr>
        </table>
    </form:form>
    <tr>
        <td>Car is on flor:</td>
        <td><b>${flor}</b></td><br/>
        <td>And on parking lot No:</td>
        <td><b>${parkingSlot}</b></td><br/>
        <td><b>${messageLocation}</b></td>
    </tr>
</div>

</body>
</html>
