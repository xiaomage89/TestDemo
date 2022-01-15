package cm.it.dao;

import cm.it.vo.User;
import cm.it.vo.UserAnnotation;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * 用户的持久层接口
 */
public interface IUserDaoAnnotation {

    /**
     * 查询所有操作
     * @return
     */
    @Select("select * from user")
    List<UserAnnotation> findAll();
}
