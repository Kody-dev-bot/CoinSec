package com.coinsec.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * <p>
 * 登录请求参数
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
@Data
public class LoginRequest {

	/**
	 * 用户名
	 */
	@NotBlank(message = "用户名不能为空")
	private String userName;

	/**
	 * 密码
	 */
	@NotBlank(message = "密码不能为空")
	private String password;
}