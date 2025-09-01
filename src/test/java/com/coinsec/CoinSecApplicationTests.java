package com.coinsec;

import com.coinsec.service.impl.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoinSecApplicationTests {

	@Autowired
	EmailService emailService;

	@Test
	void contextLoads() {
		emailService.sendUserInfo("<EMAIL>", "测试", "zj.wang.work@zohomail.cn");
	}

}
