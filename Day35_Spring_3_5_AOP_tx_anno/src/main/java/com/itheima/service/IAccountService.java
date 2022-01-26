package com.itheima.service;

import com.itheima.domain.Account;

/**
 * 账户的业务层接口
 */
public interface IAccountService {

    /**
     * 转账
     * @param sourceName    转成账户名称
     * @param targetName    转入账户名称
     * @param money         转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
