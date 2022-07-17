package tem;

import com.Strong.pojo.User;
import com.Strong.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取jsp页面传过来的数据源
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取用户提交的验证码
        String checkCode = request.getParameter("checkCode");


        //封装为一个对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        if (!checkCodeGen.equalsIgnoreCase(checkCode)) {
            request.setAttribute("register_msg", "验证码错误");
            request.getRequestDispatcher("/register.html.jsp").forward(request, response);

            return;
        }

        //调用service方法
        boolean add = service.add(user);

        //判断是否为空
        if (add == true) {
            //注册成功,跳转到登录页面
            request.setAttribute("register_msg", "注册成功,请登录!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            //注册失败,跳转到登录页面
            request.setAttribute("register_msg", "注册失败，用户名已经存在!");
            request.getRequestDispatcher("/register.html.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
