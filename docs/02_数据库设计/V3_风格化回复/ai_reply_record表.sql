CREATE TABLE `ai_reply_record` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '回复ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `record_id` bigint NOT NULL COMMENT '关联的记账记录ID',
  `style_id` bigint NOT NULL COMMENT '使用的风格ID（关联style_template.id）',
  `ai_prompt` text NOT NULL COMMENT '生成回复的提示词（含风格模板）',
  `reply_content` text NOT NULL COMMENT 'AI生成的风格化回复',
  `cost_time_ms` int DEFAULT NULL COMMENT 'AI调用耗时（毫秒）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_record_id` (`record_id`) COMMENT '关联记账记录'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'AI风格化回复记录表（版本三新增）';