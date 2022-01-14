package it.com.dao.impl;

import it.com.dao.CategoryDao;
import it.com.util.JDBCUtils;
import it.com.vo.Category;
import it.com.vo.Route;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author majj
 * @create 2022-01-13 11:25
 */
public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll() {
        String sql = " select * from tab_category order by cid  ";
        List<Category> list = template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
        return list;
    }

    @Override
    public int findTotalCount(int cid,String rname) {
        List params = new ArrayList();//条件们
        String sql = "select count(*) from tab_route where cid = ?";
        params.add(cid);
        if (!StringUtils.isEmpty(rname)){
            sql += " and rname like ? ";
            params.add("%"+rname+"%");
        }
        return template.queryForObject(sql,Integer.class,params.toArray());
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize,String rname) {
        List params = new ArrayList();//条件们
        String sql = "select * from tab_route where cid = ? ";
        params.add(cid);
        if (!StringUtils.isEmpty(rname)){
            sql += " and rname like ? ";
            params.add("%"+rname+"%");
        }
        sql += "  limit ? , ? ";
        params.add(start);
        params.add(pageSize);
        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
    }

    @Override
    public Route findOne(int rid) {
        String sql = "select * from tab_route where rid = ?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Route>(Route.class),rid);
    }
}
