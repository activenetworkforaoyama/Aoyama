package co.jp.aoyama.macchinetta.app.rest.api.util;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.encoders.Base64;

public class AESEncrypt {

	public static String encrypt1(String inputValue, String appsecret, String accessToken) {
		try {
			byte[] inputValueBytes = inputValue.getBytes("UTF-8");
			byte[] appsecretBytes = appsecret.getBytes("UTF-8");
			byte[] accessTokenBytes = accessToken.getBytes("UTF-8");

			byte[] keyBytes = new byte[16];

			System.out.println(appsecretBytes.length);
			System.out.println(keyBytes.length);
			int len = appsecretBytes.length;
			if (appsecretBytes.length > keyBytes.length) {
				len = keyBytes.length;
			}
			keyBytes = Arrays.copyOf(appsecretBytes, len);

			IvParameterSpec iv = new IvParameterSpec(accessTokenBytes);
			SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(inputValueBytes);
			return Base64.toBase64String(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String encrypt2(String inputValue, String appsecret, String accessToken) {
		try {
			byte[] inputValueBytes = inputValue.getBytes("UTF-8");
			byte[] appsecretBytes = appsecret.getBytes("UTF-8");
			byte[] accessTokenBytes = accessToken.getBytes("UTF-8");
			// Set up
			AESEngine engine = new AESEngine();
			CBCBlockCipher blockCipher = new CBCBlockCipher(engine);
			PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(blockCipher, new PKCS7Padding());
			KeyParameter keyParam = new KeyParameter(appsecretBytes);
			ParametersWithIV keyParamWithIV = new ParametersWithIV(keyParam, accessTokenBytes, 0, 16);

			// Encrypt
			cipher.init(true, keyParamWithIV);
			byte[] outputBytes = new byte[cipher.getOutputSize(inputValueBytes.length)];
			cipher.doFinal(outputBytes,
					cipher.processBytes(inputValueBytes, 0, inputValueBytes.length, outputBytes, 0));
			String encryptedInput = new String(Base64.encode(outputBytes));
//			System.out.println("Encrypted String:" + encryptedInput);

			// Decrypt
//			cipher.init(false, keyParamWithIV);
//			byte[] out2 = Base64.decode(encryptedInput);
//			byte[] comparisonBytes = new byte[cipher.getOutputSize(out2.length)];
//			cipher.doFinal(comparisonBytes, cipher.processBytes(out2, 0, out2.length, comparisonBytes, 0)); // Do the final block
//			String s2 = new String(comparisonBytes);
//			System.out.println("Decrypted String:" + s2);

			return encryptedInput;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String encrypt3(String inputValue, String appsecret, String accessToken) {
		try {
			byte[] inputValueBytes = inputValue.getBytes("UTF-8");
			byte[] appsecretBytes = appsecret.getBytes("UTF-8");
			byte[] accessTokenBytes = accessToken.getBytes("UTF-8");

			PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()),
					new PKCS7Padding());

			KeyParameter keyParam = new KeyParameter(appsecretBytes);
			CipherParameters params = new ParametersWithIV(keyParam, accessTokenBytes);
			cipher.init(true, params);
			byte[] outputBytes = new byte[cipher.getOutputSize(inputValueBytes.length)];
			int length = cipher.processBytes(inputValueBytes, 0, inputValueBytes.length, outputBytes, 0);

			cipher.doFinal(outputBytes, length);
			String encryptedInput = new String(Base64.encode(outputBytes));

			return encryptedInput;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
