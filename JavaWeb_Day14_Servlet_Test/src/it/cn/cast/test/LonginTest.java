package it.cn.cast.test;

import it.cn.cast.dao.LonginDao;
import it.cn.cast.vo.UserVo;
import org.junit.Test;

/**
 *
 */
public class LonginTest {

    @Test
    public void userdaoTest(){
        LonginDao longinDao = new LonginDao();
        UserVo vo = new UserVo();
        vo.setUsername("zhangsan");
        vo.setPassword("123");
        vo = longinDao.onLogin(vo);
        System.out.println(vo.toString());
    }
}