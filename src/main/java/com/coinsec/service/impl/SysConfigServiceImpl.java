package com.coinsec.service.impl;

import com.coinsec.entity.SysConfig;
import com.coinsec.mapper.SysConfigMapper;
import com.coinsec.service.SysConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置表，存储系统级各项配置参数 服务实现类
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {

}
