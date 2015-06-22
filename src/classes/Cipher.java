package classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import interfaces.ICipher;

public class Cipher implements ICipher {

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
                char chEncoded = getEncodeChar(ch, key);
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
                char chEncoded = getDecodeChar(ch, key);
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
        Collections.shuffle(listkey, new Random(seed));

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

    public static char getEncodeChar(char c, File key) {

        char ca = 'a';
        return ca;
    }
    public static char getDecodeChar(char c, File key) {

        char ca = 'a';
        return ca;
    }

}
