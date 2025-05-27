<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/27/2025
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>List Category</h3>
    <form method="get" action="search-categoryName">
        <input name="name" value="${param.name}" placeholder="Tìm kiếm tên danh mục">
        <button type="submit">Tìm kiếm</button>
    </form>
    <table border="1" cellspacing="0" cellpadding="10">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên danh mục</th>
            <th>Mô tả danh mục</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td>${category.category_id}</td>
                <td>${category.category_name}</td>
                <td>${category.description}</td>
                <td>${category.status == true ? 'active' : 'inactive'}</td>
                <td><a href="edit-category/${category.category_id}">Sửa</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
