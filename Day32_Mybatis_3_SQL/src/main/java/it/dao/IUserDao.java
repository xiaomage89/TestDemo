package it.dao;

import it.vo.User;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();

    List<User> findByString(String user);

    List<User> findByName(User user);

    List<User> findByLikeName(User user);

    List<User> findManytoMany();

}
