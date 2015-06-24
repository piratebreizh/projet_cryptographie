package classes;

import interfaces.ICipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class HomophoniqueCipher implements ICipher {

    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + " .,;:\"'";
    private Map<Character, ArrayList<Byte>> generateKeyMap;
    private Map<Character, ArrayList<Byte>> readMap;
	private ArrayList<Character> frequence;
	private Map<Character, Float> frequenceNumberChar;

    public HomophoniqueCipher(){
        generateKeyMap = new HashMap<>();
        readMap = new HashMap<>();
        frequence = new ArrayList<Character>();
    }
    
    private void initialisationfrequenceNumberChar(){
		frequenceNumberChar = new HashMap<Character, Float>();

		frequenceNumberChar.put('A',new Float(0.0));
		frequenceNumberChar.put('B',new Float(0.0));
		frequenceNumberChar.put('C',new Float(0.0));
		frequenceNumberChar.put('D',new Float(0.0));
		frequenceNumberChar.put('E',new Float(0.0));
		frequenceNumberChar.put('F',new Float(0.0));
		frequenceNumberChar.put('G',new Float(0.0));
		frequenceNumberChar.put('H',new Float(0.0));
		frequenceNumberChar.put('I',new Float(0.0));
		frequenceNumberChar.put('J',new Float(0.0));
		frequenceNumberChar.put('K',new Float(0.0));
		frequenceNumberChar.put('L',new Float(0.0));
		frequenceNumberChar.put('M',new Float(0.0));
		frequenceNumberChar.put('N',new Float(0.0));
		frequenceNumberChar.put('O',new Float(0.0));
		frequenceNumberChar.put('P',new Float(0.0));
		frequenceNumberChar.put('Q',new Float(0.0));
		frequenceNumberChar.put('R',new Float(0.0));
		frequenceNumberChar.put('S',new Float(0.0));
		frequenceNumberChar.put('T',new Float(0.0));
		frequenceNumberChar.put('U',new Float(0.0));
		frequenceNumberChar.put('V',new Float(0.0));
		frequenceNumberChar.put('W',new Float(0.0));
		frequenceNumberChar.put('X',new Float(0.0));
		frequenceNumberChar.put('Y',new Float(0.0));
		frequenceNumberChar.put('Z',new Float(0.0));
		frequenceNumberChar.put(' ',new Float(0.0));
		frequenceNumberChar.put('.',new Float(0.0));
		frequenceNumberChar.put(',',new Float(0.0));
		frequenceNumberChar.put(';',new Float(0.0));
		frequenceNumberChar.put(':',new Float(0.0));
		frequenceNumberChar.put('"',new Float(0.0));
		frequenceNumberChar.put('\'',new Float(0.0));
	}
    
    public void createFrequence(File source){
		Float lengthFichier = new Float(0.0);
		try {

			initialisationfrequenceNumberChar();
			//Message
			InputStream inputStream = new FileInputStream(source);
			InputStreamReader input = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(input);
			//Lecture
			int intChar;
			while ((intChar = br.read()) != -1) {
				char ch = (char) intChar;
				if(this.frequenceNumberChar.containsKey(ch)){
					Float number = this.frequenceNumberChar.get(ch);
					this.frequenceNumberChar.put(ch,++number);
					lengthFichier++;
				}
			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Character c : frequenceNumberChar.keySet()){
			Float val = frequenceNumberChar.get(c);
			frequenceNumberChar.put(c, val/lengthFichier);
		}

		//Tri de la MAP
		this.frequenceNumberChar=sortByComparatorFloat(this.frequenceNumberChar);
		
		for(Character tempChar : this.frequenceNumberChar.keySet()){
			frequence.add(tempChar);
		}
		
	}
    
    private static Map<Character, Float> sortByComparatorFloat(Map<Character, Float> unsortMap) {

		// Convert Map to List
		List<Map.Entry<Character, Float>> list =
				new LinkedList<Map.Entry<Character, Float>>(unsortMap.entrySet());

		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<Character, Float>>() {
            public int compare(Map.Entry<Character, Float> o1,
                               Map.Entry<Character, Float> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

		// Convert sorted map back to a Map
		Map<Character, Float> sortedMap = new LinkedHashMap<Character, Float>();
		for (Iterator<Map.Entry<Character, Float>> it = list.iterator(); it.hasNext();) {
			Map.Entry<Character, Float> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

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
                byte bEncoded = getEncodeByte(ch);
                //Encodage
                outputStreamWriter.write(bEncoded);
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

    public byte getEncodeByte(char c) {
    	Random random = new Random();
        if (readMap.containsKey(c)) {
        	ArrayList<Byte> bytePossibles = readMap.get(c);
        	int v = random.nextInt(bytePossibles.size());
            return bytePossibles.get(v);
        } else {
            return -1;
        }
    }

    public char getDecodeChar(char c) {
       return c;
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
    public void generateKeyMap(File source){

    	ArrayList<Byte> valeurspossibles = new ArrayList<Byte>();
    	
    	createFrequence(source);
    	
    	//remplissage des valeurs possibles pour un �lements de l'alphabet A
    	for(int i=0;i<255;i++){
    		valeurspossibles.add((byte)i);
    	}
        System.out.println(valeurspossibles.size());
    	for(Character c : frequenceNumberChar.keySet()){
    		ArrayList<Byte> valeurPourLeCar = new ArrayList<Byte>();
    		Random random = new Random();
    		
    		//autant de valeur possibles en fonction de la fr�quence du caract�re
            for (int j = 0; j <= Math.floor(frequenceNumberChar.get(c) * 200.0); j++) {
                byte b = valeurspossibles.get(random.nextInt(valeurspossibles.size()));
                valeurspossibles.remove(valeurspossibles.indexOf(b));
                valeurPourLeCar.add(b);
            }

            generateKeyMap.put(c, valeurPourLeCar);
    	}
        System.out.println(valeurspossibles.size());
    }

	/**
	 * Charge dans readMap les données du fichier Key
	 * @param key
	 */
	public void readKey(File _key){
		readMap = new HashMap<Character, ArrayList<Byte>>();

		InputStream is = null;
		byte[] buffer=new byte[5];
		char c;

		try{
			// new input stream created
			is = new FileInputStream(_key);

			// read stream data into buffer
			is.read(buffer);
			
			//true si on rentre en mode ecriture des variable de B, sinon on recupère le nombre de Byte
			boolean modeEcritureB = false;
			//Le nombre de Byte pour une lettre
			int numberOfElementB = 0;
			//l'indice de l'élement de B
			int countNumberRead = 0;
			//Indice de l'alphabet qu'on parcour
			int indiceAlphabet=-1;
			
			for(byte b:buffer)
			{
				Byte byte2 = new Byte(b);
				if(modeEcritureB){
					if(countNumberRead == numberOfElementB){
						//this.readMap.get(this.alphabet).add(e)

						modeEcritureB = false;
						indiceAlphabet++;
					}else{
						
					}
				}else{
					//Le nombre d'élement dans B
					numberOfElementB = byte2.intValue();
					modeEcritureB = true;

					//this.readMap.put(this.alphabet.charAt(indiceAlphabet), new ArrayList<Integer>());

				}

				// convert byte to character
				c=(char)b;

				// prints character
				System.out.print(c);


			}
			if(is!=null)
				is.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
