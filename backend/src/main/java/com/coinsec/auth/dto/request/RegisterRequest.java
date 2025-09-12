package com.coinsec.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * <p>
 * 注册请求参数
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
@Data
public class RegisterRequest {

	@NotBlank(message = "用户名不能为空")
	private String userName;

	@NotBlank(message = "密码不能为空")
	private String password;
}