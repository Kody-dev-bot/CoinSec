package com.coinsec.service.impl;

import com.coinsec.entity.SysUser;
import com.coinsec.mapper.SysUserMapper;
import com.coinsec.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表，存储用户登录及基本信息 服务实现类
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
