package com.coinsec.common.util;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;

/**
 * <p>
 * 密码加密工具类
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
public class Encryption {

	/**
	 * 加密密码
	 */
	public static String encodePassword(String password) {
		Digester digester = DigestUtil.digester("sm3");
		return digester.digestHex(password);
	}

}