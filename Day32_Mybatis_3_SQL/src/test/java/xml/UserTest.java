package xml;


import it.dao.IUserDao;
import it.vo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author majj
 * @create 2022-01-15 23:15
 */
public class UserTest {

    private  InputStream stream;
    private  SqlSession session;
    private  IUserDao dao;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建 SqlSessionFactory 的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象 SqlSessionFactory
        SqlSessionFactory factory = builder.build(stream);
        //4.使用 SqlSessionFactory 生产 SqlSession 对象
        session = factory.openSession();
        //5.使用 SqlSession 创建 dao 接口的代理对象
        dao = session.getMapper(IUserDao.class);
    }

    @After
    public void detory() throws IOException {
        //7.释放资源
        session.close();
        stream.close();
    }

    @Test
    public void findAll(){
        //6.使用代理对象执行查询所有方法
        List<User> list = dao.findAll();
        for (User user : list){
            System.out.println(user.toString());
        }
    }

    @Test
    public  void findByString(){
        List<User> list = dao.findByString("老王");
        for (User vo : list){
            System.out.println(vo.toString());
        }
        System.out.println("=====================");
        list = dao.findByString(null);
        for (User vo : list){
            System.out.println(vo.toString());
        }
    }

    @Test
    public  void findByName(){
        //6.使用代理对象执行查询所有方法
        User user = new User();
        user.setUsername("老王");
        List<User> list = dao.findByName(user);
        for (User vo : list){
            System.out.println(vo.toString());
        }
    }

    @Test
    public  void findByLikeName(){
        //6.使用代理对象执行查询所有方法
        User user = new User();
        user.setUsername("%王%");
        List<User> list = dao.findByLikeName(user);
        for (User vo : list){
            System.out.println(vo.toString());
        }
    }


    /**
     * 一对一的关系映射
     * return User{id=41, username='老王', birthday=Wed Feb 28 01:47:08 CST 2018, sex='男', address='null'}
     * [Role{roleId=1, roleName='院长', roleDesc='null'}, Role{roleId=2, roleName='总裁', roleDesc='null'}]
     * User{id=42, username='小二王', birthday=Fri Mar 02 23:09:37 CST 2018, sex='女', address='null'}
     * []
     */
    @Test
    public  void findManytoMany(){
        List<User> list = dao.findManytoMany();
        for (User vo : list){
            System.out.println(vo.toString());
            System.out.println(vo.getRole());
        }
    }
}
