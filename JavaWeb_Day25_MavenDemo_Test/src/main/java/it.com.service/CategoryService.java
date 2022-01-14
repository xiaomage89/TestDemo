package it.com.service;

import it.com.vo.Category;
import it.com.vo.PageBean;
import it.com.vo.Route;

import java.util.List;

/**
 * @author majj
 * @create 2022-01-13 11:19
 */
public interface CategoryService {

    public List<Category> findAll();

    public PageBean<Route> findPageRoute(int cid,int currentPage,int pageSize,String rname);

    /**
     * 根据id查询
     * @param rid
     * @return
     */
    public Route findOne(String rid);
}
