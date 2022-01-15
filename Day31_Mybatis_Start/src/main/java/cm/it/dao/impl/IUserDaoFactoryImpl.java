package cm.it.dao.impl;

import cm.it.dao.IUserFactoryDao;
import cm.it.vo.UserFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * 用户的持久层接口
 */
public class IUserDaoFactoryImpl implements IUserFactoryDao {

    private SqlSessionFactory factory;

    public IUserDaoFactoryImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<UserFactory> findAll() {
        SqlSession session = factory.openSession();
        List<UserFactory> objects = session.selectList("cm.it.dao.IUserFactoryDao.findAll");
        return objects;
    }
}
