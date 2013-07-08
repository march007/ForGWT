package ru.vrn.rusap.server.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Предназначен для шифрования пароля c солью.
 * 
 * @autor marchenko
 * 
 * @create 10.06.213
**/
public class EncryptPass {
	private static String SALT = "LongStringForExtraSecurity@#$!%^&*(*)12345678901";
	
	public static String encrypt(String pass){
	        String unecryptedPassword1 =  pass.substring(2, 4);
	         
	        MessageDigest messageDigest=null;
	        try {
	            messageDigest = MessageDigest.getInstance("SHA");
	            messageDigest.update((SALT+pass+unecryptedPassword1+SALT).getBytes());
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        String encryptedPassword = (new BigInteger(messageDigest.digest())).toString(16);
	        
	        return encryptedPassword;
	}
	
}
