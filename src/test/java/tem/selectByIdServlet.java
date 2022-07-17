package tem;

import com.Strong.pojo.Brand;
import com.Strong.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/selectByIdServlet")
public class selectByIdServlet extends HttpServlet {
    private BrandServiceImpl service = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收id
        String id = request.getParameter("id");

        //查询数据
        Brand brand = service.selectById(Integer.parseInt(id));

        request .setAttribute("brand" ,brand);

        request.getRequestDispatcher("/update.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
