package com.coinsec;

import cn.dev33.satoken.SaManager;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * coinsec启动类
 * </p>
 *
 * @author kody
 * @since 2019-05-07
 */
@Log4j2
@SpringBootApplication
@MapperScan("com.coinsec.*.mapper")
public class CoinsecApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinsecApplication.class, args);
		log.info("启动成功，Sa-Token 配置如下：{}", SaManager.getConfig());
	}

}
