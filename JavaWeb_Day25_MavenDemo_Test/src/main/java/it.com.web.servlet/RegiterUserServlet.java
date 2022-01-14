package it.com.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
import it.com.service.UserService;
import it.com.service.impl.UserServiceImpl;
import it.com.vo.ResultInfo;
import it.com.vo.User;
import org.apache.commons.beanutils.BeanUtils;

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
 * @create 2021-12-26 16:18
 */
@WebServlet("/regiterUserServlet")
public class RegiterUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        //验证码错误
        ResultInfo info = new ResultInfo();
        // 验证校验
        String check = request.getParameter("check");
        String checkcode = (String)request.getSession().getAttribute("checkcode_service");
        request.getSession().removeAttribute("checkcode_service");
        if (checkcode == null || !checkcode.equalsIgnoreCase(check)){
            info.setFlag(false);
            info.setErrorMsg("验证码错误");

            //将info对象序列化为json
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }

        //1.获取数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.调用service完成注册
        UserService userService = new UserServiceImpl();
        User vo = userService.findUser(user.getUsername());
        if (vo!=null){
            info.setFlag(false);
            info.setErrorMsg("用户名重复");

            //将info对象序列化为json
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }

        Boolean flag = userService.insertUser(user);
        if (flag){
            info.setFlag(true);
            info.setErrorMsg("注册成功");
        }else {
            info.setFlag(false);
            info.setErrorMsg("注册失败");
        }

        //将info对象序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
