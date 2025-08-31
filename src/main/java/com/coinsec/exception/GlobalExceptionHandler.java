package com.coinsec.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotRoleException;
import com.coinsec.response.Result;
import jakarta.validation.ConstraintDeclarationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * 全局异常处理
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Sys系统异常
	 *
	 * @param e 自定义异常
	 * @return 错误信息
	 */
	@ExceptionHandler(SysException.class)
	public Result<?> handleSysException(SysException e) {
		log.error("SysException: {}", e.getMessage());
		return Result.failed(e.getCode(), e.getMessage());
	}

	/**
	 * 参数验证异常处理
	 *
	 * @param e 参数验证异常
	 * @return 错误信息
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Result<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		String msg = e.getBindingResult().getAllErrors().getFirst().getDefaultMessage();
		log.error("MethodArgumentNotValidException: {}", msg);
		return Result.failed(msg);
	}

	/**
	 * 参数约束违反异常处理
	 *
	 * @param e 参数验证异常
	 * @return 错误信息
	 */
	@ExceptionHandler(ConstraintDeclarationException.class)
	public Result<?> handleConstraintDeclarationException(ConstraintDeclarationException e) {
		log.error("ConstraintDeclarationException:", e);
		return Result.failed(e.getMessage());
	}

	/**
	 * 参数异常处理
	 *
	 * @param e 参数异常
	 * @return 错误信息
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	public Result<?> handleIllegalArgumentException(IllegalArgumentException e) {
		log.error("IllegalArgumentException:", e);
		return Result.failed(e.getMessage());
	}

	/**
	 * 登录异常处理
	 *
	 * @param e 登录异常
	 * @return 错误信息
	 */
	@ExceptionHandler(NotLoginException.class)
	public Result<?> handleNotLoginException(NotLoginException e) {
		log.error("NotLoginException:", e);
		return Result.failed(e.getMessage());
	}

	/**
	 * 角色异常处理
	 *
	 * @param e 角色异常
	 * @return 错误信息
	 */
	@ExceptionHandler(NotRoleException.class)
	public Result<?> handleNotRoleException(NotRoleException e) {
		log.error("NotRoleException:", e);
		return Result.failed(e.getMessage());
	}

	/**
	 * 全局异常处理
	 *
	 * @param e 异常
	 * @return 错误信息
	 */
	@ExceptionHandler(Exception.class)
	public Result<?> handleException(Exception e) {
		log.error("Exception:", e);
		return Result.failed(e.getMessage());
	}
}