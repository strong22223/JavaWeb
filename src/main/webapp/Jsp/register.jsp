<%--
  Created by IntelliJ IDEA.
  User: BigStrong
  Date: 2022/7/5
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@   page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="../css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
    </div>
    <form id="reg-form" action="/xxx/registerServlet" method="post">

        <table>

            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg" style="display: none"> 用户名已存在</span>
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>


            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id="checkCodeImg" onclick="on()" src="/xxx/checkCodeServlet">
                    <a href="#" id="changeImg">看不清？</a>
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>

<script>
    /**
     * 验证码注册
     */
    //单击"看不清",绑定切换验证码
    document.getElementById("changeImg").onclick = function () {

        document.getElementById("checkCodeImg").src = "/xxx/checkCodeServlet?" + new Date().getMilliseconds();
    }

    //单击图片,绑定切换验证码

    function on() {
        document.getElementById("checkCodeImg").src = "/xxx/checkCodeServlet?" + new Date().getMilliseconds();
    }


    /**
     * 实现移动光标自动检测,用户名是否存在
     */
    //1.首先给用户名的输入框绑定 失去焦点的事件
    document.getElementById("username").onblur = function () {

        //2.发送ajax请求
        //获取用户数据
        var username = this.value;


        //2.1创建核心对象
        var xhttp;
        if (window.XMLHttpRequest) {
            xhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        //2.2. 发送请求
        xhttp.open("GET", "http://localhost:8080/xxx/checkUserRegisterServlet?username=" + username);
        xhttp.send();
        //2.3. 获取响应
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                // //处理响应的结果,不为空
                if (this.responseText == "false") {
                    //用户名存在
                    document.getElementById("username_err").style.display = '';
                } else {
                    document.getElementById("username_err").style.display = 'none';
                }

            }
        };
    }

</script>


</body>
</html>