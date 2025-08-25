package com.kody.coinsec.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Getter
@Setter
@ToString
@TableName("sys_user")
@Accessors(chain = true)
public class SysUser {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 登录名
	 */
	@TableField("username")
	@NotBlank(message = "登录名不能为空")
	private String username;

	/**
	 * BCrypt加密后的密码
	 */
	@TableField("password")
	@NotBlank(message = "密码不能为空")
	private String password;

	/**
	 * 昵称
	 */
	@TableField("nickname")
	@NotBlank(message = "昵称不能为空")
	private String nickname;

	/**
	 * 1=正常,0=禁用
	 */
	@TableField("status")
	private Byte status;

	@TableField("create_time")
	private LocalDateTime createTime;

	@TableField("update_time")
	private LocalDateTime updateTime;
}
