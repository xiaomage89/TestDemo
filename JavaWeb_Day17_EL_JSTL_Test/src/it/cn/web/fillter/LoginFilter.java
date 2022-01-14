package it.cn.web.fillter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet")
                || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")  ){
            chain.doFilter(req,resp);
        }else{
            Object username = request.getSession().getAttribute("user");
            if (username != null){
                chain.doFilter(req,resp);
            }else{
                req.setAttribute("login_msg","请先登录！");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
