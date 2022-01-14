package it.cn.dao;

import it.cn.vo.PageBean;
import it.cn.vo.UserVo;

import java.util.List;
import java.util.Map;

/**
 * @author majj
 * @create 2021-12-08 21:06
 */
public interface UserSelectDao {
    public List<UserVo> findAll();
    public UserVo onLogin(UserVo vo);
    public  UserVo findUser(String pk);
    public void updateUser(UserVo vo);
    public  void deleteUser(String pk);
    public List<UserVo> findUserByPage(int start, int rows, Map<String,String[]> map);
    public int findTotalCount(Map<String,String[]> map);
    public  void addUser(UserVo user );
}
