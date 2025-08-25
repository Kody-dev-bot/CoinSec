package com.kody.coinsec.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kody.coinsec.entity.sys.SysUser;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
public interface SysUserService extends IService<SysUser> {

	/**
	 * 注册
	 *
	 * @param sysUser 系统用户
	 * @return 是否创建成功
	 */
	boolean register(SysUser sysUser);

	/**
	 * 登录
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @return 是否登录成功
	 */
	SysUser login(String username, String password);

	/**
	 * 根据用户ID获取角色
	 *
	 * @param userId 用户ID
	 * @return 角色
	 */
	String getRoleByUserId(Long userId);
}
