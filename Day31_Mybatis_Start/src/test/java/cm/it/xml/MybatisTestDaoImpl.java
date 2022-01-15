package cm.it.xml;

import cm.it.dao.IUserDao;
import cm.it.dao.IUserFactoryDao;
import cm.it.dao.impl.IUserDaoFactoryImpl;
import cm.it.vo.User;
import cm.it.vo.UserFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author majj
 * @create 2022-01-15 23:15
 */
public class MybatisTestDaoImpl {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂创建dao对象
        IUserFactoryDao userDao = new IUserDaoFactoryImpl(factory);
        //4.使用代理对象执行方法
        List<UserFactory> users = userDao.findAll();
        for(UserFactory user : users){
            System.out.println(user);
        }
        //5.释放资源
        in.close();
    }
}
