package com.coinsec.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.coinsec.dto.request.LoginDTO;
import com.coinsec.dto.request.RegisterDTO;
import com.coinsec.dto.response.UserInfoDTO;
import com.coinsec.entity.SysUser;
import com.coinsec.exception.SysException;
import com.coinsec.response.Result;
import com.coinsec.service.SysUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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
	public Result<?> register(@Valid @RequestBody RegisterDTO registerDTO) {
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

	/**
	 * 登录
	 *
	 * @param loginDTO 登录信息
	 * @return 登录结果
	 */
	@PostMapping("/login")
	public Result<?> login(@Valid @RequestBody LoginDTO loginDTO) {
		log.info("用户登录请求，参数：{}", loginDTO.getUserName());
		try {
			SysUser userInfo = sysUserService.loginUser(loginDTO.getUserName(), loginDTO.getPassword());
			if (userInfo != null) {
				StpUtil.login(userInfo.getId());

				log.info("用户登录成功，用户名：{}", loginDTO.getUserName());
				UserInfoDTO userInfoDTO = UserInfoDTO.builder()
						.userName(userInfo.getUserName())
						.role(userInfo.getRole())
						.email(userInfo.getEmail())
						.tokenName(StpUtil.getTokenName())
						.tokenValue(StpUtil.getTokenValue())
						.isFirstLogin(userInfo.getIsFirstLogin() == 1)
						.build();
				return Result.success("登录成功", userInfoDTO);
			} else {
				log.error("用户登录失败，用户名：{}，错误：用户不存在", loginDTO.getUserName());
				return Result.failed("用户不存在");
			}
		} catch (SysException e) {
			log.error("用户登录失败，用户名：{}，错误：{}", loginDTO.getUserName(), e.getMessage());
			return Result.failed(e.getMessage());
		}
	}

	/**
	 * 修改密码
	 *
	 * @param newPassword 新密码
	 * @return 修改密码结果
	 */
	@PostMapping("/update-password")
	public Result<?> updatePassword(@NotBlank(message = "新密码不能为空") @RequestParam String newPassword) {
		try {
			// 验证登录状态
			StpUtil.checkLogin();
			Long userId = StpUtil.getLoginIdAsLong();
			sysUserService.updatePassword(userId, newPassword);
			return Result.success("密码修改成功");
		} catch (SysException e) {
			log.error("修改密码失败：{}", e.getMessage());
			return Result.failed(e.getMessage());
		}
	}

	/**
	 * 登出
	 *
	 * @return 登出结果
	 */
	@PostMapping("/logout")
	public Result<?> logout() {
		try {
			StpUtil.checkLogin();
			Long userId = StpUtil.getLoginIdAsLong();
			String userName = sysUserService.getById(userId).getUserName();
			StpUtil.logout();
			log.info("用户{}登出成功", userName);
			return Result.success("登出成功");
		} catch (SysException e) {
			log.error("用户登出失败：{}", e.getMessage());
			return Result.failed(e.getMessage());
		}
	}
}