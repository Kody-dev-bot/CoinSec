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
 * 账户余额变动表
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("account_transaction")
public class AccountTransaction {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 用户ID
	 */
	@TableField("user_id")
	private Long userId;

	/**
	 * 账户ID
	 */
	@TableField("account_id")
	private Long accountId;

	/**
	 * 记账记录ID
	 */
	@TableField("record_id")
	private Long recordId;

	/**
	 * 变动金额（+增加，-减少）
	 */
	@TableField("amount")
	private BigDecimal amount;

	/**
	 * 变动前余额
	 */
	@TableField("balance_before")
	private BigDecimal balanceBefore;

	/**
	 * 变动后余额
	 */
	@TableField("balance_after")
	private BigDecimal balanceAfter;

	@TableField("create_time")
	private LocalDateTime createTime;

	/**
	 * 0=未删除,1=已删除
	 */
	@TableField("is_deleted")
	private Byte isDeleted;

	/**
	 * 删除时间
	 */
	@TableField("deleted_time")
	private LocalDateTime deletedTime;

	/**
	 * 关联转账ID（非转账记录为null）
	 */
	@TableField("transfer_id")
	private Long transferId;
}
