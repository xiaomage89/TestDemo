package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 */
public class AccountServiceTest2 {

    @Autowired
    private  IAccountService as;

    @Test
    public void testFindAll() {
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService)applicationContext.getBean("accountService");
        //3.执行方法
        List<Account> accounts = accountService.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
        System.out.println(as);
        System.out.println(accountService);
        if(as==accountService){
            System.out.println(true);
        }
    }

}
