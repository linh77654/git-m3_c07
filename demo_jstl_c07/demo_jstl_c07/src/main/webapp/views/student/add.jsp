<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 10/28/2024
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/students?action=add" method="post">
<%--    <input hidden="hidden" name="action" value="add">--%>
<%--    <input name="id" placeholder="enter id">--%>
    <input name="name" placeholder="enter name">
    <input type="radio" name="gender" value="1"> Male
    <input type="radio" na
           me="gender" value="0"> Female
    <input type="number" name="point">
    <select name="classId">
     <c:forEach items="${classList}" var="cls">
         <option value="${cls.id}">${cls.name}</option>
     </c:forEach>
    </select>
    <input type="submit" value="Add"/>
</form>
</body>
</html>
