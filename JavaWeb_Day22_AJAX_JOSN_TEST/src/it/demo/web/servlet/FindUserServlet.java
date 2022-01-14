package it.demo.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author majj
 * @create 2021-12-23 17:37
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        // resp.setContentType("application/json;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");

        Map<String, Object> map = new HashMap<>();
        if ("tom".equals(username)) {
            map.put("userExsit", true);
            map.put("msg", "此用户名太受欢迎,请更换一个");
        } else {
            //不存在
            map.put("userExsit", false);
            map.put("msg", "用户名可用");
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), map);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
