package it.com.service;

import it.com.vo.User;

/**
 * @author majj
 * @create 2021-12-27 15:07
 */
public interface UserService {
    public User findUser(String username);

    public Boolean insertUser(User vo);

    public boolean active(String code);

    User login(User user);
}
