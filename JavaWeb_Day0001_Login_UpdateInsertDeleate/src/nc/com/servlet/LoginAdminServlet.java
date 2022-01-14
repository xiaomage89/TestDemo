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
	        �õ�ҳ�洫�������ֶ��������֤��, ����֤��Ҫ������ͼƬ�ϵ�
	        �ı���֤��Ƚ�, �����ͬ, ��֤������ɹ�!
	     */
	    String imageText = req.getParameter("image");
	    // ͼƬ����֤��
	    String text = (String) req.getSession().getAttribute("text");
	
	    if (!text.equalsIgnoreCase(imageText)) {
	    	req.setAttribute("imageMess", "��֤���������!");
	    	req.getRequestDispatcher("/loginAdmin.jsp").forward(req, resp);
	    }
		//��֤�û���¼
		//����Ϣ���浽ʵ��ģ����
		AdminDto dto = new AdminDto();
		dto.setUser(req.getParameter("user"));
		dto.setPassword(req.getParameter("password"));
		//ҵ���
		LoginAdminService service = new LoginAdminService();
		//��¼�ɹ�
		if(service.checkUser(dto)){
			HttpSession session = req.getSession();
			String username = req.getParameter("user");
			session.setAttribute("login", username);
			
			
			//��ѯ��Ʒ����
			LoginAdminService loginAdminService = new LoginAdminService();
			List<GoodstypeDto> list = loginAdminService.getGoodStype();
			req.getSession().setAttribute("goodstypeId", list);
			
			//��ת��̨����
			RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/main.jsp");
			dispatcher.forward(req, resp);
		}else{
	    	req.setAttribute("userMess", "�û����������������!");
	    	req.getRequestDispatcher("/loginAdmin.jsp").forward(req, resp);
		}

		
	}
}
