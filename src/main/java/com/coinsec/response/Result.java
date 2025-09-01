package com.coinsec.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * <p>
 * 统一返回结果
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {
	/**
	 * 状态码
	 */
	private Integer code;
	/**
	 * 消息
	 */
	private String message;
	/**
	 * 数据
	 */
	private T data;

	/**
	 * 构造函数
	 */
	public Result() {
	}

	/**
	 * 构造函数
	 *
	 * @param code    状态码
	 * @param message 消息
	 */
	public Result(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 构造函数
	 *
	 * @param result 状态码枚举
	 */
	public Result(IResult result) {
		this.code = result.getCode();
		this.message = result.getMessage();
	}

	/**
	 * 构造函数
	 *
	 * @param code    状态码
	 * @param message 消息
	 * @param data    数据
	 */
	public Result(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * 成功结果
	 *
	 * @param data 数据
	 * @return 结果
	 */
	public static <T> Result<T> success(T data) {
		return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
	}

	/**
	 * 成功结果
	 *
	 * @return 结果
	 */
	public static Result<?> success() {
		return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
	}

	/**
	 * 成功结果
	 *
	 * @param message 消息
	 * @param data    数据
	 * @return 结果
	 */
	public static <T> Result<T> success(String message, T data) {
		return new Result<>(ResultEnum.SUCCESS.getCode(), message, data);
	}

	/**
	 * 失败结果
	 *
	 * @return 结果
	 */
	public static Result<?> failed() {
		return new Result<>(ResultEnum.COMMON_FAILED.getCode(), ResultEnum.COMMON_FAILED.getMessage(), null);
	}

	/**
	 * 失败结果
	 *
	 * @param message 错误消息
	 * @return 错误结果
	 */
	public static Result<?> failed(String message) {
		return new Result<>(ResultEnum.COMMON_FAILED.getCode(), message, null);
	}

	public static Result<?> failed(int code, String message) {
		return new Result<>(code, message, null);
	}

	/**
	 * 失败结果
	 *
	 * @param errorResult 错误结果
	 * @return 错误结果
	 */
	public static Result<?> failed(IResult errorResult) {
		return new Result<>(errorResult.getCode(), errorResult.getMessage(), null);
	}

	/**
	 * 创建结果
	 *
	 * @param code    状态码
	 * @param message 错误消息
	 * @param data    数据
	 * @return 结果
	 */
	public static <T> Result<T> instance(Integer code, String message, T data) {
		Result<T> result = new Result<>();
		result.setCode(code);
		result.setMessage(message);
		result.setData(data);
		return result;
	}
}