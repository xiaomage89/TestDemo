package it.com.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.com.service.CategoryService;
import it.com.service.FavoriteService;
import it.com.service.impl.CategoryServiceImpl;
import it.com.service.impl.FavoriteServiceImpl;
import it.com.vo.Category;
import it.com.vo.PageBean;
import it.com.vo.Route;
import it.com.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author majj
 * @create 2022-01-13 11:09
 */
@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    private  CategoryService service = new CategoryServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();

    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<Category> list = service.findAll();

        //直接将传入的对象序列化为json，并且写回客户端
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json:charset=utf-8");
        mapper.writeValue(resp.getOutputStream(),list);
    }

    public void findPageRoute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String cid_s = req.getParameter("cid");
        String currentPage_s = req.getParameter("currentPage");
        String pageSize_s = req.getParameter("pageSize");
        //接受rname 线路名称
        String rname = req.getParameter("rname");
        if("null".equals(rname)  ){
            rname = "";
        }
        rname = new String(rname.getBytes("iso-8859-1"),"utf-8");

        int cid = 1;
        if(cid_s != null && cid_s.length() > 0 && !"null".equals(cid_s)){
            cid = Integer.parseInt(cid_s);
        }

        int currentPage = 1;
        if(currentPage_s != null && currentPage_s.length() > 0){
            currentPage = Integer.parseInt(currentPage_s);
        }

        int pageSize = 5;
        if(pageSize_s != null && pageSize_s.length() > 0){
            pageSize = Integer.parseInt(pageSize_s);
        }


        //3. 调用service查询PageBean对象
        PageBean<Route> pb = service.findPageRoute(cid, currentPage, pageSize,rname);

        writeValue(pb,resp);

    }

    /**
     * 根据id查询一个旅游线路的详细信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.接收id
        String rid = request.getParameter("rid");
        //2.调用service查询route对象
        Route route = service.findOne(rid);
        //3.转为json写回客户端
        writeValue(route,response);
    }

    public void favoriteCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 获取线路id
        String rid = request.getParameter("rid");

        //3. 调用FavoriteService查询是否收藏
        int favoriteCount = favoriteService.favoriteCount(rid);

        //4. 写回客户端
        writeValue(favoriteCount,response);
    }

    /**
     * 判断当前登录用户是否收藏过该线路
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取线路id
        String rid = request.getParameter("rid");

        //2. 获取当前登录的用户 user
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户id
        if(user == null){
            //用户尚未登录
            uid = 0;
        }else{
            //用户已经登录
            uid = user.getUid();
        }

        //3. 调用FavoriteService查询是否收藏
        boolean flag = favoriteService.isFavorite(rid, uid);

        //4. 写回客户端
        writeValue(flag,response);
    }

    /**
     * 添加收藏
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取线路rid
        String rid = request.getParameter("rid");
        //2. 获取当前登录的用户
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户id
        if(user == null){
            //用户尚未登录
            return ;
        }else{
            //用户已经登录
            uid = user.getUid();
        }


        //3. 调用service添加
        favoriteService.add(rid,uid);

    }
}
