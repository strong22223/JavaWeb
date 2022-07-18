package com.Strong.web.Servlet;

import com.Strong.pojo.Brand;
import com.Strong.pojo.PageBean;
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

    /**
     * 查询所有
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        List<Brand> brands = brandService.selectAll();

        //准换为JSON
        String json = JSON.toJSONString(brands);
        //设置响应的中文字符
        response.setContentType("text/json;charset=utf-8");
        //发送数据
        response.getWriter().write(json);

    }

    /**
     * 添加数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        BufferedReader reader = request.getReader();
        String param = reader.readLine();
        //转换为Brand的对象
        Brand o = JSON.parseObject(param, Brand.class);
        //调用service来调价
        brandService.addBrand(o);
        //成功之后响应标识

        response.getWriter().write("success");
    }

    /**
     * 批量删除
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        BufferedReader reader = request.getReader();
        String param = reader.readLine();
        //转换为Brand的对象
        int[] ids = JSON.parseObject(param, int[].class);
        //调用service来调价
        brandService.deleteByIds(ids);
        //成功之后响应标识

        response.getWriter().write("success");
//        System.out.println("DELETE");
    }

    public void selectByPageSize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据,依据ajax一步请求来发送数据,并且在使用get的方式来发送
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        //2.调用service方法
        PageBean<Brand> pageBean = brandService.selectByPageSize(currentPage, pageSize);
//
//        System.out.println("1111111111");
//        System.out.println(pageBean);
        //准换为JSON
        String json = JSON.toJSONString(pageBean);
        //设置响应的中文字符
        response.setContentType("text/json;charset=utf-8");
        //发送数据
        response.getWriter().write(json);

    }

}
