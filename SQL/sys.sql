CREATE TABLE `sys_user` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID，自增主键',
                            `user_name` varchar(50) NOT NULL COMMENT '登录用户名，唯一标识',
                            `password` varchar(100) NOT NULL COMMENT '登录密码，使用BCrypt加密存储',
                            `status` tinyint NOT NULL DEFAULT 1 COMMENT '账号状态：1=正常，0=禁用',
                            `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间，记录用户最近一次登录系统的时间',
                            `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '账号创建时间',
                            `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '账号信息更新时间',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `uk_username` (`user_name`) COMMENT '确保用户名唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表，存储用户登录及基本信息';


CREATE TABLE `sys_config` (
                              `id` bigint NOT NULL AUTO_INCREMENT COMMENT '配置ID，自增主键',
                              `config_key` varchar(50) NOT NULL COMMENT '配置键，唯一标识',
                              `config_value` varchar(200) NOT NULL COMMENT '配置值',
                              `remark` varchar(200) DEFAULT NULL COMMENT '配置说明，描述该配置的用途',
                              `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '配置创建时间',
                              `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '配置更新时间',
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `uk_config_key` (`config_key`) COMMENT '确保配置键唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统配置表，存储系统级各项配置参数';