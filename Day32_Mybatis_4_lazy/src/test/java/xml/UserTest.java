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

    /**
     * /实现懒加载 延迟加载
     */
    @Test
    public void findAll(){
        //6.使用代理对象执行查询所有方法
        List<User> list = dao.findAll();

        //实现懒加载 延迟加载
        // for (User user : list){
        //     System.out.println(user);
        //     System.out.println(user.getAccounts());
        // }
    }


}
