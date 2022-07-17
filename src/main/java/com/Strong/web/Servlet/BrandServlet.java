package com.Strong.web.Servlet;

import com.Strong.pojo.Brand;
import com.Strong.service.BrandService;
import com.Strong.service.impl.BrandServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/brandServlet/*")
public class BrandServlet extends BaseServlet {
    private final BrandService brandService = new BrandServiceImpl();


    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("111");
        //获取数据
        List<Brand> brands = brandService.selectAll();

        //准换为JSON
        String json = JSON.toJSONString(brands);
        //设置响应的中文字符
        response.setContentType("text/json;charset=utf-8");
        //发送数据
        response.getWriter().write(json);

    }

    public void addBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        BufferedReader reader = request.getReader();
        String param = reader.readLine();
        //转换为Brand的对象
        Brand o = (Brand) JSON.parseObject(param, Brand.class);
        //调用service来调价
        brandService.addBrand(o);
        //成功之后响应标识

        response.getWriter().write("success");
    }


}
