package com.coinsec.record.entity;

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
 * 记账记录表（版本一核心）
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("account_record")
public class AccountRecord {

	/**
	 * 记录ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 用户ID
	 */
	@TableField("user_id")
	private Long userId;

	/**
	 * 用户原始对话文本（如“今天吃饭花了50元”）
	 */
	@TableField("original_text")
	private String originalText;

	/**
	 * 金额
	 */
	@TableField("amount")
	private BigDecimal amount;

	/**
	 * 类型（expense=支出/income=收入）
	 */
	@TableField("type")
	private String type;

	/**
	 * 分类ID（关联category表）
	 */
	@TableField("category_id")
	private Long categoryId;

	/**
	 * 记账发生时间（如2023-10-10 12:00:00）
	 */
	@TableField("record_time")
	private LocalDateTime recordTime;

	/**
	 * 备注（从文本中提取）
	 */
	@TableField("note")
	private String note;

	@TableField("create_time")
	private LocalDateTime createTime;

	@TableField("update_time")
	private LocalDateTime updateTime;
}
