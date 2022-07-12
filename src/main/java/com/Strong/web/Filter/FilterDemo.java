//package com.Strong.web.Filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class FilterDemo implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        //1.放行之前,就对request数据进行处理.
//
//        System.out.println("FilterDemo....");
//
//        filterChain.doFilter(servletRequest, servletResponse);
//        //2.放行后,才对response的对象的数据封装
//
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
////        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void destroy() {
////        Filter.super.destroy();
//    }
//}
