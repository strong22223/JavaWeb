package tem;

import com.Strong.pojo.Brand;
import com.Strong.service.impl.BrandServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(value = "/selectAllServlet11")
public class selectAllServlet extends HttpServlet {
    private BrandServiceImpl service = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        //1.调用BrandService 完成查询
//        List<Brand> brands = service.selectAll();
//
//        //2.存入到request的数据域中
//        //request.setAttribute("brands",brands);
//        //请求转发
//        request.getRequestDispatcher("/brand.jsp").forward(request,response);

        /**
         * JSON
         *
         */
        //1.首先调用service方法来获取数据
        List<Brand> brands = service.selectAll();
        //2.将对象转换为JSON 数据  序列化
        String jsonString = JSON.toJSONString(brands);
        //响应数据
        response.setContentType("text/json;charset=utf-8");

        response.getWriter().write(jsonString);
        System.out.println("JSON");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
