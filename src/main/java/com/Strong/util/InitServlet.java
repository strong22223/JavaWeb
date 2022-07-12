package com.Strong.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitServlet {
    public static void initGetPost(HttpServletRequest request, HttpServletResponse response) {
        String method = request.getMethod();
        String s;
        s = method.equals("GET") ? "Get....." : "Post...";
        System.out.println(s);
    }

}
