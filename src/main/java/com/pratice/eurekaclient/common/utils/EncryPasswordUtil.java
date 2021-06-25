package com.pratice.eurekaclient.common.utils;

import java.util.UUID;

import org.springframework.util.DigestUtils;

public class EncryPasswordUtil {

	/**
	 * 获取salt
	 * @return
	 */
	public static String getRandomSalt(){
		return  UUID.randomUUID().toString().toUpperCase();
	}


	/**
	 * 对明文密码加密
	 * @param src 明文密码
	 * @param salt 安全指令salt
	 * @return 密文密码
	 */
	public static String getEncrpyPassword(String src,String salt){

		String erc1 = DigestUtils.md5DigestAsHex(src.getBytes()).toUpperCase();

		String erc2 = DigestUtils.md5DigestAsHex(salt.getBytes()).toUpperCase();

		String erc3 = erc1+erc2;
		String result = DigestUtils.md5DigestAsHex(erc3.getBytes()).toUpperCase();

		for(int i=0;i<5;i++){
			result = DigestUtils.md5DigestAsHex(result.getBytes()).toUpperCase();
		}
		return result;
	}

	/**
	 * 判段密码是否正确
	 * @param password 用户登陆密码
	 * @param savePassword db保存密码
	 * @param salt 安全指令
	 * @return true：正确 false：错误
	 */
	public static boolean isCorrect(String password,final String savePassword,final String salt) {

		password = getEncrpyPassword(password,salt);

		return savePassword.equals(password) ? true : false;
	}

}
