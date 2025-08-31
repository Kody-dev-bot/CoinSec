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
}
