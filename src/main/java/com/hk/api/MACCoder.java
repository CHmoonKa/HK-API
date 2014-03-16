package com.hk.api;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class MACCoder {
	
    /**
     * Returns the encoded key for HmacSHA1 algorithm.
     */
	public static byte[] initHmacSHAKey() throws NoSuchAlgorithmException {
		KeyGenerator generator = KeyGenerator.getInstance("HmacSHA1");
		SecretKey secretKey = generator.generateKey();
		byte[] key = secretKey.getEncoded();
		return key;
	}

	/**
	 * Convert key to String type.
	 */
	public static String encodeHmacSHA(byte[] data, byte[] key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(key, "HmacSHA1");
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		byte[] digest = mac.doFinal(data);
		return new HexBinaryAdapter().marshal(digest).toLowerCase();
	}

}