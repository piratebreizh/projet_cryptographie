package classes;

import interfaces.ICipher;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomophoniqueCipher implements ICipher {

    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + " .,;:\"'";
    private Map<Character, ArrayList<Byte>> generateKeyMap;
    private Map<Character, ArrayList<Byte>> readMap;

    public HomophoniqueCipher(){
        generateKeyMap = new HashMap<>();
        ArrayList<Byte> arrayList = new ArrayList<>();
        arrayList.add((byte) 1);
        arrayList.add((byte) 112);
        arrayList.add((byte) 110);
        generateKeyMap.put('A',arrayList);
        readMap = new HashMap<>();
    }

    @Override
    public void encode(File message, File key, File encoded) {

    }

    @Override
    public void decode(File encoded, File key, File decoded) {

    }

    @Override
    public void generateKey(File key) {
        try {
            OutputStreamWriter outputStreamWriter = new FileWriter(key);
            //Lire la generateKeyMap
            for (int i = 0; i < alphabet.length(); i++) {
                char charA = alphabet.charAt(i);
                if (!generateKeyMap.containsKey(charA)) {
                    continue;
                }
                ArrayList<Byte> arrayListB = generateKeyMap.get(charA);
                if (arrayListB.size() == 0) {
                    continue;
                }
                //Ecrire dans le fichier Key
                outputStreamWriter.write((byte) arrayListB.size());
                for (int b = 0; b < arrayListB.size(); b++) {
                    outputStreamWriter.write(arrayListB.get(b));
                }
            }
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Génère la Hashmap pour la Key
     */
    public void generateKeyMap(){

    }

    /**
     * Charge dans readMap les données du fichier Key
     * @param key
     */
    public void readKey(File key){

    }

}
