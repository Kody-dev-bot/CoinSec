package com.kody.coinsec.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


/**
 * <p>
 * 消费类别表
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Getter
@Setter
@ToString
@TableName("category")
@Accessors(chain = true)
public class Category {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID（null=系统默认）
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 类别名称
     */
    @TableField("name")
    private String name;

    /**
     * 父类别ID
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 1=支出,2=收入,3=通用
     */
    @TableField("type")
    private Byte type;

    /**
     * 排序权重
     */
    @TableField("sort")
    private Integer sort;
}
