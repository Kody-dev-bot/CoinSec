CREATE TABLE `ai_parse_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `record_id` bigint NOT NULL COMMENT '关联的记账记录ID（account_record.id）',
  `original_text` varchar(500) NOT NULL COMMENT '用户输入文本',
  `ai_prompt` text NOT NULL COMMENT '发送给AI的提示词',
  `ai_response` text NOT NULL COMMENT 'AI返回的原始响应（JSON格式）',
  `parse_status` tinyint NOT NULL COMMENT '解析状态（1=成功/0=失败）',
  `cost_time_ms` int DEFAULT NULL COMMENT 'AI调用耗时（毫秒）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_record_id` (`record_id`) COMMENT '关联记账记录'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'AI解析日志表（版本二新增）';