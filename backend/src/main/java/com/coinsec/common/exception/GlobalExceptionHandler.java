package com.coinsec.common.exception;

import com.coinsec.common.result.Result;
import com.coinsec.common.result.ResultCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * <p>
 * 全局异常处理
 * </p>
 * 捕获所有Controller层抛出的异常，转换为统一Result格式返回
 *
 * @author kody
 * @since 2025-09-12
 */
@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 处理业务逻辑异常（自定义异常）
	 *
	 * @param e 业务逻辑异常
	 */
	@ExceptionHandler(BusinessException.class)
	public Result<Void> handleBusinessException(BusinessException e) {
		log.error("业务异常：{}", e.getMessage());
		return Result.fail(e.getCode(), e.getMessage());
	}

	/**
	 * 处理参数校验异常（如@Valid注解校验失败）
	 *
	 * @param e 参数校验异常
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Result<Void> handleValidException(MethodArgumentNotValidException e) {
		BindingResult bindingResult = e.getBindingResult();
		// 提取第一个错误字段的提示信息
		FieldError firstError = bindingResult.getFieldError();
		String errorMsg = firstError != null ? firstError.getDefaultMessage() : "参数校验失败";
		log.error("参数校验异常：{}", errorMsg);
		return Result.fail(ResultCode.PARAM_ERROR.getCode(), errorMsg);
	}

	/**
	 * 处理404异常
	 *
	 * @param e 404异常
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	public Result<Void> handleNoHandlerFoundException(NoHandlerFoundException e) {
		log.error("接口不存在：{}", e.getRequestURL());
		return Result.fail(ResultCode.NOT_FOUND);
	}

	/**
	 * 处理未捕获的其他异常（兜底）
	 *
	 * @param e 未捕获的其他异常
	 */
	@ExceptionHandler(Exception.class)
	public Result<Void> handleException(Exception e) {
		log.error("系统异常", e);
		return Result.fail(ResultCode.SYSTEM_ERROR);
	}
}