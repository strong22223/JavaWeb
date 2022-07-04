package com.Strong.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitServlet {


    public static void initGetPost(HttpServletRequest request, HttpServletResponse response) {

        String method = request.getMethod();

        if(method.equals("GET")){
            System.out.println("Get.....");
        }else{
            System.out.println("Post...");
        }
    }
}
