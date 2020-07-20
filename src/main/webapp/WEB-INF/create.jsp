<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create new Record in Address Book</title>
</head>
<body>
<%@ include file="nav.html"%>
<br>
<p><%=request.getAttribute("error") != null ? request.getAttribute("error") : ""%></p>
<form method="post">
    <table>
        <tr>
            <td>
                <label for="first-name">First name:</label>
            </td>
            <td>
                <input type="text" id="first-name" name="first-name" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="last-name">Last name:</label>
            </td>
            <td>
                <input type="text" id="last-name" name="last-name" required/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="address">Address:</label>
            </td>
            <td>
                <textarea id="address" name="address" required></textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create"/>
            </td>
            <td>
                <input type="reset" value="Clear">
            </td>
        </tr>
    </table>
</form>
</body>
</html>