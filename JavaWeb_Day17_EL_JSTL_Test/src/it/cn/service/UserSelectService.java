package it.cn.service;

import it.cn.vo.PageBean;
import it.cn.vo.UserVo;

import java.util.List;
import java.util.Map;

/**
 * @author majj
 * @create 2021-12-08 21:07
 */
public interface UserSelectService {
    public List<UserVo> findAll();
    public UserVo onLogin(UserVo vo);
    public  UserVo findUser(String pk);
    public void updateUser(UserVo vo);
    public  void deleteUser(String pk);
    public PageBean<UserVo> findUserByPage(String currentPage, String rows, Map<String,String[]>map);
    public  void addUser(UserVo user );
}
