package com.coinsec.exception;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

/**
 * <p>
 * Sys系统异常
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
@Getter
@Log4j2
public class SysException extends RuntimeException {

	/**
	 * 错误码
	 */
	private Integer code = 500;

	/**
	 * 构造方法
	 *
	 * @param message 错误信息
	 */
	public SysException(String message) {
		super(message);
		log.error("SysException: {}", message);
	}

	public SysException(Integer code, String message) {
		super(message);
		this.code = code;
		log.error("SysException: {}, code: {}", message, code);
	}

	/**
	 * 构造方法
	 *
	 * @param message 错误信息
	 * @param cause   错误原因
	 */
	public SysException(String message, Throwable cause) {
		super(message, cause);
		log.error("SysException: {}, cause: {}", message, cause);
	}

}