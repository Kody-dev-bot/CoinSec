package com.coinsec.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户表，存储用户登录及基本信息
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
@Getter
@Setter
@ToString
@Builder
@TableName("sys_user")
@Accessors(chain = true)
public class SysUser {

	/**
	 * 用户ID，自增主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 登录用户名，唯一标识
	 */
	@TableField("user_name")
	private String userName;

	/**
	 * 登录密码，使用BCrypt加密存储
	 */
	@TableField("password")
	private String password;

	/**
	 * 账号状态：1=正常，0=禁用
	 */
	@TableField("status")
	private Byte status;

	/**
	 * 角色
	 */
	@TableField("role")
	private String role;

	/**
	 * 最后登录时间，记录用户最近一次登录系统的时间
	 */
	@TableField("last_login_time")
	private LocalDateTime lastLoginTime;

	/**
	 * 账号创建时间
	 */
	@TableField("create_time")
	private LocalDateTime createTime;

	/**
	 * 账号信息更新时间
	 */
	@TableField("update_time")
	private LocalDateTime updateTime;
}
