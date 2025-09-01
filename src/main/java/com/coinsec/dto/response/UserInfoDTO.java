package com.coinsec.dto.response;

import lombok.Builder;
import lombok.Data;

/**
 * <p>
 * 返回用户信息
 * </p>
 *
 * @author kody
 * @since 2025-09-01
 */
@Data
@Builder
public class UserInfoDTO {

	/**
	 * 用户id
	 */
	private Long id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 角色
	 */
	private String role;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * token名称
	 */
	private String tokenName;
	/**
	 * token值
	 */
	private String tokenValue;

	/**
	 * 是否首次登录
	 */
	private boolean isFirstLogin;

}