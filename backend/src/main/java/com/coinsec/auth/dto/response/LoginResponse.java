package com.coinsec.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 * 登录响应
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
@Data
@AllArgsConstructor
public class LoginResponse {

	/**
	 * token名称
	 */
	private String tokenName;

	/**
	 * token值
	 */
	private String tokenValue;
}