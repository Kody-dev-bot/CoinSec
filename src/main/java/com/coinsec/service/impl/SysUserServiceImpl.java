package com.coinsec.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinsec.entity.SysUser;
import com.coinsec.mapper.SysUserMapper;
import com.coinsec.service.SysUserService;
import jakarta.annotation.Resource;
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

	/**
	 * 用户Mapper
	 */
	@Resource
	private SysUserMapper sysAdminMapper;

	/**
	 * 判断用户名是否存在
	 *
	 * @param userName 用户名
	 * @param role     角色
	 * @return 存在返回true，不存在返回false
	 */
	@Override
	public boolean existsAdmin(String userName, String role) {
		return sysAdminMapper.countByUserNameAndRole(userName, role) > 0;
	}
}
