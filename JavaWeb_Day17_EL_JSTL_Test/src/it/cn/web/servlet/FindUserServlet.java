package it.cn.web.servlet;

import it.cn.service.UserSelectService;
import it.cn.service.impl.UserSelectServiceImpl;
import it.cn.vo.UserVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author majj
 * @create 2021-12-17 16:29
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserSelectService service = new UserSelectServiceImpl();
        UserVo vo = service.findUser(id);
        req.setAttribute("user",vo);
        req.getRequestDispatcher("/update.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
