package com.Strong.web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(value = "/baseServlet")
public class BaseServlet extends HttpServlet {
    //根据请求的最后一行来进行方法分发
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求路径
        String uri = req.getRequestURI();//xxx/brand=demo/selectAll
        int index = uri.lastIndexOf('/');
        //获取最后的方法名,截取的字段,就是访问的方法名称
        //并且通过反射的机制获取对应类的方法对象
        String methodName = uri.substring(index + 1);

        //获取调用该Servlet类的对象
        Class<? extends BaseServlet> cls = this.getClass();


        //获取方法对象
        try {
            //获取方法
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //调用方法
            //设置方法为
//            method.setAccessible(true);

            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {


        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
