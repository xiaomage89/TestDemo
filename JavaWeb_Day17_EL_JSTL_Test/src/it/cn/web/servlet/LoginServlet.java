package it.cn.web.servlet;

import it.cn.service.UserSelectService;
import it.cn.service.impl.UserSelectServiceImpl;
import it.cn.vo.UserVo;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author majj
 * @create 2021-12-09 23:20
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String verifycode = req.getParameter("verifycode");
        System.out.println(verifycode);

        HttpSession session = req.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
        if(!verifycode.equalsIgnoreCase(checkcode_server)){
            req.setAttribute("login_msg","验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

        UserVo vo = new UserVo();
        Map<String, String[]> parameterMap = req.getParameterMap();
        try {
            BeanUtils.populate(vo,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserSelectService service = new UserSelectServiceImpl();
        vo = service.onLogin(vo);
        if(vo != null){
            //登录成功
            //登录成功
            //将用户存入session
            session.setAttribute("user",vo);
            //跳转页面
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }else{
            //登录失败
            //提示信息
            req.setAttribute("login_msg","用户名或密码错误！");
            //跳转登录页面
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
