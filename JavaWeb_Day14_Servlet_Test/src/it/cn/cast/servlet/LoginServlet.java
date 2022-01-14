package it.cn.cast.servlet;

import it.cn.cast.dao.LonginDao;
import it.cn.cast.vo.UserVo;
import org.apache.commons.beanutils.BeanUtils;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author majj
 * @create 2021-12-06 16:12
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        req.setCharacterEncoding("utf-8");
        //方法一
        // String username = req.getParameter("username");
        // String password = req.getParameter("password");
        // UserVo userVo = new UserVo();
        // userVo.setUsername(username);
        // userVo.setPassword(password);

        // 方法二
        Map<String, String[]> map = req.getParameterMap();
        UserVo userVo = new UserVo();
        try {
            BeanUtils.populate(userVo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        LonginDao dao = new LonginDao();
        UserVo vo = dao.onLogin(userVo);
        if (vo==null){
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else{
            req.setAttribute("user",vo);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
