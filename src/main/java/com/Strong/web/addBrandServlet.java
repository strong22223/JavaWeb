package com.Strong.web;

import com.Strong.pojo.Brand;
import com.Strong.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(value = "/addBrandServlet")
public class addBrandServlet extends HttpServlet {
    private BrandService service = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        //1.接收单 提交的数据,并且封装为一个Brand 的对象

        String brandName = request.getParameter("brandName");
//        brandName = new String(brandName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");


        //2.创建Brand的对象并且封装数据
        Brand brand = new Brand();


        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setDescription(description);
        brand.setStatus(Integer.parseInt(status));

        //3.调用service的方法来添加
        service.addBrand(brand);

        //4.请求转发到查询所有的Servlet
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
