package com.kody.coinsec.controller.sys;

import cn.dev33.satoken.stp.StpUtil;
import com.kody.coinsec.entity.sys.SysUser;
import com.kody.coinsec.response.Result;
import com.kody.coinsec.service.sys.SysUserService;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 登录和注册接口
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Log4j2
@Getter
@Validated
@RestController
@RequestMapping("/sys")
public class SysController {

	/**
	 * 登录和注册接口
	 */
	private final SysUserService sysUserService;

	/**
	 * 构造函数
	 *
	 * @param sysUserService 系统用户服务
	 */
	public SysController(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	/**
	 * 登录
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录结果
	 */
	@PostMapping("/login")
	public Result<?> login(@RequestBody SysUser sysUser) {
		log.info("登录: {}", sysUser.getUserName());
		try {
			SysUser userInfo = sysUserService.login(sysUser.getUserName(), sysUser.getPassword());
			StpUtil.login(userInfo.getId());
			String tokenName = StpUtil.getTokenName();
			String tokenValue = StpUtil.getTokenValue();

			log.info("token_name: {}, token_value: {}", tokenName, tokenValue);
			Map<String, String> value = Map.of(
					"token_name", tokenName,
					"token_value", tokenValue);
			return Result.success(value);
		} catch (Exception e) {
			log.error("登录失败: {}", e.getMessage());
			return Result.failed("登录失败: " + e.getMessage());
		}
	}

	/**
	 * 注册
	 *
	 * @param sysUser 用户信息
	 * @return 注册结果
	 */
	@PostMapping("/register")
	public Result<?> register(@RequestBody SysUser sysUser) {
		try {
			boolean register = sysUserService.register(sysUser);
			if (register) {
				log.info("注册成功");
				return Result.success("注册成功");
			} else {
				return Result.failed("注册失败");
			}
		} catch (Exception e) {
			log.error("注册失败: {}", e.getMessage());
			return Result.failed("注册失败: " + e);
		}
	}
}