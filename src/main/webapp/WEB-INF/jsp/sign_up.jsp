<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign up form</title>
</head>
<body>
<h1>Sign up form</h1>
<form action="/sign_up" method="post">
    <table style="with: 50%">
        <tr>
            <td>First Name</td>
            <td><input type="text" name="first_name" /></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="last_name" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="e-mail" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" /></td>
        </tr>
        <tr>
            <td>Phone number</td>
            <td><input type="text" name="phone_number" /></td>
        </tr></table>
    <input type="submit" value="Submit" /></form>
</body>
</html>