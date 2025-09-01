package com.coinsec.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coinsec.entity.SysUser;

/**
 * <p>
 * 系统用户表，存储用户登录及基本信息 Mapper 接口
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

	/**
	 * 根据用户和角色查询用户数量
	 *
	 * @param userName 用户名
	 * @param role     角色
	 * @return 用户数量
	 */
	int countByUserNameAndRole(String userName, String role);
}
