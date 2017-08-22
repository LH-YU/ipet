package com.myhexin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密辅助工具类
 * 
 * @author zhc time:2012-3-11
 */
public final class MD5Util {
	// 默认的密码字符串组合，用来将字节转换成 16 进制表示的字符,apache校验下载
	// 的文件的正确性用的就是默认的这个组合
	protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	protected static MessageDigest messagedigest = null;
	static {
		try {
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 字符加密(32)
	 * 
	 * @param str
	 *            要加密的字符
	 * @param isUpperCase
	 *            (编码中英文字符是否大写,true是，false否)
	 * @return
	 */
	public static String encryptionStr(String str, boolean isUpperCase) {
		StringBuffer buf = null;
		messagedigest.update(str.getBytes());
		byte b[] = messagedigest.digest();
		int i;
		buf = new StringBuffer("");
		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0)
				i += 256;
			if (i < 16)
				buf.append("0");
			buf.append(Integer.toHexString(i));
		}

		return (isUpperCase == true) ? buf.toString().toUpperCase() : buf
				.toString();
	}

	/** 生成文件的md5校验值： */
	public static String getFileMD5String(File file) throws IOException {
		InputStream fis;
		fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int numRead = 0;
		while ((numRead = fis.read(buffer)) > 0) {
			messagedigest.update(buffer, 0, numRead);
		}
		fis.close();
		return bufferToHex(messagedigest.digest());
	}

	private static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		// 取字节中高 4 位的数字转换，为逻辑右移，将符号位一起右移，此处未发现两种符号有何不同
		char c0 = hexDigits[(bt & 0xf0) >> 4];
		// 取字节中低 4 位的数字转换
		char c1 = hexDigits[bt & 0xf];
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}
}