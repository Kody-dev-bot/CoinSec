CREATE TABLE `account` (
                           `id` bigint NOT NULL AUTO_INCREMENT COMMENT '账户ID，自增主键',
                           `user_id` bigint NOT NULL COMMENT '用户ID，关联所属用户',
                           `name` varchar(100) NOT NULL COMMENT '账户名称，如"招商银行储蓄卡"、"微信钱包"',
                           `type` tinyint NOT NULL COMMENT '账户类型：1=银行卡，2=微信，3=支付宝，4=现金',
                           `card_no` varchar(50) DEFAULT NULL COMMENT '卡号/账号信息，脱敏存储（如仅保留后4位）',
                           `balance` decimal(12,2) NOT NULL DEFAULT 0.00 COMMENT '当前账户余额，精确到分',
                           `status` tinyint NOT NULL DEFAULT 1 COMMENT '账户状态：1=正常使用，0=停用',
                           `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '账户创建时间',
                           `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '账户信息更新时间',
                           PRIMARY KEY (`id`),
                           KEY `idx_user` (`user_id`) COMMENT '按用户查询其所有账户，优化账户列表查询'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账户表，存储用户的资金账户信息';

CREATE TABLE `account_record` (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '记录ID，自增主键',
                                  `user_id` bigint NOT NULL COMMENT '用户ID，关联所属用户',
                                  `account_id` bigint NOT NULL COMMENT '账户ID，关联发生交易的账户',
                                  `amount` decimal(12,2) NOT NULL COMMENT '交易金额，正数表示收入，负数表示支出，精确到分',
                                  `type` tinyint NOT NULL COMMENT '交易类型：1=支出，2=收入',
                                  `category_id` bigint NOT NULL COMMENT '类别ID，关联交易所属分类（必须是二级叶子节点）',
                                  `record_date` date NOT NULL COMMENT '业务发生日期，即实际消费/收入的日期',
                                  `original_text` varchar(1000) NOT NULL COMMENT '用户原始输入文本，如"昨天吃饭花了50元"',
                                  `location` varchar(100) DEFAULT NULL COMMENT '消费地点，可选填，如"公司楼下餐厅"',
                                  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间，即用户输入的时间',
                                  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
                                  `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除标识：0=未删除，1=已删除',
                                  `deleted_time` datetime DEFAULT NULL COMMENT '删除时间，仅当deleted=1时有值',
                                  `transfer_id` bigint DEFAULT NULL COMMENT '关联转账ID，非转账记录为null',
                                  `transfer_role` tinyint DEFAULT NULL COMMENT '转账角色：1=转出方，2=转入方，非转账记录为null',
                                  PRIMARY KEY (`id`),
                                  KEY `idx_user_deleted_date` (`user_id`, `deleted`, `record_date`) COMMENT '按用户+删除状态+日期查询，优化记账记录列表查询',
                                  KEY `idx_account` (`account_id`) COMMENT '按账户查询交易记录',
                                  KEY `idx_category` (`category_id`) COMMENT '按类别查询交易记录',
                                  KEY `idx_transfer` (`transfer_id`, `transfer_role`) COMMENT '按转账ID查询相关记录'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='记账记录表，存储用户每笔收支的核心信息';

CREATE TABLE `account_transaction` (
                                       `id` bigint NOT NULL AUTO_INCREMENT COMMENT '交易ID，自增主键',
                                       `user_id` bigint NOT NULL COMMENT '用户ID，关联所属用户',
                                       `account_id` bigint NOT NULL COMMENT '账户ID，关联发生变动的账户',
                                       `record_id` bigint NOT NULL COMMENT '记账记录ID，关联对应的记账记录',
                                       `amount` decimal(12,2) NOT NULL COMMENT '变动金额：正数表示增加，负数表示减少，精确到分',
                                       `balance_before` decimal(12,2) NOT NULL COMMENT '变动前余额，记录交易前的账户余额',
                                       `balance_after` decimal(12,2) NOT NULL COMMENT '变动后余额，记录交易后的账户余额',
                                       `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '交易创建时间',
                                       `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '逻辑删除标识：0=未删除，1=已删除',
                                       `deleted_time` datetime DEFAULT NULL COMMENT '删除时间，仅当deleted=1时有值',
                                       `transfer_id` bigint DEFAULT NULL COMMENT '关联转账ID，非转账记录为null',
                                       PRIMARY KEY (`id`),
                                       KEY `idx_account` (`account_id`) COMMENT '按账户查询余额变动历史',
                                       KEY `idx_record_deleted` (`record_id`, `deleted`) COMMENT '按记账记录ID+删除状态查询',
                                       KEY `idx_transfer` (`transfer_id`) COMMENT '按转账ID查询相关余额变动'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账户余额变动表，记录账户余额的每次变动，确保余额可追溯';

CREATE TABLE `account_transfer` (
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '转账ID，自增主键',
                                    `user_id` bigint NOT NULL COMMENT '用户ID，关联所属用户',
                                    `out_account_id` bigint NOT NULL COMMENT '转出账户ID，资金从该账户转出',
                                    `in_account_id` bigint NOT NULL COMMENT '转入账户ID，资金转入该账户',
                                    `amount` decimal(12,2) NOT NULL COMMENT '转账金额，精确到分',
                                    `status` tinyint NOT NULL DEFAULT 1 COMMENT '转账状态：1=已完成，2=失败，3=处理中',
                                    `transfer_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '转账时间',
                                    `remark` varchar(200) DEFAULT NULL COMMENT '转账备注，如"银行卡转微信"',
                                    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
                                    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
                                    PRIMARY KEY (`id`),
                                    KEY `idx_user_time` (`user_id`, `transfer_time`) COMMENT '按用户和时间查询转账记录',
                                    CONSTRAINT `fk_transfer_out_account` FOREIGN KEY (`out_account_id`) REFERENCES `account` (`id`),
                                    CONSTRAINT `fk_transfer_in_account` FOREIGN KEY (`in_account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账户转账主表，记录账户间的转账信息';
