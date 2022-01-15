package cm.it.xml;

import cm.it.dao.IUserDao;
import cm.it.vo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author majj
 * @create 2022-01-15 23:15
 */
public class MybatisTestXml {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建 SqlSessionFactory 的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象 SqlSessionFactory
        SqlSessionFactory factory = builder.build(stream);
        //4.使用 SqlSessionFactory 生产 SqlSession 对象
        SqlSession session = factory.openSession();
        //5.使用 SqlSession 创建 dao 接口的代理对象
        IUserDao dao = session.getMapper(IUserDao.class);
        //6.使用代理对象执行查询所有方法
        List<User> list = dao.findAll();
        for (User user : list){
            System.out.println(user.toString());
        }
        //7.释放资源
        session.close();
        stream.close();
    }
}
