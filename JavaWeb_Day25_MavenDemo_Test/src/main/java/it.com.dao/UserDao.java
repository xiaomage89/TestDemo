package it.com.dao;

import it.com.vo.User;

/**
 * @author majj
 * @create 2021-12-27 15:17
 */
public interface UserDao {

    public User findUser(String username);

    public void insertUser(User vo);


    User findByCode(String code);

    void updateStatus(User user);

    User findByUsernameAndPassword(String username, String password);
}
