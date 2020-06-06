<%--
  Created by IntelliJ IDEA.
  User: Arpushik
  Date: 5/26/2020
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<% if (request.getAttribute("message") != null) { %>
<%=request.getAttribute("message")%>
<% } %>
<br><br>

<form method="post" action="/forget-password">
    username : <input type="text" name="username"><br/>
    <input type="submit" name="submit"><br>
</form>

</body>
</html>
