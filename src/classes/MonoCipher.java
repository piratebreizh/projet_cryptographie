package classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import interfaces.ICipher;

public class MonoCipher implements ICipher {
	
	private Map<Character, Character> keyAlphabet;
	ArrayList<Character> listkey;

	public MonoCipher(){
		keyAlphabet = new HashMap<Character, Character>();
        listkey = new ArrayList<Character>();
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

	}
    public void encode(File message, File key, File encoded) {

        try {
        	readFileKey (key);
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

    public void decode(File encoded, File key, File decoded) {

        try {
        	readFileKey (key);
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

    public void generateKey(File key) {
    	ArrayList<Character> listRandomKey = new ArrayList<Character>(listkey.size());
    	for(Character item: listkey) 
    		listRandomKey.add(item);
    	long seed = System.nanoTime();
        Collections.shuffle(listRandomKey, new Random(seed));

        PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream(key));
            for (Character c : listRandomKey)
                pw.print(c);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public char getEncodeChar(char c) {
    	if(keyAlphabet.containsKey(c)){
    		return keyAlphabet.get(c);
    	}else{
    		return c;
    	}
 
    }
    
    public char getDecodeChar(char c) {
    	char rep = c;
    	if(keyAlphabet.containsValue(c)){
    		for (Entry<Character, Character> e : keyAlphabet.entrySet()) {
    		    if(e.getValue()==c){
    		    	rep = e.getKey();
    		    }  
    		}
    	}
    	return rep;
    }
    
    private void readFileKey (File key){
    	 try {
             //Message
             InputStream inputStream = new FileInputStream(key);
             InputStreamReader input = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(input);
             
             //Lecture
             int intChar;
             int index = 0;
             while ((intChar = br.read()) != -1) {
                 char ch = (char) intChar;
                 keyAlphabet.put(listkey.get(index), ch);
                 index ++;
             }
             br.close();
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }

}
