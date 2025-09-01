package com.coinsec.entity;

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
 * 系统配置表，存储系统级各项配置参数
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("sys_config")
public class SysConfig {

    /**
     * 配置ID，自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 配置键，唯一标识
     */
    @TableField("config_key")
    private String configKey;

    /**
     * 配置值
     */
    @TableField("config_value")
    private String configValue;

    /**
     * 配置说明，描述该配置的用途
     */
    @TableField("remark")
    private String remark;

    /**
     * 配置创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 配置更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;
}
