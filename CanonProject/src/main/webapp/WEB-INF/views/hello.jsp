<%--
  Created by IntelliJ IDEA.
  User: lordl
  Date: 2015. 10. 02.
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sql:query var="rs" dataSource="jdbc/canon">
  select name from image
</sql:query>

<html>
<head>
    <title></title>
</head>
<body style="background-color: ${col}">
  ${message}
  <br/>
  Image names:
  <br/>
  <c:forEach var="row" items="${rs.rows}">
      - ${row.name}
      <br/>
  </c:forEach>
    <br/>
    <br/>
  <c:forEach var="image" items="${images}">
       - ${image.mime.mimeType} - ${image.name}
      <br/>
  </c:forEach>

<form action="http://localhost:8080/test" method="get" >
    <input value="Go" type="submit">
</form>

  <img alt="image"  src="http://localhost:8080/getImage">
</body>
</html>
