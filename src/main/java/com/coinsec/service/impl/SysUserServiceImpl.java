package com.coinsec.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinsec.entity.SysUser;
import com.coinsec.mapper.SysUserMapper;
import com.coinsec.service.SysUserService;
import com.coinsec.utils.RandomPassword;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表，存储用户登录及基本信息 服务实现类
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
@Log4j2
@Getter
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	/**
	 * 邮件服务
	 */
	private final EmailService emailService;
	/**
	 * 用户Mapper
	 */
	@Resource
	private SysUserMapper sysAdminMapper;

	@Autowired
	public SysUserServiceImpl(EmailService emailService) {
		this.emailService = emailService;
	}

	/**
	 * 判断用户名是否存在
	 *
	 * @param userName 用户名
	 * @param role     角色
	 * @return 存在返回true，不存在返回false
	 */
	@Override
	public boolean existsAdmin(String userName, String role) {
		return sysAdminMapper.countByUserNameAndRole(userName, role) > 0;
	}

	/**
	 *
	 * 注册用户
	 *
	 * @param userName 用户名
	 * @param email    邮箱
	 * @return 注册结果
	 */
	@Override
	public boolean registerUser(String userName, String email) {
		RandomPassword randomPassword = new RandomPassword();
		String password = randomPassword.generatePassword();
		SysUser sysUser = new SysUser();
		sysUser
				.setUserName(userName)
				.setPassword(randomPassword.encodePassword(password));
		if (save(sysUser)) {
			emailService.sendUserInfo(userName, password, email);
			log.info("用户注册成功");
			return true;
		} else {
			log.info("用户注册失败");
			return false;
		}
	}

}
