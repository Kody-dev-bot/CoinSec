package com.kody.coinsec.service.impl;

import com.kody.coinsec.entity.Account;
import com.kody.coinsec.mapper.AccountMapper;
import com.kody.coinsec.service.AccountService;
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
