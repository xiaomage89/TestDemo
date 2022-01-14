package it.cn.service.impl;

import it.cn.dao.UserSelectDao;
import it.cn.dao.impl.UserSelectDaoImpl;
import it.cn.service.UserSelectService;
import it.cn.vo.PageBean;
import it.cn.vo.UserVo;

import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

/**
 * @author majj
 * @create 2021-12-08 21:07
 */
public class UserSelectServiceImpl implements UserSelectService {
    @Override
    public List<UserVo> findAll() {
        UserSelectDao dao = new UserSelectDaoImpl();
        List<UserVo> users = dao.findAll();
        return users;
    }

    @Override
    public UserVo onLogin(UserVo vo) {
        UserSelectDao dao = new UserSelectDaoImpl();
        UserVo user = dao.onLogin(vo);
        return user;
    }

    @Override
    public UserVo findUser(String pk) {
        UserSelectDao dao = new UserSelectDaoImpl();
        UserVo vo = dao.findUser(pk);
        return vo;
    }

    @Override
    public void updateUser(UserVo vo) {
        UserSelectDao dao = new UserSelectDaoImpl();
        dao.updateUser(vo);
    }

    @Override
    public void deleteUser(String pk) {
        UserSelectDao dao = new UserSelectDaoImpl();
        dao.deleteUser(pk);
    }



    @Override
    public PageBean<UserVo> findUserByPage(String _currentPage, String _rows, Map<String, String[]> map) {

        UserSelectDao dao = new UserSelectDaoImpl();

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //1.创建空的PageBean对象
        PageBean<UserVo> pb = new PageBean<UserVo>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //3.调用dao查询总记录数
        int totalCount = dao.findTotalCount(map);
        pb.setTotalCount(totalCount);
        if(totalCount%rows==0){
            pb.setTotalPage(totalCount/rows);
        }else{
            pb.setTotalPage(totalCount/rows + 1);
        }


        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<UserVo> list = dao.findUserByPage(start,rows,map);
        pb.setList(list);

        return pb;
    }

    @Override
    public void addUser(UserVo vo) {
        UserSelectDao dao = new UserSelectDaoImpl();
        dao.addUser(vo);
    }
}
