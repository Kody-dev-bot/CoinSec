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
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 预算主表（周期总预算）
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("budget_main")
public class BudgetMain {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 1=月度,2=季度,3=年度
     */
    @TableField("cycle_type")
    private Byte cycleType;

    /**
     * 周期总预算
     */
    @TableField("total_amount")
    private BigDecimal totalAmount;

    /**
     * 周期开始日期
     */
    @TableField("start_date")
    private LocalDate startDate;

    /**
     * 周期结束日期
     */
    @TableField("end_date")
    private LocalDate endDate;

    /**
     * 1=启用,0=禁用
     */
    @TableField("status")
    private Byte status;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;
}
