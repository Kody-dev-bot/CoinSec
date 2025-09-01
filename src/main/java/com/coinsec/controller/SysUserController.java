package com.coinsec.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户表，存储用户登录及基本信息 前端控制器
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
@Log4j2
@Validated
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
}