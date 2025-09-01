package com.coinsec.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coinsec.entity.SysUser;

/**
 * <p>
 * 系统用户表，存储用户登录及基本信息 服务类
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
public interface SysUserService extends IService<SysUser> {

	/**
	 * 判断用户名是否存在
	 *
	 * @param userName 用户名
	 * @param role     角色
	 * @return 存在返回true，不存在返回false
	 */
	boolean existsAdmin(String userName, String role);

	/**
	 *
	 * 注册用户
	 *
	 * @param userName 用户名
	 * @param email    邮箱
	 */
	void registerUser(String userName, String email);

	/**
	 * 登录用户
	 *
	 * @param userName 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	SysUser loginUser(String userName, String password);

	/**
	 * 修改密码
	 *
	 * @param id          用户id
	 * @param newPassword 新密码
	 */
	void updatePassword(Long id, String newPassword);
}
