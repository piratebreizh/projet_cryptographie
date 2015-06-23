package classes;

import attaques.BruteForce;
import attaques.MonoEncodedAttack;
import interfaces.ICipher;

import java.io.File;

public class Application {

	public static String BASE_PATH = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        encodeCesar();
	}

    public static void attackCesar(){
        BruteForce bruteForce = new BruteForce();
        bruteForce.
    }


    public static void encodeCesar(){
        ICipher cipher = new CesarCipher();
        File maCle = new File(BASE_PATH+"keyCesar.txt");

        File message = new File(BASE_PATH+"messageCesar.txt");
        File encoded = new File(BASE_PATH+"encodedCesar.txt");
        File decoded = new File(BASE_PATH+"decodedCesar.txt");

        cipher.encode(message, maCle, encoded);
        cipher.decode(encoded, maCle, decoded);
    }

    public static void encodeMono(){
        ICipher cipher = new MonoCipher();
        File maCle = new File(BASE_PATH+"key.txt");
		cipher.generateKey(maCle);

        File message = new File(BASE_PATH+"message.txt");
        File source = new File(BASE_PATH+"source.txt");
        File encoded = new File(BASE_PATH+"encoded.txt");
        File decoded = new File(BASE_PATH+"decoded.txt");

		cipher.encode(message, maCle, encoded);
		cipher.decode(encoded, maCle, decoded);
    }


    public static void launchAttack(){
        ICipher cipher = new MonoCipher();

        File encoded = new File(BASE_PATH+"encoded.txt");

        File sourceFrequence = new File(BASE_PATH+"texte_reference.txt");
        File foundKey = new File(BASE_PATH+"foundKey.txt");
        File decodedAttack = new File(BASE_PATH+"decodedAttack.txt");

        MonoEncodedAttack attack = new MonoEncodedAttack();
        attack.createFrequence(sourceFrequence);
        attack.findkey(encoded, foundKey);

        cipher.decode(encoded,foundKey,decodedAttack);
    }
}
