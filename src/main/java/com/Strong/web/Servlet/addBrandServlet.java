package com.Strong.web.Servlet;

import com.Strong.pojo.Brand;
import com.Strong.service.BrandService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(value = "/addBrandServlet")
public class addBrandServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.setCharacterEncoding("utf-8");
//
//        //1.接收单 提交的数据,并且封装为一个Brand 的对象
//
//        String brandName = request.getParameter("brandName");
////        brandName = new String(brandName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
//        String companyName = request.getParameter("companyName");
//        String ordered = request.getParameter("ordered");
//        String description = request.getParameter("description");
//        String status = request.getParameter("status");
//
//
//        //2.创建Brand的对象并且封装数据
//        Brand brand = new Brand();
//
//
//        brand.setBrandName(brandName);
//        brand.setCompanyName(companyName);
//        brand.setOrdered(Integer.parseInt(ordered));
//        brand.setDescription(description);
//        brand.setStatus(Integer.parseInt(status));
//
//        //3.调用service的方法来添加
//        service.addBrand(brand);
//
//        //4.请求转发到查询所有的Servlet
//        request.getRequestDispatcher("/selectAllServlet").forward(request,response);


        //1. 接收数据,request.getParameter 不能接收json的数据
       /* String brandName = request.getParameter("brandName");
        System.out.println(brandName);*/
        // 获取请求体数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        // 将JSON字符串转为Java对象
        Brand brand = JSON.parseObject(params, Brand.class);
        System.out.println(".............");

        //2. 调用service 添加
        service.addBrand(brand);

        //3. 响应成功标识
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
