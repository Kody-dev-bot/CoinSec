package com.coinsec.auth.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.coinsec.auth.dto.request.LoginRequest;
import com.coinsec.auth.dto.response.LoginResponse;
import com.coinsec.auth.entity.User;
import com.coinsec.auth.service.UserService;
import com.coinsec.common.result.Result;
import com.coinsec.common.result.ResultCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
@Log4j2
@Validated
@RestController
@RequestMapping("/auth/user")
@Tag(name = "用户管理", description = "登录、注册等用户相关接口")
public class UserController {

	/**
	 * 用户服务
	 */
	private final UserService userService;

	/**
	 * 构造函数
	 *
	 * @param userService 用户服务
	 */
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 登录
	 *
	 * @param request 登录请求
	 * @return 登录用户
	 */
	@Operation(summary = "用户登录", description = "通过用户名和密码登录系统，返回Token")
	@SaIgnore
	@PostMapping("/login")
	public Result<LoginResponse> login(@RequestBody LoginRequest request) {
		try {
			User user = userService.login(request.getUserName(), request.getPassword());
			if (user == null) {
				return Result.fail(ResultCode.UNAUTHORIZED);
			}
			StpUtil.login(user.getId());
			// 获取token名称和值
			String tokenName = StpUtil.getTokenName();
			String tokenValue = StpUtil.getTokenValue();
			// 封装响应数据
			LoginResponse response = new LoginResponse(tokenName, tokenValue);
			return Result.success(response);
		} catch (Exception e) {
			log.error("登录失败：{}", e.getMessage());
			throw e;
		}
	}

	/**
	 * 注册
	 *
	 * @param request 注册请求
	 * @return 注册结果
	 */
	@Operation(summary = "用户注册", description = "通过用户名和密码注册用户")
	@SaIgnore
	@PostMapping("/register")
	public Result<Void> register(@RequestBody LoginRequest request) {
		try {
			if (userService.register(request.getUserName(), request.getPassword())) {
				return Result.success();
			} else {
				return Result.fail(ResultCode.INTERNAL_ERROR);
			}
		} catch (Exception e) {
			log.error("注册异常：{}", e.getMessage());
			throw e;
		}
	}
}
