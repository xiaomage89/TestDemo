package nc.com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import nc.com.dto.GoodstableDto;
import nc.com.service.LoginAdminService;

@WebServlet(name="admin/adminAddGoods",urlPatterns="/admin/adminAddGoods")
@MultipartConfig(maxFileSize=10*1024*1024) //�ļ��ϴ�
public class AdminAddGoodsServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GoodstableDto dto = new GoodstableDto();
		String goodname = req.getParameter("goodname");
		Double goodoldprice = Double.parseDouble(req.getParameter("goodoldprice"));
		Double goodnewprice = Double.parseDouble(req.getParameter("goodnewprice"));
		int goodstore = Integer.parseInt(req.getParameter("goodstore"));
		String goodstypeId = req.getParameter("typeid");
		//ͼƬ
		Part part = req.getPart("goodimg");
		//ָ���ϴ�·��
		String path = null;
		File uploadDir = new File(getServletContext().getRealPath("uploadImg"));
		if(!uploadDir.exists()){
			uploadDir.mkdir();
		}
		String act = req.getParameter("act");
		if(act.equals("add")){
			String format = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			String oldName = part.getSubmittedFileName();
			path = uploadDir+File.separator+format+oldName;
			part.write(path);
		}
		

		dto.setGoodname(goodname);
		dto.setGoodoldprice(goodoldprice);
		dto.setGoodnewprice(goodnewprice);
		dto.setGoodstore(goodstore);
		dto.setGoodstypeId(goodstypeId);
		dto.setGoodimg(path);
		
		//�����Ʒ
		LoginAdminService loginAdminService = new LoginAdminService();
		loginAdminService.insertGoods(dto);
		
		resp.sendRedirect("addGoods.jsp");
	}
}
