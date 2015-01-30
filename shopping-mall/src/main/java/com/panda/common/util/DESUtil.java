package com.panda.common.util;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DESUtil {
	public static int _DES = 1;
	public static int _DESede = 1;
	public static int _Blowfish = 3;

	private Cipher p_Cipher;
	private SecretKey p_Key;
	private String p_Algorithm;

	private void selectAlgorithm(int al) {
		switch (al) {
		default:
		case 1:
			this.p_Algorithm = "DES";
			break;
		case 2:
			this.p_Algorithm = "DESede";
			break;
		case 3:
			this.p_Algorithm = "Blowfish";
			break;
		}
	}

	public DESUtil(int algorithm) throws Exception {
		this.selectAlgorithm(algorithm);
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		this.p_Cipher = Cipher.getInstance(this.p_Algorithm);
	}

	public byte[] getKey() {
		return this.checkKey().getEncoded();
	}

	private SecretKey checkKey() {
		try {
			if (this.p_Key == null) {
				KeyGenerator keygen = KeyGenerator
						.getInstance(this.p_Algorithm);
				/*
				 * SecureRandom sr = new SecureRandom(key.getBytes());
				 * keygen.init(168, sr);
				 */
				this.p_Key = keygen.generateKey();
			}
		} catch (Exception nsae) {
		}
		return this.p_Key;
	}

	public void setKey(byte[] enckey) {
		this.p_Key = new SecretKeySpec(enckey, this.p_Algorithm);
	}

	public byte[] encode(byte[] data) throws Exception {
		this.p_Cipher.init(Cipher.ENCRYPT_MODE, this.checkKey());
		return this.p_Cipher.doFinal(data);
	}

	public byte[] decode(byte[] encdata, byte[] enckey) throws Exception {
		this.setKey(enckey);
		this.p_Cipher.init(Cipher.DECRYPT_MODE, this.p_Key);
		return this.p_Cipher.doFinal(encdata);
	}

	public String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int i = 0; i < b.length; i++) {
			stmp = Integer.toHexString(b[i] & 0xFF);
			if (stmp.length() == 1) {
				hs += "0" + stmp;
			} else {
				hs += stmp;
			}
		}
		return hs.toUpperCase();
	}

	public byte[] hex2byte(String hex) throws IllegalArgumentException {
		if (hex.length() % 2 != 0) {
			throw new IllegalArgumentException();
		}
		char[] arr = hex.toCharArray();
		byte[] b = new byte[hex.length() / 2];
		for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
			String swap = "" + arr[i++] + arr[i];
			int byteint = Integer.parseInt(swap, 16) & 0xFF;
			b[j] = new Integer(byteint).byteValue();
		}
		return b;
	}

	public static void main(String[] args) throws Exception {
		for(int i=0;i<10;i++){
		System.out.println(des("11111113asdfasdffffffffffffff"));
		}
	}

	public static String des(String src) {
		String hexkey = null;
		try {
			byte[] key; // 密钥文件(byte)
			DESUtil des = new DESUtil(DESUtil._DESede); // 声明DES
			key = des.getKey(); // 获取随机生成的密钥 
			hexkey = des.byte2hex(key); // 生成十六进制密钥
		} catch (Exception e) {

		}
		if (hexkey == null) {
			String[] strs = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
					"A", "B", "C", "D", "E", "F" };
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 16; i++) {
				int m = (int) (Math.random() * 16);
				sb.append(strs[m]);
				System.out.println(strs[m]);
			}
			hexkey = sb.toString();
		}
		return hexkey;
	}
}
