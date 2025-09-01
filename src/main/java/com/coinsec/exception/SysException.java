package com.coinsec.exception;

import com.coinsec.response.IResult;
import com.coinsec.response.ResultEnum;
import lombok.extern.log4j.Log4j2;

import static io.lettuce.core.pubsub.PubSubOutput.Type.message;

/**
 * <p>
 * Sys系统异常
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
@Log4j2
public class SysException extends RuntimeException implements IResult {

	/**
	 * 错误码
	 */
	private Integer code = ResultEnum.SYS_ERROR.getCode();

	/**
	 * 构造方法
	 *
	 * @param message 错误信息
	 */
	public SysException(String message) {
		super(message);
		log.error("SysException: {}", message);

	}

	public SysException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
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