package com.kody.coinsec.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kody.coinsec.entity.sys.SysUser;

import java.util.List;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

	/**
	 * 根据用户id获取角色
	 *
	 * @param userId 用户id
	 * @return 角色
	 */
	List<String> getRoleByUserId(Long userId);
}
