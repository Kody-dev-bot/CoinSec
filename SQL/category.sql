CREATE TABLE `category` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '类别ID，自增主键',
                            `user_id` bigint DEFAULT NULL COMMENT '用户ID，null表示系统默认类别，非null表示用户自定义类别',
                            `name` varchar(30) NOT NULL COMMENT '类别名称，如"餐饮"、"工资"',
                            `parent_id` bigint DEFAULT NULL COMMENT '父类别ID，用于实现多级分类，null表示一级类别',
                            `level` tinyint NOT NULL DEFAULT 1 COMMENT '类别层级：1=一级类别，2=二级类别，限制最大层级为2',
                            `type` tinyint NOT NULL COMMENT '类别类型：1=支出，2=收入，3=通用（可用于收支）',
                            `sort` int NOT NULL DEFAULT 0 COMMENT '排序权重，数值越大排序越靠前',
                            `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '类别创建时间',
                            `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '类别信息更新时间',
                            PRIMARY KEY (`id`),
                            KEY `idx_user_type` (`user_id`, `type`) COMMENT '按用户和类型查询类别，优化查询效率',
                            KEY `idx_parent` (`parent_id`) COMMENT '按父类别ID查询子类别，优化层级查询'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消费类别表，存储收支分类信息，支持系统默认和用户自定义';

INSERT INTO `category` (name, parent_id, level, type, sort) VALUES
                                                                ('餐饮', NULL, 1, 1, 1),
                                                                ('交通', NULL, 1, 1, 2),
                                                                ('购物', NULL, 1, 1, 3),
                                                                ('住房', NULL, 1, 1, 4),
                                                                ('娱乐', NULL, 1, 1, 5),
                                                                ('医疗', NULL, 1, 1, 6),
                                                                ('工资', NULL, 1, 2, 1),
                                                                ('兼职', NULL, 1, 2, 2),
                                                                ('投资收益', NULL, 1, 2, 3),
                                                                ('其他收入', NULL, 1, 2, 4);