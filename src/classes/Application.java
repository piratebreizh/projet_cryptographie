package classes;

import attaques.MonoEncodedAttack;
import interfaces.ICipher;

import java.io.File;

public class Application {

	public static String BASE_PATH = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ICipher cipher = new MonoCipher();
		File maCle = new File(BASE_PATH+"key.txt");
		cipher.generateKey(maCle);

		File message = new File(BASE_PATH+"message.txt");
		File source = new File(BASE_PATH+"source.txt");
		File encoded = new File(BASE_PATH+"encoded.txt");
		File decoded = new File(BASE_PATH+"decoded.txt");

		cipher.encode(message, maCle, encoded);
		cipher.decode(encoded, maCle, decoded);

		
		File foundKey = new File(BASE_PATH+"foundKey.txt");
		MonoEncodedAttack attack = new MonoEncodedAttack();
		attack.createFrequence(source);
		attack.findkey(encoded, foundKey);
	}

}
