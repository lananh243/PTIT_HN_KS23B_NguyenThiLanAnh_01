<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lan Anh
  Date: 5/27/2025
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Edit Category</h3>
    <form:form modelAttribute="categoryDTO" action="${pageContext.request.contextPath}/update-category" method="post" enctype="multipart/form-data">
        <label for="category_name">Tên danh mục: </label>
        <form:input path="category_name" id="category_name"/>
        <br>
        <form:errors path="category_name" cssStyle="color: red"/>
        <br>
        <label for="description">Mô tả danh mục: </label>
        <form:input path="description" id="description"/>
        <br>
        <form:errors path="description" cssStyle="color: red"/>
        <br>
        <label for="status">Trạng thái: </label>
        <form:input path="status" id="status"/>
        <br>
        <input type="submit" value="Sửa danh mục">
    </form:form>
</body>
</html>
