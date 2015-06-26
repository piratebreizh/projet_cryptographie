package classes;

import interfaces.ICipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class TranspositionCipher implements ICipher {
    private ArrayList<Integer> keyList;


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
