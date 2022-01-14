package it.com.dao;

import it.com.vo.Category;
import it.com.vo.PageBean;
import it.com.vo.Route;

import java.util.List;

/**
 * @author majj
 * @create 2022-01-13 11:24
 */
public interface CategoryDao {
    public List<Category> findAll();
    /**
     * 根据cid查询总记录数
     */
    public int findTotalCount(int cid,String rname);

    /**
     * 根据cid，start,pageSize查询当前页的数据集合
     */
    public List<Route> findByPage(int cid , int start , int pageSize,String rname);

    /**
     * 根据id查询
     * @param rid
     * @return
     */
    public Route findOne(int rid);
}
