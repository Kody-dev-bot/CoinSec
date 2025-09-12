CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `user_id` bigint NOT NULL COMMENT '所属用户ID（0表示系统默认分类）',
  `name` varchar(50) NOT NULL COMMENT '分类名称（如餐饮、交通）',
  `type` varchar(20) NOT NULL COMMENT '类型（expense=支出/income=收入）',
  `sort` int NOT NULL DEFAULT 0 COMMENT '排序权重（越大越靠前）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_type` (`user_id`,`type`) COMMENT '按用户+类型查询分类'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '记账分类表';