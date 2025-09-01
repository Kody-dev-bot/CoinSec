package com.coinsec.controller;

import com.coinsec.dto.request.RegisterDTO;
import com.coinsec.exception.SysException;
import com.coinsec.response.Result;
import com.coinsec.service.SysUserService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 登录、注册、登出、验证码等认证相关接口
 * </p>
 *
 * @author kody
 * @since 2025-09-01
 */
@Log4j2
@Validated
@RestController
@RequestMapping("/sys")
public class AuthController {

	/**
	 * 用户服务
	 */
	private final SysUserService sysUserService;

	/**
	 * 构造函数
	 *
	 * @param sysUserService 用户服务
	 */
	@Autowired
	public AuthController(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	/**
	 * 注册
	 *
	 * @param registerDTO 注册信息
	 * @return 注册结果
	 */
	@PostMapping("/register")
	public Result<?> register(
			@Valid @RequestBody RegisterDTO registerDTO) {
		log.info("用户注册请求，参数：{}", registerDTO.getUserName());
		try {
			sysUserService.registerUser(registerDTO.getUserName(), registerDTO.getEmail());
			log.info("用户注册成功，用户名：{}", registerDTO.getUserName());
			return Result.success("注册成功，初始密码已发送至邮箱");
		} catch (SysException e) {
			log.error("用户注册失败，用户名：{}，错误：{}", registerDTO.getUserName(), e.getMessage());
			return Result.failed(e.getMessage());
		}
	}
}