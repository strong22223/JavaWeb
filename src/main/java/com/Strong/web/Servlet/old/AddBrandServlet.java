package com.Strong.web.Servlet.old;

import com.Strong.pojo.Brand;
import com.Strong.service.BrandService;
import com.Strong.service.impl.BrandServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet(value = "/addBrandServlet")
public class AddBrandServlet extends HttpServlet {
    BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
