package com.coinsec.category.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 记账分类表
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
@Getter
@Setter
@ToString
@TableName("category")
@Accessors(chain = true)
public class Category {

	/**
	 * 分类ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 所属用户ID（0表示系统默认分类）
	 */
	@TableField("user_id")
	private Long userId;

	/**
	 * 分类名称（如餐饮、交通）
	 */
	@TableField("name")
	private String name;

	/**
	 * 类型（expense=支出/income=收入）
	 */
	@TableField("type")
	private String type;

	/**
	 * 排序权重（越大越靠前）
	 */
	@TableField("sort")
	private Integer sort;

	@TableField("create_time")
	private LocalDateTime createTime;

	@TableField("update_time")
	private LocalDateTime updateTime;
}
