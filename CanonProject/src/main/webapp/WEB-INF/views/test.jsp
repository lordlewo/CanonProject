<%--
  Created by IntelliJ IDEA.
  User: lordl
  Date: 2015. 10. 16.
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Test</title>
</head>
<body>
  <table >
    <tr >
      <th>id</th>
      <th>name</th>
    </tr>
    <c:forEach items="${tests}" var="test">
      <tr>
        <td>${test.id}</td>
        <td>${test.name}</td>
      </tr>
    </c:forEach>
  </table>

</body>
</html>
