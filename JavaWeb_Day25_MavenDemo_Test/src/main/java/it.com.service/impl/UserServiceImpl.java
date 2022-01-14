package it.com.service.impl;

import it.com.dao.UserDao;
import it.com.dao.impl.UserDaoImpl;
import it.com.service.UserService;
import it.com.util.MailUtils;
import it.com.util.UuidUtil;
import it.com.vo.User;

/**
 * @author majj
 * @create 2021-12-27 15:07
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User findUser(String username) {
        User user = userDao.findUser(username);
        return user;
    }

    @Override
    public Boolean insertUser(User user) {
        //2.保存用户信息
        //2.1设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //2.2设置激活状态
        user.setStatus("N");

        userDao.insertUser(user);

        //3.激活邮件发送，邮件正文？

        String content="<a href='http://localhost/day25/activeUserServlet?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>";

        MailUtils.sendMail(user.getEmail(),content,"激活邮件");

        return true;
    }

    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = userDao.findByCode(code);
        if(user != null){
            //2.调用dao的修改激活状态的方法
            userDao.updateStatus(user);
            return true;
        }else{
            return false;
        }
    }

    /**
     * 登录方法
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
