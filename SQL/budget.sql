CREATE TABLE `budget_main` (
                               `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主预算ID，自增主键',
                               `user_id` bigint NOT NULL COMMENT '用户ID，关联所属用户',
                               `cycle_type` tinyint NOT NULL COMMENT '预算周期类型：1=月度，2=季度，3=年度',
                               `total_amount` decimal(12,2) NOT NULL COMMENT '周期总预算金额，该周期内的总预算上限',
                               `start_date` date NOT NULL COMMENT '周期开始日期，如2023-10-01',
                               `end_date` date NOT NULL COMMENT '周期结束日期，如2023-10-31',
                               `status` tinyint NOT NULL DEFAULT 1 COMMENT '预算状态：1=启用，0=禁用',
                               `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '预算创建时间',
                               `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '预算更新时间',
                               PRIMARY KEY (`id`),
                               UNIQUE KEY `uk_user_cycle` (`user_id`, `cycle_type`, `start_date`) COMMENT '确保同一用户同一周期内只有一条总预算'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='预算主表，存储用户在不同周期的总预算信息';

CREATE TABLE `budget_sub` (
                              `id` bigint NOT NULL AUTO_INCREMENT COMMENT '子预算ID，自增主键',
                              `main_id` bigint NOT NULL COMMENT '主预算ID，关联所属的主预算',
                              `category_id` bigint NOT NULL COMMENT '类别ID，关联对应的消费类别',
                              `amount` decimal(12,2) NOT NULL COMMENT '子预算金额，该类别在周期内的预算上限',
                              `remind_ratio` decimal(3,2) NOT NULL DEFAULT 0.8 COMMENT '提醒比例，达到该比例时触发预算提醒，如0.8表示80%',
                              `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '子预算创建时间',
                              `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '子预算更新时间',
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `uk_main_category` (`main_id`, `category_id`) COMMENT '确保同一主预算下同一类别只有一条子预算',
                              CONSTRAINT `fk_budget_sub_main` FOREIGN KEY (`main_id`)
                                  REFERENCES `budget_main` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='预算子表，按类别拆分总预算，存储每个类别的预算金额';

CREATE TABLE `budget_execution` (
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '执行记录ID，自增主键',
                                    `sub_id` bigint NOT NULL COMMENT '子预算ID，关联所属的子预算',
                                    `main_id` bigint NOT NULL COMMENT '主预算ID，冗余字段，优化查询',
                                    `user_id` bigint NOT NULL COMMENT '用户ID，冗余字段，优化查询',
                                    `used_amount` decimal(12,2) NOT NULL DEFAULT 0.00 COMMENT '已使用金额，该类别在周期内已消费的金额',
                                    `remaining_amount` decimal(12,2) NOT NULL COMMENT '剩余金额，子预算金额减去已使用金额',
                                    `progress_ratio` decimal(5,4) NOT NULL DEFAULT 0.0000 COMMENT '进度比例，已使用金额/子预算金额，范围0-1',
                                    `is_overspent` tinyint NOT NULL DEFAULT 0 COMMENT '是否超支：0=未超支，1=已超支',
                                    `last_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
                                    PRIMARY KEY (`id`),
                                    UNIQUE KEY `uk_sub` (`sub_id`) COMMENT '确保一个子预算只有一条执行记录',
                                    CONSTRAINT `fk_budget_exec_sub` FOREIGN KEY (`sub_id`)
                                        REFERENCES `budget_sub` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='预算执行表，记录每个子预算的使用情况和进度';
