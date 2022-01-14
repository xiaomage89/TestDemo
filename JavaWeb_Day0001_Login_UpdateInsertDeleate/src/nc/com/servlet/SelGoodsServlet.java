package nc.com.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nc.com.service.SelGoodsService;

//href="admin/selGoods.jsp?act=sel 不需要写WebServlet ，回显自身
@WebServlet(name="selGoodsServlet",urlPatterns="/selGoodsServlet")
public class SelGoodsServlet extends HttpServlet{

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
		SelGoodsService service = new SelGoodsService();
		List<Map<String, Object>> list=null;
		//动作类型
		String act = req.getParameter("act");
		//参数
		String goodname = req.getParameter("goodname");
		String goodstypeId = req.getParameter("goodstypeId");
		
		//条件查询
		if(act.equals("condiction")){
			 list = service.condictionSelectGoods(goodname,goodstypeId);
		}else{
			 list = service.selectGoods();
		}
		
		//分页查询
		int totalCount = 0;
		int totalPage = 0;
		int pageCur = 0;
		
		totalCount= list.size();
		req.setAttribute("totalCount", totalCount);
		if(totalCount != 0){
			totalPage = (int) Math.ceil(((double)totalCount / 10));
		}
		
		String pageCurOld=req.getParameter("pageCur");
		if(pageCurOld == null){
			pageCurOld = "1";
		}
		pageCur = Integer.parseInt(pageCurOld);
		if((pageCur-1)*10>totalCount){
			pageCur=pageCur-1;
		}
		
		//起始位置
		int startindex = (pageCur-1)*10;
		int pageCount = 10;
		//条件查询
		if(act.equals("condiction")){
			 list = service.condictionSelectGoodsByPage(goodname,goodstypeId,startindex,pageCount);
		}else{
			 list = service.selectGoodsByPage(startindex,pageCount);
		}
		
		//回显信息
		req.setAttribute("goodname", goodname);
		req.setAttribute("act", act);
		req.setAttribute("goodstypeId", goodstypeId);
		req.setAttribute("allGoods", list);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("pageCur", pageCur);
		RequestDispatcher dispatcher  = null;
		if("sel".equals(act)||"condiction".equals(act)){
			dispatcher = req.getRequestDispatcher("admin/selGoods.jsp");
			dispatcher.forward(req, resp);
		}else if("del".equals(act)){
			dispatcher = req.getRequestDispatcher("admin/delGoods.jsp");
			dispatcher.forward(req, resp);
		}else if ("upd".equals(act)){
			dispatcher = req.getRequestDispatcher("admin/updGoods.jsp");
			dispatcher.forward(req, resp);
		}else if ("main".equals(act)){
			dispatcher = req.getRequestDispatcher("admin/selGoods.jsp");
			dispatcher.forward(req, resp);
		}
		
	}

}
