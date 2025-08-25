package com.kody.coinsec.response;

/**
 * <p>
 * 统一返回结果接口
 * </p>
 *
 * @author kody
 * @since 2025-08-25
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