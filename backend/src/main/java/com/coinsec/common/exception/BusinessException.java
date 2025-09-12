package com.coinsec.common.exception;

import com.coinsec.common.result.ResultCode;
import lombok.Getter;

/**
 * <p>
 * 业务异常
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
@Getter
public class BusinessException extends RuntimeException {
	private final int code;

	/**
	 * 构造函数
	 *
	 * @param resultCode 错误码
	 */
	public BusinessException(ResultCode resultCode) {
		super(resultCode.getMsg());
		this.code = resultCode.getCode();
	}

	/**
	 * 构造函数
	 *
	 * @param code    错误码
	 * @param message 错误信息
	 */
	public BusinessException(int code, String message) {
		super(message);
		this.code = code;
	}
}