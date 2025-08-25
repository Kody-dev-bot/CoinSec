package com.kody.coinsec.entity;

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
 * 预算执行表
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("budget_execution")
public class BudgetExecution {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 子预算ID
     */
    @TableField("sub_id")
    private Long subId;

    /**
     * 主预算ID
     */
    @TableField("main_id")
    private Long mainId;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 已使用金额
     */
    @TableField("used_amount")
    private BigDecimal usedAmount;

    /**
     * 剩余金额
     */
    @TableField("remaining_amount")
    private BigDecimal remainingAmount;

    /**
     * 进度比例
     */
    @TableField("progress_ratio")
    private BigDecimal progressRatio;

    /**
     * 0=未超支,1=超支
     */
    @TableField("is_overspent")
    private Byte isOverspent;

    @TableField("last_update_time")
    private LocalDateTime lastUpdateTime;
}
