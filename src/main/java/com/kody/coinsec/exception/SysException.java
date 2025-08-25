package com.kody.coinsec.exception;

import com.kody.coinsec.response.IResult;

/**
 * <p>
 * sys系统异常
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
public class SysException extends RuntimeException implements IResult {

	/**
	 * 状态码
	 */
	private final Integer code;

	/**
	 * <p>
	 * 创建一个系统异常
	 * </p>
	 *
	 * @param message 异常信息
	 */
	public SysException(String message) {
		super(message);
		this.code = 500;
	}

	/**
	 * <p>
	 * 创建一个系统异常
	 * </p>
	 *
	 * @param code    状态码
	 * @param message 错误信息
	 */
	public SysException(Integer code, String message) {
		super(message);
		this.code = code;
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
}