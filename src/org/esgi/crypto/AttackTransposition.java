package org.esgi.crypto;

import org.esgi.crypto.attaques.TranspositionAttack;
import org.esgi.crypto.interfaces.IExecute;

import java.io.File;

public class AttackTransposition implements IExecute{
    @Override
    public void execute(File encoded, File key, File decoded) {
        File source = new File("source.txt");
        File od = new File("liste_mots.txt");
        TranspositionAttack attack = new TranspositionAttack();
        attack.createFrequence(source);
        attack.launchAttack(encoded, decoded,od);
    }
    
    public static void main(String[] args) {
		AttackTransposition a = new AttackTransposition();
        File encoded = new File("encodedTranspo.txt");
        File key = new File("keyTranspo.txt");
        File decoded = new File("decodedTranspo.txt");
		a.execute(encoded, key, decoded);
	}
}
