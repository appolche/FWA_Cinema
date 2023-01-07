<%@ page import="edu.school21.cinema.models.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <style>
        table, th, td {
            border: 1px solid black;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Profile</h1>
<p><strong>
    <%=((User)session.getAttribute("User")).getFirstName()%>
    <%=((User)session.getAttribute("User")).getLastName()%>
</strong></p>


<img src="https://sun9-west.userapi.com/sun9-1/s/v1/ig2/jiHCXf_uzeFWx23q78EHiuYvNyrExXxMpBpoTq5sBRM3xz1es9jESONQXOoX0_lNrfUmVwZVqqVDE8VPQPKyWPzL.jpg?size=907x720&quality=96&type=album" width="600" height="400">
<table width="500" align="center">
    <tr>
        <th>Date</th>
        <th>Time</th>
        <th>IP</th>
    </tr>
    <tr>
        <td>December 10, 2020</td>
        <td>05:00</td>
        <td>127.0.0.1</td>
    </tr>
    <tr>
        <td>December 09, 2020</td>
        <td>04:00</td>
        <td>127.0.0.1</td>
    </tr>
    <tr>
        <td>December 08, 2020</td>
        <td>03:00</td>
        <td>127.0.0.1</td>
    </tr>
</table>
</body>
</html>