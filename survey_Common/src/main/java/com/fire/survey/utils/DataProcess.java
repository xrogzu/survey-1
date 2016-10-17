package com.fire.survey.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataProcess {

	public static String md5(String source) {
		if (source == null || source.length() == 0) {
			return null;
		}
		StringBuffer buffer = new StringBuffer();
		byte[] sourceBytes = source.getBytes();
		try {
			MessageDigest digest = MessageDigest.getInstance("md5");

			byte[] bytes = digest.digest(sourceBytes);
			char[] ch = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

			for (byte b : bytes) {
				int hi = (b >> 4) & 15;
				int lo = b & 15;
				buffer.append(ch[hi]).append(ch[lo]);
			}

		} catch (NoSuchAlgorithmException e) {
			System.out.println("不可能有异常");
		}
		return buffer.toString();
	}
}
