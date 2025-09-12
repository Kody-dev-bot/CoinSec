package com.coinsec.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinsec.auth.entity.User;
import com.coinsec.auth.mapper.UserMapper;
import com.coinsec.auth.service.UserService;
import com.coinsec.common.exception.BusinessException;
import com.coinsec.common.result.ResultCode;
import com.coinsec.common.util.Encryption;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
@Log4j2
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	/**
	 * 登录
	 *
	 * @param userName 用户名
	 * @param password 密码
	 * @return 登录用户
	 */
	@Override
	public User login(String userName, String password) {
		try {
			log.info("登录用户名：{}", userName);
			String encodePassword = Encryption.encodePassword(password);
			LambdaQueryWrapper<User> query = new LambdaQueryWrapper<>();
			query.eq(User::getUserName, userName).eq(User::getPassword, encodePassword);
			return this.getOne(query);
		} catch (Exception e) {
			log.error("登录异常：{}", e.getMessage());
			throw new BusinessException(ResultCode.SYSTEM_ERROR);
		}
	}

	/**
	 * 注册
	 *
	 * @param userName 用户名
	 * @param password 密码
	 * @return 是否注册成功
	 */
	@Override
	public boolean register(String userName, String password) {
		try {
			log.info("注册用户名：{}", userName);
			String encodePassword = Encryption.encodePassword(password);
			User user = User.builder().userName(userName).password(encodePassword).build();
			return this.save(user);
		} catch (Exception e) {
			log.error("注册异常：{}", e.getMessage());
			throw new BusinessException(ResultCode.SYSTEM_ERROR);
		}
	}

}
