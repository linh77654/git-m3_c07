<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Sửa Sách</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h2>Sửa Sách</h2>
<form action="book?action=edit" method="post">
  <input type="hidden" name="id" value="${book.id}">

  <label for="title">Tiêu Đề:</label>
  <input type="text" id="title" name="title" value="${book.title}" required><br>

  <label for="author">Tác Giả:</label>
  <input type="text" id="author" name="author" value="${book.author}" required><br>

  <label for="category">Thể Loại:</label>
  <input type="text" id="category" name="category" value="${book.category}" required><br>

  <label for="pageSize">Số Trang:</label>
  <input type="number" id="pageSize" name="pageSize" value="${book.pageSize}" required><br>

  <input type="submit" value="Cập Nhật Sách">
</form>
<a href="book?action=list">Trở Về Danh Sách Sách</a>
</body>
</html>
