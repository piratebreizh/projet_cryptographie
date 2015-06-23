package classes;

import interfaces.ICipher;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomophoniqueCipher implements ICipher {

    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + " .,;:\"'";
    private Map<Character, ArrayList<Integer>> generateKeyMap;
    private Map<Character, ArrayList<Integer>> readMap;

    public HomophoniqueCipher(){
        generateKeyMap = new HashMap<>();
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
        //Lire la generateKeyMap

        //Ecrire dans le fichier Key

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
