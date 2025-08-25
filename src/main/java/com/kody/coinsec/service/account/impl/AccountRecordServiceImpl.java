package com.kody.coinsec.service.account.impl;

import com.kody.coinsec.entity.account.AccountRecord;
import com.kody.coinsec.mapper.account.AccountRecordMapper;
import com.kody.coinsec.service.account.AccountRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 记账记录表 服务实现类
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Service
public class AccountRecordServiceImpl extends ServiceImpl<AccountRecordMapper, AccountRecord> implements AccountRecordService {

}
