package com.kody.coinsec.service.sys.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kody.coinsec.entity.sys.SysUser;
import com.kody.coinsec.exception.SysException;
import com.kody.coinsec.mapper.sys.SysUserMapper;
import com.kody.coinsec.service.sys.SysUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Log4j2
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	/**
	 * 注册
	 *
	 * @param sysUser 系统用户
	 * @return 是否创建成功
	 */
	@Override
	public boolean register(SysUser sysUser) {
		if (save(sysUser)) {
			log.info("创建用户{}成功", sysUser.getUserName());
			return true;
		} else {
			log.error("创建用户失败");
			throw new SysException("创建用户失败");
		}
	}

	/**
	 * 登录
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @return 是否登录成功
	 */
	@Override
	public SysUser login(String username, String password) {
		LambdaQueryWrapper<SysUser> query = new LambdaQueryWrapper<SysUser>();
		query.eq(SysUser::getUserName, username)
				.eq(SysUser::getPassword, password);
		SysUser sysUserInfo = getOne(query);
		if (sysUserInfo != null) {
			log.info("用户{}登录成功", username);
			return sysUserInfo;
		} else {
			log.error("用户{}登录失败", username);
			throw new SysException("用户名或密码错误");
		}
	}

	/**
	 * 根据用户ID获取角色
	 *
	 * @param userId 用户ID
	 * @return 角色
	 */
	@Override
	public String getRoleByUserId(Long userId) {
		SysUser sysUserInfo = getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getId, userId));
		if (sysUserInfo != null) {
			return sysUserInfo.getRole();
		} else {
			throw new SysException("用户不存在");
		}
	}
}
