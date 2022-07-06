package com.Strong.web;

import com.Strong.pojo.User;
import com.Strong.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取jsp页面传过来的数据源
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String remember = request.getParameter("remember");

        //调用service的方法
        User user = service.login(username, password);

        //逻辑判断
        if (user != null) {
            //勾选记住密码的功能
            if ("on".equals(remember)) {
                //1.发送Cookie

                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);
                //2.设置cookie的存储时间
                c_password.setMaxAge(60 * 60 * 24);
                c_password.setMaxAge(60 * 60 * 24);

                //2.发送Cookie
                response.addCookie(c_username);
                response.addCookie(c_password);


            }


            //登录成功的数据

            //1.跳转到查询所有的页面,这两次请求之间没有数据的共享,所以使用重定向
            String contextPath = request.getContextPath();
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(contextPath + "/selectAllServlet");


        } else {
            //登录失败的数据

            //跳转回login
            request.setAttribute("login_msg", "用户名或者密码错误");

            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
