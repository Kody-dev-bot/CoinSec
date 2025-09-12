CREATE TABLE `account_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `original_text` varchar(500) NOT NULL COMMENT '用户原始对话文本（如“今天吃饭花了50元”）',
  `amount` decimal(10,2) NOT NULL COMMENT '金额',
  `type` varchar(20) NOT NULL COMMENT '类型（expense=支出/income=收入）',
  `category_id` bigint NOT NULL COMMENT '分类ID（关联category表）',
  `record_time` datetime NOT NULL COMMENT '记账发生时间（如2023-10-10 12:00:00）',
  `note` varchar(500) DEFAULT NULL COMMENT '备注（从文本中提取）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_user_time` (`user_id`,`record_time`) COMMENT '按用户+时间查询记录'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '记账记录表（版本一核心）';