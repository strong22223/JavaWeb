<%--
  Created by IntelliJ IDEA.
  User: BigStrong
  Date: 2022/7/2
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加品牌</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="/xxx/updateServlet" method="post">

<%--    隐藏域--%>

    <input type="hidden" name="id" value="${brand.id}">


    品牌名称：<input name="brandName"  value="${brand.brandName}"><br>
    企业名称：<input name="companyName" value="${brand.companyName}"><br>
    排序：<input name="ordered" value="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">${brand.description}</textarea><br>
    状态：
    <c:if test="${brand.status==0}">

        <input type="radio" name="status" value="0" checked="checked">禁用
        <input type="radio" name="status" value="1">启用<br>
    </c:if>
    <c:if test="${brand.status==1}">

        <input type="radio" name="status" value="0" >禁用
        <input type="radio" name="status" value="1" checked="checked">启用<br>

    </c:if>

    <input type="submit" value="提交">
</form>
</body>
</html>