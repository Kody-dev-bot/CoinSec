CREATE TABLE `conversation` (
                                `session_id` varchar(64) NOT NULL COMMENT '会话ID，唯一标识一次对话会话',
                                `user_id` bigint NOT NULL COMMENT '用户ID，关联所属用户',
                                `last_record_id` bigint DEFAULT NULL COMMENT '最近关联的记账记录ID，用于上下文关联',
                                `context_data` text COMMENT '上下文数据，JSON格式存储，记录对话历史和上下文信息',
                                `expire_time` datetime NOT NULL COMMENT '会话过期时间，用于自动清理过期会话',
                                `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '会话创建时间',
                                `update_time` datetime NOT NULL DEFAULT  CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '会话更新时间',
                                PRIMARY KEY (`session_id`),
                                KEY `idx_user_expire` (`user_id`, `expire_time`) COMMENT '按用户和过期时间查询，用于清理过期会话'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='对话上下文表，存储用户与系统的对话历史，支持多轮对话';