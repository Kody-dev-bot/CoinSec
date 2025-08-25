package com.kody.coinsec.service.account.impl;

import com.kody.coinsec.entity.account.Account;
import com.kody.coinsec.mapper.account.AccountMapper;
import com.kody.coinsec.service.account.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账户表 服务实现类
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
