//package com.Strong.web.Filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class LoginFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        //判断访问的路径是否与 登录 注册 相关
//
//        String[] urls = new String[]{"login.jsp", "/imgs/", "/css/", "/loginServlet", "/registerServlet", "register.jsp", "/checkCodeServlet"
//        ,"/AjaxServlet"};
//        //获取访问的路径
//        String requestURL = req.getRequestURL().toString();
//
//        for (String a : urls) {
//            if (requestURL.contains(a)) {
//                //召找见了，放行
//
//                chain.doFilter(request, response);
//                return;
//            }
//        }
//
//
//        //判断Session中是否拥有User对象
//        HttpSession session = req.getSession();
//        Object user = session.getAttribute("user");
//
//        //判断user的值是否为空,如果不是空就说明已经登录
//        if (user != null) {
//            //登陆过了,    放行
//            chain.doFilter(request, response);
//        } else {
//            //没有登录,设置提示信息
//            request.setAttribute("login_msg", "你尚未登录!");
//            //请求准发
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
//        }
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//    public void destroy() {
//    }
//}
