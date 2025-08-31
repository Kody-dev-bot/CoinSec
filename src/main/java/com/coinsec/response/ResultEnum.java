package com.coinsec.response;

/**
 * <p>
 *
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
public enum ResultEnum implements IResult {

	SUCCESS(200, "成功"),
	PARAM_VALID_ERROR(400, "参数校验失败"),
	FORBIDDEN(403, "没有权限访问资源"),
	NOT_LOGIN(401, "未登录"),
	COMMON_FAILED(500, "接口调用失败");

	// 状态码
	private final Integer code;
	// 消息
	private final String message;

	/**
	 * 构造函数
	 *
	 * @param code    状态码
	 * @param message 消息
	 */
	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 获取状态码
	 *
	 * @return 状态码
	 */
	@Override
	public Integer getCode() {
		return code;
	}

	/**
	 * 获取消息
	 *
	 * @return 消息
	 */
	@Override
	public String getMessage() {
		return message;
	}
}