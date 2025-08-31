package com.coinsec.utils;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;

import java.security.SecureRandom;
import java.util.Random;

/**
 * <p>
 * 密码生成器
 * </p>
 *
 * @author kody
 * @since 2025-08-31
 */
public class RandomPassword {

	/**
	 * 密码字符集
	 */
	private final static String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String LOWER = "abcdefghijklmnopqrstuvwxyz";
	private final static String NUMBER = "0123456789";
	private final static String SPECIAL = "!@#$%^&*()";

	/**
	 * 随机数生成器
	 */
	private final Random random = new SecureRandom();

	/**
	 * 生成随机密码
	 *
	 * @return 随机密码
	 */
	public String generatePassword() {
		int passwordLength = 16;
		StringBuilder allChars = new StringBuilder(UPPER + LOWER + NUMBER + SPECIAL);
		StringBuilder password = new StringBuilder();

		// 确保至少包含每种字符类型各一个
		password.append(UPPER.charAt(random.nextInt(UPPER.length())));
		password.append(LOWER.charAt(random.nextInt(LOWER.length())));
		password.append(NUMBER.charAt(random.nextInt(NUMBER.length())));
		password.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));

		// 填充剩余长度
		int remainingLength = passwordLength - password.length();
		for (int i = 0; i < remainingLength; i++) {
			password.append(allChars.charAt(random.nextInt(allChars.length())));
		}

		// 打乱顺序，增加密码随机性
		return shuffleString(password.toString());
	}

	/**
	 * 打乱字符串顺序
	 */
	private String shuffleString(String input) {
		char[] chars = input.toCharArray();
		for (int i = chars.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		return new String(chars);
	}

	/**
	 * 加密密码
	 *
	 * @param password 密码
	 * @return 加密后的密码
	 */
	public String encodePassword(String password) {
		Digester digester = DigestUtil.digester("sm3");
		return digester.digestHex(password);
	}

}