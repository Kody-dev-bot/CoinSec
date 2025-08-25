package com.kody.coinsec.service.account.impl;

import com.kody.coinsec.entity.account.AccountTransaction;
import com.kody.coinsec.mapper.account.AccountTransactionMapper;
import com.kody.coinsec.service.account.AccountTransactionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账户余额变动表 服务实现类
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Service
public class AccountTransactionServiceImpl extends ServiceImpl<AccountTransactionMapper, AccountTransaction> implements AccountTransactionService {

}
