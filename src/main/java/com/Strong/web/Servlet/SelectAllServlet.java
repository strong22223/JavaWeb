package com.Strong.web.Servlet;

import com.Strong.pojo.Brand;
import com.Strong.service.BrandService;
import com.Strong.service.impl.BrandServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        List<Brand> brands = brandService.selectAll();

        //准换为JSON
        String json = (String) JSON.toJSONString(brands);
        //设置响应的中文字符
        response.setContentType("text/json;charset=utf-8");
        //发送数据
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
