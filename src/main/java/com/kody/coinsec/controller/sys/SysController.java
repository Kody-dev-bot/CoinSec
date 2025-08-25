package com.kody.coinsec.controller.sys;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 登录和注册接口
 * </p>
 *
 * @author kody
 * @since 2025-08-25
 */
@Log4j2
@Getter
@Validated
@RestController
@RequestMapping("/sys/user")
public class SysController {
}