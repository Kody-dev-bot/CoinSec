package com.coinsec.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * <p>
 * DTO: 注册
 * </p>
 *
 * @author kody
 * @since 2025-09-01
 */
@Data
public class RegisterDTO {
	@NotBlank(message = "用户名不能为空")
	private String userName;

	@Email(message = "邮箱格式不正确")
	private String email;
}