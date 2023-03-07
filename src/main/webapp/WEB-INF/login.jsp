<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Login" %>
    <form action="login.php" method="post">
        <table>
            <tr>
                <td align="right"><b><t:field mandatory="yes"
                                              text="Username"></t:field></b></td>
                <td align="left"><input type="text" size="25" maxlength="50"
                                        name="username" id="username" /></td>
            </tr>
            <tr>
                <td align="right"><b><t:field mandatory="yes"
                                              text="Password"></t:field></b></td>
                <td align="left"><input type="password" size="25"
                                        maxlength="50" name="password" id="password" /></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
            </tr>
            <tr bgcolor="gray">
                <td align="right">&nbsp;</td>
                <td align="left"><input type="submit" value="Login" /></td>
            </tr>
        </table>
    </form>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>
