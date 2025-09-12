package com.coinsec.record.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinsec.record.entity.AccountRecord;
import com.coinsec.record.mapper.AccountRecordMapper;
import com.coinsec.record.service.AccountRecordService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 记账记录表（版本一核心） 服务实现类
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
@Service
public class AccountRecordServiceImpl extends ServiceImpl<AccountRecordMapper, AccountRecord> implements AccountRecordService {

}
