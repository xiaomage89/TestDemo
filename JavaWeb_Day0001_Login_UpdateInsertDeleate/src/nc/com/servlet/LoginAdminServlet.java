package nc.com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nc.com.dto.AdminDto;
import nc.com.dto.GoodstypeDto;
import nc.com.service.LoginAdminService;

@WebServlet(name = "loginAdmin",urlPatterns="/loginAdmin")
public class LoginAdminServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   /*
	        拿到页面传过来的手动输入的验证码, 该验证码要和生成图片上的
	        文本验证码比较, 如果相同, 验证码输入成功!
	     */
	    String imageText = req.getParameter("image");
	    // 图片的验证码
	    String text = (String) req.getSession().getAttribute("text");
	
	    if (!text.equalsIgnoreCase(imageText)) {
	    	req.setAttribute("imageMess", "验证码输入错误!");
	    	req.getRequestDispatcher("/loginAdmin.jsp").forward(req, resp);
	    }
		//验证用户登录
		//将信息保存到实体模型中
		AdminDto dto = new AdminDto();
		dto.setUser(req.getParameter("user"));
		dto.setPassword(req.getParameter("password"));
		//业务层
		LoginAdminService service = new LoginAdminService();
		//登录成功
		if(service.checkUser(dto)){
			HttpSession session = req.getSession();
			String username = req.getParameter("user");
			session.setAttribute("login", username);
			
			
			//查询商品类型
			LoginAdminService loginAdminService = new LoginAdminService();
			List<GoodstypeDto> list = loginAdminService.getGoodStype();
			req.getSession().setAttribute("goodstypeId", list);
			
			//跳转后台界面
			RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/main.jsp");
			dispatcher.forward(req, resp);
		}else{
	    	req.setAttribute("userMess", "用户名或密码输入错误!");
	    	req.getRequestDispatcher("/loginAdmin.jsp").forward(req, resp);
		}

		
	}
}
