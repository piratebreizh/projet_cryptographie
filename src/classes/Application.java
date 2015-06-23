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
//		cipher.generateKey(maCle);

		File message = new File(BASE_PATH+"message.txt");
		File encoded = new File(BASE_PATH+"encoded.txt");
		File decoded = new File(BASE_PATH+"decoded.txt");

//		cipher.encode(message, maCle, encoded);
//		cipher.decode(encoded, maCle, decoded);

        File sourceFrequence = new File(BASE_PATH+"texte_reference.txt");
		File foundKey = new File(BASE_PATH+"foundKey.txt");
        File decodedAttack = new File(BASE_PATH+"decodedAttack.txt");

		MonoEncodedAttack attack = new MonoEncodedAttack();
        attack.createFrequence(sourceFrequence);
		attack.findkey(encoded, foundKey);

        cipher.decode(encoded,foundKey,decodedAttack);
	}

}
