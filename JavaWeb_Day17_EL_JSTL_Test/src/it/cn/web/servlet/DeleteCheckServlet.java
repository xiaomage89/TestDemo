package it.cn.web.servlet;

import it.cn.service.UserSelectService;
import it.cn.service.impl.UserSelectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author majj
 * @create 2021-12-17 21:26
 */
@WebServlet("/deleteCheckServlet")
public class DeleteCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] uCBS = req.getParameterValues("uCB");
        UserSelectService service = new UserSelectServiceImpl();
        for (String uid : uCBS){
            service.deleteUser(uid);
        }

        resp.sendRedirect(req.getContextPath()+"/userSelect");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
