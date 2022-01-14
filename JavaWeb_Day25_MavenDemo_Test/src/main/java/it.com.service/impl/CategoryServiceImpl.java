package it.com.service.impl;

import it.com.dao.CategoryDao;
import it.com.dao.RouteImgDao;
import it.com.dao.SellerDao;
import it.com.dao.impl.CategoryDaoImpl;
import it.com.dao.impl.RouteImgDaoImpl;
import it.com.dao.impl.SellerDaoImpl;
import it.com.service.CategoryService;
import it.com.vo.PageBean;
import it.com.vo.Route;
import it.com.vo.RouteImg;
import it.com.vo.Seller;
import it.com.vo.Category;

import java.util.ArrayList;
import java.util.List;


/**
 * @author majj
 * @create 2022-01-13 11:23
 */
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao = new CategoryDaoImpl();

    private RouteImgDao routeImgDao = new RouteImgDaoImpl();

    private SellerDao sellerDao = new SellerDaoImpl();

    @Override
    public List<Category> findAll() {
        List<Category> list = dao.findAll();
        return list;
    }

    @Override
    public PageBean<Route> findPageRoute(int cid, int currentPage, int pageSize, String rname) {
        PageBean pageBean = new PageBean();
        List<Route> list = new ArrayList<Route>();

        // 总件数
        int totalCount = dao.findTotalCount(cid,rname);
        //显示数据
        int start = (currentPage-1)*pageSize;
        List<Route> page = dao.findByPage(cid, start, pageSize,rname);

        pageBean.setTotalCount(totalCount);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalPage(totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1);
        pageBean.setList(page);
        return pageBean;
    }


    @Override
    public Route findOne(String rid) {
        //1.根据id去route表中查询route对象
        Route route = dao.findOne(Integer.parseInt(rid));

        //2.根据route的id 查询图片集合信息
        List<RouteImg> routeImgList = routeImgDao.findByRid(route.getRid());
        //2.2将集合设置到route对象
        route.setRouteImgList(routeImgList);
        //3.根据route的sid（商家id）查询商家对象
        Seller seller = sellerDao.findById(route.getSid());
        route.setSeller(seller);

        return route;
    }
}
