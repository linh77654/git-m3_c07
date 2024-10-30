<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Thêm Sách</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h2>Thêm Sách Mới</h2>
<form action="book?action=add" method="post">
  <label for="title">Tiêu Đề:</label>
  <input type="text" id="title" name="title" required><br>

  <label for="author">Tác Giả:</label>
  <input type="text" id="author" name="author" required><br>

  <label for="category">Thể Loại:</label>
  <input type="text" id="category" name="category" required><br>

  <label for="pageSize">Số Trang:</label>
  <input type="number" id="pageSize" name="pageSize" required><br>

  <input type="submit" value="Thêm Sách">
</form>
<a href="book?action=list">Trở Về Danh Sách Sách</a>
</body>
</html>
