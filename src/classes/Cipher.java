package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import interfaces.ICipher;

public class Cipher implements ICipher {

	public void encode(File message, File key, File encoded) {
		
		
	}

	public void decode(File encoded, File key, File decoded) {
		
		
	}

	public void generateKey(File key) {

		ArrayList<Character> listkey = new ArrayList<Character>();
		listkey.add('A');
		listkey.add('B');
		listkey.add('C');
		listkey.add('D');
		listkey.add('E');
		listkey.add('F');
		listkey.add('G');
		listkey.add('H');
		listkey.add('I');
		listkey.add('J');
		listkey.add('K');
		listkey.add('L');
		listkey.add('M');
		listkey.add('N');
		listkey.add('O');
		listkey.add('P');
		listkey.add('Q');
		listkey.add('R');
		listkey.add('S');
		listkey.add('T');
		listkey.add('U');
		listkey.add('V');
		listkey.add('W');
		listkey.add('X');
		listkey.add('Y');
		listkey.add('Z');
		listkey.add(' ');
		listkey.add('.');
		listkey.add(',');
		listkey.add(';');
		listkey.add(':');
		listkey.add('"');
		listkey.add('\'');
		
		long seed = System.nanoTime();
		Collections.shuffle(listkey,new Random(seed));
		
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileOutputStream(key));
	    for (Character c : listkey)
	        pw.print(c);
	    pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Character getEncodeChar(Character c, File key){
		
		char ca = 'a';
		return ca;
	}

}
