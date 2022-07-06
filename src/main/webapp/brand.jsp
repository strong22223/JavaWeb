<%--
  Created by IntelliJ IDEA.
  User: BigStrong
  Date: 2022/7/2
  Time: 16:22
  To change this template use File | Settings | File Templates.
 isELIgnored="false"
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>${user.username},欢迎你!</h1>
<%--事件绑定--%>
<input type="button" value="新增" id="addBrand"><br>

<hr>
<table border="1" cellspacing="0" width="900">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>

    <c:forEach items="${brands}" var="brand" varStatus="status">

        <tr>
                <%--         <td>$brand.id</td>--%>
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status==1}">
                <td>启用</td>
            </c:if>

            <c:if test="${brand.status!=1}">
                <td>禁用</td>
            </c:if>

            <td><a href="/xxx/selectByIdServlet?id=${brand.id}">修改 </a> <a href="/xxx/deleteByIdServlet?id=${brand.id}">删除</a>
            </td>
        </tr>


    </c:forEach>
</table>
<%--利用JS来跳转页面--%>
<script>
    document.getElementById("addBrand").onclick = function () {

        location.href = "/xxx/addBrand.jsp";
    }

</script>

</body>
</html>
