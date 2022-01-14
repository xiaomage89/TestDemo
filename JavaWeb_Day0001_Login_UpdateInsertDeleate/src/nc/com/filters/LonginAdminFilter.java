package nc.com.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LonginAdminFilter implements Filter{

	private static String[] pathsArray;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chan)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        
        if(null != session.getAttribute("login")){
        	chan.doFilter(req, resp);
        	return;
        }

        
        for(String jspName:pathsArray){
        	if(jspName.startsWith(request.getServletPath())){
        		chan.doFilter(req, resp);
        		return;
        	}
        }
 
        PrintWriter out = response.getWriter();
//      out.print("<script language='javascript'>alert('Please login first! ÇëÏÈµÇÂ¼£¡');window.location.href='index.jsp';</script>");
        out.print("ÇëÏÈµÇÂ¼£¡£¡");
//        out.flush();
//        out.close();
        String contextPath = request.getContextPath();
        response.setHeader("refresh","3;url="+contextPath +"/loginAdmin.jsp");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String initParameter = config.getInitParameter("logo");
		pathsArray=initParameter==null? null:initParameter.split(";");
	}

}
