<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Xác Nhận Xóa Sách</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h2>Xác Nhận Xóa Sách</h2>
<p>Bạn có chắc chắn muốn xóa sách: <strong>${book.title}</strong>?</p>
<form action="book?action=delete&id=${book.id}" method="post">
    <input type="submit" value="Xóa">
</form>
<a href="book?action=list">Trở Về Danh Sách Sách</a>
</body>
</html>
