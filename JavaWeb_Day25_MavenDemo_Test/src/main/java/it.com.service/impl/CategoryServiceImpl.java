package it.com.service.impl;

import it.com.dao.CategoryDao;
import it.com.dao.RouteImgDao;
import it.com.dao.SellerDao;
import it.com.dao.impl.CategoryDaoImpl;
import it.com.dao.impl.RouteImgDaoImpl;
import it.com.dao.impl.SellerDaoImpl;
import it.com.service.CategoryService;
import it.com.util.JedisUtil;
import it.com.vo.PageBean;
import it.com.vo.Route;
import it.com.vo.RouteImg;
import it.com.vo.Seller;
import it.com.vo.Category;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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
        //1.从redis中查询
        //1.1获取jedis客户端
        Jedis jedis = JedisUtil.getJedis();

        //1.2可使用sortedset排序查询
        //Set<String> categorys = jedis.zrange("category", 0, -1);
        //1.3查询sortedset中的分数(cid)和值(cname)
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);
        List<Category> cs = null;
        //2.判断查询的集合是否为空
        if (categorys == null || categorys.size() == 0) {
            cs = dao.findAll();

            //3.2 将集合数据存储到redis中的 category的key
            for (int i = 0; i < cs.size(); i++) {

                jedis.zadd("category", cs.get(i).getCid(), cs.get(i).getCname());
            }
        }else {
            System.out.println("从redis中查询.....");

            //4.如果不为空,将set的数据存入list
            cs = new ArrayList<Category>();
            for (Tuple tuple : categorys) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int)tuple.getScore());
                cs.add(category);

            }
        }

        return cs;
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
