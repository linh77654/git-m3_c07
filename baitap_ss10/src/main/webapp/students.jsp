<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh sách Học viên Code Gym</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Danh sách Học viên Code Gym</h2>

    <c:choose>
        <c:when test="${empty students}">
            <p class="text-danger text-center">Danh sách rỗng.</p>
        </c:when>
        <c:otherwise>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Mã học viên</th>
                    <th>Tên học viên</th>
                    <th>Giới tính</th>
                    <th>Điểm số</th>
                    <th>Xếp loại</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.mahocvien}</td>
                        <td>${student.tenhoctien}</td>
                        <td>${student.gioitinh}</td>
                        <td>${student.diemso}</td>
                        <td>
                            <c:choose>
                                <c:when test="${student.diemso >= 90}">Giỏi</c:when>
                                <c:when test="${student.diemso >= 80}">Khá</c:when>
                                <c:when test="${student.diemso >= 60}">Trung Bình</c:when>
                                <c:otherwise>Yếu</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
