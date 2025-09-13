package com.coinsec.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * Sa-Token 配置类
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
@Log4j2
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

	/**
	 * <p>
	 * 添加 Sa-Token 拦截器
	 * </p>
	 *
	 * @param registry 拦截器注册
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SaInterceptor(h -> {
			log.info("Sa-Token 拦截器");
			SaRouter.match("/**")
					.notMatch("/auth/user/login", "/auth/user/register")
					.notMatch("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**")
					.check(r -> StpUtil.checkLogin());

			// 用户权限
			SaRouter.match("/auth/**", r -> StpUtil.checkLogin());
		})).addPathPatterns("/**");
	}
}