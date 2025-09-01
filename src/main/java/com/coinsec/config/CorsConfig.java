package com.coinsec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * <p>
 * CORS配置类
 * </p>
 *
 * @author kody
 * @since 2025-09-01
 */
@Configuration
public class CorsConfig {

	@Bean
	public CorsFilter corsFilter() {
		// 1. 创建CORS配置对象
		CorsConfiguration config = new CorsConfiguration();
		// 允许前端域名访问（生产环境需指定具体域名，不要用*）
		config.addAllowedOrigin("http://localhost:5173");
		// 允许携带Cookie
		config.setAllowCredentials(true);
		// 允许所有请求方法（GET、POST、PUT等）
		config.addAllowedMethod("*");
		// 允许所有请求头
		config.addAllowedHeader("*");
		// 暴露响应头（如Authorization）
		config.addExposedHeader("*");

		// 2. 配置路径映射
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);

		// 3. 返回过滤器
		return new CorsFilter(source);
	}
}