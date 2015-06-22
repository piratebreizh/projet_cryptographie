package classes;

import interfaces.ICipher;

import java.io.File;

public class Application {

	public static String BASE_PATH = "D:\\ESGI\\Cryptographie\\Substitution_monoalpha\\test\\";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ICipher cipher = new Cipher();
		File maCle = new File(BASE_PATH+"maCLe.txt");
		cipher.generateKey(maCle);

		File message = new File(BASE_PATH+"message.txt");
		File encoded = new File(BASE_PATH+"encoded.txt");
		File decoded = new File(BASE_PATH+"decoded.txt");

		cipher.encode(message, maCle, encoded);
		cipher.decode(encoded, maCle, decoded);

	}

}
