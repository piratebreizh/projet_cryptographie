package classes;

import interfaces.ICipher;

import java.io.*;

public class VigenerCipher implements ICipher{

    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + " .,;:\"'";

    private int indexKey;
    private String key;



    @Override
    public void encode(File message, File _key, File encoded) {
        generateKey(_key);
        indexKey = -1;
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
                char dec = getDecalage();
                char chEncoded = getEncodeChar(ch, dec);
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
    public void decode(File encoded, File _key, File decoded) {
        generateKey(_key);
        indexKey = -1;
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
                char dec = getDecalage();
                char chEncoded = getDecodeChar(ch, dec);
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

    private char getDecalage() {
        indexKey = (indexKey++)%key.length();
        return key.charAt(indexKey);
    }

    @Override
    public void generateKey(File _key) {
        try {
            //Message
            InputStream inputStream = new FileInputStream(_key);
            InputStreamReader input = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(input);
            //Lecture
            int intChar;
            StringBuilder builder = new StringBuilder();
            while ((intChar = br.read()) != -1) {
                if(alphabet.indexOf((char) intChar) != -1)
                    builder.append((char) intChar);
            }
            key = builder.toString();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public char getEncodeChar(char c, char dec) {
        int posCesar = alphabet.indexOf(dec);
        int posC = alphabet.indexOf(c);

        int length = alphabet.length();
        int pos = (posC+posCesar)%length;
        if(pos>=0){
            return alphabet.charAt(pos);
        }else{
            return c;
        }
    }

    public char getDecodeChar(char c, char dec) {
        int posCesar = alphabet.indexOf(dec);
        int posC = alphabet.indexOf(c);
        int length = alphabet.length();
        int pos = (length+posC-posCesar)%length;
        if(pos>=0){
            return alphabet.charAt(pos);
        }else{
            return c;
        }
    }
}
