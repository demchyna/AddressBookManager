<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Records from Address Book</title>
</head>
<body>
<%@ include file="nav.html"%>
<br>
<p>Sort by: <a href="/records/list?sort=asc">ascending</a> | <a href="/records/list?sort=desc">descending</a></p>
<table border="1">
    <tr>
        <th>No.</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Address</th>
        <th colspan="3">Operation</th>
    </tr>
    <%
        List<String[]> records = (List<String[]>)request.getAttribute("records");
        int counter = 1;
        for (String[] record : records) {
    %>
            <tr>
                <td><%=counter++%></td>
                <td><%=record[0]%></td>
                <td><%=record[1]%></td>
                <td><%=record[2]%></td>
                <td>
                    <a href="read?first-name=<%=record[0]%>&last-name=<%=record[1]%>">Read</a>
                </td>
                <td>
                    <a href="update?first-name=<%=record[0]%>&last-name=<%=record[1]%>">Update</a>
                </td>
                <td>
                    <a href="delete?first-name=<%=record[0]%>&last-name=<%=record[1]%>">Delete</a>
                </td>
            </tr>
    <%
        }
    %>
</table>
</body>
</html>