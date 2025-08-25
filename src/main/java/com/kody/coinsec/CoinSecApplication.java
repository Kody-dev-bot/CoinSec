package com.kody.coinsec;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * CoinSecApplication is the main class for the CoinSec application.
 *
 * @author Kody
 * @since 2025-08-25
 */
@SpringBootApplication
@MapperScan("com.kody.coinsec.mapper")
public class CoinSecApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinSecApplication.class, args);
	}

}
