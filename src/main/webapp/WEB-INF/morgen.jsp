<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <p>Bonjour à vous !</p>
  <p>
    <%
        String heure = (String) request.getAttribute("heure");
       out.println(heure);
    %>
</p>
</body>
</html>