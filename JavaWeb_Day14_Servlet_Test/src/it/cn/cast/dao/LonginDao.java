package it.cn.cast.dao;

import it.cn.cast.utils.JDBCUtils;
import it.cn.cast.vo.UserVo;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

/**
 * @author majj
 * @create 2021-12-06 13:18
 */
public class LonginDao {

     private JdbcTemplate jdbcTemplate =  new JdbcTemplate(JDBCUtils.getDataSource());

      public UserVo onLogin(UserVo userVo){
          String sql = "select * from test_user where username = ? and password = ?";
          try {
              userVo = jdbcTemplate.queryForObject(sql,
                      new BeanPropertyRowMapper<UserVo>(UserVo.class),
                      userVo.getUsername(), userVo.getPassword());
              return userVo;
          }catch (Exception e){
              e.printStackTrace();
              return null;
          }


      }
}
