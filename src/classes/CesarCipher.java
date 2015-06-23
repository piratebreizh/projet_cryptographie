package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Map.Entry;

import interfaces.ICipher;

public class CesarCipher implements ICipher {

	private char codeCesar;

	private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + " .,;:\"'";

	@Override
	public void encode(File message, File key, File encoded) {
		try {
			//Message
			InputStream inputStream = new FileInputStream(message);
			InputStreamReader input = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(input);
			//Encoded
			OutputStreamWriter outputStreamWriter = new FileWriter(encoded);
			//Lecture
			int intChar;
			while ((intChar = br.read()) != -1) {
				char ch = (char) intChar;
				char chEncoded = getEncodeChar(ch);
				//Encodage
				outputStreamWriter.write(chEncoded);
			}
			br.close();
			outputStreamWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void decode(File encoded, File key, File decoded) {
		try {
			//Encoded
			InputStream inputStream = new FileInputStream(encoded);
			InputStreamReader input = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(input);
			//Encoded
			OutputStreamWriter outputStreamWriter = new FileWriter(decoded);
			//Lecture
			int intChar;
			while ((intChar = br.read()) != -1) {
				char ch = (char) intChar;
				//Decodage
				char chEncoded = getDecodeChar(ch);
				outputStreamWriter.write(chEncoded);
			}
			br.close();
			outputStreamWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String decodeString(String encoded, Character key)
	{
		String decoded = "";
		for(int i=0; i<encoded.length() ; i++){
			//Decodage
			char chDecode = getDecodeCharWithKey(encoded.charAt(i), key);
			decoded += chDecode;
		}

		return decoded;
	}

	@Override
	public void generateKey(File key) {
		try {
			//Message
			InputStream inputStream = new FileInputStream(key);
			InputStreamReader input = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(input);
			//Lecture
			int intChar;
			while ((intChar = br.read()) != -1) {
				codeCesar = (char) intChar;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public char getEncodeChar(char c) {
		int posCesar = alphabet.indexOf(codeCesar);
		int posC = alphabet.indexOf(c);

        int length = alphabet.length();
        int pos = (posCesar+posC)%length;
		if(pos>=0){
			return alphabet.charAt(pos);
		}else{
			return c;
		}
	}

	public char getDecodeChar(char c) {
		int posCesar = alphabet.indexOf(codeCesar);
		int posC = alphabet.indexOf(c);
        int length = alphabet.length();
		int pos = (posC-posCesar)%length;
		if(pos>=0){
			return alphabet.charAt(pos);
		}else{
			return alphabet.charAt(pos+length);
		}
	}
	public char getDecodeCharWithKey(char c, char key) {
		int posCesar = alphabet.indexOf(key);
		int posC = alphabet.indexOf(c);
		int pos = (posC-posCesar)%alphabet.length();
		if(pos>=0){
			return alphabet.charAt(pos);
		}else{
			return c;
		}
	}

}
