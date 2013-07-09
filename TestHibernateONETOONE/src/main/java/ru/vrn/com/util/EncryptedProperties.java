package ru.vrn.com.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptedProperties {
	private static String SALT = "************************************";

	public static String encrypt(String pass) {
		String unecryptedPassword1 = pass.substring(2, 4);

		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA");
			messageDigest.update((SALT + pass + unecryptedPassword1 + SALT)
					.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String encryptedPassword = (new BigInteger(messageDigest.digest()))
				.toString(16);
		return encryptedPassword;
	}
}