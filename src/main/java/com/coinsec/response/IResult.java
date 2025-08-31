package com.coinsec.response;

/**
 * <p>
 * 接口返回结果
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
public interface IResult {
	/**
	 * 获取状态码
	 *
	 * @return 状态码
	 */
	Integer getCode();

	/**
	 * 获取消息
	 *
	 * @return 消息
	 */
	String getMessage();
}