package com.coinsec.config;

import cn.dev33.satoken.stp.StpInterface;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 自定义权限验证接口扩展
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
@Getter
@Log4j2
@Component
public class StpInterfaceImpl implements StpInterface {
	
	/**
	 * 返回指定账号id所拥有的权限码集合
	 *
	 * @param loginId   账号id
	 * @param loginType 账号类型
	 * @return 该账号id具有的权限码集合
	 */
	@Override
	public List<String> getPermissionList(Object loginId, String loginType) {
		return List.of();
	}

	/**
	 * 返回指定账号id所拥有的角色标识集合
	 *
	 * @param loginId   账号id
	 * @param loginType 账号类型
	 * @return 该账号id具有的角色标识集合
	 */
	@Override
	public List<String> getRoleList(Object loginId, String loginType) {
		return List.of();
	}
}