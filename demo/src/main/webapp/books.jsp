<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/29/2024
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách sách</title>
</head>
<body>
<h1>Danh sách sách</h1>
<a href="book?action=add">Thêm sách mới</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Kích thước trang</th>
        <th>Tác giả</th>
        <th>Thể loại</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty books}">
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.pageSize}</td>
                <td>${book.author}</td>
                <td>${book.category}</td>
                <td>
                    <a href="book?action=edit&id=${book.id}">Chỉnh sửa</a>
                    <a href="book?action=delete&id=${book.id}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${empty books}">
        <tr>
            <td colspan="6">Không có sách nào trong danh sách.</td>
        </tr>
    </c:if>
    </tbody>
</table>
</body>
</html>
