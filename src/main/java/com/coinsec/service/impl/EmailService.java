package com.coinsec.service.impl;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Email 服务类
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
@Getter
@Log4j2
@Service
public class EmailService {

	/**
	 * 邮件发送者
	 */
	private final JavaMailSender mailSender;

	/**
	 * 邮件发送者
	 */
	@Value("${spring.mail.username}")
	private String fromEmail;


	/**
	 * 构造方法
	 *
	 * @param mailSender 邮件发送者
	 */
	@Autowired
	public EmailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/**
	 * 发送管理员账号信息
	 *
	 * @param username 用户名
	 * @param password 密码
	 */
	public void sendAdminInfo(String username, String password, String adminEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromEmail);
		log.info("发送管理员邮件：{}", fromEmail);
		message.setTo(adminEmail);
		log.info("发送管理员邮件给：{}", adminEmail);
		message.setSubject("系统初始化 - 管理员账号信息");
		message.setText("系统首次启动，自动生成管理员账号：\n" +
				"用户名：" + username + "\n" +
				"初始密码：" + password + "\n" +
				"请登录后及时修改密码以保证安全！");
		mailSender.send(message);
	}

	/**
	 * 发送用户账号信息
	 *
	 * @param username     用户名
	 * @param password     密码
	 * @param receiveEmail 接收者
	 */
	public void sendUserInfo(String username, String password, String receiveEmail) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(fromEmail);
			log.info("发送邮件：{}", fromEmail);
			message.setTo(receiveEmail);
			log.info("发送邮件给：{}", receiveEmail);
			message.setSubject("CoinSec系统 - 用户账号信息");
			message.setText("系统首次启动，自动生成用户账号：\n" +
					"用户名：" + username + "\n" +
					"初始密码：" + password + "\n" +
					"请登录后及时修改密码以保证安全！");
			mailSender.send(message);
		} catch (Exception e) {
			log.error("发送邮件失败：{}", e.getMessage());
		}
	}
}