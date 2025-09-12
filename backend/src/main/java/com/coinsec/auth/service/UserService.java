package com.coinsec.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coinsec.auth.entity.User;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
public interface UserService extends IService<User> {

	/**
	 * 登录
	 *
	 * @param userName 用户名
	 * @param password 密码
	 * @return 登录用户
	 */
	User login(String userName, String password);

	/**
	 * 注册
	 *
	 * @param userName 用户名
	 * @param password 密码
	 * @return 是否注册成功
	 */
	boolean register(String userName, String password);
}
