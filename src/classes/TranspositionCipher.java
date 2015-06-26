package classes;

import interfaces.ICipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class TranspositionCipher implements ICipher {
    private ArrayList<Integer> keyList;


    @Override
    public void encode(File message, File key, File encoded) {
        generateKey(key);
        try {
            FileReader reader = new FileReader(message);
            FileWriter writer = new FileWriter(encoded);
            StringBuilder block = new StringBuilder();
            //Lecture
            int intChar;
            while ((intChar = reader.read()) != -1) {
                if(block.length() != keyList.size()){
                    block.append((char) intChar);
                }else{
                    writer.write(getEncodedBlock(block.toString()));
                    block.delete(0,block.length());
                }
            }
            //Cas où le dernier block n'est pas plein
            if(block.length() > 0){
                while (block.length() != keyList.size()){
                    block.append(' ');
                }
                writer.write(getEncodedBlock(block.toString()));
            }
            reader.close();
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getEncodedBlock(String block) {
        StringBuilder builder = new StringBuilder();
        for(int i=0 ; i<keyList.size() ; i++){
            builder.append(block.charAt(keyList.get(i)));
        }

        return builder.toString();
    }

    @Override
    public void decode(File encoded, File key, File decoded) {

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
}
