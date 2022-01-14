package nc.com.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nc.com.util.VerifyCode;

@WebServlet("/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet{

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        //��������
        VerifyCode vc = new VerifyCode();
        //��ȡͼƬ����
        BufferedImage bi = vc.getImage();
        //���ͼƬ���ı�����
        String text = vc.getText();
        // ��ϵͳ���ɵ��ı����ݱ��浽session��
        request.getSession().setAttribute("text", text);
        //����������ͼƬ
        vc.output(bi, response.getOutputStream());
	}

	
}
