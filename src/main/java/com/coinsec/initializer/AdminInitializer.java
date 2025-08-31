package com.coinsec.initializer;

import com.coinsec.entity.SysUser;
import com.coinsec.service.SysUserService;
import com.coinsec.service.impl.EmailService;
import com.coinsec.utils.RandomPassword;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 系统初始化
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
@Log4j2
@Getter
@Component
public class AdminInitializer implements ApplicationRunner {

	/**
	 * 超级管理员角色
	 */
	private static final String ADMIN_ROLE = "ADMIN";
	/**
	 * 超级管理员用户名
	 */
	private static final String ADMIN_USERNAME = "admin";
	/**
	 * 用户服务
	 */
	private final SysUserService sysUserService;
	/**
	 * 邮件服务
	 */
	private final EmailService emailService;

	/**
	 * 构造方法
	 *
	 * @param sysUserService 用户服务
	 * @param emailService   邮件服务
	 */
	@Autowired
	public AdminInitializer(SysUserService sysUserService, EmailService emailService) {
		this.sysUserService = sysUserService;
		this.emailService = emailService;
	}

	/**
	 * @param args the arguments
	 */
	@Override
	public void run(ApplicationArguments args) {
		/*
		  判断是否存在超级管理员
		 */
		boolean hasAdmin = sysUserService.existsAdmin(ADMIN_ROLE, ADMIN_USERNAME);
		if (!hasAdmin) {
			log.info("开始初始化管理员账号");
			RandomPassword randomPassword = new RandomPassword();
			String password = randomPassword.generatePassword();
			String encodePassword = randomPassword.encodePassword(password);
			SysUser sysUser = new SysUser();
			sysUser
					.setUserName(ADMIN_USERNAME)
					.setRole(ADMIN_ROLE)
					.setPassword(encodePassword);
			if (sysUserService.save(sysUser)) {
				log.info("管理员账号初始化成功");
				emailService.sendAdminInfo(ADMIN_USERNAME, password);
			}
		} else {
			log.info("管理员账号已存在");
		}
	}
}