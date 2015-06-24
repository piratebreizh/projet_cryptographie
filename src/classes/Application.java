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
        encodePolyAlpha();
	}

    private static void encodePolyAlpha() {
        File keyPA = new File(BASE_PATH+"keyPA.txt");
        File message = new File(BASE_PATH+"message.txt");
        File encodedPA = new File(BASE_PATH+"encodedPA.txt");
        File decodedPA = new File(BASE_PATH+"decodedPA.txt");


    }


    public static void encodeHomophonique(){
        File key = new File(BASE_PATH+"keyHomophonique.txt");
        File source = new File(BASE_PATH+"source.txt");
        File message = new File(BASE_PATH+"message.txt");
        File encodedHP = new File(BASE_PATH+"encodedHP.txt");
        File decodedHP = new File(BASE_PATH+"decodedHP.txt");

        HomophoniqueCipher cipher = new HomophoniqueCipher();        
        cipher.generateKeyMap(source);
        cipher.generateKey(key);
        cipher.encode(message, key, encodedHP);
//        cipher.decode(encodedHP, key, decodedHP);
    }

    public static void attackCesar(){
        BruteForce bruteForce = new BruteForce();
        File encoded = new File(BASE_PATH+"encodedCesar.txt");
        File ve = new File(BASE_PATH+"encodedVeCesar.txt");
        bruteForce.stringFromFile(encoded);
        bruteForce.runAttaque(ve);
    }


    public static void encodeCesar(){
        ICipher cipher = new CesarCipher();
        File maCle = new File(BASE_PATH+"keyCesar.txt");

        File message = new File(BASE_PATH+"messageCesar.txt");
        File encoded = new File(BASE_PATH+"encodedCesar.txt");
        File decoded = new File(BASE_PATH+"decodedCesar.txt");
        cipher.generateKey(maCle);
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
