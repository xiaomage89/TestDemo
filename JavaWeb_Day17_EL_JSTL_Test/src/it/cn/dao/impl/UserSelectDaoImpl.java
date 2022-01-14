package it.cn.dao.impl;

import it.cn.dao.UserSelectDao;
import it.cn.util.JDBCUtils;
import it.cn.vo.PageBean;
import it.cn.vo.UserVo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author majj
 * @create 2021-12-08 21:06
 */
public class UserSelectDaoImpl implements UserSelectDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<UserVo> findAll() {
        String sql = "select * from day17_user";
        List<UserVo> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserVo>(UserVo.class));
        return users;
    }

    @Override
    public UserVo onLogin(UserVo vo) {
        String sql = "select * from test_user where username=? and password=?";
        UserVo userVo = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<UserVo>(UserVo.class), vo.getUsername(), vo.getPassword());
        return userVo;
    }

    @Override
    public UserVo findUser(String pk) {
        String sql = "select * from day17_user where id=?";
        UserVo vo = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<UserVo>(UserVo.class), pk);
        return vo;
    }

    @Override
    public void updateUser(UserVo vo) {
        String sql = "update day17_user set name=?,gender=?,age=?,address=?,qq=?,email=? where id = ? ";
        jdbcTemplate.update(sql,vo.getName(),vo.getGender(),vo.getAge(),vo.getAddress(),vo.getQq(),vo.getEmail(),vo.getId());
    }

    @Override
    public void deleteUser(String pk) {
        String sql = "delete from day17_user  where id = ? ";
        jdbcTemplate.update(sql,pk);
    }

    @Override
    public void addUser(UserVo user) {
        //1.定义sql
        String sql = "insert into day17_user values(null,?,?,?,?,?,?)";
        //2.执行sql
        jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());

    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql = "select count(*) from day17_user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);

        return jdbcTemplate.queryForObject(sb.toString(),Integer.class,params.toArray());
    }




    @Override
    public List<UserVo>  findUserByPage(int start, int rows, Map<String, String[]> map) {
        StringBuilder sql = new StringBuilder("select * from day17_user where 1=1 ");
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        Set<String> keySet = map.keySet();
        for (String key : keySet){
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = map.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)) {
                sql.append(" and " + key + " like ?");
                params.add("%" + value + "%");
            }
        }
        //添加分页查询
        sql.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);

        System.out.println(sql);
        System.out.println(params);

        return jdbcTemplate.query(sql.toString(),new BeanPropertyRowMapper<UserVo>(UserVo.class),params.toArray());
    }
}
