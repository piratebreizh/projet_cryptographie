package classes;

import interfaces.ICipher;

import java.io.*;

public class VigenerCipher implements ICipher{

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

    @Override
    public void generateKey(File key) {

    }


    public char getEncodeChar(char c) {
        int posCesar = alphabet.indexOf(codeCesar);
        int posC = alphabet.indexOf(c);

        int length = alphabet.length();
        int pos = (posC+posCesar)%length;
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
        int pos = (length+posC-posCesar)%length;
        if(pos>=0){
            return alphabet.charAt(pos);
        }else{
            return c;
        }
    }
}
