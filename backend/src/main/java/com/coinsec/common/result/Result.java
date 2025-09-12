package com.coinsec.common.result;

/**
 * <p>
 * 统一接口返回结构
 * </p>
 * 所有接口响应均使用此格式，便于前端统一解析
 *
 * @param code 状态码（参考ResultCode枚举）
 * @param msg  响应消息（成功/错误描述）
 * @param data 响应数据（成功时返回，失败时可为null）
 * @author kody
 * @since 2025-09-12
 */
public record Result<T>(int code, String msg, T data) {
	// 私有构造，通过静态方法创建实例

	/**
	 * 成功响应（无数据）
	 */
	public static <T> Result<T> success() {
		return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), null);
	}

	/**
	 * 成功响应（带数据）
	 */
	public static <T> Result<T> success(T data) {
		return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
	}

	/**
	 * 失败响应（基于ResultCode）
	 */
	public static <T> Result<T> fail(ResultCode code) {
		return new Result<>(code.getCode(), code.getMsg(), null);
	}

	/**
	 * 失败响应（自定义消息）
	 */
	public static <T> Result<T> fail(String msg) {
		return new Result<>(ResultCode.SYSTEM_ERROR.getCode(), msg, null);
	}

	/**
	 * 失败响应（自定义状态码和消息）
	 */
	public static <T> Result<T> fail(int code, String msg) {
		return new Result<>(code, msg, null);
	}
}