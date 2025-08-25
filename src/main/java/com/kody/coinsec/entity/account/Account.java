package com.kody.coinsec.entity.account;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 账户表
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Getter
@Setter
@ToString
@TableName("account")
@Accessors(chain = true)
public class Account {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 用户ID
	 */
	@TableField("user_id")
	private Long userId;

	/**
	 * 账户名称
	 */
	@TableField("name")
	private String name;

	/**
	 * 1=银行卡,2=微信,3=支付宝,4=现金
	 */
	@TableField("type")
	private Byte type;

	/**
	 * 脱敏卡号
	 */
	@TableField("card_no")
	private String cardNo;

	/**
	 * 当前余额
	 */
	@TableField("balance")
	private BigDecimal balance;

	/**
	 * 1=正常,0=停用
	 */
	@TableField("status")
	private Byte status;

	@TableField("create_time")
	private LocalDateTime createTime;

	@TableField("update_time")
	private LocalDateTime updateTime;
}
