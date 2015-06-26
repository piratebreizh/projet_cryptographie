package org.esgi.crypto.attaques;

import java.io.*;
import java.util.*;

public class TranspositionAttack {

    private Map<Character, Float> frequenceNumberChar;
    private ArrayList<Character> frequenceInverse;
    private Map<Character, ArrayList<Integer>> positionsLettres;
    private String content;
    
    private ArrayList<String> wordWithLetter;

    public TranspositionAttack() {
        frequenceInverse = new ArrayList<Character>();
    }

    public void launchAttack(File encoded, File out,File dic){
        findLettresPositions(encoded);
        readFile(encoded);
        try {
			searchWordWithLetterInFile(dic,"K");
		
        for(int i=0;i<10;i++){
        	for(int <getStringAroundPosition(positionsLettres.get('K'), i, i);j++){
        		ArrayList<String> a = anagram();	
        	}
        	for(String object: list){
        		  System.out.println(object)
        		}
        	
        	PrintWriter pr = new PrintWriter(new BufferedWriter( new FileWriter(out, true)));
        	
        	pr.println(
        }
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void readFile(File encoded) {
        StringBuilder builder = new StringBuilder();

        try {
            initialisationfrequenceNumberChar();
            //Message
            FileReader reader = new FileReader(encoded);
            //Lecture
            int intChar;
            while ((intChar = reader.read()) != -1) {
                builder.append((char) intChar);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        content = builder.toString();
    }

    public void createFrequence(File source) {
        Float lengthFichier = new Float(0.0);
        try {
            initialisationfrequenceNumberChar();
            //Message
            FileReader reader = new FileReader(source);
            //Lecture
            int intChar;
            while ((intChar = reader.read()) != -1) {
                char ch = (char) intChar;
                if (this.frequenceNumberChar.containsKey(ch)) {
                    Float number = this.frequenceNumberChar.get(ch);
                    this.frequenceNumberChar.put(ch, ++number);
                    lengthFichier++;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Character c : frequenceNumberChar.keySet()) {
            Float val = frequenceNumberChar.get(c);
            frequenceNumberChar.put(c, val / lengthFichier);
        }

        //Tri de la MAP
        this.frequenceNumberChar = sortByComparatorFloat(this.frequenceNumberChar);

        for (Character tempChar : this.frequenceNumberChar.keySet()) {
            frequenceInverse.add(tempChar);
        }

    }

    private void initialisationfrequenceNumberChar() {
        frequenceNumberChar = new HashMap<Character, Float>();

        frequenceNumberChar.put('A', new Float(0.0));
        frequenceNumberChar.put('B', new Float(0.0));
        frequenceNumberChar.put('C', new Float(0.0));
        frequenceNumberChar.put('D', new Float(0.0));
        frequenceNumberChar.put('E', new Float(0.0));
        frequenceNumberChar.put('F', new Float(0.0));
        frequenceNumberChar.put('G', new Float(0.0));
        frequenceNumberChar.put('H', new Float(0.0));
        frequenceNumberChar.put('I', new Float(0.0));
        frequenceNumberChar.put('J', new Float(0.0));
        frequenceNumberChar.put('K', new Float(0.0));
        frequenceNumberChar.put('L', new Float(0.0));
        frequenceNumberChar.put('M', new Float(0.0));
        frequenceNumberChar.put('N', new Float(0.0));
        frequenceNumberChar.put('O', new Float(0.0));
        frequenceNumberChar.put('P', new Float(0.0));
        frequenceNumberChar.put('Q', new Float(0.0));
        frequenceNumberChar.put('R', new Float(0.0));
        frequenceNumberChar.put('S', new Float(0.0));
        frequenceNumberChar.put('T', new Float(0.0));
        frequenceNumberChar.put('U', new Float(0.0));
        frequenceNumberChar.put('V', new Float(0.0));
        frequenceNumberChar.put('W', new Float(0.0));
        frequenceNumberChar.put('X', new Float(0.0));
        frequenceNumberChar.put('Y', new Float(0.0));
        frequenceNumberChar.put('Z', new Float(0.0));
        frequenceNumberChar.put(' ', new Float(0.0));
        frequenceNumberChar.put('.', new Float(0.0));
        frequenceNumberChar.put(',', new Float(0.0));
        frequenceNumberChar.put(';', new Float(0.0));
        frequenceNumberChar.put(':', new Float(0.0));
        frequenceNumberChar.put('"', new Float(0.0));
        frequenceNumberChar.put('\'', new Float(0.0));
    }

    private static Map<Character, Float> sortByComparatorFloat(Map<Character, Float> unsortMap) {

        // Convert Map to List
        List<Map.Entry<Character, Float>> list =
                new LinkedList<Map.Entry<Character, Float>>(unsortMap.entrySet());

        // Sort list with comparator, to compare the Map values
        Collections.sort(list, new Comparator<Map.Entry<Character, Float>>() {
            public int compare(Map.Entry<Character, Float> o1,
                               Map.Entry<Character, Float> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
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
    
    public void searchWordWithLetterInFile(File dic,CharSequence c) throws Exception{
    	wordWithLetter = new ArrayList<String>();
    	try (BufferedReader br = new BufferedReader(new FileReader(dic))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	       if (line.contains(c)){
    	    	   wordWithLetter.add(line);
    	       }
    	    }
    	}
    }
    
    public ArrayList<String> anagram(String s){    	
    	ArrayList<String> aPossibles = new ArrayList<>();
    	for (int i = 0; i < s.length(); i++) {
            final List<String> remaining = anagram(s.substring(0, i) + s.substring(i + 1));
            for (int j = 0; j < remaining.size(); j++) {
            	aPossibles.add(s.charAt(i) + remaining.get(j));
            }
        }
    	return aPossibles;
    }
    

    public void findLettresPositions(File encoded){
        positionsLettres = new HashMap<>();
        try{
            FileReader reader = new FileReader(encoded);
            int intChar;
            int position = 0;
            while ((intChar = reader.read()) != -1){
                char ch = (char) intChar;
                ArrayList<Integer> positions = new ArrayList<>();
                if(positionsLettres.containsKey(ch))
                    positions = positionsLettres.get(ch);
                positions.add(position);
                positionsLettres.put(ch, positions);
                position++;
            }
            reader.close();

        }catch (Exception e){}
    }

    private String getStringAroundPosition(int position, int ecartGauche, int ecartDroite){
        return content.substring(position-ecartGauche, position+ecartDroite);
    }


}
