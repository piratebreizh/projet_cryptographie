package classes;

import java.io.File;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cipher c = new Cipher();
		File key = new File("key.txt");
		File message = new File("message.txt");
		File encoded = new File("encoded.txt");
		File decoded = new File("decoded.txt");
		c.generateKey(key);
		//c.encode(message, key, encoded);
		//c.decode(encoded, key, decoded);

	}

}
