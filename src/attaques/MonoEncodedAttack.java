package attaques;

import java.io.File;
import java.util.ArrayList;

public class MonoEncodedAttack {
	private ArrayList<Character> frequence;
	
	public MonoEncodedAttack(){
		frequence = new ArrayList<Character>();
		frequence.add('E');
		frequence.add('A');
		frequence.add('I');
		frequence.add('S');
		frequence.add('N');
		frequence.add('R');
		frequence.add('T');
		frequence.add('O');
		frequence.add('L');
		frequence.add('U');
		frequence.add('D');
		frequence.add('C');
		frequence.add('M');
		frequence.add('P');
		frequence.add(' ');
		frequence.add('G');
		frequence.add('B');
		frequence.add('V');
		frequence.add('H');
		frequence.add('F');
		frequence.add(',');
		frequence.add('.');
		frequence.add('0');
		frequence.add('Q');
		frequence.add('Y');
		frequence.add('X');
		frequence.add('J');
		frequence.add(':');
		frequence.add('K');
		frequence.add('W');
		frequence.add('Z');
		frequence.add('"');
		frequence.add(';');

	}
	
	public void findkey(File encoded, File foundedKey){
		
	}

}
