package attaques;

import classes.CesarCipher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BruteForce {



	private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + " .,;:\"'";
	private String encodedString;
	private ArrayList<String> listeMotsConfirmation;
	private Map<Character, String> decodedMessages;
	
	BruteForce(){
		decodedMessages = new HashMap<>();

		listeMotsConfirmation = new ArrayList<String>();
		listeMotsConfirmation.add("LE");
		listeMotsConfirmation.add("DE");
		listeMotsConfirmation.add("UN");
		listeMotsConfirmation.add("ET");
		listeMotsConfirmation.add("ETRE");
		listeMotsConfirmation.add("A");
		listeMotsConfirmation.add("IL");
		listeMotsConfirmation.add("AVOIR");
		listeMotsConfirmation.add("NE");
		listeMotsConfirmation.add("JE");
		listeMotsConfirmation.add("SON");
		listeMotsConfirmation.add("QUE");
		listeMotsConfirmation.add("SE");
		listeMotsConfirmation.add("QUI");
		listeMotsConfirmation.add("EN");
		listeMotsConfirmation.add("CE");
		listeMotsConfirmation.add("DANS");
		listeMotsConfirmation.add("DU");
		listeMotsConfirmation.add("ELLE");
		listeMotsConfirmation.add("AU");
		listeMotsConfirmation.add("DE");
		listeMotsConfirmation.add("CE");
		listeMotsConfirmation.add("LE");
		listeMotsConfirmation.add("POUR");
		listeMotsConfirmation.add("PAS");
		listeMotsConfirmation.add("QUE");
		listeMotsConfirmation.add("VOUS");
		listeMotsConfirmation.add("PAR");
		listeMotsConfirmation.add("SUR");
		listeMotsConfirmation.add("FAIRE");
		listeMotsConfirmation.add("PLUS");
		listeMotsConfirmation.add("DIRE");
		listeMotsConfirmation.add("ME");
		listeMotsConfirmation.add("ON");
		listeMotsConfirmation.add("MON");
		listeMotsConfirmation.add("LUI");
		listeMotsConfirmation.add("NOUS");
		listeMotsConfirmation.add("COMME");
		listeMotsConfirmation.add("MAIS");
		listeMotsConfirmation.add("POUVOIR");
		listeMotsConfirmation.add("AVEC");
		listeMotsConfirmation.add("TOUT");
		listeMotsConfirmation.add("Y");
		listeMotsConfirmation.add("ALLER");
		listeMotsConfirmation.add("VOIR");
		listeMotsConfirmation.add("EN");
		listeMotsConfirmation.add("BIEN");
		listeMotsConfirmation.add("SANS");
		listeMotsConfirmation.add("TU");
		listeMotsConfirmation.add("OU");
		listeMotsConfirmation.add("LEUR");
		listeMotsConfirmation.add("HOMME");
		listeMotsConfirmation.add("SI");
		listeMotsConfirmation.add("DEUX");
		listeMotsConfirmation.add("MARI");
		listeMotsConfirmation.add("MOI");
		listeMotsConfirmation.add("VOULOIR");
		listeMotsConfirmation.add("TE");
		listeMotsConfirmation.add("FEMME");
		listeMotsConfirmation.add("VENIR");
		listeMotsConfirmation.add("QUAND");
		listeMotsConfirmation.add("GRAND");
		listeMotsConfirmation.add("CELUI");
		listeMotsConfirmation.add("SI");
		listeMotsConfirmation.add("NOTRE");
		listeMotsConfirmation.add("DEVOIR");
		listeMotsConfirmation.add("LA");
		listeMotsConfirmation.add("JOUR");
		listeMotsConfirmation.add("PRENDRE");

	}
	
	private void runAttaque(File _message, File _enCoded){
		createMapDecoded();

	}

	private void createMapDecoded(){
		CesarCipher cipher = new CesarCipher();
		for(int i=0; i<=alphabet.length() ; i++){
			Character key = alphabet.charAt(i);
			decodedMessages.put(key, cipher.decodeString(encodedString, key));
		}
	}
	
	public void stringFromFile(File encoded) throws Exception{
		
			BufferedReader br = new BufferedReader(new FileReader(encoded));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        encodedString = sb.toString();
	   
	}
	
	
}
