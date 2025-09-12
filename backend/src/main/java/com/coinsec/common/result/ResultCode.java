package com.coinsec.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 结果码
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
	// 通用成功
	SUCCESS(200, "操作成功"),
	// 客户端错误
	PARAM_ERROR(400, "参数错误"),
	UNAUTHORIZED(401, "未登录或Token过期"),
	FORBIDDEN(403, "无权限访问"),
	NOT_FOUND(404, "资源不存在"),
	// 服务器错误
	SYSTEM_ERROR(500, "系统异常，请稍后重试"),
	// 业务逻辑错误（记账相关）
	AMOUNT_NOT_FOUND(601, "未找到金额信息，请包含类似“50元”的表述"),
	TYPE_NOT_CLEAR(602, "未明确收支类型，请包含“花了”或“收入”等表述"),
	CATEGORY_NOT_MATCH(603, "未匹配到合适分类，请补充关键词");

	private final int code;
	private final String msg;
}