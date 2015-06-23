package attaques;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MonoEncodedAttack {

	private ArrayList<Character> frequence;
	private Map<Character,Integer> frequenceNumberChar;
	private Map<Character,Integer> mapEncodedNumberChar;
	private TreeMap<Character, Character> mapKeyAlphabet;
	private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + " .,;:\"'";


	public MonoEncodedAttack(){
		this.initialisationMapEncodeNumberChar();
		mapKeyAlphabet = new TreeMap<Character, Character>();
		frequence = new ArrayList<Character>();
	}

	private void initialisationMapEncodeNumberChar(){
		mapEncodedNumberChar = new HashMap<Character, Integer>();

		mapEncodedNumberChar.put('A',new Integer(0));
		mapEncodedNumberChar.put('B',new Integer(0));
		mapEncodedNumberChar.put('C',new Integer(0));
		mapEncodedNumberChar.put('D',new Integer(0));
		mapEncodedNumberChar.put('E',new Integer(0));
		mapEncodedNumberChar.put('F',new Integer(0));
		mapEncodedNumberChar.put('G',new Integer(0));
		mapEncodedNumberChar.put('H',new Integer(0));
		mapEncodedNumberChar.put('I',new Integer(0));
		mapEncodedNumberChar.put('J',new Integer(0));
		mapEncodedNumberChar.put('K',new Integer(0));
		mapEncodedNumberChar.put('L',new Integer(0));
		mapEncodedNumberChar.put('M',new Integer(0));
		mapEncodedNumberChar.put('N',new Integer(0));
		mapEncodedNumberChar.put('O',new Integer(0));
		mapEncodedNumberChar.put('P',new Integer(0));
		mapEncodedNumberChar.put('Q',new Integer(0));
		mapEncodedNumberChar.put('R',new Integer(0));
		mapEncodedNumberChar.put('S',new Integer(0));
		mapEncodedNumberChar.put('T',new Integer(0));
		mapEncodedNumberChar.put('U',new Integer(0));
		mapEncodedNumberChar.put('V',new Integer(0));
		mapEncodedNumberChar.put('W',new Integer(0));
		mapEncodedNumberChar.put('X',new Integer(0));
		mapEncodedNumberChar.put('Y',new Integer(0));
		mapEncodedNumberChar.put('Z',new Integer(0));
		mapEncodedNumberChar.put(' ',new Integer(0));
		mapEncodedNumberChar.put('.',new Integer(0));
		mapEncodedNumberChar.put(',',new Integer(0));
		mapEncodedNumberChar.put(';',new Integer(0));
		mapEncodedNumberChar.put(':',new Integer(0));
		mapEncodedNumberChar.put('"',new Integer(0));
		mapEncodedNumberChar.put('\'',new Integer(0));
	}
	
	private void initialisationfrequenceNumberChar(){
		frequenceNumberChar = new HashMap<Character, Integer>();

		frequenceNumberChar.put('A',new Integer(0));
		frequenceNumberChar.put('B',new Integer(0));
		frequenceNumberChar.put('C',new Integer(0));
		frequenceNumberChar.put('D',new Integer(0));
		frequenceNumberChar.put('E',new Integer(0));
		frequenceNumberChar.put('F',new Integer(0));
		frequenceNumberChar.put('G',new Integer(0));
		frequenceNumberChar.put('H',new Integer(0));
		frequenceNumberChar.put('I',new Integer(0));
		frequenceNumberChar.put('J',new Integer(0));
		frequenceNumberChar.put('K',new Integer(0));
		frequenceNumberChar.put('L',new Integer(0));
		frequenceNumberChar.put('M',new Integer(0));
		frequenceNumberChar.put('N',new Integer(0));
		frequenceNumberChar.put('O',new Integer(0));
		frequenceNumberChar.put('P',new Integer(0));
		frequenceNumberChar.put('Q',new Integer(0));
		frequenceNumberChar.put('R',new Integer(0));
		frequenceNumberChar.put('S',new Integer(0));
		frequenceNumberChar.put('T',new Integer(0));
		frequenceNumberChar.put('U',new Integer(0));
		frequenceNumberChar.put('V',new Integer(0));
		frequenceNumberChar.put('W',new Integer(0));
		frequenceNumberChar.put('X',new Integer(0));
		frequenceNumberChar.put('Y',new Integer(0));
		frequenceNumberChar.put('Z',new Integer(0));
		frequenceNumberChar.put(' ',new Integer(0));
		frequenceNumberChar.put('.',new Integer(0));
		frequenceNumberChar.put(',',new Integer(0));
		frequenceNumberChar.put(';',new Integer(0));
		frequenceNumberChar.put(':',new Integer(0));
		frequenceNumberChar.put('"',new Integer(0));
		frequenceNumberChar.put('\'',new Integer(0));
	}
	
	public void createFrequence(File source){
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
					Integer number = this.frequenceNumberChar.get(ch);
					this.frequenceNumberChar.put(ch,++number);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Tri de la MAP
		this.frequenceNumberChar=sortByComparator(this.frequenceNumberChar);
		
		for(Character tempChar : this.frequenceNumberChar.keySet()){
			frequence.add(tempChar);
		}
		
	}
	

	public void findkey(File encoded, File foundedKey){

		try {

			initialisationMapEncodeNumberChar();
			//Message
			InputStream inputStream = new FileInputStream(encoded);
			InputStreamReader input = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(input);
			//Encoded
			OutputStreamWriter outputStreamWriter = new FileWriter(foundedKey);
			//Lecture
			int intChar;
			while ((intChar = br.read()) != -1) {
				char ch = (char) intChar;
				if(this.mapEncodedNumberChar.containsKey(ch)){
					Integer number = this.mapEncodedNumberChar.get(ch);
					this.mapEncodedNumberChar.put(ch,++number);
				}
			}
			br.close();
			

			//Tri de la MAP
			this.mapEncodedNumberChar=sortByComparator(this.mapEncodedNumberChar);

			int i = 0;
			for(Character tempChar : this.mapEncodedNumberChar.keySet()){
				if(this.frequence.size()>i){
					mapKeyAlphabet.put(this.frequence.get(i) ,tempChar);
					i++;
				}
			}
			//ecrit la clé dans le bon ordre
			for(int y=0;y<this.alphabet.length();y++){
				Character tempChar = this.alphabet.charAt(y);
				if(this.mapKeyAlphabet.containsKey(tempChar)){
					outputStreamWriter.write(mapKeyAlphabet.get(tempChar));
				}
			}
			outputStreamWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Map<Character, Integer> sortByComparator(Map<Character, Integer> unsortMap) {

		// Convert Map to List
		List<Map.Entry<Character, Integer>> list = 
				new LinkedList<Map.Entry<Character, Integer>>(unsortMap.entrySet());

		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o1,
					Map.Entry<Character, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		// Convert sorted map back to a Map
		Map<Character, Integer> sortedMap = new LinkedHashMap<Character, Integer>();
		for (Iterator<Map.Entry<Character, Integer>> it = list.iterator(); it.hasNext();) {
			Map.Entry<Character, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
