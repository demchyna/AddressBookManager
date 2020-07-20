<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Read Record from Address Book</title>
</head>
<body>
<%@ include file="nav.html"%>
<br><br>
<table>
    <tr>
        <td>First name: </td>
        <td>
            <strong><%=request.getParameter("first-name")%></strong>
        </td>
    </tr>
    <tr>
        <td>Last name: </td>
        <td>
            <strong><%=request.getParameter("last-name")%></strong>
        </td>
    </tr>
    <tr>
        <td>Address: </td>
        <td>
            <strong><%=request.getAttribute("address")%></strong>
        </td>
    </tr>
</table>
</body>
</html>