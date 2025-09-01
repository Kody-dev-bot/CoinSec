package com.coinsec.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinsec.entity.SysUser;
import com.coinsec.exception.SysException;
import com.coinsec.mapper.SysUserMapper;
import com.coinsec.service.SysUserService;
import com.coinsec.utils.RandomPassword;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户表，存储用户登录及基本信息 服务实现类
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
@Log4j2
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	/**
	 * 邮件服务
	 */
	private final EmailService emailService;

	/**
	 * 随机密码生成器
	 */
	private final RandomPassword randomPassword;
	/**
	 * 用户Mapper
	 */
	@Resource
	private SysUserMapper sysAdminMapper;

	@Autowired
	public SysUserServiceImpl(EmailService emailService, RandomPassword randomPassword) {
		this.emailService = emailService;
		this.randomPassword = randomPassword;
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
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void registerUser(String userName, String email) {
		LambdaQueryWrapper<SysUser> query = new LambdaQueryWrapper<SysUser>()
				.eq(SysUser::getUserName, userName)
				.last("LIMIT 1");
		SysUser userInfo = getOne(query);
		if (userInfo != null) {
			log.info("用户已存在, 用户名: {}", userName);
			throw new SysException("用户名已存在，请更换其他用户名");
		}

		String password = randomPassword.generatePassword();
		SysUser sysUser = SysUser.builder()
				.userName(userName)
				.password(randomPassword.encodePassword(password))
				.email(email)
				.build();

		if (save(sysUser)) {
			emailService.sendUserInfo(userName, password, email);
			log.info("用户注册成功，用户名: {}", userName);
		} else {
			log.error("用户注册失败, 用户名: {}", userName);
			throw new SysException("用户信息保存失败，请稍后重试");
		}
	}

	/**
	 * 登录用户
	 *
	 * @param userName 用户名
	 * @param password 密码
	 * @return 用户信息
	 */
	@Override
	public SysUser loginUser(String userName, String password) {
		LambdaQueryWrapper<SysUser> query = new LambdaQueryWrapper<SysUser>()
				.eq(SysUser::getUserName, userName)
				.eq(SysUser::getPassword, password);
		SysUser sysUserInfo = getOne(query);
		if (sysUserInfo != null) {
			log.info("用户{}登录成功", userName);
			sysUserInfo.setLastLoginTime(LocalDateTime.now());
			updateById(sysUserInfo);
			return sysUserInfo;
		} else {
			log.error("用户{}登录失败", userName);
			throw new SysException("用户名或密码错误");
		}
	}

	/**
	 * 修改密码
	 *
	 * @param id          用户id
	 * @param newPassword 新密码
	 */
	@Override
	public void updatePassword(Long id, String newPassword) {
		if (getById(id) == null) {
			throw new SysException("用户不存在");
		}

		SysUser sysUser = SysUser.builder()
				.id(id)
				.password(newPassword)
				.isFirstLogin((byte) 0)
				.updateTime(LocalDateTime.now())
				.build();
		if (updateById(sysUser)) {
			log.info("用户{}修改密码成功", id);
		} else {
			log.error("用户{}修改密码失败", id);
			throw new SysException("修改密码失败，请稍后重试");
		}
	}

}
