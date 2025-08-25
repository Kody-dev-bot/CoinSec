package com.kody.coinsec.entity.budget;

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
 * 预算子表（类别拆分）
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("budget_sub")
public class BudgetSub {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 主预算ID
	 */
	@TableField("main_id")
	private Long mainId;

	/**
	 * 消费类别ID
	 */
	@TableField("category_id")
	private Long categoryId;

	/**
	 * 子预算金额
	 */
	@TableField("amount")
	private BigDecimal amount;

	/**
	 * 提醒比例
	 */
	@TableField("remind_ratio")
	private BigDecimal remindRatio;

	@TableField("create_time")
	private LocalDateTime createTime;

	@TableField("update_time")
	private LocalDateTime updateTime;
}
