package classes;

import interfaces.ICipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class TranspositionCipher implements ICipher {
    private ArrayList<Integer> keyList;

    private int BLOCK_LENGTH;

    @Override
    public void encode(File message, File key, File encoded) {
        try {
            FileReader reader = new FileReader(message);

            String block = "";
            //Lecture
            int intChar;
            while ((intChar = reader.read()) != -1) {

            }

        } catch (Exception e) {
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
            StringBuilder block = null;
            
            while ((intChar = br.read()) != -1) {
                if(block.length()<BLOCK_LENGTH){
                	block.append(intChar);
                }else{
                	String decodedBlock = getDecodedBlock(block);
                    outputStreamWriter.write(decodedBlock);
                    block.delete(0, block.length());
                }
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
        keyList = new ArrayList<>();
        int keyLength = 5;
        for(int i=0 ; i< keyLength ; i++){
            keyList.add(i);
        }
        Collections.shuffle(keyList);
    }
    
    public String getDecodedBlock(StringBuilder codedString){
    	return codedString.toString();
    }
}
