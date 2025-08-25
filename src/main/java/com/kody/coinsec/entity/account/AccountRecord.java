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
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 记账记录表
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("account_record")
public class AccountRecord {

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
	 * 金额
	 */
	@TableField("amount")
	private BigDecimal amount;

	/**
	 * 1=支出,2=收入
	 */
	@TableField("type")
	private Byte type;

	/**
	 * 类别ID
	 */
	@TableField("category_id")
	private Long categoryId;

	/**
	 * 业务日期
	 */
	@TableField("record_date")
	private LocalDate recordDate;

	/**
	 * 用户原始输入
	 */
	@TableField("original_text")
	private String originalText;

	@TableField("create_time")
	private LocalDateTime createTime;

	@TableField("update_time")
	private LocalDateTime updateTime;

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

	/**
	 * 转账角色：1=转出方，2=转入方（非转账记录为null）
	 */
	@TableField("transfer_role")
	private Byte transferRole;
}
